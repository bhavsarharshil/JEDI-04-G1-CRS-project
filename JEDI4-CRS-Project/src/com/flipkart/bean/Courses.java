/**
 * 
 */
package com.flipkart.bean;

/**
 * @author 91883
 *
 */
public class Courses {
	protected int courseID;
	
	protected String courseName;
    private int credits;
    
    Vecor<Student> listOfEnrolledStudents = new Vector<Student>();
    Vector<Integer> professorAllotted = new Vector<Integer>();

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
	public Vecor<Student> getListOfEnrolledStudents() {
		return listOfEnrolledStudents;
	}
	public void setListOfEnrolledStudents(Vecor<Student> listOfEnrolledStudents) {
		this.listOfEnrolledStudents = listOfEnrolledStudents;
	}
	public Vector<Integer> getProfessorAllotted() {
		return professorAllotted;
	}
	public void setProfessorAllotted(Vector<Integer> professorAllotted) {
		this.professorAllotted = professorAllotted;
	}

}
