package com.flipkart.DAO;

import com.flipkart.bean.Professor;

public interface ProfessorDAOInterface {
	public Professor getProfessorById(int id);
	public String getProfessorByIdName(int professorID);
	public boolean gradeStudents(int courseID,int studentID,String grade);
	public void viewGrades(int courseID,int studentID);
	public void showAssignedCourses(int profID);
	public boolean addAssignedCourse(int courseID,int profID);
	public boolean removeAssignedCourse(int courseID,int profID);
	public boolean viewEnrolledStudentsInCourse(int courseID);
	
	public int getStudentCount(int courseID);
	public boolean getCoursePresence(int courseID);
	public boolean NoCoursePresence(int profID);
}