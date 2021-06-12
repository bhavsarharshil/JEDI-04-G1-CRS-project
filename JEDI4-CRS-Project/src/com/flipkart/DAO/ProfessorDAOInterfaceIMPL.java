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
	public boolean gradeStudents(int courseID, int studentID,String grade) {

		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		boolean update=false;
		Connection conn = null;
		try{


			System.out.println("Connecting to database...");
			conn = DBConnection.getConnection();
			// System.out.println("Creating statement...");
			String sql="insert into grade values(?,?,?)";
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1,courseID);
			stmt.setInt(2,studentID);
			stmt.setString(3, grade);
			stmt.executeUpdate();

			stmt.close();
			conn.close();
			update=true;

		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}//end finally try
		}//end try
		return update;
	}

	@Override
	public void viewGrades(int courseID,int studentID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;

		try{

			System.out.println("Connecting to database...");
			conn = DBConnection.getConnection();
			String sql = "SELECT * from grade WHERE courseid = ? AND studentid = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,courseID);
			stmt.setInt(2,studentID);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				courseID=rs.getInt("courseid");
				studentID=rs.getInt("studentid");
				String grade = rs.getString("grade");
				System.out.print("courseID: " + courseID);
				System.out.print(" stduentID: " + studentID);
				System.out.println(" grade: " + grade);
			}
			stmt.close();
			conn.close();

		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){

			e.printStackTrace();
		}finally{

			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
	}

	@Override
	public void showAssignedCourses(int profID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;

		try{

			System.out.println("Connecting to database...");
			conn = DBConnection.getConnection();
			String sql = "SELECT * FROM courseprof WHERE profid = ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,profID);

			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				int courseID1  = rs.getInt("courseid");
				System.out.println("ID: " + courseID1);
			}

			stmt.close();
			conn.close();

		}catch(SQLException se){

			se.printStackTrace();
		}catch(Exception e){

			e.printStackTrace();
		}finally{

			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
	}

	@Override
	public boolean addAssignedCourse(int courseID,int profID) {
		// TODO Auto-generated method stub
		boolean added=false;
		Connection conn = null;
		PreparedStatement stmt = null;

		try{

			System.out.println("Connecting to database...");
			conn = DBConnection.getConnection();
			// System.out.println("Creating statement...");
			String sql="insert into courseprof values(?,?)";
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1,courseID);
			stmt.setInt(2,profID);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
			added=true;

		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){

			e.printStackTrace();
		}finally{

			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		return added;
	}

	@Override
	public boolean removeAssignedCourse(int courseID,int profID) {
		// TODO Auto-generated method stub
		boolean remove=false;
		Connection conn = null;
		PreparedStatement stmt = null;

		try{

			System.out.println("Connecting to database...");
			conn = DBConnection.getConnection();

			String sql = "DELETE FROM courseprof WHERE courseid= ? AND profid= ?";
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,courseID);
			stmt.setInt(2,profID);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
			remove=true;

		}catch(SQLException se){

			se.printStackTrace();
		}catch(Exception e){

			e.printStackTrace();
		}finally{

			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		return remove;
	}

	@Override
	public boolean viewEnrolledStudentsInCourse(int courseID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;

		try{

			System.out.println("Connecting to database...");
			conn = DBConnection.getConnection();
			String sql = "SELECT * FROM studentcourse WHERE courseid=?" ;
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,courseID);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				int studentID1  = rs.getInt("studentid");
				System.out.println("ID: " + studentID1);
			}

			stmt.close();
			conn.close();

		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){

			e.printStackTrace();
		}finally{

			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		return false;
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
	
}
