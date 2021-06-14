/**
 * 
 */
package com.flipkart.exception;

/**
 * @author froz1
 *
 */
public class ProfessorException extends Exception{
	//private static final long serialVersionUID = 3L;
	private String message;
	
	public ProfessorException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
	
}
