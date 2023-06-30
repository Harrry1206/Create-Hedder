package com.example.demo;

/**----------------------------------------------------------------------*
 *■■■RegisterRequestクラス■■■
 *概要：DTO（gacya_imageテーブル）
 *----------------------------------------------------------------------**/
public class RegisterRequest {
	
	//----------------------------------------------------------------
	//フィールド
	//----------------------------------------------------------------
	private String imageUrl   ;  //imageUrl
	private String rarity     ;  //rarity
	
	
	//----------------------------------------------------------------
	//getter/setter
	//----------------------------------------------------------------
	
	//getter/setter（対象フィールド：imageUrl）
	public String getImageUrl() {
		return imageUrl;
	}
	
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	//getter/setter（対象フィールド：rarity）
	public String getRarity() {
		return rarity;
	}
	
	
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}
}
