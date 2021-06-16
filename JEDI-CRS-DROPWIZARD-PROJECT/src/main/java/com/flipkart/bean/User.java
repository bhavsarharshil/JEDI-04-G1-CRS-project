package com.flipkart.bean;

/**
 * @author utkarsh
 *
 */

public class User {
	private int id;
	private String email;
	private String password;
	private boolean isLoggedin;
	private String role;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public boolean isLoggedin() {
		return isLoggedin;
	}
	public void setLoggedin(boolean isLoggedin) {
		this.isLoggedin = isLoggedin;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
}