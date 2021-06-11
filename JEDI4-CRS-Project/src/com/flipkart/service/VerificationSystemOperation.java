/**
 * 
 */
package com.flipkart.service;

import com.flipkart.DAO.UserDAOInterfaceIMPL;
/**
 * @author froz1
 *
 */
public class VerificationSystemOperation implements VerificationSystem {

	@Override
	public String loginWithCredential(int username, String password) {
		// TODO Auto-generated method stub
		UserDAOInterfaceIMPL user = new UserDAOInterfaceIMPL();
		try {
			String role = user.verifyLoginCredentials(username,password);
			return role;
		}
		catch( Exception E) {
			System.out.println("invalid credentials");
		}
		return null;
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
