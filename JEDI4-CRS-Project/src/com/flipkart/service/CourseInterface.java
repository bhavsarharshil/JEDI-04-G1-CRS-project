package com.flipkart.service;

import java.util.Vector;

import com.flipkart.bean.Course;
import com.flipkart.bean.Student;

public interface CourseInterface {
	public Vector<Student> studentsEnrolled(int courseId);
	public Course getCourseById(int courseId);
	public void viewCourseCatalog();
	
}
