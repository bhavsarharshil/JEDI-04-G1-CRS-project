/**
 * 
 */
package com.flipkart.service;
import java.util.Scanner;

import com.flipkart.DAO.AdminDAOInterface;
import com.flipkart.DAO.AdminDAOInterfaceIMPL;
import com.flipkart.bean.Course;
import com.flipkart.bean.Professor;
import com.flipkart.bean.ReportCard;
import com.flipkart.bean.Student;
import com.flipkart.bean.Admin;
/**
 * @author harshil
 *
 */
public class AdminOperation implements AdminInterface {

	AdminDAOInterfaceIMPL adminInterface=new AdminDAOInterfaceIMPL();
	Scanner sc=new Scanner(System.in);
	@Override
	public void addCourse() {
		// TODO Auto-generated method stub
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
	}

	@Override
	public void removeCourse() {
		// TODO Auto-generated method stub
		Course course=new Course();
		System.out.println("Enter the course id");
		int id=sc.nextInt();
		course.setCourseID(id);
		adminInterface.removeCourse(course);
	}

	@Override
	public void generateReportCard() {
		// TODO Auto-generated method stub
		Student student=new Student();
		System.out.println("Enter student id");
		int id=sc.nextInt();
		student.setId(id);
		adminInterface.viewReportCard(student);
	}

	@Override
	public void addProfessor() {
		// TODO Auto-generated method stub
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
	}

	@Override
	public void removeProfessor() {
		// TODO Auto-generated method stub
		Professor professor=new Professor();
		System.out.println("Enter professor id");
		int id=sc.nextInt();
		professor.setId(id);
		adminInterface.removeProfessor(professor);
	}

	@Override
	public void addStudent() {
		// TODO Auto-generated method stub
		Student student=new Student();
		System.out.println("Enter new student id");
		int id=sc.nextInt();
		student.setId(id);
		System.out.println("Enter student email");
		String email=sc.next();
		student.setEmail(email);
		System.out.println("Enter password");
		String password=sc.next();
		student.setPassword(password);
		student.setRole("student");
		student.setLoggedin(false);
		System.out.println("Enter student name");
		String name=sc.next();
		student.setName(name);
		adminInterface.addStudent(student);
	}

	@Override
	public void removeStudent() {
		// TODO Auto-generated method stub
		Student student=new Student();
		System.out.println("Enter student id");
		int id=sc.nextInt();
		student.setId(id);
		adminInterface.removeStudent(student);
	}
	
	@Override
	public Admin getAdminById(int id) {
		AdminDAOInterface addao = new AdminDAOInterfaceIMPL();

		return addao.getAdminById(id);
	}

	@Override
	public void approveStudents() {
		// TODO Auto-generated method stub
		adminInterface.approveStudents();
	}

}