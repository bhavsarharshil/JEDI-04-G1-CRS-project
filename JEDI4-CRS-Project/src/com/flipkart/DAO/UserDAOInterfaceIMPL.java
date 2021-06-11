package com.flipkart.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.utils.DBConnection;
public class UserDAOInterfaceIMPL implements UserDAOInterface{

	@Override
	public String verifyLoginCredentials(int id, String password) {
		// TODO Auto-generated method stub
		
		PreparedStatement stmt = null;
		Connection conn = DBConnection.getConnection();
		try {
			
			stmt = conn.prepareStatement(SQLQueriesConstant.VERIFY_LOGIN_QUERY);
			stmt.setInt(1, id);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				System.out.println("login successfull");
				stmt = conn.prepareStatement(SQLQueriesConstant.LOG_IN);
				stmt.setInt(1, id);
				stmt.setString(2, password);
				stmt.executeUpdate();
				return rs.getString("role");
			}
			else {
				return "invalid";
			}
			
		}
		catch(SQLException E) {
			E.printStackTrace();
		}
		catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		}
		finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		        	 stmt.close();
		      } 
		      catch(SQLException se2){
		      }// nothing we can do
		      
		   }//end try
		return "invalid";
	}
	
}
