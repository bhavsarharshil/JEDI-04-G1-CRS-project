package com.flipkart.DAO;
import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.utils.DBConnection;
public class UserDAOInterfaceIMPL implements UserDAOInterface{
	public static Logger logger=LoggerFactory.getLogger(UserDAOInterface.class);

	/**
	 * @param id id of user
	 * @param password password of user
	 * @return role of user admin, student or professor
	 */
	@Override
	public String verifyLoginCredentials(int id, String password) {
		PreparedStatement stmt = null;
		logger.info("bbbbbbbbb");
		
		try {
			Connection conn = DBConnection.getConnection();
			logger.debug(String.valueOf(conn));
			stmt = conn.prepareStatement(SQLQueriesConstant.VERIFY_LOGIN_QUERY);
			
			stmt.setInt(1, id);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				stmt = conn.prepareStatement(SQLQueriesConstant.LOG_IN);
				stmt.setInt(1, id);
				stmt.setString(2, password);
				stmt.executeUpdate();
				if(rs.getString("role").equals("student")){
					PreparedStatement stmt2 = conn.prepareStatement(SQLQueriesConstant.VEIFY_STUDENT_APPROVAL);
					stmt2.setInt(1,id);
					ResultSet rs2 = stmt2.executeQuery();
					rs2.next();
					boolean app = rs2.getBoolean("isApproved");
					if(app) {
						System.out.println("\n---Logged in successfully---\n");
						return rs.getString("role");
					}
					else{
						System.out.println("\n---Your application is not yet approved by the admin---\n");
						return "unApproved";
					}
				 }
				 else{
					System.out.println("\n---Logged in successfully---\n");
					return rs.getString("role");
				 }
			}
			else {
				return "\n---INVALID CREDENTIALS---\n";
			}
		}catch(SQLException E) {
			System.out.println(E.getMessage());
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
