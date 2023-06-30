package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/gacya")
public class GacyaController0831 {
	
	
	//ガチャ実行時のカード取得
	@PostMapping("/getimg")
	public String getimg(@RequestBody PersonalId request) {
		
		String userId = request.getUserId();
		
		//ランダムに数値を生成
		int randomValue = (int)(Math.random() * 100);
		String imgUrl = null;
		
		//ガチャロジック（ユーザーの情報抽出）クラスのインスタンス化＆メソッド起動
		GacyaLogic blSel = new GacyaLogic();
		imgUrl = blSel.extract( randomValue, userId);
		return imgUrl;
		
		//もう1つのリターン方法
		//return blSel.extract( randomValue );
	}
	
	
	//新規のカード登録
	@PostMapping("/registerimg")
	public void registerimg(@RequestBody RegisterRequest request) {
		
		String itemUrl = request.getImageUrl();
		String rarity = request.getRarity();
		
		//ガチャロジック（ユーザーの情報抽出）クラスのインスタンス化＆メソッド起動
		GacyaLogic blSel = new GacyaLogic();
		blSel.cardRegister( itemUrl, rarity );
	}
	
	
	//全てのカードの取得
	@GetMapping("/getallimg")
	public ExtractAllResponse getallimg() {	

		ExtractAllResponse allImage = new ExtractAllResponse();

		//ガチャロジック（ユーザーの情報抽出）クラスのインスタンス化＆メソッド起動
		GacyaLogic blSel = new GacyaLogic();
		allImage = blSel.extractAll();
		return allImage;
	}
	
	
	//個人別のカードの取得
	@PostMapping("/getpersonalimg")
	public ExtractEachResponse getpersonalimg(@RequestBody GetPersonalId request) {
		
		String getUserId = request.getUserId();
		
		ExtractEachResponse eachImage = new ExtractEachResponse();

		//ガチャロジック（ユーザーの情報抽出）クラスのインスタンス化＆メソッド起動
		GacyaLogic blSel = new GacyaLogic();
		int getPersonalId = blSel.getPersonalId(getUserId);
		eachImage = blSel.extractEach(getPersonalId);
		return eachImage;
	}
	
	
	//新規登録
	@PostMapping("/registerMember")
	public void registerMember(@RequestBody GacyaMember member) {
		
		String memberId = member.getLoginId();
		String memberPassword = member.getPassword();
		
		//ガチャロジック（ユーザーの情報抽出）クラスのインスタンス化＆メソッド起動
		GacyaLogic blSel = new GacyaLogic();
		blSel.memberRegister( memberId, memberPassword );
	}
	
	
	//ログイン
	@PostMapping("/login")
	public String login(@RequestBody LoginInfo request) {
		
		String loginId = request.getLoginId();
		String password = request.getPassword();
		
		String displayLoginId = null;
		
		//ガチャロジック（ユーザーの情報抽出）クラスのインスタンス化＆メソッド起動
		GacyaLogic blSel = new GacyaLogic();
		displayLoginId = blSel.login( loginId, password );
		
		return displayLoginId;
	}
	
	
}