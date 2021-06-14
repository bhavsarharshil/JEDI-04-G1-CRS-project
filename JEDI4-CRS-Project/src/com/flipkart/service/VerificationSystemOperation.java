/**
 * 
 */
package com.flipkart.service;

import com.flipkart.DAO.UserDAOInterfaceIMPL;
import com.flipkart.application.CRSApplication;
import org.apache.log4j.Logger;

/**
 * @author froz1
 *
 */
public class VerificationSystemOperation implements VerificationSystem {
	public static Logger logger=Logger.getLogger(VerificationSystem.class);
	@Override
	public String loginWithCredential(int username, String password) {
		// TODO Auto-generated method stub
		UserDAOInterfaceIMPL user = new UserDAOInterfaceIMPL();
		try {
			String role = user.verifyLoginCredentials(username,password);
			return role;
		}
		catch( Exception E) {
			logger.error("login failed");
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
