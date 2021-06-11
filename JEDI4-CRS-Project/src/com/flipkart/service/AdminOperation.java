/**
 * 
 */
package com.flipkart.service;

import com.flipkart.DAO.AdminDAOInterface;
import com.flipkart.DAO.AdminDAOInterfaceIMPL;
import com.flipkart.bean.Admin;

/**
 * @author froz1
 *
 */
public class AdminOperation implements AdminInterface {

	@Override
	public void addCourse() {
		// TODO Auto-generated method stub
		System.out.println("course added");
	}

	@Override
	public void removeCourse() {
		// TODO Auto-generated method stub
		System.out.println("course removed");
	}

	@Override
	public void generateReportCard() {
		// TODO Auto-generated method stub
		System.out.println("report view");
	}

	@Override
	public void addProfessor() {
		// TODO Auto-generated method stub
		System.out.println("prof added");
	}

	@Override
	public void removeProfessor() {
		// TODO Auto-generated method stub
		System.out.println("prof remove");
	}

	@Override
	public void addStudent() {
		// TODO Auto-generated method stub
		System.out.println("student added");
	}

	@Override
	public void removeStudent() {
		// TODO Auto-generated method stub
		System.out.println("student removed");
	}

	@Override
	public Admin getAdminById(int id) {
		AdminDAOInterface addao = new AdminDAOInterfaceIMPL();
		
		return addao.getAdminById(id);
	}
	

}
