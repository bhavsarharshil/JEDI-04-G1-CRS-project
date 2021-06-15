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
			System.out.println("Course ID\t\tCourse Name\t\tCredits");
			System.out.println("________________________________________________________\n");
			for(Course i:courseArray) {
				System.out.println(i.getCourseID() +"\t\t\t"+i.getCourseName()+"\t\t"+ i.getCredits());
			}
		}
		System.out.println("________________________________________________________\n\n");
	}
	
}
