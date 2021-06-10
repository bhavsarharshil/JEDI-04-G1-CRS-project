/**
 * 
 */
package com.flipkart.service;

/**
 * @author hp
 *
 */
public interface ProfessorInterface {
	public String getName();
	public boolean gradeStudents(int courseId);
	public void viewGrades(int courseId);
	public void showAssignedCourses(int professorId);
	public boolean addAssignedCourse(int courseId);
	public boolean removeAssignedCourse(int courseId);
	public boolean viewEnrolledStudentsInCourse(int courseId);
}
