package com.example.demo;

/**----------------------------------------------------------------------*
 *■■■GetPersonalUserIdクラス■■■
 *概要：DTO（get_itemテーブル）
 *----------------------------------------------------------------------**/
public class GetPersonalUserId{
	
	//----------------------------------------------------------------
	//フィールド
	//----------------------------------------------------------------
	private int    personalUserId          ;  //ユーザーID
	
	
	//----------------------------------------------------------------
	//getter/setter
	//----------------------------------------------------------------
	
	//getter/setter（対象フィールド：personalUserId）
	public int getPersonalUserId() {
		return personalUserId;
	}
	
	
	public void setPersonalUserId(int personalUserId) {
		this.personalUserId = personalUserId;
	}
}
