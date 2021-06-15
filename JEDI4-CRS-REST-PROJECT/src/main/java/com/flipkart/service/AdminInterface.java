package com.flipkart.service;

import com.flipkart.bean.Admin;

public interface AdminInterface {
	public void addCourse();
	public void removeCourse();
	public void generateReportCard();
	public void addProfessor();
	public void removeProfessor();
	public void removeStudent();
	public void approveStudents();
	public void viewProfessors();
	public void viewStudents();
	public void viewCourses();
	public Admin getAdminById(int id);

	public void approveStudentsRequest();
}
