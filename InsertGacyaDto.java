package com.example.demo;

/**----------------------------------------------------------------------*
 *■■■InsertGacyaDtoクラス■■■
 *概要：DTO（gacya_imageテーブル）
 *----------------------------------------------------------------------**/
public class InsertGacyaDto {

	//----------------------------------------------------------------
	//フィールド
	//----------------------------------------------------------------
	private int    result     ;  //登録された件数
	
	//----------------------------------------------------------------
	//getter/setter
	//----------------------------------------------------------------
	
	//getter/setter（対象フィールド：result）
	public int getResult() {
		return result;
	}
	
	
	public void setResult(int result) {
		this.result = result;
	}
}
