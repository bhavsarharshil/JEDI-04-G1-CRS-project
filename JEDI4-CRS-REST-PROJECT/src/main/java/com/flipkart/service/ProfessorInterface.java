/**
 * 
 */
package com.flipkart.service;

import com.flipkart.bean.Professor;

/**
 * @author hp
 *
 */
public interface ProfessorInterface {
	public boolean gradeStudents(Professor professor);
	public void viewGrades(Professor professor);
	public void showAssignedCourses(Professor professor);
	public boolean addAssignedCourse(Professor professor);
	public boolean removeAssignedCourse(Professor professor);
	public boolean viewEnrolledStudentsInCourse(Professor professor);
	public Professor getProfessorById(int id);
}