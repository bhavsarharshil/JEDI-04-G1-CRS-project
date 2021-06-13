package com.flipkart.constant;

public class SQLQueriesConstant {
	public static final String VERIFY_LOGIN_QUERY = "SELECT * FROM user WHERE id=? AND password =? ;";
	public static final String LOG_IN = "UPDATE user SET isLogged=1 WHERE id=? AND password =?;";
	public static final String GET_USER_BY_ID = "SELECT * FROM user WHERE id=?";
	public static final String INSERT_SEMREGISTRATION = "INSERT INTO semregistration (courseid,studentid,isPrimary,datetime) VALUES (?,?,?,?);";
	public static final String DELETE_PRIMARY_SM = "DELETE  FROM semregistration WHERE isPrimary=1 AND studentid=? AND courseid=?";
	public static final String DELETE_SECONDARY_SM = "DELETE  FROM semregistration WHERE isPrimary=0 AND studentid=? AND courseid=?";
	public static final String SELECT_PRIMARY_COURSE = "SELECT * FROM semregistration WHERE studentid=? AND isPrimary=1";
	public static final String SELECT_SECONDARY_COURSE = "SELECT * FROM semregistration WHERE studentid=? AND isPrimary=0";
	public static final String GET_SM_BY_ID = "SELECT * FROM semregistration WHERE studentid=? AND courseid=?";
	public static final String DELETE_SM_BY_ID = "DELETE FROM semregistration WHERE studentid=?";
	public static final String SELECT_SEM_REGISTRATION = "Select courseid,studentid from semregistration where isPrimary=1;";
	public static final String DELETE_SEM_REGISTRATION = "Delete from semregistration;";
	public static final String ADD_COURSE_STUDENT = "Insert into studentcourse values(?,?);";
	public static final String SELECT_USERS = "Select * from user;";
	public static final String INSERT_PROFESSOR = "Insert into user values(?,?,?,\"professor\",0,?);";
	public static final String INSERT_STUDENT = "Insert into user values(?,?,?,\"student\",0,?);";
	public static final String INSERT_COURSE = "Insert into course values(?,?,?);";
	public static final String DELETE_USER_BY_ID = "Delete from user where id=?";
	public static final String DELETE_COURSE_BY_ID = "Delete from course where id=?";

	public static final String GET_GRADES_QUERY = "SELECT grade.courseId, course.name as courseName, grade.grade, grade.studentId FROM grade INNER JOIN course ON grade.courseId = course.id AND grade.studentId=?";

	public static final String SET_PAYMENT_STATUS_QUERY = "UPDATE payment set status = true , mode = ?,paymentdate=?  WHERE studentid=?" ; 
	
	
	public static final String GET_ALL_COURSES_QUERY = "SELECT cc.id, cc.name, cc.credits, c.profId FROM course AS cc INNER JOIN courseprof AS c ON cc.id = c.courseid " ; 

	public static final String GET_PROFESSOR_BY_ID_QUERY = "SELECT name FROM user WHERE id = ?";
	public static final String SELECT_PROFESSORS = "Select * from user where role=\"professor\"";
	public static final String SELECT_STUDENTS = "Select * from user where role=\"student\"";
	public static final String SELECT_COURSES = "Select * from course";
	public static final String GET_PAYMENT_STATUS = "SELECT status , amount FROM payment WHERE studentid =?";
	public static final String SELECT_DISTINCT_SEM_REGISTRATION = "Select distinct(studentid) from semregistration";
	public static final String INSERT_PAYMENT = "Insert into payment values(?,?,\"null\",?,\"null\",5000,0)";
	public static final String INSERT_GRADE = "insert into grade values(?,?,?)";
	
	
}
