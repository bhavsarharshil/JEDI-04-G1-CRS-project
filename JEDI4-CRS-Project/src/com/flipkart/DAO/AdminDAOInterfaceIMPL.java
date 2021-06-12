package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
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
	
	
	
	 
	// Declare the Connection or prepaidstatement variable here 
   	Connection conn = null;
   	PreparedStatement stmt = null;
	   	
   	@Override
   	public void viewReportCard(Student student) {
		try {
		    conn = DBConnection.getConnection();
		    stmt=conn.prepareStatement(SQLQueriesConstant.SELECT_USERS);
		    ResultSet res=stmt.executeQuery();
		    while(res.next()) {
		    	System.out.println(res.getInt("id")+"\t"+res.getString("role"));
		    }
		    System.out.println("Query executed");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean addProfessor(Professor professor) {
		// TODO Auto-generated method stub
		try {
		   	conn = DBConnection.getConnection();
		    stmt=conn.prepareStatement(SQLQueriesConstant.INSERT_PROFESSOR);
		    stmt.setInt(1, professor.getId());
		    stmt.setString(2, professor.getEmail());
		    stmt.setString(3, professor.getPassword());
		    stmt.setString(4, professor.getName());
		    int res=stmt.executeUpdate();
		    if(res==1) {
		    	System.out.println("Professor successfully added.");
		    	return true;
		    }
		    System.out.println("Unable to add Professor");
		    return false;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeProfessor(Professor professor) {
		// TODO Auto-generated method stub
		try {
		   	conn = DBConnection.getConnection();
		    stmt=conn.prepareStatement(SQLQueriesConstant.DELETE_USER_BY_ID);
		    stmt.setInt(1, professor.getId());
		    int res=stmt.executeUpdate();
		    if(res==1) {
		    	System.out.println("Professor successfully deleted.");
		    	return true;
		    }
		    System.out.println("Unable to delete Professor");
		    return false;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		try {
			conn = DBConnection.getConnection();
		    stmt=conn.prepareStatement(SQLQueriesConstant.INSERT_STUDENT);
		    stmt.setInt(1, student.getId());
		    stmt.setString(2, student.getEmail());
		    stmt.setString(3, student.getPassword());
		    stmt.setString(4, student.getName());
		    int res=stmt.executeUpdate();
		    if(res==1) {
		    	System.out.println("Student successfully added.");
		    	return true;
		    }
		    System.out.println("Unable to add Student");
		    return false;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

		@Override
	public boolean removeStudent(Student student) {
		// TODO Auto-generated method stub
		try {
			conn = DBConnection.getConnection();
		    stmt=conn.prepareStatement(SQLQueriesConstant.DELETE_USER_BY_ID);
		    stmt.setInt(1, student.getId());
		    int res=stmt.executeUpdate();
		    if(res==1) {
		    	System.out.println("Student successfully deleted.");
		    	return true;
		    }
		    System.out.println("Unable to delete Student");
		    return false;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addCourse(Course course) {
		// TODO Auto-generated method stub
		try {
		   	conn = DBConnection.getConnection();
		    stmt=conn.prepareStatement(SQLQueriesConstant.INSERT_COURSE);
		    stmt.setInt(1, course.getCourseID());
		    stmt.setString(2, course.getCourseName());
		    stmt.setInt(3, course.getCredits());
		    int res=stmt.executeUpdate();
		    if(res==1) {
		    	System.out.println("Course successfully added.");
		    	return true;
		    }
		    System.out.println("Unable to add course");
		    return false;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removeCourse(Course course) {
		// TODO Auto-generated method stub
		try {
			conn = DBConnection.getConnection();
		    stmt=conn.prepareStatement(SQLQueriesConstant.DELETE_COURSE_BY_ID);
		    stmt.setInt(1, course.getCourseID());
		    int res=stmt.executeUpdate();
		    if(res==1) {
		    	System.out.println("Course successfully added.");
		    	return true;
		    }
		    System.out.println("Unable to add course");
		    return false;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void approveStudents() {
		// TODO Auto-generated method stub
		PreparedStatement stmt=null;
		try {
			conn=DBConnection.getConnection();
			stmt=conn.prepareStatement(SQLQueriesConstant.SELECT_SEM_REGISTRATION);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				stmt.setInt(1,rs.getInt("studentid"));
				stmt.setInt(2,rs.getInt("courseid"));
				stmt=conn.prepareStatement(SQLQueriesConstant.ADD_COURSE_STUDENT);
			}
			System.out.println("All students are approved");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
