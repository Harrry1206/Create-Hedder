package com.example.demo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**----------------------------------------------------------------------*
 *■■■LoginInfoクラス■■■
 *概要：DTO（userテーブル）
 *----------------------------------------------------------------------**/
public class LoginInfo{
	
	//----------------------------------------------------------------
	//フィールド
	//----------------------------------------------------------------
	@NotBlank(message = "入力は必須です")
	@Size(max=10)
	@Pattern(regexp = "^[0-9a-zA-Z]*$")
	private String    loginId     ;  //ログインID
	
	@NotBlank(message = "入力は必須です")
	@Size(max=10)
	@Pattern(regexp = "^[0-9a-zA-Z]*$")
	private String    password    ;  //パスワード
	
	
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
