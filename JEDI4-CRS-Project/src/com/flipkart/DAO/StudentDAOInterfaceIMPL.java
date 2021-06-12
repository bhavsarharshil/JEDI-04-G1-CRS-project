package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;
import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.utils.DBConnection;

public class StudentDAOInterfaceIMPL implements StudentDAOInterface {
	

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
		Student student = new Student();
		PreparedStatement stmt = null;
		Connection conn = DBConnection.getConnection();
		try {
			
			stmt = conn.prepareStatement(SQLQueriesConstant.GET_USER_BY_ID);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				student.setId(rs.getInt("id"));
				student.setEmail(rs.getString("email"));
				student.setRole(rs.getString("role"));
				student.setLoggedin(rs.getBoolean("isLogged"));
				student.setName(rs.getString("name"));
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
		return student;
	}
	
	@Override
	public void addPrimaryCourse(int studentId, int courseId) {
		try {
			/*if(!courseDAO.getCourse(courseId)) {
				System.out.println("Invalid Course ID");
				return;
			}*/
			if(alreadyPresent(studentId, courseId)) {
				System.out.println("You have already added this course");
				return;
			}
			PreparedStatement stmt = null;
			Connection conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueriesConstant.INSERT_SEMIREGISTRATION);
			java.util.Date date = new java.util.Date();
			java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());
			stmt.setInt(1, courseId);
			stmt.setInt(2, studentId);
			stmt.setInt(3, 1);
			stmt.setTimestamp(4,sqlTime);
			int added = stmt.executeUpdate();
			if(added>0) {
				System.out.println("Course " + courseId + " added successfully\n");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void addSecondaryCourse(int studentId, int courseId) {
		try {
			/*if(!courseDAO.getCourse(courseId)) {
				System.out.println("Invalid Course ID");
				return;
			}*/
			if(alreadyPresent(studentId, courseId)) {
				System.out.println("You have already added this course");
				return;
			}
			PreparedStatement stmt = null;
			Connection conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueriesConstant.INSERT_SEMIREGISTRATION);
			java.util.Date date = new java.util.Date();
			java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());
			stmt.setInt(1, courseId);
			stmt.setInt(2, studentId);
			stmt.setInt(3, 0);
			stmt.setTimestamp(4,sqlTime);
			int added = stmt.executeUpdate();
			if(added>0) {
				System.out.println("Course " + courseId + " added successfully\n");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override
	public void removePrimaryCourse(int studentId, int courseId) {
		/*if(!courseDAO.getCourse(courseId)) {
		System.out.println("Invalid Course ID");
		return;
		}*/
		if(!alreadyPresent(studentId, courseId)) {
			System.out.println("You have not registered for this course");
			return;
		}
		try {
			PreparedStatement stmt = null;
			Connection conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueriesConstant.DELETE_PRIMARY_SM);
			stmt.setInt(1, studentId);
			stmt.setInt(2, courseId);
			int dropped = stmt.executeUpdate();
			if(dropped > 0) {
				System.out.println("Course" + courseId + " deleted successfully");
			}else {
				System.out.println("You have added this course as secondary");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Override 
	public void removeSecondaryCourse(int studentId, int courseId) {
		/*if(!courseDAO.getCourse(courseId)) {
		System.out.println("Invalid Course ID");
		return;
		}*/
		if(!alreadyPresent(studentId, courseId)) {
			System.out.println("You have not registered for this course");
			return;
		}
		try {
			PreparedStatement stmt = null;
			Connection conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueriesConstant.DELETE_SECONDARY_SM);
			stmt.setInt(1, studentId);
			stmt.setInt(2, courseId);
			int dropped = stmt.executeUpdate();
			if(dropped > 0) {
				System.out.println("Course" + courseId + " deleted successfully");
			}else {
				System.out.println("You have added this course as primary");
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	@Override
	public ArrayList<Course> getPrimaryRegisteredCourses(int studentId) {
		ArrayList<Course> primaryCourses = new ArrayList<Course>();
		try {
			PreparedStatement stmt = null;
			Connection conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueriesConstant.SELECT_PRIMARY_COURSE);
			stmt.setInt(1, studentId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Course course = new Course();
				course.setCourseID(rs.getInt(1));
				course.setCourseName(rs.getString(2));
				course.setCredits(rs.getInt(3));
				primaryCourses.add(course);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return primaryCourses;
	}
	
	@Override
	public ArrayList<Course> getSecondaryRegisteredCourses(int studentId) {
		ArrayList<Course> secondaryCourses = new ArrayList<Course>();
		try {
			PreparedStatement stmt = null;
			Connection conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueriesConstant.SELECT_SECONDARY_COURSE);
			stmt.setInt(1, studentId);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Course course = new Course();
				course.setCourseID(rs.getInt(1));
				course.setCourseName(rs.getString(2));
				course.setCredits(rs.getInt(3));
				secondaryCourses.add(course);
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return secondaryCourses;
	}
	public boolean alreadyPresent(int studentId,int courseId) {
		try {
			PreparedStatement stmt = null;
			Connection conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueriesConstant.GET_SM_BY_ID);
			stmt.setInt(1, studentId);
			stmt.setInt(2, courseId);
			ResultSet rs = stmt.executeQuery();
			if(!rs.next()) {
				return false;
			}
			rs.close();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return true;
	}

	@Override
	public void deleteFromSemiRegistration(int studentId) {
		// NOT TESTED
		try {
			PreparedStatement stmt = null;
			Connection conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueriesConstant.DELETE_SM_BY_ID);
			stmt.setInt(1, studentId);
			stmt.executeQuery();
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
