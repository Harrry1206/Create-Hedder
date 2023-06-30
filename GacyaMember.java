package com.example.demo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**----------------------------------------------------------------------*
 *■■■GacyaMemberクラス■■■
 *概要：DTO（userテーブル）
 *----------------------------------------------------------------------**/
public class GacyaMember{

	//----------------------------------------------------------------
	//フィールド
	//----------------------------------------------------------------
	@NotBlank(message = "入力は必須です")
	@Size(max=10, message = "10文字以内で入力してください")
	@Pattern(regexp = "^[0-9a-zA-Z]+$", message = "半角英数字で入力してください")
	private String    loginId     ;  //ログインID
	
	
	@NotBlank(message = "入力は必須です")
	@Size(max=10, message = "10文字以内で入力してください")
	@Pattern(regexp = "^[0-9a-zA-Z]+$", message = "半角英数字で入力してください")
	private String    password   ;  //パスワード
	
	
	//----------------------------------------------------------------
	//getter/setter
	//----------------------------------------------------------------

	//getter/setter（対象フィールド：loginId）
	public String getLoginId() {
		return loginId;
	}
	
	
	public void setId(String loginId) {
		this.loginId = loginId;
	}
	
	
	//getter/setter（対象フィールド：password）
	public String getPassword() {
		return password;
	}
	
	
	public void setImage(String password) {
		this.password = password;
	}
}
