/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Grades;
import com.flipkart.bean.Professor;

/**
 * @author hp
 *
 */
public interface ProfessorInterface {
	public boolean gradeStudents(int professorID,int courseID,int studentID,String grade);
	
	public Grades viewGrades(int professorid,int studentid,int courseid);
	
	public ArrayList<Integer> showAssignedCourses(int profID) ;
	
	public boolean addAssignedCourse(int professorID,int courseID);
	
	public boolean removeAssignedCourse(int professorID,int courseID);
	
	public ArrayList<Integer> viewEnrolledStudentsInCourse(int professorID,int courseID) ;
	
	public Professor getProfessorById(int id);
}