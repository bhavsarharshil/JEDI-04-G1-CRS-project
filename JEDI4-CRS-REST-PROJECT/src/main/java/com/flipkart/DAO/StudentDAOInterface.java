package com.flipkart.DAO;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grades;
import com.flipkart.bean.Payment;
import com.flipkart.bean.Student;

public interface StudentDAOInterface {
	
	
public Student getStudentById(int id);
	
	public boolean addPrimaryCourse(int studentId,int courseId);
	
	public boolean addSecondaryCourse(int studentId,int courseId);
	
	public boolean removePrimaryCourse(int studentId,int courseId);
	
	public boolean removeSecondaryCourse(int studentId,int courseId);
	
	public ArrayList<Course> getPrimaryRegisteredCourses(int studentId);
	
	public ArrayList<Course> getSecondaryRegisteredCourses(int studentId);
	
	public boolean alreadyPresent(int studentId,int CourseId);
	
	public void deleteFromSemiRegistration(int studentId);
	
	public ArrayList<Grades> getGrades(int studentID);

	public boolean addStudent(Student student);
	
	public int setPaymentStatus(int studentId,String method);
	
	public int countPrimaryCourses(int studentId);
	
	public int countSecondaryCourses(int studentId);
	
	public Payment viewPayments(int studentId);
	
}

