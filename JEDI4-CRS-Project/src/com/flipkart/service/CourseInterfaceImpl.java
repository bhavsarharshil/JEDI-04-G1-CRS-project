package com.flipkart.service;

import java.util.ArrayList;
import java.util.Vector;

import com.flipkart.DAO.CoursesDAOInterfaceIMPL;
import com.flipkart.bean.*;

public class CourseInterfaceImpl implements CourseInterface {


	/**
	 * method to view course catalog
	 */
	@Override
	public void viewCourseCatalog() {
		// TODO Auto-generated method stub
		System.out.println("\n=======================================================");
		System.out.println("\t\tCourseCatalog");
		System.out.println("=======================================================\n");
		CoursesDAOInterfaceIMPL courseDAOInterface=new CoursesDAOInterfaceIMPL();
		ArrayList<Course> courseArray=courseDAOInterface.getAllCourses();
		if(courseArray.isEmpty()) {
			System.out.println("The course catalog is EMPTY\n");
		}
		else {
			System.out.println(String.format("%10s %20s %10s", "Course ID","Course Name","Credits"));
			System.out.println("________________________________________________________\n");
			for(Course i:courseArray) {
				System.out.println(String.format("%10s %20s %10s", i.getCourseID(),i.getCourseName(),i.getCredits()));
			}
		}
		System.out.println("________________________________________________________\n\n");
	}
	
}
