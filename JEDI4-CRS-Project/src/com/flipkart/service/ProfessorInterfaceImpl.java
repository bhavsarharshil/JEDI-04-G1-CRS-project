package com.flipkart.service;

import com.flipkart.DAO.ProfessorDAOInterface;
import com.flipkart.DAO.ProfessorDAOInterfaceIMPL;
import com.flipkart.bean.Professor;

import java.util.Scanner;

public class ProfessorInterfaceImpl implements ProfessorInterface {
	private static ProfessorDAOInterface professor= new ProfessorDAOInterfaceIMPL();
	@Override
	public boolean gradeStudents() {

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
		sc.close();
		professor.gradeStudents(courseID, studentID, grade);
		return false;
	}

	@Override
	public void viewGrades() {
		// TODO Auto-generated method stub
		int courseID,studentID;
		System.out.println("Enter the course ID and StudentID to view grade");
		Scanner sc= new Scanner(System.in);
		courseID=sc.nextInt();
		studentID=sc.nextInt();
		professor.viewGrades(courseID, studentID);
		sc.close();
	}

	@Override
	public void showAssignedCourses() {
		// TODO Auto-generated method stub
		int profID;
		System.out.println("Enter the profid");
		Scanner sc= new Scanner(System.in);
		profID=sc.nextInt();
		professor.showAssignedCourses(profID);
		sc.close();

	}

	@Override
	public boolean addAssignedCourse() {
		// TODO Auto-generated method stub
		int courseID,profID;
		System.out.println("enter the courseID to add and profID");
		Scanner sc= new Scanner(System.in);
		courseID=sc.nextInt();
		profID=sc.nextInt();
		professor.addAssignedCourse(courseID, profID);
		return false;
	}

	@Override
	public boolean removeAssignedCourse() {
		// TODO Auto-generated method stub
		System.out.println("Select courseID to remove and profID");
		int courseID,profID;
		Scanner sc= new Scanner(System.in);
		courseID=sc.nextInt();
		profID=sc.nextInt();
		professor.removeAssignedCourse(courseID, profID);
		return false;
	}

	@Override
	public boolean viewEnrolledStudentsInCourse() {
		// TODO Auto-generated method stub
		int courseID;
		Scanner sc= new Scanner(System.in);
		courseID=sc.nextInt();
		professor.viewEnrolledStudentsInCourse(courseID);
		return false;
	}

	@Override
	public Professor getProfessorById(int id) {
		// TODO Auto-generated method stub
		return professor.getProfessorById(id);
	}

	

}
