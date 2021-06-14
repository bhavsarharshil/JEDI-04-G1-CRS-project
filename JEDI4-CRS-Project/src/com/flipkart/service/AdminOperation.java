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

	@Override
	public void generateReportCard() {
		// TODO Auto-generated method stub
		try {
			Student student=new Student();
			System.out.println("Enter student id");
			int id=sc.nextInt();
			student.setId(id);
			adminInterface.viewReportCard(student);
		}catch(InputMismatchException e){
			sc.next();
			logger.error("The input formal is invalid\n");
		}catch(Exception e) {
			sc.next();
			logger.error(e.getMessage());
		}
	}

	@Override
	public void addProfessor() {
		// TODO Auto-generated method stub
		try {
			Professor professor=new Professor();
			System.out.println("Enter new professor id");
			int id=sc.nextInt();
			professor.setId(id);
			System.out.println("Enter professor email");
			String email=sc.next();
			professor.setEmail(email);
			System.out.println("Enter password");
			String password=sc.next();
			professor.setPassword(password);
			professor.setRole("professor");
			professor.setLoggedin(false);
			System.out.println("Enter professor name");
			String name=sc.next();
			professor.setName(name);
			adminInterface.addProfessor(professor);
		}catch(InputMismatchException e){
			sc.next();
			logger.error("The input formal is invalid\n");
		}catch(Exception e) {
			sc.next();
			logger.error(e.getMessage());
		}
	}

	@Override
	public void removeProfessor() {
		// TODO Auto-generated method stub
		try {
			Professor professor=new Professor();
			System.out.println("Enter professor id");
			int id=sc.nextInt();
			professor.setId(id);
			adminInterface.removeProfessor(professor);
		}catch(InputMismatchException e){
			sc.next();
			logger.error("The input formal is invalid\n");
		}catch(Exception e) {
			sc.next();
			logger.error(e.getMessage());
		}
	}

	@Override
	public void addStudent() {
		// TODO Auto-generated method stub
		StudentInterface si = new StudentOperation();
		si.addStudent();
	}

	@Override
	public void removeStudent() {
		// TODO Auto-generated method stub
		try {
			Student student=new Student();
			System.out.println("Enter student id");
			int id=sc.nextInt();
			student.setId(id);
			adminInterface.removeStudent(student);
		}catch(InputMismatchException e){
			sc.next();
			logger.error("The input formal is invalid\n");
		}catch(Exception e) {
			sc.next();
			logger.error(e.getMessage());
		}
	}
	
	@Override
	public Admin getAdminById(int id) {
		AdminDAOInterface addao = new AdminDAOInterfaceIMPL();
		return addao.getAdminById(id);
	}

	@Override
	public void approveStudentsRequest() {
		try {
			System.out.println("Enter Student id to approve");
			int id = sc.nextInt();
			AdminDAOInterface addao = new AdminDAOInterfaceIMPL();
			addao.approveStudentsRequest(id);
		}catch(InputMismatchException e){
			sc.next();
			logger.error("The input formal is invalid\n");
		}catch(Exception e) {
			sc.next();
			logger.error(e.getMessage());
		}
	}

	@Override
	public void approveStudents() {
		// TODO Auto-generated method stub
		adminInterface.approveStudents();
	}

	public void viewProfessors() {
		// TODO Auto-generated method stub
		adminInterface.viewProfessors();
	}

	public void viewStudents() {
		// TODO Auto-generated method stub
		adminInterface.viewStudents();
	}

	public void viewCourses() {
		// TODO Auto-generated method stub
		adminInterface.viewCourses();
	}

}