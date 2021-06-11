package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Grades;
import com.flipkart.bean.Student;

public interface StudentInterface {
	public void showCourses();
    
    public ArrayList<Grades> viewGrades(int studentId);

    public void makePayment(Student student, String method);

    public boolean addPrimaryCourse(Student student,int courseId);

    public boolean removePrimaryCourse(Student student,int courseId);
    
    public boolean addSecondaryCourse(Student student,int courseId);

    public boolean removeSecondaryCourse(Student student,int courseId);
    
    public boolean registerCourses(ArrayList<Integer> courseCart, Student student);

    public void viewPrimaryRegisteredCourses(Student student);
    
    public void viewSecondaryRegisteredCourses(Student student);
    
}
