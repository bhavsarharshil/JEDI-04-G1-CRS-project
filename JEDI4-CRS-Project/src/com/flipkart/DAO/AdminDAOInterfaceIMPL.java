package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.bean.Admin;
import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.utils.DBConnection;

public class AdminDAOInterfaceIMPL implements AdminDAOInterface {

	@Override
	public Admin getAdminById(int id) {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		PreparedStatement stmt = null;
		Connection conn = DBConnection.getConnection();
		
		try {
			
			stmt = conn.prepareStatement(SQLQueriesConstant.GET_USER_BY_ID);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				admin.setId(rs.getInt("id"));
				admin.setEmail(rs.getString("email"));
				admin.setRole(rs.getString("role"));
				admin.setLoggedin(rs.getBoolean("isLogged"));
				admin.setName(rs.getString("name"));
				admin.setAdminEmail(rs.getString("email"));
				admin.setAdminId(id);
				admin.setAdminName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
		      try{
		         if(stmt!=null)
		        	 stmt.close();
		      } 
		      catch(SQLException se2){
		    	  se2.printStackTrace();
		      }
		      
	   }
		return admin;
	}

}
