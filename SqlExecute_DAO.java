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
	String USER_PASS   = "honda24";
	
	
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
			buf.append("   gacya_item_id  ,     ");
			buf.append("   gacya_item_url       ");
			buf.append(" FROM          ");
			buf.append("   gacya_image ");
			buf.append(" WHERE         ");
			buf.append("   rarity = ?      ");  //第1パラメータ
			
			
			//PreparedStatement（SQL発行用オブジェクト）を生成＆発行するSQLをセット
			ps = con.prepareStatement(buf.toString());
			
			
			//パラメータをセット
			ps.setString(1, randomRarity);
			
			
			//SQL文の送信＆戻り値としてResultSet（SQL抽出結果）を取得
			rs = ps.executeQuery();
			
			
			//ResultSetオブジェクトから1レコード分のデータをDTOに格納
			while(rs.next()){
				dto = new GacyaExecute_DTO();
				dto.setId(     rs.getInt(    "gacya_item_id"     ) );
				dto.setImage(  rs.getString( "gacya_item_url"   ) );
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
	public GetUserId personalUserInfo(String userId){
		
		
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
		GetUserId dto = null;
		
		
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
			buf.append("   user_id      ");
			buf.append(" FROM          ");
			buf.append("   user ");
			buf.append(" WHERE         ");
			buf.append("   login_id = ?      ");  //第1パラメータ
			
			
			//PreparedStatement（SQL発行用オブジェクト）を生成＆発行するSQLをセット
			ps = con.prepareStatement(buf.toString());
			
			
			//パラメータをセット
			ps.setString(1,userId);
			
			
			//SQL文の送信＆戻り値としてResultSet（SQL抽出結果）を取得
			rs = ps.executeQuery();
			
			
			//ResultSetオブジェクトから1レコード分のデータをDTOに格納
			if(rs.next()){
				dto = new GetUserId();
				dto.setUserId(     rs.getInt(    "user_id"     ) );
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
			buf.append("   gacya_item_id      ");
			buf.append(" FROM          ");
			buf.append("   gacya_image ");
			buf.append(" WHERE         ");
			buf.append("   gacya_item_url = ?      ");  //第1パラメータ
			
			//PreparedStatement（SQL発行用オブジェクト）を生成＆発行するSQLをセット
			ps = con.prepareStatement(buf.toString());
			
			
			//パラメータをセット
			ps.setString(1,imgUrl);
			
			
			//SQL文の送信＆戻り値としてResultSet（SQL抽出結果）を取得
			rs = ps.executeQuery();
			
			
			//ResultSetオブジェクトから1レコード分のデータをDTOに格納
			if(rs.next()){
				dto = new GetItemId();
				dto.setItemId(     rs.getInt(    "gacya_item_id"     ) );
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
	 *■personalInfoメソッド
	 *概要　：
	 *引数　：personalUserInfo、personalItemInfo
	 *戻り値：GetItem
	 *----------------------------------------------------------------------**/
	public GetItem personalInfo(GetUserId personalUserInfo, GetItemId personalItemInfo){
		
		
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
		int         rs  = 0 ;   // ResultSet（SQL抽出結果）格納用変数
		int userId = personalUserInfo.getUserId();
		int itemId = personalItemInfo.getItemId();
		
		//抽出データ（Sample4_02_1_Common_DTO型）格納用変数
		//※最終的にreturnするため、tryブロック内で宣言してはいけないことに注意
		GetItem dto = null;
		
		
		try {
			
			//-------------------------------------------
			//接続の確立（Connectionオブジェクトの取得）
			//-------------------------------------------
			con = DriverManager.getConnection(JDBC_URL, USER_ID, USER_PASS);
			
			//-------------------------------------------
			//SQL文の送信 ＆ 結果の取得
			//-------------------------------------------
			
			//発行するSQL文の生成（INSERT）
			StringBuffer buf = new StringBuffer();
			buf.append(" INSERT INTO get_item (");
			buf.append("   user_id    ,    ");
			buf.append("   gacya_item_id    )   ");
			buf.append(" VALUES   (       ");
			buf.append("   ?,      ");  //第1パラメータ
			buf.append("   ?)      ");  //第2パラメータ
			
			//PreparedStatement（SQL発行用オブジェクト）を生成＆発行するSQLをセット
			ps = con.prepareStatement(buf.toString());
			
			
			//パラメータをセット
			ps.setObject(1, userId);
			ps.setObject(2, itemId);
			
			
			//SQL文の送信＆戻り値としてResultSet（SQL抽出結果）を取得
			rs = ps.executeUpdate();
			
			
			//ResultSetオブジェクトから1レコード分のデータをDTOに格納
//			if(rs.next()){
//				dto = new GetItem();
//				dto.setUserId(     rs.getInt(    "user_id"     ) );
//				dto.setGacyaItemId(  rs.getInt( "gacya_item_id"   ) );
//			}
			
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
	public InsertGacyaDto addCardInfo(String itemUrl, String rarity){
		
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
		int rs  = 0;   // ResultSet（SQL抽出結果）格納用変数
		
		//抽出データ（Sample4_02_1_Common_DTO型）格納用変数
		//※最終的にreturnするため、tryブロック内で宣言してはいけないことに注意
		InsertGacyaDto dto = null;
		
		
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
			buf.append(" INSERT INTO gacya_image (");
			buf.append("   gacya_item_url    ,    ");
			buf.append("   rarity    )   ");
			buf.append(" VALUES   (       ");
			buf.append("   ?,      ");  //第1パラメータ
			buf.append("   ?)      ");  //第2パラメータ
			
			//PreparedStatement（SQL発行用オブジェクト）を生成＆発行するSQLをセット
			ps = con.prepareStatement(buf.toString());
			
			
			//パラメータをセット
			ps.setString(1,itemUrl);
			ps.setString(2,rarity);
			
			
			//SQL文の送信＆戻り値としてResultSet（SQL抽出結果）を取得
			rs = ps.executeUpdate();
			
			
			//ResultSetオブジェクトから1レコード分のデータをDTOに格納
//			if(rs.next()){
//				dto = new InsertGacyaDto();
//				dto.setId(     rs.getInt(    "gacya_item_id"     ) );
//			}
			
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
			buf.append("   gacya_item_id     ,    ");
			buf.append("   gacya_item_url       ");
			buf.append(" FROM          ");
			buf.append("   gacya_image ");
			
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
				dto.setId(     rs.getInt(    "gacya_item_id"     ) );
				dto.setImage(  rs.getString( "gacya_item_url"   ) );
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
	
	
	/**----------------------------------------------------------------------*
	 *■selectUserIdメソッド
	 *概要　：
	 *引数　：userId
	 *戻り値：抽出データ（GetPersonalUserId）
	 *----------------------------------------------------------------------**/
	public GetPersonalUserId selectUserId(String userId){
		
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
		GetPersonalUserId dto = null;
		
		
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
			buf.append("   user_id       ");
			buf.append(" FROM          ");
			buf.append("   user ");
			buf.append(" WHERE          ");
			buf.append("   login_id =  ? ");
			
			//PreparedStatement（SQL発行用オブジェクト）を生成＆発行するSQLをセット
			ps = con.prepareStatement(buf.toString());
			
			
			//パラメータをセット
			ps.setString(1, userId);
			
			
			//SQL文の送信＆戻り値としてResultSet（SQL抽出結果）を取得
			rs = ps.executeQuery();
			
			
			//ResultSetオブジェクトから1レコード分のデータをDTOに格納
//			String getAllImage = null;
			
			
			if(rs.next()){
				dto = new GetPersonalUserId();
				dto.setPersonalUserId(  rs.getInt( "user_id"   ) );
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
		return dto;
	}
	
	
	/**----------------------------------------------------------------------*
	 *■selectEachInfoメソッド
	 *概要　：
	 *引数　：getPersonalId
	 *戻り値：抽出データ（List<GacyaEachExecute>）
	 *----------------------------------------------------------------------**/
	public List<GacyaEachExecute> selectEachInfo(int getPersonalId){
		
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
		List<GacyaEachExecute> eachCardList = new ArrayList<>();
		
		//抽出データ（Sample4_02_1_Common_DTO型）格納用変数
		//※最終的にreturnするため、tryブロック内で宣言してはいけないことに注意
		GacyaEachExecute dto = null;
		
		
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
			buf.append("   gacya_item_url       ");
			buf.append(" FROM          ");
			buf.append("   gacya_image ");
			buf.append(" JOIN        ");
			buf.append("   get_item       ");
			buf.append(" ON          ");
			buf.append("   gacya_image.gacya_item_id =  ");
			buf.append("   get_item.gacya_item_id   ");
			buf.append(" WHERE          ");
			buf.append("   get_item.user_id =  ? ");
			
			//PreparedStatement（SQL発行用オブジェクト）を生成＆発行するSQLをセット
			ps = con.prepareStatement(buf.toString());
			
			
			//パラメータをセット
			ps.setInt(1, getPersonalId);
			
			
			//SQL文の送信＆戻り値としてResultSet（SQL抽出結果）を取得
			rs = ps.executeQuery();
			
			
			while(rs.next()){
				dto = new GacyaEachExecute();
				dto.setEachImageUrl(  rs.getString( "gacya_item_url"   ) );
				eachCardList.add(dto);
			}
			
			
			for(int i =0; i < eachCardList.size(); i++) {
				eachCardList.get(i).getEachImageUrl();
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
		return eachCardList;
	}
	
	/**----------------------------------------------------------------------*
	 *■addMemberInfoメソッド
	 *概要　：
	 *引数　：memberId、memberPassword
	 *戻り値：GacyaMember
	 *----------------------------------------------------------------------**/
	public GacyaMember addMemberInfo(String memberId, String memberPassword){
		
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
		int rs  = 0;   // ResultSet（SQL抽出結果）格納用変数
		
		//抽出データ（Sample4_02_1_Common_DTO型）格納用変数
		//※最終的にreturnするため、tryブロック内で宣言してはいけないことに注意
		GacyaMember dto = null;
		
		
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
			buf.append(" INSERT INTO user (");
			buf.append("   login_id    ,    ");
			buf.append("   password    )   ");
			buf.append(" VALUES   (       ");
			buf.append("   ?,      ");  //第1パラメータ
			buf.append("   ?)      ");  //第2パラメータ
			
			//PreparedStatement（SQL発行用オブジェクト）を生成＆発行するSQLをセット
			ps = con.prepareStatement(buf.toString());
			
			
			//パラメータをセット
			ps.setString(1,memberId);
			ps.setString(2,memberPassword);
			
			
			//SQL文の送信＆戻り値としてResultSet（SQL抽出結果）を取得
			rs = ps.executeUpdate();
			
			
			//ResultSetオブジェクトから1レコード分のデータをDTOに格納
//			if(rs.next()){
//				dto = new InsertGacyaDto();
//				dto.setId(     rs.getInt(    "gacya_item_id"     ) );
//			}
			
			
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
	 *■loginMemberInfoメソッド
	 *概要　：
	 *引数　：loginId、password
	 *戻り値：LoginInfo
	 *----------------------------------------------------------------------**/
	public LoginInfo loginMemberInfo(String loginId, String password){
		
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
		LoginInfo dto = null;
		
		
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
			buf.append("   login_id      ");
			buf.append(" FROM          ");
			buf.append("   user ");
			buf.append(" WHERE         ");
			buf.append("   login_id = ?      ");  //第1パラメータ
			buf.append("   AND      ");
			buf.append("   password = ?      ");  //第2パラメータ
			
			//PreparedStatement（SQL発行用オブジェクト）を生成＆発行するSQLをセット
			ps = con.prepareStatement(buf.toString());
			
			
			//パラメータをセット
			ps.setString(1,loginId);
			ps.setString(2,password);
			
			
			//SQL文の送信＆戻り値としてResultSet（SQL抽出結果）を取得
			rs = ps.executeQuery();
			
			
			//ResultSetオブジェクトから1レコード分のデータをDTOに格納
			if(rs.next()){
				dto = new LoginInfo();
				dto.setId(     rs.getString(    "login_id"     ) );
			}
			
			
			dto.getLoginId();
			
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
}
