package com.flipkart.constant;

public class SQLQueriesConstant {
	public static final String VERIFY_LOGIN_QUERY = "SELECT * FROM user WHERE id=? AND password =? ;";
	public static final String LOG_IN = "UPDATE user SET isLogged=1 WHERE id=? AND password =?;";
	public static final String GET_USER_BY_ID = "SELECT * FROM user WHERE id=?";
	public static final String INSERT_SEMIREGISTRATION = "INSERT INTO semiregistration (courseid,studentid,isPrimary,datetime) VALUES (?,?,?,?);";
	public static final String DELETE_PRIMARY_SM = "DELETE  FROM semiregistration WHERE isPrimary=1 AND studentid=? AND courseid=?";
	public static final String DELETE_SECONDARY_SM = "DELETE  FROM semiregistration WHERE isPrimary=0 AND studentid=? AND courseid=?";
	public static final String SELECT_PRIMARY_COURSE = "SELECT * FROM semiregistration WHERE studentid=? AND isPrimary=1";
	public static final String SELECT_SECONDARY_COURSE = "SELECT * FROM semiregistration WHERE studentid=? AND isPrimary=0";
	public static final String GET_SM_BY_ID = "SELECT * FROM semiregistration WHERE studentid=? AND courseid=?";
	public static final String DELETE_SM_BY_ID = "DELETE FROM semiregistration WHERE studentid=?";
}
