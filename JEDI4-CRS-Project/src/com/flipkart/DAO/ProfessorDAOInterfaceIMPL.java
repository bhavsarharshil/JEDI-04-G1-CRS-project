package com.flipkart.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.flipkart.bean.Professor;
import com.flipkart.utils.DBConnection;
import com.flipkart.constant.SQLQueriesConstant;
public class ProfessorDAOInterfaceIMPL implements ProfessorDAOInterface {
	private static ProfessorDAOInterfaceIMPL instance = null;
	
	private static Logger logger = Logger.getLogger(ProfessorDAOInterfaceIMPL.class);
	
	public static ProfessorDAOInterfaceIMPL getInstance() {
		if (instance == null) {
			instance = new ProfessorDAOInterfaceIMPL();
		}
		return instance;
	}
	/**
	 * @param id id of professor
	 * @return Professor bean
	 */
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
			logger.info(e.getMessage());
		} catch (Exception e) {
			logger.info(e.getMessage());
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

	/**
	 * @param professorID id of professor
	 * @return professor name
	 */
	@Override
	public String getProfessorByIdName(int professorID)
	{
		String professorName = null;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBConnection.getConnection();
			stmt = con.prepareStatement(SQLQueriesConstant.GET_PROFESSOR_BY_ID_QUERY);

			stmt.setInt(1, professorID);

			ResultSet resultSet = stmt.executeQuery();
			if (resultSet.next()) {
				professorName = resultSet.getString("name");
			}
		} catch (SQLException e) {
			logger.info(e.getMessage());
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

		return professorName;
	}

	/**
	 * @param courseID id of course
	 * @param studentID if of student
	 * @param grade grade of student in course
	 * @return boolean: true if student graded correctly
	 */
	@Override
	public boolean gradeStudents(int courseID, int studentID,String grade) {

		// TODO Auto-generated method stub
		PreparedStatement stmt = null;
		boolean update=false;
		Connection conn = null;
		try{
			conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueriesConstant.INSERT_GRADE);

			stmt.setInt(1,studentID);
			stmt.setInt(2,courseID);
			stmt.setString(3, grade);
			stmt.executeUpdate();

			stmt.close();
			conn.close();
			update=true;
			System.out.println("Grade added successfully\n\n");

		}catch(SQLException se){
			//Handle errors for JDBC
			logger.info(se.getMessage());
		}catch(Exception e){
			//Handle errors for Class.forName
			logger.info(e.getMessage());
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
				logger.info(se2.getMessage());
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				logger.info(se.getMessage());
			}//end finally try
		}//end try
		return update;
	}

	/**
	 * @param courseID id of course
	 * @param studentID id of student
	 * method to view grades
	 */
	@Override
	public void viewGrades(int courseID,int studentID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;

		try{

			System.out.println("======Grades======");
			conn = DBConnection.getConnection();
			String sql = SQLQueriesConstant.GRADES_QUERY_WITH_ID;
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
			logger.info(se.getMessage());
		}catch(Exception e){

			logger.info(e.getMessage());
		}finally{

			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
				logger.info(se2.getMessage());
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				logger.info(se.getMessage());
			}
		}
	}

	/**
	 * @param profID id of professor
	 * method to show courses taught by professors
	 */
	@Override
	public void showAssignedCourses(int profID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;

		try{

			System.out.println("=======Assigned Courses=======");
			conn = DBConnection.getConnection();
			String sql =SQLQueriesConstant.GET_PROF_WITH_ID;
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

			logger.info(se.getMessage());
		}catch(Exception e){

			logger.info(e.getMessage());
		}finally{

			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
				logger.info(se2.getMessage());
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				logger.info(se.getMessage());
			}
		}
	}

	/**
	 * @param courseID id of course
	 * @param profID id of professor
	 * @return boolean:m true if course assigned correctly
	 */
	@Override
	public boolean addAssignedCourse(int courseID,int profID) {
		// TODO Auto-generated method stub
		boolean added=false;
		Connection conn = null;
		PreparedStatement stmt = null;

		try{
			conn = DBConnection.getConnection();
			// System.out.println("Creating statement...");
			String sql=SQLQueriesConstant.INSERT_INTO_COURSEPROF;
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1,courseID);
			stmt.setInt(2,profID);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
			added=true;
			System.out.println("Course assigned successfully");

		}catch(SQLException se){
			logger.info(se.getMessage());
		}catch(Exception e){

			logger.info(e.getMessage());
		}finally{

			try{
				if(stmt!=null)
					stmt.close();
			}
			catch(SQLException se2){
				logger.info(se2.getMessage());
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				logger.info(se.getMessage());
			}
		}
		return added;
	}

	/**
	 * @param courseID id of course
	 * @param profID id of professor
	 * @return boolean: true id assigned course removed correctly
	 */
	@Override
	public boolean removeAssignedCourse(int courseID,int profID) {
		// TODO Auto-generated method stub
		boolean remove=false;
		Connection conn = null;
		PreparedStatement stmt = null;

		try{
			conn = DBConnection.getConnection();
			String sql = SQLQueriesConstant.DELETE_FROM_COURSEPROF;
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,courseID);
			stmt.setInt(2,profID);
			stmt.executeUpdate();
			stmt.close();
			conn.close();
			remove=true;
			System.out.println("Course removed successfully");

		}catch(SQLException se){

			logger.info(se.getMessage());
		}catch(Exception e){

			logger.info(e.getMessage());
		}finally{

			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2)
			{
				logger.info(se2.getMessage());
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				logger.info(se.getMessage());
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

			System.out.println("=====Enrolled Students in course"+String.valueOf(courseID)+"======");
			conn = DBConnection.getConnection();
			String sql = SQLQueriesConstant.SELECT_FROM_STUDENTCOURSE;
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
			logger.info(se.getMessage());
		}catch(Exception e){

			logger.info(e.getMessage());
		}finally{

			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2)
			{
				logger.info(se2.getMessage());
			}
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				logger.info(se.getMessage());
			}
		}
		return false;
	}

	/**
	 * @param courseID id of course
	 * @return number of students enrolled
	 */
	@Override
	public int getStudentCount(int courseID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		try
		{
			conn = DBConnection.getConnection();
			String sql = SQLQueriesConstant.GET_STUDENT_COUNT;
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,courseID);
			ResultSet rs = stmt.executeQuery();
			
			int count = rs.getInt("total");
			
			return count ; 
		}
		catch(SQLException se){
			logger.info(se.getMessage());
		}
		return 0;
	}

	/**
	 * @param courseID id of course
	 * @return boolean: true if course already taught by some professor
	 */
	@Override
	public boolean getCoursePresence(int courseID) {
		// TODO Auto-generated smethod stub
		Connection conn = null;
		PreparedStatement stmt = null;
		try
		{
			conn = DBConnection.getConnection();
			String sql = SQLQueriesConstant.GET_COURSE_STATUS;
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,courseID);
			ResultSet rs = stmt.executeQuery();
			
			boolean status = rs.next();
			return status;
		}
		catch(SQLException se){
			logger.info(se.getMessage());
		};
		return false;
	}
	
}
