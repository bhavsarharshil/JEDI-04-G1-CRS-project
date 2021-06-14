package com.flipkart.service;

import com.flipkart.DAO.ProfessorDAOInterface;
import com.flipkart.DAO.ProfessorDAOInterfaceIMPL;
import com.flipkart.bean.Professor;
import com.flipkart.exception.ProfessorException;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class ProfessorInterfaceImpl implements ProfessorInterface {
	private static Logger logger = Logger.getLogger(ProfessorInterfaceImpl.class);
	private static ProfessorDAOInterface professorDAOInterface= new ProfessorDAOInterfaceIMPL();

	/**
	 * @param professor
	 * @return
	 */
	@Override
	public boolean gradeStudents(Professor professor) {

		// TODO Auto-generated method stub
		try{
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
			//throw new ProfessorException("HAHAAH");
			return professorDAOInterface.gradeStudents(courseID, studentID, grade);
		}
		
		catch (Exception e) {
			logger.info(e.getMessage());
		}
		return false;
	}

	/**
	 * @param professor
	 */
	@Override
	public void viewGrades(Professor professor) {
		// TODO Auto-generated method stub
		try{
			int courseID,studentID;
			System.out.println("Enter the course ID and StudentID to view grade");
			Scanner sc= new Scanner(System.in);
			courseID=sc.nextInt();
			studentID=sc.nextInt();
			professorDAOInterface.viewGrades(courseID, studentID);
		}
		
		catch (Exception e) {
			logger.info(e.getMessage());
		}
//		sc.close();
	}

	/**
	 * @param professor
	 */
	@Override
	public void showAssignedCourses(Professor professor) {
		// TODO Auto-generated method stub
		try 
		{
			professorDAOInterface.showAssignedCourses(professor.getId());
		}
		catch (Exception e) {
			logger.info(e.getMessage());
		}

	}

	/**
	 * @param professor
	 * @return
	 */
	@Override
	public boolean addAssignedCourse(Professor professor) {
		// TODO Auto-generated method stub
		
		try{
			int courseID,profID;
		
			System.out.println("enter the courseID");
			Scanner sc= new Scanner(System.in);
			courseID=sc.nextInt();
			return professorDAOInterface.addAssignedCourse(courseID, professor.getId());
		}
		catch (Exception e) {
			logger.info(e.getMessage());
		}
		return false;
	}

	/**
	 * @param professor
	 * @return
	 */
	@Override
	public boolean removeAssignedCourse(Professor professor) {
		// TODO Auto-generated method stub
		try{
			System.out.println("Enter courseID");
		
			int courseID,profID;
			Scanner sc= new Scanner(System.in);
			courseID=sc.nextInt();
			return professorDAOInterface.removeAssignedCourse(courseID, professor.getId());
		}
		catch (Exception e) {
			logger.info(e.getMessage());
		}
		return false;
	}

	/**
	 * @param professor
	 * @return
	 */
	@Override
	public boolean viewEnrolledStudentsInCourse(Professor professor) {
		// TODO Auto-generated method stub
		try{
			System.out.println("Enter course id");
		
			int courseID;
			Scanner sc= new Scanner(System.in);
			courseID=sc.nextInt();
			return professorDAOInterface.viewEnrolledStudentsInCourse(courseID);
		}
		catch (Exception e) {
			logger.info(e.getMessage());
		}
		return false;
	}

	/**
	 * @param id
	 * @return
	 */
	@Override
	public Professor getProfessorById(int id) {
		// TODO Auto-generated method stub
		try 
		{
			return professorDAOInterface.getProfessorById(id);
		}
		catch (Exception e) {
			logger.info(e.getMessage());
		}
		return null;
	}

	

}