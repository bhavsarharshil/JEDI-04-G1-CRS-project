/**
 * 
 */
package com.flipkart.bean;

import java.util.Vector;

/**
 * @author hp
 *
 */
public class Professor {
	private String department;
	private String name;
	private Vector<String> listOfCourseAssigned = new Vector<String>();
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Vector<String> getListOfCourseAssigned() {
		return listOfCourseAssigned;
	}
	public void setListOfCourseAssigned(Vector<String> listOfCourseAssigned) {
		this.listOfCourseAssigned = listOfCourseAssigned;
	}
}
