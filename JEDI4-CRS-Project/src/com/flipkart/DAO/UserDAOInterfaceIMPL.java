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

				stmt = conn.prepareStatement(SQLQueriesConstant.LOG_IN);
				stmt.setInt(1, id);
				stmt.setString(2, password);
				stmt.executeUpdate();
				if(rs.getString("role").equals("student")){
					PreparedStatement stmt2 = conn.prepareStatement(SQLQueriesConstant.VEIFY_STUDENT_APPROVAL);
					stmt2.setInt(1,id);
					ResultSet rs2 = stmt2.executeQuery();
					boolean app = rs2.getBoolean("isApproved");
					if(app) {
						System.out.println("login successful");
						return rs.getString("role");
					}
					else{
						return "student approval pending";
					}
				}
				else{
					System.out.println("login successful");
					return rs.getString("role");
				}

			}
			else {
				return "invalid";
			}
			
		}
		catch(SQLException E) {
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
