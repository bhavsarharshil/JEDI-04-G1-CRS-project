package com.flipkart.service;

import com.flipkart.DAO.ProfessorDAOInterface;
import com.flipkart.DAO.ProfessorDAOInterfaceIMPL;
import com.flipkart.bean.Professor;

import java.util.Scanner;

public class ProfessorInterfaceImpl implements ProfessorInterface {
	private static ProfessorDAOInterface professorDAOInterface= new ProfessorDAOInterfaceIMPL();
	@Override
	public boolean gradeStudents(Professor professor) {

		// TODO Auto-generated method stub
		int courseID,studentID;
		String grade;
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the course ID");
		courseID=sc.nextInt();
		System.out.println("Enter the StudentID");
		studentID=sc.nextInt();
		System.out.println("Enter the grade");
		grade=sc.next();
//		sc.close();
		return professorDAOInterface.gradeStudents(courseID, studentID, grade);
	}

	@Override
	public void viewGrades(Professor professor) {
		// TODO Auto-generated method stub
		int courseID,studentID;
		System.out.println("Enter the course ID and StudentID to view grade");
		Scanner sc= new Scanner(System.in);
		courseID=sc.nextInt();
		studentID=sc.nextInt();
		professorDAOInterface.viewGrades(courseID, studentID);
//		sc.close();
	}

	@Override
	public void showAssignedCourses(Professor professor) {
		// TODO Auto-generated method stub
		professorDAOInterface.showAssignedCourses(professor.getId());
//		sc.close();

	}

	@Override
	public boolean addAssignedCourse(Professor professor) {
		// TODO Auto-generated method stub
		int courseID,profID;
		System.out.println("enter the courseID");
		Scanner sc= new Scanner(System.in);
		courseID=sc.nextInt();
		return professorDAOInterface.addAssignedCourse(courseID, professor.getId());
	}

	@Override
	public boolean removeAssignedCourse(Professor professor) {
		// TODO Auto-generated method stub
		System.out.println("Enter courseID");
		int courseID,profID;
		Scanner sc= new Scanner(System.in);
		courseID=sc.nextInt();
		return professorDAOInterface.removeAssignedCourse(courseID, professor.getId());
	}

	@Override
	public boolean viewEnrolledStudentsInCourse(Professor professor) {
		// TODO Auto-generated method stub
		System.out.println("Enter course id");
		int courseID;
		Scanner sc= new Scanner(System.in);
		courseID=sc.nextInt();
		return professorDAOInterface.viewEnrolledStudentsInCourse(courseID);
	}

	@Override
	public Professor getProfessorById(int id) {
		// TODO Auto-generated method stub
		return professorDAOInterface.getProfessorById(id);
	}

	

}