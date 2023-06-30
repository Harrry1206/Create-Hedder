package com.example.demo;

/**----------------------------------------------------------------------*
 *■■■GetItemクラス■■■
 *概要：DTO（get_itemテーブル）
 *----------------------------------------------------------------------**/
public class GetItem{

	//----------------------------------------------------------------
	//フィールド
	//----------------------------------------------------------------
	private int    userId          ;  //ユーザーID
	private int    gacyaItemId     ;  //ガチャ景品ID
	
	
	//----------------------------------------------------------------
	//getter/setter
	//----------------------------------------------------------------

	//getter/setter（対象フィールド：userId）
	public int getUserId() {
		return userId;
	}
	
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	//getter/setter（対象フィールド：gacyaItemId）
	public int getGacyaItemId() {
		return gacyaItemId;
	}
	
	
	public void setGacyaItemId(int gacyaItemId) {
		this.gacyaItemId = gacyaItemId;
	}
}
