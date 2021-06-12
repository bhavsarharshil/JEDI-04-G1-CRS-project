/**
 * 
 */
package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	
	public static CoursesDAOInterfaceIMPL getInstance()
	{
		if(instance == null)
		{
			instance = new CoursesDAOInterfaceIMPL();
		}
		return instance;
	}
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
				course.setProfessorAllotted(resultSet.getInt("profId"));
				courses.add(course);
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage() + "\n");
		}
		catch(Exception e) {
			System.out.println(e.getMessage() + "\n");
		}

		return courses;
		
		// TODO Auto-generated method stub
	}
}
