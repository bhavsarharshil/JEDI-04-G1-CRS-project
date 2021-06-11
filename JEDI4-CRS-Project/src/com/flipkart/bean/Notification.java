/**
 * 
 */
package com.flipkart.bean;

/**
 * @author 91883
 *
 */
public class Notification {
	private String msg;
	private int notificationId;
	private int studentId;
	private int time ; 
	private boolean status;
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getNotificationId() {
		return notificationId;
	}
	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	

}
