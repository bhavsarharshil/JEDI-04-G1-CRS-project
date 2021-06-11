/**
 * 
 */
package com.flipkart.bean;

import java.util.ArrayList;

import com.flipkart.constant.PairCourseChar;

/**
 * @author harshil
 *
 */
public class ReportCard {
	private int studentId;
	private ArrayList<PairCourseChar> grades = new ArrayList<PairCourseChar>();
	
	
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public ArrayList<PairCourseChar> getGrades() {
		return grades;
	}

	public void setGrades(Course x,Character y) {
		PairCourseChar myPair=new PairCourseChar(x,y);
		this.grades.add(myPair);
	}
}
