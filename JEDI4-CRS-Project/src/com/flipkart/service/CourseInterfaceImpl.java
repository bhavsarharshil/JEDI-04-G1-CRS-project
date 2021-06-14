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
		System.out.println("========CourseCatalog=========");
		CoursesDAOInterfaceIMPL courseDAOInterface=new CoursesDAOInterfaceIMPL();
		ArrayList<Course> courseArray=courseDAOInterface.getAllCourses();
		for(Course i:courseArray) {
			System.out.println(i.getCourseID() +"\t"+i.getCourseName()+"\t"+ i.getCredits());
		}
	}
	
}
