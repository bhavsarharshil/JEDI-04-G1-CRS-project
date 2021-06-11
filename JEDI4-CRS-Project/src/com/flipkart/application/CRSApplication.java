/**
 * 
 */
package com.flipkart.application;

import java.util.Scanner;

import com.flipkart.application.StudentCRSMenu;
import com.flipkart.service.VerificationSystem;
import com.flipkart.service.VerificationSystemOperation;

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
		System.out.println("==========Welcome to the CRS System==========");
		System.out.println("Enter 1 to login \nEnter 2 to view the course catalog \nEnter 3 to register as a new student");
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		if(a==1) {
			System.out.println("Please enter your ID");
			String id=sc.next();
			System.out.println("Enter your password");
			String password=sc.next();
			VerificationSystem newverfiy=new VerificationSystemOperation();
			//loginWithCredentials(id,password);
			String person=newverfiy.loginWithCredential(id, password);
			if(person.equals("student"))
			{
				StudentCRSMenu newclient =new StudentCRSMenu();
				newclient.studentClient();
			}
			else if(person.equals("prof"))
			{
				ProfessorCRSMenu newclient=new ProfessorCRSMenu();
				newclient.professorClient();
			}
			else 
			{
				AdminCRSMenu newclient=new AdminCRSMenu();
				newclient.AdminClient();
			}
		}
		else if(a==2) {
//			viewCourseCatalog();
		}
		else
			System.out.println("NEW Registration");
		}
	}

