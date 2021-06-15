package com.flipkart.DAO;

import java.util.ArrayList;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grades;
import com.flipkart.bean.Professor;

public interface ProfessorDAOInterface {
	public Professor getProfessorById(int id);
	public String getProfessorByIdName(int professorID);
	public boolean gradeStudents(int courseID,int studentID,String grade);
	
	public Grades viewGrades(int courseID,int studentID);
	
	public ArrayList<Integer> showAssignedCourses(int profID);
	
	public boolean addAssignedCourse(int courseID,int profID);
	public boolean removeAssignedCourse(int courseID,int profID);
	
	public ArrayList<Integer> viewEnrolledStudentsInCourse(int courseID);
	
	public int getStudentCount(int courseID);
	public boolean getCoursePresence(int courseID);
	public boolean NoCoursePresence(int profID);
}