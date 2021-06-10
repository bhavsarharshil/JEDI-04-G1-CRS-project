/**
 * 
 */
package com.flipkart.application;

import java.util.Scanner;

/**
 * @author harshil
 *
 */
public class CRSApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to the CRS System");
		System.out.println("Enter 1 to login, Enter 2 to view the course catalog");
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		if(a==1) {
			System.out.println("Please enter your ID");
			int id=sc.nextInt();
			System.out.println("Enter your password");
			String password=sc.next();
			loginWithCredentials(id,password);
		}
		else if(a==2) {
			viewCourseCatalog();
		}
		else {
			System.out.println("Please enter a valid input");
		}
	}

}
