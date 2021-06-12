package com.flipkart.service;

import com.flipkart.bean.Admin;

public interface AdminInterface {
	public void addCourse();
	public void removeCourse();
	public void generateReportCard();
	public void addProfessor();
	public void removeProfessor();
	public void addStudent();
	public void removeStudent();
	public void approveStudents();
	public Admin getAdminById(int id);

}
