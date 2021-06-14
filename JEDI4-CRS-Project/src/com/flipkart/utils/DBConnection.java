/**
 * 
 */
package com.flipkart.utils;

/**
 * @author utkarsh
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; 
	static final String DB_URL = "jdbc:mysql://localhost/jedicrs";
	
	static final String USER = "jedi";
	static final String PASS = "Flipkart@jedi4";
	public static Connection conn = null;
	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			return conn;
		}
		catch(SQLException E) {
			E.printStackTrace();
		}
		catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		}
		finally{
		   }//end try
		return null;
		
		
	}
}
