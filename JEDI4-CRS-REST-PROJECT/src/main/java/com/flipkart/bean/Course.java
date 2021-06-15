/**
 * 
 */
package com.flipkart.bean;

import java.util.ArrayList;

import com.flipkart.constant.PairStudentProfessor;

/**
 * @author 91883
 *
 */
public class Course {
	protected int courseID;
	
	protected String courseName;
    private int credits;

	/**
	 * list of students enrolled in course
	 */
    ArrayList<PairStudentProfessor> listOfEnrolledStudents = new ArrayList<PairStudentProfessor>();
    private int professorAllotted;

    public int getCourseID() {
		return courseID;
	}
	public void setCourseID(int courseID) {
		this.courseID = courseID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public ArrayList<PairStudentProfessor> getListOfEnrolledStudents() {
		return listOfEnrolledStudents;
	}
	public void setListOfEnrolledStudents(ArrayList<PairStudentProfessor> listOfEnrolledStudents) {
		this.listOfEnrolledStudents = listOfEnrolledStudents;
	}
	public void setProfessorAllotted(int professorID){
        	this.professorAllotted = professorID;
    	}

    	public int getProfessorAllotted(){
        	return professorAllotted;
    	}

}
