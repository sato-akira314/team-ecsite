package jp.co.internous.milestone.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.milestone.model.domain.MstCategory;
import jp.co.internous.milestone.model.domain.MstProduct;
import jp.co.internous.milestone.model.form.SearchForm;
import jp.co.internous.milestone.model.mapper.MstCategoryMapper;
import jp.co.internous.milestone.model.mapper.MstProductMapper;
import jp.co.internous.milestone.model.session.LoginSession;

/**
 * 商品検索に関する処理を行うコントローラー
 * @author インターノウス
 *
 */
@Controller
@RequestMapping("/milestone")
public class IndexController {
	
	/*
	 * フィールド定義
	 */
	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	private MstProductMapper mstProductMapper;
	
	@Autowired
	private MstCategoryMapper mstCategoryMapper;
	
	/**
	 * トップページを初期表示する。
	 * @param m 画面表示用オブジェクト
	 * @return トップページ
	 */
	@RequestMapping("/")
	public String index(Model m) {
		
		if(!loginSession.isLogined() && loginSession.getTmpUserId() >= 0) {
			loginSession.setTmpUserId(-new Random().nextInt(1000000000));
		}
		m.addAttribute("loginSession", loginSession);
		
		List<MstCategory> categories = mstCategoryMapper.find();
		m.addAttribute("categories", categories);
		
		m.addAttribute("selected", 0);
		
		m.addAttribute("keywords", "");
		
		List<MstProduct>products = mstProductMapper.find();
		m.addAttribute("products", products);
		 
		return "index";
	}
	
	/**
	 * 検索処理を行う
	 * @param f 検索用フォーム
	 * @param m 画面表示用オブジェクト
	 * @return トップページ
	 */
	@RequestMapping("/searchItem")
	public String searchItem(SearchForm f, Model m) {
		
		m.addAttribute("loginSession", loginSession);
		
		List<MstCategory> categories = mstCategoryMapper.find();
		m.addAttribute("categories", categories);
		
		m.addAttribute("selected", f.getCategory());
		
		List<MstProduct> products;
		if(f.getCategory() == 0 && f.getKeywords() == null) {
			products = mstProductMapper.find();
		}else{
			String s = f.getKeywords();
			s = s.replace(";", " ").replace("\"", " ").replace("'", " ").replace("\\", " ").replace("　", " ").trim();
			while(s.contains("  ")) {
				s = s.replace("  ", " ");
			}

			m.addAttribute("keywords", s);
			String[] keywords = s.split(" ");
			if(f.getCategory() == 0) {
				products = mstProductMapper.findByProductName(keywords);
			}else {
				products = mstProductMapper.findByCategoryAndProductName(f.getCategory(), keywords);
			}
		}
		m.addAttribute("products", products);
		
		return "index";
	}
}
