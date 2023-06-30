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
	public String extract (int randomValue, String userId) {

		//-------------------------------------------
		//データベースへの接続を実施
		//-------------------------------------------

		//-------------------------------------------
		//抽出したユーザー情報をコマンドライン上に表示
		//-------------------------------------------

		String randomRarity = null;
		String imgUrl = null;
		
		
		//確率操作(レア度ごと)
		if(randomValue < 5) {
			randomRarity = "S";
		}else if(randomValue < 15) {
			randomRarity = "A";
		}else if(randomValue < 35) {
			randomRarity = "B";
		}else if(randomValue < 65) {
			randomRarity = "C";
		}else {
			randomRarity = "D";
		}
			
		//DAOクラスをインスタンス化＆指定のIDと合致するデータを抽出するよう依頼
		SqlExecute_DAO dao = new SqlExecute_DAO();
		List<GacyaExecute_DTO> extractedDto = dao.selectMemberInfo(randomRarity);
		
		//確率操作で当たったレア度のカード数を取得
		int randomCard = (int)(Math.random() * extractedDto.size());
		
		imgUrl = extractedDto.get(randomCard).getImage();
		
		SqlExecute_DAO dao2 = new SqlExecute_DAO();
		GetUserId personalUserInfo = dao2.personalUserInfo(userId);
		
		SqlExecute_DAO dao3 = new SqlExecute_DAO();
		GetItemId personalItemInfo = dao3.personalItemInfo(imgUrl);
		
		SqlExecute_DAO dao4 = new SqlExecute_DAO();
		GetItem personalInfo = dao4.personalInfo(personalUserInfo, personalItemInfo);
		
		return imgUrl;
	}
	
	
	/**----------------------------------------------------------------------*
	 *■cardRegisterメソッド
	 *概要　：
	 *引数　：新規カードのURLとレア度
	 *戻り値：なし
	 *----------------------------------------------------------------------**/
	
	public void cardRegister(String itemUrl, String rarity) {
		
		SqlExecute_DAO dao = new SqlExecute_DAO();
		InsertGacyaDto registerDto = dao.addCardInfo(itemUrl, rarity);
	}
	
	
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
	
	
	/**----------------------------------------------------------------------*
	 *■getPersonalIdメソッド
	 *概要　：ユーザーID
	 *引数　：
	 *戻り値：int
	 *----------------------------------------------------------------------**/
	public int getPersonalId(String userId) {
		
		SqlExecute_DAO dao = new SqlExecute_DAO();
		GetPersonalUserId getPersonalUserId = dao.selectUserId(userId);
		
		int getId = getPersonalUserId.getPersonalUserId();
		
		return getId;
	}
	
	
	/**----------------------------------------------------------------------*
	 *■extractEachメソッド
	 *概要　：
	 *引数　：getPersonalId
	 *戻り値：ExtractEachResponse
	 *----------------------------------------------------------------------**/
	public ExtractEachResponse extractEach(int getPersonalId) {
		
		SqlExecute_DAO dao = new SqlExecute_DAO();
		List<GacyaEachExecute> extractedEachDto = dao.selectEachInfo(getPersonalId);
		
		List<EachCardUrl> cardUrl = new ArrayList<>();
		for(int i =0; i < extractedEachDto.size(); i++) {
			EachCardUrl tmpCardUrl = new EachCardUrl();
			tmpCardUrl.setEachCardUrl(extractedEachDto.get(i).getEachImageUrl());
			cardUrl.add(tmpCardUrl);
		}
		
		ExtractEachResponse response = new ExtractEachResponse();
		
		response.setData(cardUrl);
		
		return response;
	}
	
	
	/**----------------------------------------------------------------------*
	 *■memberRegisterメソッド
	 *概要　：
	 *引数　：ユーザーID、パスワード
	 *戻り値：
	 *----------------------------------------------------------------------**/
	
	public void memberRegister(String memberId, String memberPassword) {
		
		SqlExecute_DAO dao = new SqlExecute_DAO();
		GacyaMember memberDto = dao.addMemberInfo(memberId, memberPassword);
	}
	
	
	/**----------------------------------------------------------------------*
	 *■loginメソッド
	 *概要　：
	 *引数　：ログインID、パスワード
	 *戻り値：String
	 *----------------------------------------------------------------------**/
	
	public String login(String loginId, String password) {
		
		SqlExecute_DAO dao = new SqlExecute_DAO();
		LoginInfo loginDto = dao.loginMemberInfo(loginId, password);
		
		String getLoginId = loginDto.getLoginId();
		
		return getLoginId;
	}
}
