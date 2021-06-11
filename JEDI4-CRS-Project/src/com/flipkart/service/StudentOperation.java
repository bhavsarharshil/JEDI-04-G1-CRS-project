/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;

import com.flipkart.bean.Grades;
import com.flipkart.bean.Student;

/**
 * @author hp
 *
 */
public class StudentOperation implements StudentInterface {

	@Override
	public void showCourses() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Grades> viewGrades(int studentId) {
		System.out.println("GRADES LIST");
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void makePayment(Student student, String method) {
		System.out.println("Enter CREDENTIALS");
		System.out.println("PAYMENT SUCCESSFULL");
		// TODO Auto-generated method stub
	}

	@Override
	public boolean addPrimaryCourse(Student student, int courseId) {
		System.out.println("PRIMARY COURSE ADDED");
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removePrimaryCourse(Student student, int courseId) {
		System.out.println("PRIMARY COURSE REMOVED");
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addSecondaryCourse(Student student, int courseId) {
		System.out.println("SECONDARY COURSE ADDEDD");
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeSecondaryCourse(Student student, int courseId) {
		System.out.println("SECONDARY COURSE REMOVED");
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean registerCourses(ArrayList<Integer> courseCart, Student student) {
		System.out.println("REGISTERED FOR COURSES");
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void viewPrimaryRegisteredCourses(Student student) {
		System.out.println("LIST OF ALL REGISTERED PRIMARY COURSES");
		// TODO Auto-generated method stub
		
	}

	@Override
	public void viewSecondaryRegisteredCourses(Student student) {
		System.out.println("LIST OF ALL REGISTERED SECONDARY COURSES");
		// TODO Auto-generated method stub
		
	}

}
