package com.example.demo;

import java.util.List;

/**----------------------------------------------------------------------*
 *■■■GetAllRarityクラス■■■
 *概要：DTO（gacya_imageテーブル）
 *----------------------------------------------------------------------**/
public class GetAllRarity {
	//----------------------------------------------------------------
	//フィールド
	//----------------------------------------------------------------
	private List<CardRarity> rarity       ;  //全てのレア度
	
	
	//----------------------------------------------------------------
	//getter/setter
	//----------------------------------------------------------------

	//getter/setter（対象フィールド：rarity）
	public List<CardRarity> getRarity() {
		return rarity;
	}
	
	
	public void setRarity(List<CardRarity> rarity) {
		this.rarity = rarity;
	}
}
