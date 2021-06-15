package com.flipkart.DAO;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

public interface AdminDAOInterface {
	public Admin getAdminById(int id);
	public void viewReportCard(Student student);
	public boolean addProfessor(Professor professor);
	public boolean removeProfessor(Professor professor);
	public boolean removeStudent(Student student);
	public boolean addCourse(Course course);
	public boolean removeCourse(Course course);
	public void viewProfessors();
	public void viewStudents();
	public void viewCourses();
	public void approveStudents();
	public void viewUnapprovedStudent();
	public void approveStudentsRequest(int id);
}
