package com.flipkart.DAO;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserDAOInterface user = new UserDAOInterfaceIMPL();
		user.verifyLoginCredentials(1234, "flipkart");
	}

}
