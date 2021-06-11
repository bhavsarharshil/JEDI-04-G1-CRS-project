package com.flipkart.constant;

public class SQLQueriesConstant {
	public static final String VERIFY_LOGIN_QUERY = "SELECT * FROM user WHERE id=? AND password =? ;";
	public static final String LOG_IN = "UPDATE user SET isLogged=1 WHERE id=? AND password =?;";
	public static final String GET_USER_BY_ID = "SELECT * FROM user WHERE id=?";
}
