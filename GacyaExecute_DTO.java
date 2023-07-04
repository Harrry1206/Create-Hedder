package com.example.demo;

/**----------------------------------------------------------------------*
 *■■■GacyaExecute_DTOクラス■■■
 *概要：DTO（gacya_imageテーブル）
 *----------------------------------------------------------------------**/
public class GacyaExecute_DTO {

	//----------------------------------------------------------------
	//フィールド
	//----------------------------------------------------------------
	private int     id       ;  //ID
	private String  image    ;  //画像
	private String  rarity   ;  //レア度

	//----------------------------------------------------------------
	//getter/setter
	//----------------------------------------------------------------

	//getter/setter（対象フィールド：id）
	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	//getter/setter（対象フィールド：image）
	public String getImage() {
		return image;
	}
	
	
	public void setImage(String image) {
		this.image = image;
	}
	
	
	//getter/setter（対象フィールド：rarity）
	public String getRarity() {
		return rarity;
	}
	
	
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}
}
