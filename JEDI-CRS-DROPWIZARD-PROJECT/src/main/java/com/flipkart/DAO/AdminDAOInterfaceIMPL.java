package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Vector;

import com.flipkart.bean.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.utils.DBConnection;


public class AdminDAOInterfaceIMPL implements AdminDAOInterface {

	public static Logger logger=LoggerFactory.getLogger(AdminDAOInterfaceIMPL.class);
	/**
	 * @param id id of professor
	 * @return Admin bean
	 */
	@Override
	public Admin getAdminById(int id) {
		// TODO Auto-generated method stub
		Admin admin = new Admin();
		PreparedStatement stmt = null;

		try {
			Connection conn = DBConnection.getConnection();
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
			logger.error(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		finally{
			try{
				if(stmt!=null)
					stmt.close();
			}
			catch(SQLException se2){
				logger.error(se2.getMessage());
			}

		}
		return admin;
	}




	// Declare the Connection or prepaidstatement variable here
	Connection conn = null;
	PreparedStatement stmt = null;
	/**
	 * method to view report card
	 * @return
	 */
	@Override
	public Vector<Grades> viewReportCard(int id) {
		try {

			conn = DBConnection.getConnection();
			stmt=conn.prepareStatement(SQLQueriesConstant.GET_GRADES_QUERY);
			stmt.setInt(1,id);
			ResultSet res =stmt.executeQuery();
			logger.info("-----------------------------------------------------------------------------");
			logger.info(String.format("%10s %30s ", "Course NAME",  "GRADE"));
			logger.info("-----------------------------------------------------------------------------");
			Vector<Grades> reportCard = new Vector();
			Grades g ;
			while(res.next()) {
				logger.info(String.format("%10s %30s ",res.getString("coursename"),res.getString("grade")));
				g = new Grades();
				g.setCourseID(res.getInt("courseid"));g.setCourseName(res.getString("coursename"));
				g.setGrade(res.getString("grade"));
				g.setStudentId(id);
				reportCard.add(g);
			}
			logger.info("\n\n");

			return reportCard;
		}catch (SQLException e) {
			logger.error(e.getMessage());
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	/**
	 * method to add professor
	 */
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
				stmt=conn.prepareStatement(SQLQueriesConstant.INSERT_PROFESSOR_PROFESSOR);
				stmt.setInt(1, professor.getId());
				stmt.setString(2,professor.getDepartment());
				res=stmt.executeUpdate();
				logger.info("Professor successfully added.");
				return true;
			}
			logger.info("Unable to add Professor");
			return false;
		}catch (SQLException e) {
			logger.error(e.getMessage());
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}
	/**
	 *method to remove professor
	 */
	@Override
	public boolean removeProfessor(int id) {
		// TODO Auto-generated method stub
		try {
			conn = DBConnection.getConnection();
			stmt=conn.prepareStatement(SQLQueriesConstant.DELETE_USER_BY_ID);
			stmt.setInt(1, id);
			int res=stmt.executeUpdate();
			if(res==1) {
				logger.info("Professor successfully deleted.");
				return true;
			}
			logger.info("Unable to delete Professor");
			return false;
		}catch (SQLException e) {
			logger.error(e.getMessage());
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}

	/**
	 *method to remove student
	 */
	@Override
	public boolean removeStudent(int id) {
		// TODO Auto-generated method stub
		try {
			conn = DBConnection.getConnection();

			stmt=conn.prepareStatement(SQLQueriesConstant.DELETE_STUDENT_BY_ID);
			stmt.setInt(1, id);
			int res=stmt.executeUpdate();
			
			if(res==1) {
				stmt=conn.prepareStatement(SQLQueriesConstant.DELETE_USER_BY_ID);
				stmt.setInt(1, id);
				res=stmt.executeUpdate();
				logger.info("Student successfully deleted.");
				return true;
			}
			logger.info("Unable to delete Student");
			return false;
		}catch (SQLException e) {
			logger.error(e.getMessage());
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}
	/**
	 * method to add course
	 */
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
				logger.info("Course successfully added.");
				return true;
			}
			System.out.println("Unable to add course");
			return false;
		}catch (SQLException e) {
			logger.error(e.getMessage());
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}
	/**
	 * method to remove course
	 */
	@Override
	public boolean removeCourse(int id) {
		// TODO Auto-generated method stub
		try {
			conn = DBConnection.getConnection();
			stmt=conn.prepareStatement(SQLQueriesConstant.DELETE_COURSE_BY_ID);
			stmt.setInt(1, id);
			int res=stmt.executeUpdate();
			if(res==1) {
				logger.info("Course successfully added.");
				return true;
			}
			logger.info("Unable to add course");
			return false;
		}catch (SQLException e) {
			logger.error(e.getMessage());
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}
	/**
	 *method to approve courses of students
	 * @return
	 */
	@Override
	public boolean approveStudents() {
		// TODO Auto-generated method stub
		PreparedStatement stmt=null;
		try {
			conn=DBConnection.getConnection();
			stmt=conn.prepareStatement(SQLQueriesConstant.SELECT_SEM_REGISTRATION);
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				stmt=conn.prepareStatement(SQLQueriesConstant.ADD_COURSE_STUDENT);
				stmt.setInt(1,rs.getInt("studentid"));
				stmt.setInt(2,rs.getInt("courseid"));
				int x=stmt.executeUpdate();
				if(x!=1) {
					logger.info("Error in approving");
					break;
				}
			}
			stmt=conn.prepareStatement(SQLQueriesConstant.SELECT_DISTINCT_SEM_REGISTRATION);
			rs=stmt.executeQuery();
			LocalDateTime cur_date=LocalDateTime.now();
			String date="";
			date+=String.valueOf(cur_date.getYear())+"-"+String.valueOf(cur_date.getMonthValue())+"-"+String.valueOf(cur_date.getDayOfMonth());
			while(rs.next()) {
				stmt=conn.prepareStatement(SQLQueriesConstant.INSERT_PAYMENT);
				stmt.setInt(1,cur_date.getNano());
				stmt.setInt(2,rs.getInt("studentid"));
				stmt.setString(3, String.valueOf(LocalDate.now()));
				stmt.executeUpdate();
			}
			stmt=conn.prepareStatement(SQLQueriesConstant.DELETE_SEM_REGISTRATION);
			stmt.executeUpdate();
			System.out.println("All students are approved");
			return true;
		}catch (SQLException e) {
			logger.error(e.getMessage());
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}
	/**
	 *method to view unapproved students
	 * @return
	 */
	@Override
	public Vector<Student> viewUnapprovedStudent() {
		PreparedStatement stmt=null;
		try {
			conn=DBConnection.getConnection();
			stmt=conn.prepareStatement(SQLQueriesConstant.VIEW_UNAPPROVED_STUDENTS);
			ResultSet rs=stmt.executeQuery();
			logger.info("-----------------------------------------------------------------------------");
			logger.info(String.format("%10s %30s ", "USER ID",  "USER NAME"));
			logger.info("-----------------------------------------------------------------------------");
			Student s;
			Vector<Student> studentList = new Vector<>();
			while(rs.next()) {
				logger.info(String.format("%10s %30s ",rs.getInt("user.id"),rs.getString("user.name")));
				s = new Student();
				s.setSemester(rs.getInt("semester"));s.setBranch(rs.getString("branch"));
				s.setEmail(rs.getString("email"));s.setId(rs.getInt("id"));s.setRollNo(rs.getInt("id"));
				s.setRole("student");s.setAdmission_year(rs.getInt("admission_year"));
				studentList.add(s);
			}
			logger.info("\n\n");
			return studentList;

		}catch (SQLException e) {
			logger.error(e.getMessage());
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	/**
	 *method to approve registration of students
	 */
	@Override
	public boolean approveStudentsRequest(int id) {
		PreparedStatement stmt=null;
		try {
			conn=DBConnection.getConnection();
			stmt=conn.prepareStatement(SQLQueriesConstant.APPROVE_STUDENTS_REQUEST);
			stmt.setBoolean(1,true);
			stmt.setInt(2,id);
			stmt.executeUpdate();
			return true;
		}catch (SQLException e) {
			logger.error(e.getMessage());
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}
	/**
	 *method to view all professors
	 * @return
	 */
	@Override
	public Vector<Professor> viewProfessors() {
		// TODO Auto-generated method stub
		PreparedStatement stmt=null;
		try {
			conn=DBConnection.getConnection();
			stmt=conn.prepareStatement(SQLQueriesConstant.SELECT_PROFESSORS);
			ResultSet rs=stmt.executeQuery();
			logger.info("-----------------------------------------------------------------------------");
			logger.info(String.format("%10s %30s ", "PROFESSOR ID",  "PROFESSOR NAME"));
			logger.info("-----------------------------------------------------------------------------");
			Professor p;
			Vector<Professor> profList = new Vector<>();
			while(rs.next()) {
				logger.info(String.format("%10s %30s ",rs.getInt("id"),rs.getString("name")));

				p = new Professor();
				p.setEmail(rs.getString("email"));
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setDepartment(rs.getString("department"));
				p.setRole("professor");
				profList.add(p);
			}
			logger.info("\n\n");
			return profList;
		}catch (SQLException e) {
			logger.error(e.getMessage());
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	/**
	 *method to view all students
	 * @return
	 */
	@Override
	public Vector<Student> viewStudents() {
		// TODO Auto-generated method stub
		PreparedStatement stmt=null;
		try {
			conn=DBConnection.getConnection();
			stmt=conn.prepareStatement(SQLQueriesConstant.SELECT_STUDENTS);
			ResultSet rs=stmt.executeQuery();
			logger.info("-----------------------------------------------------------------------------");
			logger.info(String.format("%10s %30s ", "STUDENT ID",  "STUDENT NAME"));
			logger.info("-----------------------------------------------------------------------------");
			Student s;
			Vector<Student> studentList = new Vector<>();
			while(rs.next()) {
				logger.info(String.format("%10s %30s ",rs.getInt("id"),rs.getString("name")));
				s = new Student();
				s.setSemester(rs.getInt("semester"));s.setBranch(rs.getString("branch"));
				s.setEmail(rs.getString("email"));s.setId(rs.getInt("id"));s.setRollNo(rs.getInt("id"));
				s.setRole("student");s.setAdmission_year(rs.getInt("admission_year"));
				studentList.add(s);

			}

			logger.info("\n\n");
			return studentList;
		}catch (SQLException e) {
			logger.error(e.getMessage());
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}
	/**
	 *method to view all courses
	 * @return
	 */
	@Override
	public Vector<Course> viewCourses() {
		// TODO Auto-generated method stub
		PreparedStatement stmt=null;

		try {
			conn=DBConnection.getConnection();
			stmt=conn.prepareStatement(SQLQueriesConstant.SELECT_COURSES);
			ResultSet rs=stmt.executeQuery();
			Vector<Course> courseList = new Vector<>();
			Course c ;
			logger.info("-----------------------------------------------------------------------------");
			logger.info(String.format("%10s %30s ", "COURSE ID",  "COURSE NAME"));
			logger.info("-----------------------------------------------------------------------------");
			while(rs.next()) {
				logger.info(String.format("%10s %30s ",rs.getInt("id"),rs.getString("name")));
				c = new Course();
				c.setCourseID(rs.getInt("id"));
				c.setCourseName(rs.getString("name"));
				c.setCredits(rs.getInt("credits"));
				courseList.add(c);
			}
			logger.info("\n\n");
			return courseList;
		}catch (SQLException e) {
			logger.error(e.getMessage());
		}catch (Exception e) {
			logger.error(e.getMessage());
		}
		return null;
	}

}
