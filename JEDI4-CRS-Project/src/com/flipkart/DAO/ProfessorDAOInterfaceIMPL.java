package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.bean.Professor;
import com.flipkart.utils.DBConnection;
import com.flipkart.constant.SQLQueriesConstant;
public class ProfessorDAOInterfaceIMPL implements ProfessorDAOInterface {

	@Override
	public Professor getProfessorById(int id) {
		// TODO Auto-generated method stub
		Professor professor = new Professor();
		PreparedStatement stmt = null;
		Connection conn = DBConnection.getConnection();
		
		try {
			
			stmt = conn.prepareStatement(SQLQueriesConstant.GET_USER_BY_ID);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				professor.setId(rs.getInt("id"));
				professor.setEmail(rs.getString("email"));
				professor.setRole(rs.getString("role"));
				professor.setLoggedin(rs.getBoolean("isLogged"));
				professor.setName(rs.getString("name"));
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
		return professor;
	}
	
}
