package com.example.demo;

/**----------------------------------------------------------------------*
 *■■■GacyaEachExecuteクラス■■■
 *概要：DTO（gacya_imageテーブル）
 *----------------------------------------------------------------------**/
public class GacyaEachExecute {
	//----------------------------------------------------------------
	//フィールド
	//----------------------------------------------------------------
	private String eachImageUrl   ;  //個人別画像URL
	
	
	//----------------------------------------------------------------
	//getter/setter
	//----------------------------------------------------------------
	
	//getter/setter（対象フィールド：eachImageUrl）
	public String getEachImageUrl() {
		return eachImageUrl;
	}
	
	public void setEachImageUrl(String eachImageUrl) {
		this.eachImageUrl = eachImageUrl;
	}
}
