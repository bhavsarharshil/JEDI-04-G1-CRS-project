/**
 * 
 */
package com.flipkart.constant;

import com.flipkart.DAO.AdminDAOImpl;
import com.flipkart.bean.Admin;
import com.flipkart.bean.Student;

/**
 * @author harshil
 *
 */
public class GetFunctions {
	AdminDAOImpl adminInterface=new AdminDAOImpl();
	public Admin getAdmin(int id) {
		return adminInterface.getAdmin(id);
	}
}
