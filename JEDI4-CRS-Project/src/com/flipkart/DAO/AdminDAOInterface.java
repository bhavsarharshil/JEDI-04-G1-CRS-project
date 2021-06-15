package com.flipkart.DAO;

import com.flipkart.bean.*;

import java.util.Vector;

public interface AdminDAOInterface {
	public Admin getAdminById(int id);
	public Vector<Grades> viewReportCard(Student student);
	public boolean addProfessor(Professor professor);
	public boolean removeProfessor(Professor professor);
	public boolean removeStudent(Student student);
	public boolean addCourse(Course course);
	public boolean removeCourse(Course course);
	public Vector<Professor> viewProfessors();
	public Vector<Student> viewStudents();
	public Vector<Course> viewCourses();
	public boolean approveStudents();
	public Vector<Student> viewUnapprovedStudent();
	public void approveStudentsRequest(int id);
}
