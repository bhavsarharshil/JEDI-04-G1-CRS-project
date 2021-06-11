/**
 * 
 */
package com.flipkart.service;

/**
 * @author froz1
 *
 */
public class VerificationSystemOperation implements VerificationSystem {

	@Override
	public String loginWithCredential(String username, String password) {
		// TODO Auto-generated method stub
		if(username.equals("prof"))
		{
			return "prof";
		}
		else if(username.equals("admin"))
		{
			return "admin";
		}
		else
		{
			return "student";
		}
	}

	@Override
	public boolean registerStudent(int id, String email, String password, String name) {
		// TODO Auto-generated method stub
		System.out.println("student register");
		return false;
	}

	@Override
	public boolean registerProfessor(int id, String email, String password, String name) {
		// TODO Auto-generated method stub
		System.out.println("prof register");
		return false;
	}
	
	
}
