/**
 * 
 */
package com.flipkart.constant;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;

/**
 * @author harshil
 *
 */
public class PairStudentProfessor {
	private Student first;
	private Professor second;
	
	public Student getFirst() {
		return first;
	}
	public void setFirst(Student first) {
		this.first = first;
	}
	public Professor getSecond() {
		return second;
	}
	public void setSecond(Professor second) {
		this.second = second;
	}
	
	public PairStudentProfessor(Student x,Professor y) {
		this.first=x;
		this.second=y;
	}
}
