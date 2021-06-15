/**
 * 
 */
package com.flipkart.exception;

/**
 * @author froz1
 *
 */
public class NoAssignedCourseException extends Exception{
	private String message;
	
	public NoAssignedCourseException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
}