package com.flipkart.DAO;

import com.flipkart.bean.*;

import java.util.Vector;

public interface AdminDAOInterface {
	public Admin getAdminById(int id);
	public Vector<Grades> viewReportCard(int id);
	public boolean addProfessor(Professor professor);
	public boolean removeProfessor(int id);
	public boolean removeStudent(int id);
	public boolean addCourse(Course course);
	public boolean removeCourse(int id);
	public Vector<Professor> viewProfessors();
	public Vector<Student> viewStudents();
	public Vector<Course> viewCourses();
	public boolean approveStudents();
	public Vector<Student> viewUnapprovedStudent();
	public boolean approveStudentsRequest(int id);
}
