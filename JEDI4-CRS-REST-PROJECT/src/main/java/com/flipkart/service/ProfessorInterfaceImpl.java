package com.flipkart.service;

import com.flipkart.DAO.CoursesDAOInterface;
import com.flipkart.DAO.CoursesDAOInterfaceIMPL;
import com.flipkart.DAO.ProfessorDAOInterface;
import com.flipkart.DAO.ProfessorDAOInterfaceIMPL;
import com.flipkart.DAO.UserDAOInterface;
import com.flipkart.DAO.UserDAOInterfaceIMPL;
import com.flipkart.bean.Professor;
import com.flipkart.exception.CourseAssignedException;
import com.flipkart.exception.NoAssignedCourseException;
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
		System.out.println("==================Grade Students===============");
		// TODO Auto-generated method stub
		try{
			int courseID,studentID;
		
			String grade;
			Scanner sc= new Scanner(System.in);
			showAssignedCourses(professor);
			System.out.print("Enter the course ID : ");
			courseID=sc.nextInt();
			System.out.println("\n");
			professorDAOInterface.viewEnrolledStudentsInCourse(courseID);
			System.out.print("Enter the StudentID : ");
			studentID=sc.nextInt();
			System.out.print("Enter the grade : ");
			grade=sc.next();
			int no_students = 0;
			no_students = professorDAOInterface.getStudentCount(courseID);
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
			logger.error("\n"+e.getMessage()+"\n");
		}
		catch (Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
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
			logger.error("\n"+e.getMessage()+"\n");
		}
		catch (Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
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
			int profID=professor.getId();
			boolean coursePresence = false;
			coursePresence = professorDAOInterface.NoCoursePresence(profID);
			if(coursePresence == true)
			{
				professorDAOInterface.showAssignedCourses(profID);
			}
			else
			{
				throw new 	NoAssignedCourseException("NO courses are assigned to you");
			}
		}
		catch(NoAssignedCourseException e)
		{
			logger.error("\n"+e.getMessage()+"\n");
		}
		catch (Exception e) 
		{
			logger.error("\n"+e.getMessage()+"\n");
		}

	}

	/**
	 * @param professor Professor bean
	 * @return boolean: true if course assigned correctly
	 */
	@Override
	public boolean addAssignedCourse(Professor professor) {
		// TODO Auto-generated method stub
		CourseInterfaceImpl courseInterface =new CourseInterfaceImpl();
		try{
			
			courseInterface.viewCourseCatalog();
			int courseID;
			System.out.print(" Enter the courseID : ");
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
			logger.error("\n"+e.getMessage()+"\n");
		}
		catch (Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
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
			logger.error("\n"+e.getMessage()+"\n");
		}
		catch (Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
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
			logger.error("\n"+e.getMessage()+"\n");
		}
		catch (Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
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
			logger.error("\n"+e.getMessage()+"\n");
		}
		return null;
	}

	

}