/**
 * 
 */
package com.flipkart.constant;

/**
 * @author harshil
 *
 */
public class PairIntChar {
	private int first;
	private char second;
	
	public int getFirst() {
		return first;
	}
	public void setFirst(int first) {
		this.first = first;
	}
	public char getSecond() {
		return second;
	}
	public void setSecond(char second) {
		this.second = second;
	}
	
	public PairIntChar(int x,char y) {
		this.first=x;
		this.second=y;
	}
}
