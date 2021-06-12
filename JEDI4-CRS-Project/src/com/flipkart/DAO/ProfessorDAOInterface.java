package com.flipkart.DAO;

import com.flipkart.bean.Professor;

public interface ProfessorDAOInterface {
	public boolean gradeStudents(int courseID,int studentID,String grade);
	public void viewGrades(int courseID,int studentID);
	public void showAssignedCourses(int profID);
	public boolean addAssignedCourse(int courseID,int profID);
	public boolean removeAssignedCourse(int courseID,int profID);
	public boolean viewEnrolledStudentsInCourse(int courseID);
	public Professor getProfessorById(int id);
}
