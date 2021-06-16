package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grades;
import com.flipkart.bean.Payment;
import com.flipkart.bean.Student;
import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.exception.CourseLimitReached;
import com.flipkart.exception.CourseNotFound;

import com.flipkart.exception.NotFound;
import com.flipkart.utils.DBConnection;

import com.flipkart.utils.*;


public class StudentDAOInterfaceIMPL implements StudentDAOInterface {
	
	private static Logger logger = LoggerFactory.getLogger(StudentDAOInterface.class);
	
	private static StudentDAOInterfaceIMPL instance = null;
	
	Connection connection = null;
	
	PreparedStatement ps = null;
	
	public static StudentDAOInterfaceIMPL getInstance()
	{
		if(instance == null)
		{
			instance = new StudentDAOInterfaceIMPL();
		}
		return instance;
	}

	/**
	 * @param studentID id of student
	 * @return array list of grades
	 */
	@Override
	public ArrayList<Grades> getGrades(int studentID){
		ArrayList<Grades> grades = null;

		try{
			connection = DBConnection.getConnection();
			ps = connection.prepareStatement(SQLQueriesConstant.GET_GRADES_QUERY);

			ps.setInt(1,studentID);
			ResultSet resultSet = ps.executeQuery();
			grades = new ArrayList<Grades>();
			while(resultSet.next()){
				Grades grade = new Grades();
				grade.setCourseID(resultSet.getInt("courseId"));
				grade.setCourseName(resultSet.getString("courseName"));
				grade.setGrade(resultSet.getString("grade"));
				grade.setStudentId(resultSet.getInt("studentId"));
				grades.add(grade);
			}
		}
		catch(SQLException e) {
			logger.error(e.getMessage());
		}
		catch(Exception e) {
			logger.error(e.getMessage());
		}

		return grades;
	}

	/**
	 * @param student student bean
	 * @return boolean: true if student added successfully
	 */
	@Override
	public boolean addStudent(Student student) {
		// TODO Auto-generated method stub
		PreparedStatement stmt,stmt2 = null;
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			stmt=conn.prepareStatement(SQLQueriesConstant.INSERT_STUDENT_USER);
			stmt.setInt(1, student.getId());
			stmt.setString(2, student.getEmail());
			stmt.setString(3, student.getPassword());
			stmt.setString(4, student.getName());
			stmt2 = conn.prepareStatement(SQLQueriesConstant.INSERT_STUDENT_STUDENT);
			stmt2.setInt(1,student.getId());
			stmt2.setBoolean(2,false);
			stmt2.setString(3,student.getBranch());
			stmt2.setInt(4,student.getAdmission_year());
			stmt2.setInt(5,student.getSemester());
			int res=stmt.executeUpdate();
			int res2 = stmt2.executeUpdate();
			if(res==1 && res2==1) {
				return true;
			}
			return false;
		}
		catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return false;
	}

	/**
	 * @param student student bean
	 * @param method payment method
	 * returns the due amount
	 */
	@Override
	public int setPaymentStatus(int studentId, String method) {
		try{
			connection = DBConnection.getConnection();
			ps = connection.prepareStatement(SQLQueriesConstant.GET_PAYMENT_STATUS);
			ps.setInt(1, studentId);
			ResultSet resultSet = ps.executeQuery();
			if(!resultSet.next()) {
				throw new NotFound("\nThere are no payments to show\n");
			}
			else {
				int status = resultSet.getInt("status");
				int amount = resultSet.getInt("amount");
				if(status == 1){
					return 0;
				}
				else
				{
					ps = connection.prepareStatement(SQLQueriesConstant.SET_PAYMENT_STATUS_QUERY);
					ps.setString(1, method);
					ps.setString(2, String.valueOf(LocalDate.now()));
					ps.setInt(3, studentId);
					ps.executeUpdate();
					return amount;
				}
			}
		}
		catch(SQLException e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		return -1;
	}

	/**
	 * @param id id of student
	 * @return Student bean
	 */
	@Override
	public Student getStudentById(int id) {
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
			logger.error("\n"+e.getMessage()+"\n");
		} catch (Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		return student;
	}
	/**
	 * @param studentId id of student
	 * @param courseId id of course
	 * method to add primary course
	 */
	@Override
	public boolean addPrimaryCourse(int studentId, int courseId) {
		
		try {
			if(countPrimaryCourses(studentId) >= 4) {
				throw new CourseLimitReached("You can only add 4 primary courses.");
			}
			CoursesDAOInterface courseDAO = new CoursesDAOInterfaceIMPL();
			if(!courseDAO.hasCourse(courseId)) {
				throw new CourseNotFound("Invalid Course ID");
			}
			if(alreadyPresent(studentId, courseId)) {
				throw new NotFound("\nYou have already added this course\n");
			}
			PreparedStatement stmt = null;
			Connection conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueriesConstant.INSERT_SEMREGISTRATION);
			java.util.Date date = new java.util.Date();
			java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());
			stmt.setInt(1, courseId);
			stmt.setInt(2, studentId);
			stmt.setInt(3, 1);
			stmt.setTimestamp(4,sqlTime);
			int added = stmt.executeUpdate();
			if(added>0) {
				return true;
			}
		}catch(SQLException e) {
			logger.error(e.getMessage());
		}
		catch(Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}
	/**
	 * @param studentId id of student
	 * @param courseId id of course
	 * method to add secondary course
	 */
	@Override
	public boolean addSecondaryCourse(int studentId, int courseId) {
		try {
			CoursesDAOInterface courseDAO = new CoursesDAOInterfaceIMPL();
			if(countSecondaryCourses(studentId) >= 2) {
				throw new CourseLimitReached("You can only add 2 secondary courses.");
			}
			if(!courseDAO.hasCourse(courseId)) {
				throw new CourseNotFound("Invalid Course ID");
			}
			if(alreadyPresent(studentId, courseId)) {
				throw new NotFound("\nYou have already added this course\n");
			}
			PreparedStatement stmt = null;
			Connection conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueriesConstant.INSERT_SEMREGISTRATION);
			java.util.Date date = new java.util.Date();
			java.sql.Timestamp sqlTime = new java.sql.Timestamp(date.getTime());
			stmt.setInt(1, courseId);
			stmt.setInt(2, studentId);
			stmt.setInt(3, 0);
			stmt.setTimestamp(4,sqlTime);
			int added = stmt.executeUpdate();
			if(added>0) {
				return true;
			}
		}catch(SQLException e) {
			logger.error(e.getMessage());
		}
		catch(Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}
	/**
	 * @param studentId id of student
	 * @param courseId id of course
	 * method to remove primary course
	 */
	@Override
	public boolean removePrimaryCourse(int studentId, int courseId) {
		try {
			CoursesDAOInterface courseDAO = new CoursesDAOInterfaceIMPL();
			if(!courseDAO.hasCourse(courseId)) {
				throw new CourseNotFound("\nInvalid Course ID\n");
			}
			if(!alreadyPresent(studentId, courseId)) {
				throw new NotFound("\nYou have not registered for this course\n");
			}
			PreparedStatement stmt = null;
			Connection conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueriesConstant.DELETE_PRIMARY_SM);
			stmt.setInt(1, studentId);
			stmt.setInt(2, courseId);
			int dropped = stmt.executeUpdate();
			if(dropped > 0) {
				return true;
			}else {
				throw new NotFound("\nYou have added this course as secondary\n");
			}
		}catch(SQLException e) {
			logger.error(e.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}
	/**
	 * @param studentId id of student
	 * @param courseId id of course
	 * method to remove secondary course
	 */
	@Override 
	public boolean removeSecondaryCourse(int studentId, int courseId) {
		try {
			CoursesDAOInterface courseDAO = new CoursesDAOInterfaceIMPL();
			if(!courseDAO.hasCourse(courseId)) {
				throw new CourseNotFound("Invalid Course ID");
			}else if(!alreadyPresent(studentId, courseId)) {
				throw new NotFound("\nYou have not registered for this course\n");
			}else {
				PreparedStatement stmt = null;
				Connection conn = DBConnection.getConnection();
				stmt = conn.prepareStatement(SQLQueriesConstant.DELETE_SECONDARY_SM);
				stmt.setInt(1, studentId);
				stmt.setInt(2, courseId);
				int dropped = stmt.executeUpdate();
				if(dropped > 0) {
					return true;
				}else {
					throw new NotFound("\nYou have added this course as primary\n");
				}
			}
		}catch(SQLException e) {
			logger.error(e.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}

	/**
	 * @param studentId id of student
	 * @return array list of registered primary course
	 */
	@Override
	public ArrayList<Course> getPrimaryRegisteredCourses(int studentId) {
		ArrayList<Course> primaryCourses = null;
		try {
			PreparedStatement stmt = null;
			Connection conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueriesConstant.SELECT_PRIMARY_COURSE);
			stmt.setInt(1, studentId);
			ResultSet rs = stmt.executeQuery();
			primaryCourses = new ArrayList<Course>();
			while(rs.next()) {			
				PreparedStatement stmt2 = conn.prepareStatement(SQLQueriesConstant.GET_COURSE_BY_ID);
				stmt2.setInt(1, rs.getInt(1));
				ResultSet rs2 = stmt2.executeQuery();
				rs2.next();
				Course course = new Course();
				course.setCourseID(rs2.getInt(1));
				course.setCourseName(rs2.getString(2));
				course.setCredits(rs2.getInt(3));
				primaryCourses.add(course);
			}
		}catch(SQLException e) {
			logger.error(e.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return primaryCourses;
	}
	

	/**
	 * @param studentId id of student
	 * @return array list of secondary registered course
	 */
	@Override
	public ArrayList<Course> getSecondaryRegisteredCourses(int studentId) {
		ArrayList<Course> secondaryCourses = null;
		try {
			PreparedStatement stmt = null;
			Connection conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueriesConstant.SELECT_SECONDARY_COURSE);
			stmt.setInt(1, studentId);
			ResultSet rs = stmt.executeQuery();
			secondaryCourses = new ArrayList<Course>();
			while(rs.next()) {
				PreparedStatement stmt2 = conn.prepareStatement(SQLQueriesConstant.GET_COURSE_BY_ID);
				stmt2.setInt(1, rs.getInt(1));
				ResultSet rs2 = stmt2.executeQuery();
				rs2.next();
				Course course = new Course();
				course.setCourseID(rs2.getInt(1));
				course.setCourseName(rs2.getString(2));
				course.setCredits(rs2.getInt(3));
				secondaryCourses.add(course);
			}
		}catch(SQLException e) {
			logger.error(e.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return secondaryCourses;
	}

	/**
	 * @param studentId id of student
	 * @param courseId id of course
	 * @return boolean: true if student already registered for course
	 */
	@Override
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
			logger.error(e.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return true;
	}

	/**
	 * @param studentId id of student
	 * method to delete from semregistration
	 */
	@Override
	public void deleteFromSemiRegistration(int studentId) {
		// NOT TESTED
		try {
			PreparedStatement stmt = null;
			Connection conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueriesConstant.DELETE_SM_BY_ID);
			stmt.setInt(1, studentId);
			stmt.executeUpdate();
		}catch(SQLException e) {
			logger.error(e.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
	}

	/**
	 * @param studentId id of student
	 * @return number of primary courses
	 */
	public int countPrimaryCourses(int studentId) {
		try {
			PreparedStatement stmt = null;
			Connection conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueriesConstant.GET_PRIMARY_COURSE_NO);
			stmt.setInt(1, studentId);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		}catch(SQLException e) {
			logger.error(e.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return 0;
	}

	/**
	 * @param studentId id of student
	 * @return number of secondary courses
	 */
	public int countSecondaryCourses(int studentId) {
		try {
			PreparedStatement stmt = null;
			Connection conn = DBConnection.getConnection();
			stmt = conn.prepareStatement(SQLQueriesConstant.GET_SECONDARY_COURSE_NO);
			stmt.setInt(1, studentId);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		}catch(SQLException e) {
			logger.error(e.getMessage());
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return 0;
	}
	public Payment viewPayments(int studentId) {
		try{
			connection = DBConnection.getConnection();
			ps = connection.prepareStatement(SQLQueriesConstant.GET_PAYMENTS);
			ps.setInt(1, studentId);
			ResultSet resultSet = ps.executeQuery();
			if(!resultSet.next()) {
				throw new NotFound("\nThere are no payments to show\n");
			}
			else {
				int status = resultSet.getInt("status");
				int amount = resultSet.getInt("amount");
				if(status == 1){
					Payment payment = new Payment();
					payment.setAmount(amount);
					payment.setDate(resultSet.getString("paymentDate"));
					payment.setPaymentID(resultSet.getInt("paymentid"));
					payment.setMethod(resultSet.getString("mode"));
					return payment;
				}
			}
		}
		catch(SQLException e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		return null;
	}
}

		