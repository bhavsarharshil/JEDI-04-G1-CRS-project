/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flipkart.DAO.StudentDAOInterface;
import com.flipkart.DAO.StudentDAOInterfaceIMPL;
import com.flipkart.DAO.CoursesDAOInterfaceIMPL;
import com.flipkart.DAO.ProfessorDAOInterfaceIMPL;
import com.flipkart.bean.Course;
import com.flipkart.bean.Grades;
import com.flipkart.bean.Payment;
import com.flipkart.bean.Student;

/**
 * @author hp
 *
 */
public class StudentOperation implements StudentInterface {

	StudentDAOInterface stdao = new StudentDAOInterfaceIMPL();

	StudentDAOInterfaceIMPL studentDaoOperation = StudentDAOInterfaceIMPL.getInstance();

	CoursesDAOInterfaceIMPL coursesDaoOperation = CoursesDAOInterfaceIMPL.getInstance();

	ProfessorDAOInterfaceIMPL professorDAOOperation = ProfessorDAOInterfaceIMPL.getInstance();

	private static Logger logger = LoggerFactory.getLogger(StudentOperation.class);

	AdminInterface adminI = new AdminOperation();

	/**
	 * method to show courses
	 */
	@Override
	public ArrayList<Course> showCourses() {
		try{
        	return coursesDaoOperation.getAllCourses();
        }catch (Exception e){
        	logger.error(e.getMessage());
        }
		return null;
	}

	/**
	 * @param studentId id of student
	 * @return Array list of grades
	 */
	@Override
	public ArrayList<Grades> viewGrades(int studentId) {
		try{
            return studentDaoOperation.getGrades(studentId);
        }
        catch(Exception e){
        	logger.error("\n" + e.getMessage() + "\n");
        }
    	return null;
	}
	
	/**
	 * @param student Student bean
	 * @param method method of payment
	 */
	@Override
	public int makePayment(int studentId, String method) {
		try {
			int dueAmount = studentDaoOperation.setPaymentStatus(studentId,method);
			Student student  = studentDaoOperation.getStudentById(studentId);
        	student.setPaymentStatus(true);
        	return dueAmount;
        }
        catch(Exception e) {
        	logger.error("\n" + e.getMessage() + "\n");
        }
		return -1;
	}

	
	/**
	 * @param studentId id of student
	 * @param courseId id of course
	 * @return boolean: true if primary course added correctly
	 */
	@Override
	public boolean addPrimaryCourse(int studentId, int courseId) {
		try {
			return stdao.addPrimaryCourse(studentId, courseId);
		}catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		return false;
	}

	
	/**
	 * @param studentId id of student
	 * @param courseId id of course
	 * @return boolean: true if primary course removed correctly
	 */
	@Override
	public boolean removePrimaryCourse(int studentId, int courseId) {
		try {
			return stdao.removePrimaryCourse(studentId, courseId);
		}catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		return false;
	}

	
	/**
	 * @param studentId id of student
	 * @param courseId id of course
	 * @return boolean: true if secondary course added correctly
	 */
	@Override
	public boolean addSecondaryCourse(int studentId, int courseId) {
		try {
			return stdao.addSecondaryCourse(studentId, courseId);
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}

	
	/**
	 * @param studentId id of student
	 * @param courseId id of course
	 * @return boolean true: if secondary course removed correctly
	 */
	@Override
	public boolean removeSecondaryCourse(int studentId, int courseId) {
		try {
			return stdao.removeSecondaryCourse(studentId, courseId);
		}catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		return false;
	}

	
	/**
	 * @param id id of student
	 * @return Student bean
	 */
	@Override
	public Student getStudentById(int id) {
		return stdao.getStudentById(id);
	}

	
	/**
	 * method to add student
	 */
	@Override
	public boolean addStudent() {
//		 TODO Auto-generated method stub
		try {
			Scanner sc=new Scanner(System.in);
			Student student=new Student();
			System.out.print("Enter new student id : ");
			int id=sc.nextInt();
			student.setId(id);
			System.out.print("Enter student email : ");
			String email=sc.next();
			student.setEmail(email);
			System.out.print("Enter password : ");
			String password=sc.next();
			student.setPassword(password);
			student.setRole("student");
			student.setLoggedin(false);
			System.out.print("Enter student name : ");
			String name=sc.next();
			student.setName(name);
			System.out.print("Enter branch : ");
			String branch = sc.next();
			student.setBranch(branch);
			System.out.print("Enter semester : ");
			int semester = sc.nextInt();
			student.setSemester(semester);
			return stdao.addStudent(student);
		}catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		return false;
	}

	
	/**
	 * @param studentId id of student
	 * method to view primary registered courses
	 */
	@Override
	public ArrayList<Course> viewPrimaryRegisteredCourses(int studentId) {		
		try {
			return stdao.getPrimaryRegisteredCourses(studentId);
		}catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		return null;
	}

	
	/**
	 * @param studentId id of student
	 * method to view primary registered courses
	 */
	@Override
	public ArrayList<Course> viewSecondaryRegisteredCourses(int studentId) {

		try {
			return stdao.getSecondaryRegisteredCourses(studentId);
		}catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		return null;
	}

	/*
	 * @param student : details of student
	 * return payment details
	 * */
	@Override
	public Payment viewPayments(int studentId) {
		// TODO Auto-generated method stub
		try {
			 return studentDaoOperation.viewPayments(studentId);
        }
        catch(Exception e) {
        	logger.error("\n" + e.getMessage() + "\n");
        }
		return null;
	}
}
