package com.flipkart.service;

import java.util.Vector;

import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Grades;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

public interface AdminInterface {
	public boolean addCourse(Course course);
	public boolean removeCourse(int id);
	public Vector<Grades> generateReportCard(int id);
	public boolean addProfessor(Professor professor);
	public boolean removeProfessor(int id);
	public boolean removeStudent(int id);
	public boolean approveStudents();
	public Vector<Professor> viewProfessors();
	public Vector<Student> viewStudents();
	public Vector<Course> viewCourses();
	public Admin getAdminById(int id);

	public boolean approveStudentsRequest(int id);
}
