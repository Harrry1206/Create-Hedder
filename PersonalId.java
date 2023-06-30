package com.example.demo;

/**----------------------------------------------------------------------*
 *■■■PersonalIdクラス■■■
 *概要：DTO（get_itemテーブル）
 *----------------------------------------------------------------------**/
public class PersonalId{
	
	//----------------------------------------------------------------
	//フィールド
	//----------------------------------------------------------------
	private String    userId          ;  //ユーザーID
	
	
	//----------------------------------------------------------------
	//getter/setter
	//----------------------------------------------------------------
	
	//getter/setter（対象フィールド：userId）
	public String getUserId() {
		return userId;
	}
	
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
}