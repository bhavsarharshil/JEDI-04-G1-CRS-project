package com.flipkart.service;

import com.flipkart.DAO.CoursesDAOInterface;
import com.flipkart.DAO.CoursesDAOInterfaceIMPL;
import com.flipkart.DAO.ProfessorDAOInterface;
import com.flipkart.DAO.ProfessorDAOInterfaceIMPL;
import com.flipkart.DAO.UserDAOInterface;
import com.flipkart.DAO.UserDAOInterfaceIMPL;
import com.flipkart.bean.Course;
import com.flipkart.bean.Grades;
import com.flipkart.bean.Professor;
import com.flipkart.exception.CourseAssignedException;
import com.flipkart.exception.NoAssignedCourseException;
import com.flipkart.exception.ProfessorException;
import com.flipkart.exception.StudentCountException;

import java.util.ArrayList;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProfessorInterfaceImpl implements ProfessorInterface {
	private static Logger logger = LoggerFactory.getLogger(ProfessorInterfaceImpl.class);
	private static ProfessorDAOInterface professorDAOInterface= new ProfessorDAOInterfaceIMPL();

	/**
	 * @param professor Professor bean
	 * @return boolean : true if graded correctly
	 */
	@Override
	public boolean gradeStudents(int professorID,int courseID,int studentID,String grade) {
		logger.info("==================Grade Students===============");
		// TODO Auto-generated method stub
		try{
			//int courseID,studentID;
		
			//String grade;
			//Scanner sc= new Scanner(System.in);
			showAssignedCourses(professorID);
			logger.info("Enter the course ID : ");
			//courseID=sc.nextInt();
			logger.info("\n");
			professorDAOInterface.viewEnrolledStudentsInCourse(courseID);
			logger.info("Enter the StudentID : ");
			//studentID=sc.nextInt();
			logger.info("Enter the grade : ");
			//grade=sc.next();
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
	public Grades viewGrades(int professorid,int studentID,int courseID) {
		// TODO Auto-generated method stub
		Grades grade=new Grades();
		try{
			/*int courseID,studentID;
			logger.info("Enter the course ID and StudentID to view grade");
			Scanner sc= new Scanner(System.in);
			courseID=sc.nextInt();
			studentID=sc.nextInt();*/
			int no_students = professorDAOInterface.getStudentCount(courseID);
			System.out.println(no_students +" "+ professorid + " "+ studentID+" "+courseID);
			logger.debug(no_students +" "+ professorid + " "+ studentID+" "+courseID );
			if(no_students>0)
			{
				grade = professorDAOInterface.viewGrades(courseID, studentID);
				logger.info("\n========================================================================");
				logger.info("\t\t\tGrades");
				logger.info("========================================================================\n");
				
				logger.info("courseID: " + grade.getCourseId() );
				logger.info(" stduentID: " + grade.getStudentId());
				logger.info(" grade: " + grade.getGrade());
				
			}
			else
			{
				throw new StudentCountException("No Students in the given course!!!");
			}
			return grade;
			
		}
		catch(StudentCountException e)
		{
			logger.error("\n"+e.getMessage()+"\n");
		}
		catch (Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
//		sc.close();
		return null;
	}

	/**
	 * @param professor
	 * method to show courses taught by professor
	 */
	@Override
	public ArrayList<Integer> showAssignedCourses(int profID) {
		// TODO Auto-generated method stub
		ArrayList<Integer> courses = new ArrayList<Integer>();
		try 
		{
			//int profID=professor.getId();
			boolean coursePresence = false;
			coursePresence = professorDAOInterface.NoCoursePresence(profID);
			if(coursePresence == true)
			{
				courses = professorDAOInterface.showAssignedCourses(profID);
				logger.info("=======Assigned Courses=======");
				for(int c : courses)
					logger.info("  ID: " + c);
			}
			else
			{
				throw new 	NoAssignedCourseException("NO courses are assigned to you");
			}
			return courses;
		}
		catch(NoAssignedCourseException e)
		{
			logger.error("\n"+e.getMessage()+"\n");
		}
		catch (Exception e) 
		{
			logger.error("\n"+e.getMessage()+"\n");
		}
		return null;
	}

	/**
	 * @param professor Professor bean
	 * @return boolean: true if course assigned correctly
	 */
	@Override
	public boolean addAssignedCourse(int professorID,int courseID) {
		// TODO Auto-generated method stub
		CourseInterfaceImpl courseInterface =new CourseInterfaceImpl();
		try{
			
			courseInterface.viewCourseCatalog();
			//int courseID;
			logger.info(" Enter the courseID : ");
			//Scanner sc= new Scanner(System.in);
			//courseID=sc.nextInt();
			
			boolean coursePresence = false;
			coursePresence = professorDAOInterface.getCoursePresence(courseID);
			if(coursePresence == false)
			{

				System.out.println(courseID+"    aaaaaaaaaaa"+professorID);
				return professorDAOInterface.addAssignedCourse(courseID, professorID);
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
	public boolean removeAssignedCourse(int professorID,int courseID) {
		// TODO Auto-generated method stub
		try{
			logger.info("Enter courseID");
		
			//int courseID,profID;
			//Scanner sc= new Scanner(System.in);
			//courseID=sc.nextInt();
			boolean coursePresence = false;
			coursePresence = professorDAOInterface.getCoursePresence(courseID);
			if(coursePresence == true)
			{
				return professorDAOInterface.removeAssignedCourse(courseID, professorID);
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
	public ArrayList<Integer> viewEnrolledStudentsInCourse(int professorID,int courseID) {
		// TODO Auto-generated method stub
		ArrayList<Integer> students = new ArrayList<Integer>();
		try{
			logger.info("Enter course id");
		
			//int courseID;
			//Scanner sc= new Scanner(System.in);
			//courseID=sc.nextInt();
			
			int no_students = 0;
			no_students = professorDAOInterface.getStudentCount(courseID);
			
			//insert DAO func
			if(no_students>0)
			{
				students = professorDAOInterface.viewEnrolledStudentsInCourse(courseID);
				logger.info("=====Enrolled Students in course "+String.valueOf(courseID)+"======");
				for(int s : students)
					logger.info("  ID: " + s);
				
			}
			else
			{
				throw new StudentCountException("No student is currently enrolled in the course!!!");
			}
			return students;
			
		}
		catch(StudentCountException e)
		{ 
			logger.error("\n"+e.getMessage()+"\n");
		}
		catch (Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		return null;
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