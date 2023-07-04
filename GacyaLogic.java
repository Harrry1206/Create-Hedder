package com.example.demo;

import java.util.ArrayList;
import java.util.List;

/**----------------------------------------------------------------------*
 *■■■GacyaLogicクラス■■■
 *概要：ビジネスロジック（ユーザーの情報抽出）
 *----------------------------------------------------------------------**/
public class GacyaLogic {

	/**----------------------------------------------------------------------*
	 *■extractメソッド
	 *概要　：
	 *引数　：ランダム値、対象のユーザーID
	 *戻り値：String
	 *----------------------------------------------------------------------**/
	public String extract (int randomValue) {

		//-------------------------------------------
		//データベースへの接続を実施
		//-------------------------------------------

		String randomRarity = null;
		String imgUrl = null;
		
		
		//確率操作
		if(randomValue < 5) {
			randomRarity = "5";
		}else if(randomValue < 10) {
			randomRarity = "4";
		}else if(randomValue < 20) {
			randomRarity = "3";
		}else if(randomValue < 45) {
			randomRarity = "2";
		}else {
			randomRarity = "1";
		}
			
		//DAOクラスをインスタンス化＆指定のIDと合致するデータを抽出するよう依頼
		SqlExecute_DAO dao = new SqlExecute_DAO();
		List<GacyaExecute_DTO> extractedDto = dao.selectMemberInfo(randomRarity);
		
		//確率操作で当たったレア度のカード数を取得
		int randomCard = (int)(Math.random() * extractedDto.size());
		
		imgUrl = extractedDto.get(randomCard).getImage();
		
		SqlExecute_DAO dao3 = new SqlExecute_DAO();
		GetItemId personalItemInfo = dao3.personalItemInfo(imgUrl);
		
		/**SqlExecute_DAO dao4 = new SqlExecute_DAO();
		GetItemId personalInfo = dao4.personalInfo(personalUserInfo, personalItemInfo);**/
		
		return imgUrl;
	}
	

	
//	public void cardRegister(String itemUrl, String rarity) {
//		
//		SqlExecute_DAO dao = new SqlExecute_DAO();
//		InsertGacyaDto registerDto = dao.addCardInfo(itemUrl, rarity);
//	}
	
	
	/**----------------------------------------------------------------------*
	 *■extractAllメソッド
	 *概要　：
	 *引数　：なし
	 *戻り値：ExtractAllResponse
	 *----------------------------------------------------------------------**/
	public ExtractAllResponse extractAll() {
		
		SqlExecute_DAO dao = new SqlExecute_DAO();
		List<GacyaExecute_DTO> extractedAllDto = dao.selectAllMemberInfo();
		
		List<CardUrl> cardUrl = new ArrayList<>();
		for(int i =0; i < extractedAllDto.size(); i++) {
			CardUrl tmpCardUrl = new CardUrl();
			tmpCardUrl.setCardUrl(extractedAllDto.get(i).getImage());
			cardUrl.add(tmpCardUrl);
		}
		
		ExtractAllResponse response = new ExtractAllResponse();
		
		response.setData(cardUrl);
		
		return response;
	}

}
