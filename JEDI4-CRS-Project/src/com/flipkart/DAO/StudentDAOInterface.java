package com.flipkart.DAO;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grades;
import com.flipkart.bean.Student;

public interface StudentDAOInterface {
	public Student getStudentById(int id);
	public void addPrimaryCourse(int studentId,int courseId);
	public void addSecondaryCourse(int studentId,int courseId);
	public void removePrimaryCourse(int studentId,int courseId);
	public void removeSecondaryCourse(int studentId,int courseId);
	public ArrayList<Course> getPrimaryRegisteredCourses(int studentId);
	public ArrayList<Course> getSecondaryRegisteredCourses(int studentId);
	public boolean alreadyPresent(int studentId,int CourseId);
	public void deleteFromSemiRegistration(int studentId);

	public ArrayList<Grades> getGrades(int studentID);
	public boolean addStudent(Student student);
	public void setPaymentStatus(Student student,String method);
}
