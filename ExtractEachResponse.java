package com.example.demo;

import java.util.List;

/**----------------------------------------------------------------------*
 *■■■ExtractEachResponseクラス■■■
 *概要：DTO（gacya_imageテーブル）
 *----------------------------------------------------------------------**/
public class ExtractEachResponse {
	//----------------------------------------------------------------
	//フィールド
	//----------------------------------------------------------------
	private List<EachCardUrl> data         ;  //全てのカードURL（個人別）
	
	
	//----------------------------------------------------------------
	//getter/setter
	//----------------------------------------------------------------
	
	//getter/setter（対象フィールド：data）
	public List<EachCardUrl> getData() {
		return data;
	}
	
	
	public void setData(List<EachCardUrl> data) {
		this.data = data;
	}
}
