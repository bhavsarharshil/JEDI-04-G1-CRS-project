package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grades;
import com.flipkart.bean.Payment;
import com.flipkart.bean.Student;

public interface StudentInterface {
	
	
	public ArrayList<Course> showCourses();
    
    public ArrayList<Grades> viewGrades(int studentId);

    public int makePayment(int studentId, String method);

    public boolean addPrimaryCourse(int studentId,int courseId);

    public boolean removePrimaryCourse(int studentId,int courseId);
    
    public boolean addSecondaryCourse(int studentId,int courseId);

    public boolean removeSecondaryCourse(int studentId,int courseId);

    public ArrayList<Course> viewPrimaryRegisteredCourses(int studentId);
    
    public ArrayList<Course> viewSecondaryRegisteredCourses(int studentId);
    
    public Student getStudentById(int id);

    public boolean addStudent();

	public Payment viewPayments(int studentId);
        
}
