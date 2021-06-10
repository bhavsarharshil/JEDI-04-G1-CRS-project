/**
 * 
 */
package com.flipkart.bean;

import java.util.Vector;

/**
 * @author utkarsh
 *
 */
public class Student {
	private int rollNo;
	private boolean registrationStatus;
	private Vector<Integer> enrolledCourses = new Vector<>();
	private boolean paymentStatus;
	
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
