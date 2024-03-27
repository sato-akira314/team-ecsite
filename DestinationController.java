package jp.co.internous.milestone.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jp.co.internous.milestone.model.domain.MstDestination;
import jp.co.internous.milestone.model.domain.MstUser;
import jp.co.internous.milestone.model.form.DestinationForm;
import jp.co.internous.milestone.model.mapper.MstDestinationMapper;
import jp.co.internous.milestone.model.mapper.MstUserMapper;
import jp.co.internous.milestone.model.session.LoginSession;

/**
 * 宛先情報に関する処理のコントローラー
 * @author インターノウス
 *
 */
@Controller
@RequestMapping("/milestone/destination")
public class DestinationController {
	
	/*
	 * フィールド定義
	 */
	
	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	private MstUserMapper mstUserMapper;
	
	@Autowired
	private MstDestinationMapper mstDestinationMapper;
	
	private Gson gson = new Gson();
	
	/**
	 * 宛先画面を初期表示する
	 * @param m 画面表示用オブジェクト
	 * @return 宛先画面
	 */
	@RequestMapping("/")
	public String index(Model m) {
		
		m.addAttribute("loginSession", loginSession);
		
		MstUser user = mstUserMapper.findByUserNameAndPassword(loginSession.getUserName(), loginSession.getPassword());
		m.addAttribute("user", user);
		
		return "destination";
	}
	
	/**
	 * 宛先情報を削除する
	 * @param destinationId 宛先情報ID
	 * @return true:削除成功、false:削除失敗
	 */
	@SuppressWarnings("unchecked")
	@PostMapping("/delete")
	@ResponseBody
	public boolean delete(@RequestBody String destinationId) {
		
		Map<String, String> destinationMap = gson.fromJson(destinationId, Map.class);
		int i = mstDestinationMapper.logicalDeleteById(Integer.parseInt(destinationMap.get("destinationId")));
		
		return i > 0;
	}
	
	/**
	 * 宛先情報を登録する
	 * @param f 宛先情報のフォーム
	 * @return 宛先情報id
	 */
	@PostMapping("/register")
	@ResponseBody
	public String register(@RequestBody DestinationForm f) {
		
		MstDestination mstDestination = new MstDestination();
		mstDestination.setUserId(loginSession.getUserId());
		mstDestination.setFamilyName(f.getFamilyName());
		mstDestination.setFirstName(f.getFirstName());
		mstDestination.setAddress(f.getAddress());
		mstDestination.setTelNumber(f.getTelNumber());
		
		mstDestinationMapper.insert(mstDestination);
		
		return gson.toJson(mstDestination.getId());
		
		
	}
}
