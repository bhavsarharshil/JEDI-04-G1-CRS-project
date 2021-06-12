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
	public boolean gradeStudents();
	public void viewGrades();
	public void showAssignedCourses();
	public boolean addAssignedCourse();
	public boolean removeAssignedCourse();
	public boolean viewEnrolledStudentsInCourse();
	public Professor getProfessorById(int id);
}
