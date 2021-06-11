package com.flipkart.service;

import com.flipkart.DAO.ProfessorDAOInterface;
import com.flipkart.DAO.ProfessorDAOInterfaceIMPL;
import com.flipkart.bean.Professor;

public class ProfessorInterfaceImpl implements ProfessorInterface {

	@Override
	public boolean gradeStudents(int courseId) {
		// TODO Auto-generated method stub
		System.out.println("Select a course to grade");
		return false;
	}

	@Override
	public void viewGrades(int courseId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showAssignedCourses(int professorId) {
		// TODO Auto-generated method stub
		System.out.println("You have selected following courses");
		System.out.println("1) course1");
		System.out.println("1) course2");
		
	}

	@Override
	public boolean addAssignedCourse(int courseId) {
		// TODO Auto-generated method stub
		System.out.println("Select courses to add");
		System.out.println("1) course 1");
		return false;
	}

	@Override
	public boolean removeAssignedCourse(int courseId) {
		// TODO Auto-generated method stub
		System.out.println("Select course to remove");
		System.out.println("1) course 1");
		return false;
	}

	@Override
	public boolean viewEnrolledStudentsInCourse(int courseId) {
		// TODO Auto-generated method stub
		System.out.println("Following students are enrolled in your courses");
		System.out.println("1) student1");
		return false;
	}

	@Override
	public Professor getProfessorById(int id) {
		// TODO Auto-generated method stub
		ProfessorDAOInterface profdao = new ProfessorDAOInterfaceIMPL();
		return profdao.getProfessorById(id);
	}

	

}
