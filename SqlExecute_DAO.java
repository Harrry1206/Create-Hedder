package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**----------------------------------------------------------------------*
 *■■■SqlExecute_DAOクラス■■■
 *概要：DAO（gacya_imageテーブル）
 *----------------------------------------------------------------------**/
public class SqlExecute_DAO {
	
	//-------------------------------------------
	//データベースへの接続情報
	//-------------------------------------------
	
	//JDBCドライバの相対パス
	//※バージョンによって変わる可能性があります（MySQL5系の場合は「com.mysql.jdbc.Driver」）
	String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	
	//接続先のデータベース
	//※データベース名が「test_db」でない場合は該当の箇所を変更してください
	String JDBC_URL    = "jdbc:mysql://localhost/gacya_db?characterEncoding=UTF-8&serverTimezone=JST&useSSL=false";
	
	//接続するユーザー名
	//※ユーザー名が「test_user」でない場合は該当の箇所を変更してください
	String USER_ID     = "root";
	
	//接続するユーザーのパスワード
	//※パスワードが「test_pass」でない場合は該当の箇所を変更してください
	String USER_PASS   = "Ryuji1206";
	
	
	//----------------------------------------------------------------
	//メソッド
	//----------------------------------------------------------------
	
	/**----------------------------------------------------------------------*
	 *■selectMemberInfoメソッド
	 *概要　：「gacya_image」テーブルのレコードを1行抽出する
	 *引数　：ランダムレア度
	 *戻り値：抽出データ（List<GacyaExecute_DTO>型）
	 *----------------------------------------------------------------------**/
	public List<GacyaExecute_DTO> selectMemberInfo(String randomRarity){
		
		//-------------------------------------------
		//JDBCドライバのロード
		//-------------------------------------------
		try {
			Class.forName(DRIVER_NAME);       //JDBCドライバをロード＆接続先として指定
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//-------------------------------------------
		//SQL発行
		//-------------------------------------------

		//JDBCの接続に使用するオブジェクトを宣言
		//※finallyブロックでも扱うためtryブロック内で宣言してはいけないことに注意
		Connection        con = null ;   // Connection（DB接続情報）格納用変数
		PreparedStatement ps  = null ;   // PreparedStatement（SQL発行用オブジェクト）格納用変数
		ResultSet         rs  = null ;   // ResultSet（SQL抽出結果）格納用変数
		List<GacyaExecute_DTO> rarityList = new ArrayList<>();
		
		//抽出データ（Sample4_02_1_Common_DTO型）格納用変数
		//※最終的にreturnするため、tryブロック内で宣言してはいけないことに注意
		GacyaExecute_DTO dto = null;
		
		
		try {
			
			//-------------------------------------------
			//接続の確立（Connectionオブジェクトの取得）
			//-------------------------------------------
			con = DriverManager.getConnection(JDBC_URL, USER_ID, USER_PASS);

			//-------------------------------------------
			//SQL文の送信 ＆ 結果の取得
			//-------------------------------------------

			//発行するSQL文の生成（SELECT）
			StringBuffer buf = new StringBuffer();
			buf.append(" SELECT        ");
			buf.append("   card_number  ,     ");
			buf.append("   card_path       ");
			buf.append(" FROM          ");
			buf.append("   card_list ");
			buf.append(" WHERE         ");
			buf.append("   card_rarity = ?      ");  //第1パラメータ
			
			
			//PreparedStatement（SQL発行用オブジェクト）を生成＆発行するSQLをセット
			ps = con.prepareStatement(buf.toString());
			
			
			//パラメータをセット
			ps.setString(1, randomRarity);
			
			
			//SQL文の送信＆戻り値としてResultSet（SQL抽出結果）を取得
			rs = ps.executeQuery();
			
			
			//ResultSetオブジェクトから1レコード分のデータをDTOに格納
			while(rs.next()){
				dto = new GacyaExecute_DTO();
				dto.setId(     rs.getInt(    "card_number"     ) );
				dto.setImage(  rs.getString( "card_path"   ) );
				rarityList.add(dto);
			}
			
			
			for(int i =0; i < rarityList.size(); i++) {
				rarityList.get(i).getImage();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			//-------------------------------------------
			//接続の解除
			//-------------------------------------------
			
			//ResultSetオブジェクトの接続解除
			if (rs != null) {    //接続が確認できている場合のみ実施
				try {
					rs.close();  //接続の解除
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
			//PreparedStatementオブジェクトの接続解除
			if (ps != null) {    //接続が確認できている場合のみ実施
				try {
					ps.close();  //接続の解除
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
			//Connectionオブジェクトの接続解除
			if (con != null) {    //接続が確認できている場合のみ実施
				try {
					con.close();  //接続の解除
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		//抽出データを戻す
		return rarityList;
	}
	
	/**----------------------------------------------------------------------*
	 *■personalUserInfoメソッド
	 *概要　：ユーザーIDを取得
	 *引数　：ユーザーID
	 *戻り値：GetUserId
	 *----------------------------------------------------------------------**/
	
	
	
	/**----------------------------------------------------------------------*
	 *■personalItemInfoメソッド
	 *概要　：個人別のカードを取得
	 *引数　：画像URL
	 *戻り値：GetItemId
	 *----------------------------------------------------------------------**/
	public GetItemId personalItemInfo(String imgUrl){
		
		
		//-------------------------------------------
		//JDBCドライバのロード
		//-------------------------------------------
		try {
			Class.forName(DRIVER_NAME);       //JDBCドライバをロード＆接続先として指定
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		//-------------------------------------------
		//SQL発行
		//-------------------------------------------
		
		//JDBCの接続に使用するオブジェクトを宣言
		//※finallyブロックでも扱うためtryブロック内で宣言してはいけないことに注意
		Connection        con = null ;   // Connection（DB接続情報）格納用変数
		PreparedStatement ps  = null ;   // PreparedStatement（SQL発行用オブジェクト）格納用変数
		ResultSet         rs  = null ;   // ResultSet（SQL抽出結果）格納用変数
		
		//抽出データ（Sample4_02_1_Common_DTO型）格納用変数
		//※最終的にreturnするため、tryブロック内で宣言してはいけないことに注意
		GetItemId dto = null;
		
		
		try {
			
			//-------------------------------------------
			//接続の確立（Connectionオブジェクトの取得）
			//-------------------------------------------
			con = DriverManager.getConnection(JDBC_URL, USER_ID, USER_PASS);
			
			//-------------------------------------------
			//SQL文の送信 ＆ 結果の取得
			//-------------------------------------------
			
			//発行するSQL文の生成（SELECT）
			StringBuffer buf = new StringBuffer();
			buf.append(" SELECT        ");
			buf.append("  card_number      ");
			buf.append(" FROM          ");
			buf.append("   card_list ");
			buf.append(" WHERE         ");
			buf.append("   card_path = ?      ");  //第1パラメータ
			
			//PreparedStatement（SQL発行用オブジェクト）を生成＆発行するSQLをセット
			ps = con.prepareStatement(buf.toString());
			
			
			//パラメータをセット
			ps.setString(1,imgUrl);
			
			
			//SQL文の送信＆戻り値としてResultSet（SQL抽出結果）を取得
			rs = ps.executeQuery();
			
			
			//ResultSetオブジェクトから1レコード分のデータをDTOに格納
			if(rs.next()){
				dto = new GetItemId();
				dto.setItemId(     rs.getInt(    "card_number"     ) );
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			//-------------------------------------------
			//接続の解除
			//-------------------------------------------

			//ResultSetオブジェクトの接続解除
//			if (rs != null) {    //接続が確認できている場合のみ実施
//				try {
//					rs.close();  //接続の解除
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
			
			
			//PreparedStatementオブジェクトの接続解除
			if (ps != null) {    //接続が確認できている場合のみ実施
				try {
					ps.close();  //接続の解除
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
			//Connectionオブジェクトの接続解除
			if (con != null) {    //接続が確認できている場合のみ実施
				try {
					con.close();  //接続の解除
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		//抽出データを戻す
		return dto;
	}
	
	
	/**----------------------------------------------------------------------*
	 *■addCardInfoメソッド
	 *概要　：
	 *引数　：itemUrl、rarity
	 *戻り値：InsertGacyaDto
	 *----------------------------------------------------------------------**/
	
	/**----------------------------------------------------------------------*
	 *■selectAllMemberInfoメソッド
	 *概要　：
	 *引数　：なし
	 *戻り値：抽出データ（List<GacyaExecute_DTO>）
	 *----------------------------------------------------------------------**/
	
	public List<GacyaExecute_DTO> selectAllMemberInfo(){
		
		//-------------------------------------------
		//JDBCドライバのロード
		//-------------------------------------------
		try {
			Class.forName(DRIVER_NAME);       //JDBCドライバをロード＆接続先として指定
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		//-------------------------------------------
		//SQL発行
		//-------------------------------------------
		
		//JDBCの接続に使用するオブジェクトを宣言
		//※finallyブロックでも扱うためtryブロック内で宣言してはいけないことに注意
		Connection        con = null ;   // Connection（DB接続情報）格納用変数
		PreparedStatement ps  = null ;   // PreparedStatement（SQL発行用オブジェクト）格納用変数
		ResultSet         rs  = null ;   // ResultSet（SQL抽出結果）格納用変数
		List<GacyaExecute_DTO> cardList = new ArrayList<>();
		
		//抽出データ（Sample4_02_1_Common_DTO型）格納用変数
		//※最終的にreturnするため、tryブロック内で宣言してはいけないことに注意
		GacyaExecute_DTO dto = null;
		
		
		try {
			
			//-------------------------------------------
			//接続の確立（Connectionオブジェクトの取得）
			//-------------------------------------------
			con = DriverManager.getConnection(JDBC_URL, USER_ID, USER_PASS);
			
			//-------------------------------------------
			//SQL文の送信 ＆ 結果の取得
			//-------------------------------------------
			
			//発行するSQL文の生成（SELECT）
			StringBuffer buf = new StringBuffer();
			buf.append(" SELECT        ");
			buf.append("   card_number     ,    ");
			buf.append("   card_path       ");
			buf.append(" FROM          ");
			buf.append("   card_list ");
			
			//PreparedStatement（SQL発行用オブジェクト）を生成＆発行するSQLをセット
			ps = con.prepareStatement(buf.toString());
			
			
			//パラメータをセット
//			ps.setInt(1, randomId);
			
			
			//SQL文の送信＆戻り値としてResultSet（SQL抽出結果）を取得
			rs = ps.executeQuery();
			
			
			//ResultSetオブジェクトから1レコード分のデータをDTOに格納
//			String getAllImage = null;
			
			
			while(rs.next()){
				dto = new GacyaExecute_DTO();
				dto.setId(     rs.getInt(    "card_number"     ) );
				dto.setImage(  rs.getString( "card_path"   ) );
				cardList.add(dto);
			}
			
			
			for(int i =0; i < cardList.size(); i++) {
				cardList.get(i).getImage();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			//-------------------------------------------
			//接続の解除
			//-------------------------------------------
			
			//ResultSetオブジェクトの接続解除
			if (rs != null) {    //接続が確認できている場合のみ実施
				try {
					rs.close();  //接続の解除
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
			//PreparedStatementオブジェクトの接続解除
			if (ps != null) {    //接続が確認できている場合のみ実施
				try {
					ps.close();  //接続の解除
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
			//Connectionオブジェクトの接続解除
			if (con != null) {    //接続が確認できている場合のみ実施
				try {
					con.close();  //接続の解除
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		//抽出データを戻す
		return cardList;
	}

}
