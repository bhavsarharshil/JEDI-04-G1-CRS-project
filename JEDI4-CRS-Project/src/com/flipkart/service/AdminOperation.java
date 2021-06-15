/**
 * 
 */
package com.flipkart.service;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.DAO.AdminDAOInterface;
import com.flipkart.DAO.AdminDAOInterfaceIMPL;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.Admin;
/**
 * @author harshil
 *
 */
public class AdminOperation implements AdminInterface {

	public static Logger logger=Logger.getLogger(AdminOperation.class);
	AdminDAOInterfaceIMPL adminInterface=new AdminDAOInterfaceIMPL();
	Scanner sc=new Scanner(System.in);

	/**
	 * method to add course
	 */
	@Override
	public void addCourse() {
		// TODO Auto-generated method stub
		try {
			Course course=new Course();
			System.out.println("Enter the course id");
			int id=sc.nextInt();
			course.setCourseID(id);
			System.out.println("Enter course name");
			String name=sc.next();
			course.setCourseName(name);
			System.out.println("Enter course credits");
			int credits=sc.nextInt();
			course.setCredits(credits);
			adminInterface.addCourse(course);
		}catch(InputMismatchException e){
			sc.next();
			logger.error("The input formal is invalid\n");
		}catch(Exception e) {
			sc.next();
			logger.error(e.getMessage());
		}
	}

	/**
	 * method to remove course
	 */
	@Override
	public void removeCourse() {
		// TODO Auto-generated method stub
		try {
			Course course=new Course();
			System.out.println("Enter the course id");
			int id=sc.nextInt();
			course.setCourseID(id);
			adminInterface.removeCourse(course);
		}catch(InputMismatchException e){
			sc.next();
			logger.error("The input formal is invalid\n");
		}catch(Exception e) {
			sc.next();
			logger.error(e.getMessage());
		}
	}

	/**
	 * method to generate report card
	 */
	@Override
	public void generateReportCard() {
		// TODO Auto-generated method stub

		System.out.println("\n============Generate Report Card============\n");
		try {
			Student student=new Student();
			System.out.print("Enter student id : ");
			int id=sc.nextInt();
			student.setId(id);
			adminInterface.viewReportCard(student);
		}catch(InputMismatchException e){
			sc.next();
			logger.error("\nThe input format is invalid\n");
		}catch(Exception e) {
			sc.next();
			logger.error("\n"+e.getMessage()+"\n");
		}
	}

	/**
	 * method to add professor
	 */
	@Override
	public void addProfessor() {
		// TODO Auto-generated method stub
		System.out.println("\n============Add Professor============\n");
		try {
			Professor professor=new Professor();
			System.out.print("Enter new professor id : ");
			int id=sc.nextInt();
			professor.setId(id);
			System.out.print("Enter professor email : ");
			String email=sc.next();
			professor.setEmail(email);
			System.out.print("Enter password :");
			String password=sc.next();
			professor.setPassword(password);
			professor.setRole("professor");
			professor.setLoggedin(false);
			System.out.print("Enter professor name :");
			String name=sc.next();
			professor.setName(name);
			adminInterface.addProfessor(professor);
		}catch(InputMismatchException e){
			sc.next();
			logger.error("\nThe input formal is invalid\n");
		}catch(Exception e) {
			sc.next();
			logger.error("\n"+e.getMessage()+"\n");
		}
	}

	/**
	 *method to remove professor
	 */
	@Override
	public void removeProfessor() {
		// TODO Auto-generated method stub
		System.out.println("\n============Remove Professor============\n");
		try {
			Professor professor=new Professor();
			System.out.print("Enter professor id : ");
			int id=sc.nextInt();
			professor.setId(id);
			adminInterface.removeProfessor(professor);
		}catch(InputMismatchException e){
			sc.next();
			logger.error("\nThe input formal is invalid\n");
		}catch(Exception e) {
			sc.next();
			logger.error("\n"+e.getMessage()+"\n");
		}
	}

	/**
	 *method to remove student
	 */
	@Override
	public void removeStudent() {
		// TODO Auto-generated method stub
		System.out.println("\n============Remove Student============\n");
		try {
			Student student=new Student();
			System.out.print("Enter student id : ");
			int id=sc.nextInt();
			student.setId(id);
			adminInterface.removeStudent(student);
		}catch(InputMismatchException e){
			sc.next();
			logger.error("\nThe input formal is invalid\n");
		}catch(Exception e) {
			sc.next();
			logger.error("\n"+e.getMessage()+"\n");
		}
	}

	/**
	 * @param id id of professor
	 * @return Admin bean
	 */
	@Override
	public Admin getAdminById(int id) {
		AdminDAOInterface addao = new AdminDAOInterfaceIMPL();
		return addao.getAdminById(id);
	}

	/**
	 *method to approve registration of students
	 */
	@Override
	public void approveStudentsRequest() {
		AdminDAOInterface addao = new AdminDAOInterfaceIMPL();
		try {
			addao.viewUnapprovedStudent();
			System.out.print("Enter Student id to approve : ");
			int id = sc.nextInt();

			addao.approveStudentsRequest(id);
		}catch(InputMismatchException e){
			sc.next();
			logger.error("\nThe input formal is invalid\n");
		}catch(Exception e) {
			sc.next();
			logger.error("\n"+e.getMessage()+"\n");
		}
	}

	/**
	 *method to approve courses of students
	 */
	@Override
	public void approveStudents() {
		// TODO Auto-generated method stub
		adminInterface.approveStudents();
	}

	/**
	 *method to view all professors
	 */
	public void viewProfessors() {
		// TODO Auto-generated method stub
		adminInterface.viewProfessors();
	}

	/**
	 *method to view all students
	 */
	public void viewStudents() {
		// TODO Auto-generated method stub
		adminInterface.viewStudents();
	}

	/**
	 *method to view all courses
	 */
	public void viewCourses() {
		// TODO Auto-generated method stub
		adminInterface.viewCourses();
	}

}