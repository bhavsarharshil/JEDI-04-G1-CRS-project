/**
 * 
 */
package com.flipkart.exception;

/**
 * @author 91883
 *
 */
public class StudentCountException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public StudentCountException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}
	

}
