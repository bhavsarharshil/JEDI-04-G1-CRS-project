package com.flipkart.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.utils.DBConnection;
public class UserDAOInterfaceIMPL implements UserDAOInterface{
	public static Logger logger=Logger.getLogger(UserDAOInterface.class);

	/**
	 * @param id id of user
	 * @param password password of user
	 * @return role of user admin, student or professor
	 */
	@Override
	public String verifyLoginCredentials(int id, String password) {
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
					rs2.next();
					boolean app = rs2.getBoolean("isApproved");
					if(app) {
						System.out.println("\n---Logged in successfully---\n");
						return rs.getString("role");
					}
					else{
						logger.info("\n---Your application is not yet approved by the admin---\n");
						return "unApproved";
					}
				 }
				 else{
					logger.info("\n---Logged in successfully---\n");
					return rs.getString("role");
				 }
			}
			else {
				return "\n---INVALID CREDENTIALS---\n";
			}
		}catch(SQLException E) {
			logger.error("\n"+E.getMessage()+"\n");
		}
		catch(Exception e){
		      //Handle errors for Class.forName
		     logger.error("\n"+e.getMessage()+"\n");
		}
		return "invalid";
	}
	
}
