/**
 * 
 */
package com.flipkart.service;
import java.util.InputMismatchException;


import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flipkart.DAO.AdminDAOInterface;
import com.flipkart.DAO.AdminDAOInterfaceIMPL;
import com.flipkart.bean.Course;
import com.flipkart.bean.Grades;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.Admin;
/**
 * @author harshil
 *
 */
public class AdminOperation implements AdminInterface {

	public static Logger logger=LoggerFactory.getLogger(AdminOperation.class);
	AdminDAOInterfaceIMPL adminInterface=new AdminDAOInterfaceIMPL();

	/**
	 * method to add course
	 */
	@Override
	public boolean addCourse(Course course) {
		// TODO Auto-generated method stub
		try {
			return adminInterface.addCourse(course);
		}catch(InputMismatchException e){
			logger.error("The input formal is invalid\n");
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}

	/**
	 * method to remove course
	 */
	@Override
	public boolean removeCourse(int id) {
		// TODO Auto-generated method stub
		try {
			return adminInterface.removeCourse(id);
		}catch(InputMismatchException e){
			logger.error("The input formal is invalid\n");
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}

	/**
	 * method to generate report card
	 */
	@Override
	public Vector<Grades> generateReportCard(int id) {
		// TODO Auto-generated method stub

		
		try {
			return adminInterface.viewReportCard(id);
		}catch(InputMismatchException e){
			logger.error("\nThe input format is invalid\n");
		}catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		return null;
	}

	/**
	 * method to add professor
	 */
	@Override
	public boolean addProfessor(Professor professor) {
		// TODO Auto-generated method stub
		System.out.println("\n============Add Professor============\n");
		try {
			return adminInterface.addProfessor(professor);
		}catch(InputMismatchException e){
			logger.error("\nThe input formal is invalid\n");
		}catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		return false;
	}

	/**
	 *method to remove professor
	 */
	@Override
	public boolean removeProfessor(int id) {
		// TODO Auto-generated method stub
		try {
			return adminInterface.removeProfessor(id);
		}catch(InputMismatchException e){
			logger.error("\nThe input formal is invalid\n");
		}catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		return false;
	}

	/**
	 *method to remove student
	 */
	@Override
	public boolean removeStudent(int id) {
		// TODO Auto-generated method stub
		try {
			return adminInterface.removeStudent(id);
		}catch(InputMismatchException e){
			logger.error("\nThe input formal is invalid\n");
		}catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		return false;
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
	public boolean approveStudentsRequest(int id) {
		AdminDAOInterface addao = new AdminDAOInterfaceIMPL();
		try {
			return addao.approveStudentsRequest(id);
		}catch(InputMismatchException e){
			logger.error("\nThe input formal is invalid\n");
		}catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		return false;
	}

	/**
	 *method to approve courses of students
	 */
	@Override
	public boolean approveStudents() {
		// TODO Auto-generated method stub
		return adminInterface.approveStudents();
	}

	/**
	 *method to view all professors
	 */
	public Vector<Professor> viewProfessors() {
		// TODO Auto-generated method stub
		return adminInterface.viewProfessors();
	}

	/**
	 *method to view all students
	 */
	public Vector<Student> viewStudents() {
		// TODO Auto-generated method stub
		return adminInterface.viewStudents();
	}

	/**
	 *method to view all courses
	 */
	public Vector<Course> viewCourses() {
		// TODO Auto-generated method stub
		return adminInterface.viewCourses();
	}

}