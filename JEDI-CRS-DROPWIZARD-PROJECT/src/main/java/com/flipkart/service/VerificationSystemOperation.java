/**
 * 
 */
package com.flipkart.service;

import com.dropwizard.App;
import com.flipkart.DAO.UserDAOInterfaceIMPL;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author froz1
 *
 */
public class VerificationSystemOperation implements VerificationSystem {
    private static final Logger logger = LoggerFactory.getLogger(VerificationSystem.class);
    

	/**
	 * @param username username
	 * @param password password
	 * @return String: role
	 */
	@Override
	public String loginWithCredential(int username, String password) {
		// TODO Auto-generated method stub
		UserDAOInterfaceIMPL user = new UserDAOInterfaceIMPL();
		logger.info("aaaaaaaaaaaaaaaaa");
		try {
			String role = user.verifyLoginCredentials(username,password);
			return role;
		}
		catch( Exception E) {
			logger.error("\n---Login failed---\n");
		}
		return "Invalid";
	}


	
	
}
