/**
 * 
 */
package com.flipkart.bean;

import java.util.ArrayList;

/**
 * @author harshil
 *
 */
public class ReportCard {
	private int studentId;
	private ArrayList<PairIntChar> grades = new ArrayList<PairIntChar>();
	
	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public ArrayList<PairIntChar> getGrades() {
		return grades;
	}

	public void setGrades(int x,char y) {
		PairIntChar myPair=new PairIntChar(x,y);
		this.grades.add(myPair);
	}
}
