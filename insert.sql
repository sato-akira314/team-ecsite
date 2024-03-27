SET foreign_key_checks=1;

USE milestonedb;

INSERT INTO mst_user
(user_name, password, family_name, first_name, family_name_kana, first_name_kana, gender)
VALUES ('taro@gmail.com', '111111', '山田', '太郎', 'やまだ', 'たろう', 0);

INSERT INTO mst_category (category_name,category_description) VALUES
('漫画', '漫画のカテゴリです'),
('小説', '小説のカテゴリです'),
('雑誌', '雑誌のカテゴリです'),
('資格', '資格本のカテゴリです');

INSERT INTO mst_product(product_name,product_name_kana,product_description,category_id,price,image_full_path,release_date,release_company)VALUES 
('TWO PIECES','つーぴーしーず','尾畑栄二郎　著',1,920,'/img/twopieces.jpg','1997/12/29','散英社'),
('トラえもん','とらえもん','勝子・K・鰹　著',1,225,'/img/toraemon.jpg','1974/08/01','中学舘'),
('ポリーハッター','ぽりーはったー','J.K. Kawaii　著、gooogle大先生　翻訳',2,1200,'/img/porihatta.jpg','1997/06/26','山梨社'),
('ノルジャーアンに花束を','のるじゃーあんにはなたばを','ムニエル　スイス　著、 ChatGPS　翻訳',2,851,'/img/norujan.jpg','1959/04/01','遅川書房'),
('週刊文秋','しゅうかんぶんじゅう','週刊誌の老舗として、「世の中のホントウがわかる」をテーマに、創刊から「新聞・テレビでも得られる記事」を発信。',3,450,'/img/bunju.jpg','2024/03/07','文藝夏冬'),
('週刊青年HOP','しゅうかんせいねんほっぷ','裏切り！怠惰！敗北！',3,290,'/img/hop.jpg','2024/03/04','散英社'),
('駆け出しエンジニアが、２日で！Gitが怖くなくなる本','かけだしえんじにあが、ふつかで！ぎっとがこわくなくなるほん','宮崎 瞬　著',4,500,'/img/git.jpg','2020/02/09','kindle'),
('Java SE 11 Silver問題集[1Z0-815]','じゃばえすいーいれぶんしるばーもんだいしゅう','志賀 澄人　著、 株式会社ソキウス・ジャパン　編',4,3000,'/img/silver.jpg','2019/10/18','インプレス'),
('スッキリわかるJava入門','すっきりわかるじゃばにゅうもん','中山 清喬/国本 大悟　著、 株式会社フレアリンク　監修',4,2970,'/img/sukkiri.jpg','2011/10/7','インプレス');
