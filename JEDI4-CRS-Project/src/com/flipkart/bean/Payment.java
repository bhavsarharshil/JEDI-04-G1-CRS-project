/**
 * 
 */
package com.flipkart.bean;

/**
 * @author 91883
 *
 */
public class Payment {
	private int paymentID ;
	private int mode ; // 0 for online ,  1 for online 
	private String date ;
	private int amount ;
	
	public int getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}
	public int getMode() {
		return mode;
	}
	public void setMode(int mode) {
		this.mode = mode;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
