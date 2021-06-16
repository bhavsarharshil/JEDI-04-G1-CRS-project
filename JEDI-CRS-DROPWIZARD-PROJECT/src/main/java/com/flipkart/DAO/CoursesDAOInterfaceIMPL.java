/**
 * 
 */
package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flipkart.bean.Course;
import com.flipkart.constant.SQLQueriesConstant;
import com.flipkart.utils.DBConnection;

/**
 * @author 91883
 *
 */
public class CoursesDAOInterfaceIMPL implements CoursesDAOInterface {
	private static CoursesDAOInterfaceIMPL instance = null;
	Connection connection = null;
	PreparedStatement ps = null;
	private static Logger logger = LoggerFactory.getLogger(CoursesDAOInterfaceIMPL.class);
	
	public static CoursesDAOInterfaceIMPL getInstance()
	{
		if(instance == null)
		{
			instance = new CoursesDAOInterfaceIMPL();
		}
		return instance;
	}

	/**
	 * method to get all courses
	 * @return list of courses
	 */
	@Override
	public ArrayList<Course> getAllCourses() {
		ArrayList<Course> courses = new ArrayList<>();

		try{
			
			connection = DBConnection.getConnection();
			ps = connection.prepareStatement(SQLQueriesConstant.GET_ALL_COURSES_QUERY);
			
			ResultSet resultSet = ps.executeQuery();

			while(resultSet.next()){
				Course course = new Course();
				course.setCourseID(resultSet.getInt("id"));
				course.setCourseName(resultSet.getString("name"));
				course.setCredits(resultSet.getInt("credits"));
				courses.add(course);
			}
		}
		catch(SQLException e) {
			logger.error(e.getMessage());
		}
		catch(Exception e) {
			logger.error(e.getMessage());
		}

		return courses;
		
		// TODO Auto-generated method stub
	}

	/**
	 * @param courseId if of course
	 * @return boolean: true if course exist in db
	 */
	@Override
	public boolean hasCourse(int courseId) {
		try {
			connection = DBConnection.getConnection();
			ps = connection.prepareStatement(SQLQueriesConstant.GET_COURSE_BY_ID);
			ps.setInt(1, courseId);
			ResultSet rs = ps.executeQuery();
			if(rs.next())return true;
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}
}
