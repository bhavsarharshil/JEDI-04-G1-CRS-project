/**
 * 
 */
package com.flipkart.service;

import com.flipkart.DAO.UserDAOInterfaceIMPL;
import org.apache.log4j.Logger;

/**
 * @author froz1
 *
 */
public class VerificationSystemOperation implements VerificationSystem {
	public static Logger logger=Logger.getLogger(VerificationSystem.class);

	/**
	 * @param username username
	 * @param password password
	 * @return String: role
	 */
	@Override
	public String loginWithCredential(int username, String password) {
		// TODO Auto-generated method stub
		UserDAOInterfaceIMPL user = new UserDAOInterfaceIMPL();
		try {
			String role = user.verifyLoginCredentials(username,password);
			return role;
		}
		catch( Exception E) {
			logger.error("\n---Login failed---\n");
		}
		return null;
	}


	
	
}
