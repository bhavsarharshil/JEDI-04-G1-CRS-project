/**
 * 
 */
package com.flipkart.bean;

import java.util.Vector;

/**
 * @author utkarsh
 *
 */
public class Student extends User{
	private int rollNo;
	private boolean registrationStatus;
	/**
	 * vector of courses student is enrolled in
	 */
	private Vector<Integer> enrolledCourses = new Vector();
	private boolean paymentStatus;
	private String branch;
	private int semester;
	private int admission_year;
	public String getBranch() {
		return branch;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public int getAdmission_year() {
		return admission_year;
	}

	public void setAdmission_year(int admission_year) {
		this.admission_year = admission_year;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public boolean isRegistrationStatus() {
		return registrationStatus;
	}
	public void setRegistrationStatus(boolean registrationStatus) {
		this.registrationStatus = registrationStatus;
	}
	public Vector<Integer> getEnrolledCourses() {
		return enrolledCourses;
	}
	public void setEnrolledCourses(Vector<Integer> enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}
	public boolean isPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	
	
}
