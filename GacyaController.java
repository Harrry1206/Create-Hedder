package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/gacya")
@RestController
public class GacyaController {
  
	//ガチャ実行時のカード取得
	@PostMapping("/getimg")
	public String getimg(@RequestBody GetPersonalId request) {
		
		//ランダムに数値を生成
		int randomValue = (int)(Math.random() * 100);
		String imgUrl = null;
		
		//ガチャロジック（ユーザーの情報抽出）クラスのインスタンス化＆メソッド起動
		GacyaLogic blsel = new GacyaLogic();
		imgUrl = blsel.extract(randomValue);
		return imgUrl;
		
	}

	//すべてのカードを取得
	@GetMapping("/getalling")
	public ExtractAllResponse getallimg() {
		
		ExtractAllResponse allImage = new ExtractAllResponse();
		
		//ガチャロジック（ユーザーの情報抽出）クラスのインスタンス化＆メソッド起動
		GacyaLogic blsel = new GacyaLogic();
		allImage = blsel.extractAll();
		return allImage;
		
	}
	
}