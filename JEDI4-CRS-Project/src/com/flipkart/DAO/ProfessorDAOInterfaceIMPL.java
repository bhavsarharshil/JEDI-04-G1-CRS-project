package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flipkart.bean.Professor;
import com.flipkart.utils.DBConnection;
import com.flipkart.constant.SQLQueriesConstant;
public class ProfessorDAOInterfaceIMPL implements ProfessorDAOInterface {
	private static ProfessorDAOInterfaceIMPL instance = null;
	public static ProfessorDAOInterfaceIMPL getInstance() {
		if (instance == null) {
			instance = new ProfessorDAOInterfaceIMPL();
		}
		return instance;
	}
	
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
	
	@Override
	public String getProfessorByIdName(int professorID)
	{
		String professorName = null;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBConnection.getConnection();
			// String sqlQuery = "SELECT name FROM professor WHERE id = ?";
			stmt = con.prepareStatement(SQLQueriesConstant.GET_PROFESSOR_BY_ID_QUERY);

			stmt.setInt(1, professorID);

			ResultSet resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				professorName = resultSet.getString("name");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return professorName;
	}

	
}
