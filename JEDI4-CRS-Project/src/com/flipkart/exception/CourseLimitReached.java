/**
 * 
 */
package com.flipkart.exception;

/**
 * @author Nishita
 *
 */
public class CourseLimitReached  extends Exception{
	private static final long serialVersionUID = 1L;
	String message;
	
	public CourseLimitReached(String message) {
		this.message = message;
	}
	public String getMessage() {
		return this.message;
	}
}
