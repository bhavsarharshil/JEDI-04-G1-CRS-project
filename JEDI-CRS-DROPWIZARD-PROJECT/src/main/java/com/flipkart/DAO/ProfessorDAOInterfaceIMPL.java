package com.flipkart.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.LogRecord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grades;
import com.flipkart.bean.Professor;
import com.flipkart.utils.DBConnection;
import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.exception.NoAssignedCourseException;
public class ProfessorDAOInterfaceIMPL implements ProfessorDAOInterface {
	private static ProfessorDAOInterfaceIMPL instance = null;
	
	private static Logger logger = LoggerFactory.getLogger(ProfessorDAOInterfaceIMPL.class);
	
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
			logger.error("\n"+e.getMessage()+"\n");
		} catch (Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
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
			logger.error("\n"+e.getMessage()+"\n");
		} catch (Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
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
			
			update=true;
			logger.info("Grade added successfully\n\n");

		}catch(SQLException e){
			logger.error("\n"+e.getMessage()+"\n");
		}catch(Exception e){
			logger.error("\n"+e.getMessage()+"\n");
		}
		return update;
	}

	/**
	 * @param courseID id of course
	 * @param studentID id of student
	 * method to view grades
	 */
	@Override
	public Grades viewGrades(int courseID,int studentID) {
		// TODO Auto-generated method stub
		Grades grade = new Grades();
		Connection conn = null;
		PreparedStatement stmt = null;

		try{

			conn = DBConnection.getConnection();
			String sql = SQLQueriesConstant.GRADES_QUERY_WITH_ID;
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,courseID);
			stmt.setInt(2,studentID);
			ResultSet rs = stmt.executeQuery();
			if(!rs.next()) {
				logger.info("\nThere are no grades to show\n");
			}
			else {
				do
				{
					grade.setCourseID(rs.getInt("courseid"));
					grade.setStudentId(rs.getInt("studentid"));
					grade.setGrade(rs.getString("grade"));
					
				}while(rs.next());
			}
		

		}catch(SQLException e){
			logger.error("\n"+e.getMessage()+"\n");
		}catch(Exception e){

			logger.error("\n"+e.getMessage()+"\n");
		}
		return grade;
	}

	/**
	 * @param profID id of professor
	 * method to show courses taught by professors
	 */
	@Override
	public ArrayList<Integer> showAssignedCourses(int profID) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ArrayList<Integer> courses = new ArrayList<Integer>();
		Connection conn = null;
		PreparedStatement stmt = null;

		try{

					
			conn = DBConnection.getConnection();
					
			String sql =SQLQueriesConstant.GET_PROF_WITH_ID;
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,profID);
					
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				int courseID1  = rs.getInt("courseid");
				courses.add(courseID1);
			}

				

			}
			catch(SQLException e){

				logger.error("\n"+e.getMessage()+"\n");
			}catch(Exception e){

				logger.error("\n"+e.getMessage()+"\n");
			}
		return courses;
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
			String sql=SQLQueriesConstant.INSERT_INTO_COURSEPROF;
			stmt = conn.prepareStatement(sql);

			stmt.setInt(1,courseID);
			stmt.setInt(2,profID);
			stmt.executeUpdate();
		
			added=true;
			logger.info("Course assigned successfully");

		}catch(SQLException e){
			logger.error("\n"+e.getMessage()+"\n");
		}catch(Exception e){

			logger.error("\n"+e.getMessage()+"\n");
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
			
			remove=true;
			logger.info("Course removed successfully");

		}catch(SQLException e){

			logger.error("\n"+e.getMessage()+"\n");
		}catch(Exception e){

			logger.error("\n"+e.getMessage()+"\n");
		}
		return remove;
	}

	@Override
	public ArrayList<Integer> viewEnrolledStudentsInCourse(int courseID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ArrayList<Integer> students = new ArrayList<Integer>();
		try{

			
			conn = DBConnection.getConnection();
			String sql = SQLQueriesConstant.SELECT_FROM_STUDENTCOURSE;
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,courseID);
			ResultSet rs = stmt.executeQuery();
			while(rs.next())
			{
				int studentID1  = rs.getInt("studentid");
				students.add(studentID1);
			}

	

		}catch(SQLException e){
			logger.error("\n"+e.getMessage()+"\n");
		}catch(Exception e){

			logger.error("\n"+e.getMessage()+"\n");
		}
		return students;
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
			rs.next();
			int count = rs.getInt("total");
			return count ; 
		}
		catch(SQLException e){
			logger.error("\n"+e.getMessage()+"\n");
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
	@Override
	public boolean NoCoursePresence(int profID) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		try
		{
			conn = DBConnection.getConnection();
			String sql = SQLQueriesConstant.GET_PROFCOURSE_COUNT;
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,profID);
			ResultSet rs = stmt.executeQuery();
			
			boolean status = rs.next();
			return status;
		}
		catch(SQLException e){
			logger.error("\n"+e.getMessage()+"\n");
		};
		return false;
	}
	
}