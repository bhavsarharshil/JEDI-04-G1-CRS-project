package com.flipkart.service;

import java.util.ArrayList;
import java.util.Vector;

import com.flipkart.DAO.CoursesDAOInterfaceIMPL;
import com.flipkart.bean.*;

public class CourseInterfaceImpl implements CourseInterface {

	@Override
	public Vector<Student> studentsEnrolled(int courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Course getCourseById(int courseId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void viewCourseCatalog() {
		// TODO Auto-generated method stub
		System.out.println("========CourseCatalog=========");
		CoursesDAOInterfaceIMPL courseDAOInterface=new CoursesDAOInterfaceIMPL();
		ArrayList<Course> courseArray=courseDAOInterface.getAllCourses();
		for(Course i:courseArray) {
			System.out.println(String.valueOf(i.getCourseID())+"\t"+i.getCourseName()+"\t"+String.valueOf(i.getCredits()));
		}
	}
	
}
