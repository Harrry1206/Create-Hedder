package com.example.demo;

import java.util.List;

/**----------------------------------------------------------------------*
 *■■■ExtractAllResponseクラス■■■
 *概要：DTO（gacya_imageテーブル）
 *----------------------------------------------------------------------**/
public class ExtractAllResponse {
	//----------------------------------------------------------------
	//フィールド
	//----------------------------------------------------------------
	private List<CardUrl> data         ;  //全てのカードURL
	
	
	//----------------------------------------------------------------
	//getter/setter
	//----------------------------------------------------------------

	//getter/setter（対象フィールド：data）
	public List<CardUrl> getData() {
		return data;
	}
	
	
	public void setData(List<CardUrl> data) {
		this.data = data;
	}
}
