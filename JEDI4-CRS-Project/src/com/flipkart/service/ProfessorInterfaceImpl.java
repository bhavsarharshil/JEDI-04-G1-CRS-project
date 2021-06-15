package com.flipkart.service;

import com.flipkart.DAO.ProfessorDAOInterface;
import com.flipkart.DAO.ProfessorDAOInterfaceIMPL;
import com.flipkart.bean.Professor;
import com.flipkart.exception.CourseAssignedException;
import com.flipkart.exception.ProfessorException;
import com.flipkart.exception.StudentCountException;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class ProfessorInterfaceImpl implements ProfessorInterface {
	private static Logger logger = Logger.getLogger(ProfessorInterfaceImpl.class);
	private static ProfessorDAOInterface professorDAOInterface= new ProfessorDAOInterfaceIMPL();

	/**
	 * @param professor Professor bean
	 * @return boolean : true if graded correctly
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
			int no_students = 0;
			no_students = professorDAOInterface.getStudentCount(courseID);
			//insert DAO func
			if(no_students>0)
			{
				return professorDAOInterface.gradeStudents(courseID, studentID, grade);
			}
			else
			{
				throw new StudentCountException("No Students to Grade!!!");
			}
		}
		catch(StudentCountException e)
		{
			logger.info("\n\n");
			logger.error(e.getMessage());
			logger.info("\n\n");
		}
		catch (Exception e) {
			logger.info(e.getMessage());
		}
		return false;
	}

	/**
	 * @param professor
	 * method to view grades
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
			int no_students = professorDAOInterface.getStudentCount(courseID);
			if(no_students>0)
			{
				professorDAOInterface.viewGrades(courseID, studentID);
			}
			else
			{
				throw new StudentCountException("No Students in the given course!!!");
			}
			
		}
		catch(StudentCountException e)
		{
			logger.info("\n\n");
			logger.error(e.getMessage());
			logger.info("\n\n");
		}
		catch (Exception e) {
			logger.info(e.getMessage());
		}
//		sc.close();
	}

	/**
	 * @param professor
	 * method to show courses taught by professor
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
	 * @param professor Professor bean
	 * @return boolean: true if course assigned correctly
	 */
	@Override
	public boolean addAssignedCourse(Professor professor) {
		// TODO Auto-generated method stub
		
		try{
			int courseID,profID;
		
			System.out.println("enter the courseID");
			Scanner sc= new Scanner(System.in);
			courseID=sc.nextInt();
			boolean coursePresence = false;
			coursePresence = professorDAOInterface.getCoursePresence(courseID);
			if(coursePresence == false)
			{
				return professorDAOInterface.addAssignedCourse(courseID, professor.getId());
			}
			else
			{
				throw new CourseAssignedException("Course is already assigned to some other professor . ");
			}
			
		}
		catch(CourseAssignedException e)
		{
			logger.info("\n\n");
			logger.error(e.getMessage());
			logger.info("\n\n");
		}
		catch (Exception e) {
			logger.info(e.getMessage());
		}
		return false;
	}

	/**
	 * @param professor Professr bean
	 * @return boolean: true if professor removed from course correctly
	 */
	@Override
	public boolean removeAssignedCourse(Professor professor) {
		// TODO Auto-generated method stub
		try{
			System.out.println("Enter courseID");
		
			int courseID,profID;
			Scanner sc= new Scanner(System.in);
			courseID=sc.nextInt();
			boolean coursePresence = false;
			coursePresence = professorDAOInterface.getCoursePresence(courseID);
			if(coursePresence == true)
			{
				return professorDAOInterface.removeAssignedCourse(courseID, professor.getId());
			}
			else
			{
				throw new CourseAssignedException("Course was already removed. ");
			}
			
		}
		catch(CourseAssignedException e)
		{
			logger.info("\n\n");
			logger.error(e.getMessage());
			logger.info("\n\n");
		}
		catch (Exception e) {
			logger.info(e.getMessage());
		}
		return false;
	}

	/**
	 * @param professor Professor bean
	 * @return boolean: true if enrolled students viewed correctly
	 */
	@Override
	public boolean viewEnrolledStudentsInCourse(Professor professor) {
		// TODO Auto-generated method stub
		try{
			System.out.println("Enter course id");
		
			int courseID;
			Scanner sc= new Scanner(System.in);
			courseID=sc.nextInt();
			
			int no_students = 0;
			no_students = professorDAOInterface.getStudentCount(courseID);
			//insert DAO func
			if(no_students>0)
			{
				return professorDAOInterface.viewEnrolledStudentsInCourse(courseID);
			}
			else
			{
				throw new StudentCountException("No student is currently enrolled in the course!!!");
			}
			
		}
		catch(StudentCountException e)
		{
			logger.info("\n\n");
			logger.error(e.getMessage());
			logger.info("\n\n");
		}
		catch (Exception e) {
			logger.info(e.getMessage());
		}
		return false;
	}

	/**
	 * @param id id of professor
	 * @return Professor bean
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