/**
 * 
 */
package com.flipkart.application;
import java.util.Scanner;

import com.flipkart.bean.*;
import com.flipkart.service.*;
/**
 * @author froz1
 *
 */
public class AdminCRSMenu {
	
	public static void showChoices()
	{
		System.out.println("Select an operation");
		System.out.println("Enter 1 to generate report card of a student");
		System.out.println("Enter 2 to add professor");
		System.out.println("Enter 3 to remove professor");
		System.out.println("Enter 4 to add student");
		System.out.println("Enter 5 to remove student");
		System.out.println("Enter 6 to add course");
		System.out.println("Enter 7 to remove course");
		System.out.println("Approve students");
		System.out.println("Enter -1 to logout");
	}
	public  void AdminClient(Admin admin)
	{
		System.out.println("\n");
		System.out.println("=========================================");
		System.out.println("Welcome Admin!!" + admin.getAdminName());
		System.out.println("=========================================");
		Scanner sc = new Scanner(System.in);
		AdminOperation newadmin= new AdminOperation();
			int choice = -1;
			do
			{		
				showChoices();
				choice = sc.nextInt();
				
				switch(choice)
				{
					case 1:
						newadmin.generateReportCard();
						break;
					case 2:
						newadmin.addProfessor();
						break;
					case 3:				
						newadmin.removeProfessor();
						break;
					case 4:
						newadmin.addStudent();
						break;
					case 5:
						newadmin.removeStudent();
						break;
					case 6:
						newadmin.addCourse();
						break;
					case 7:
						newadmin.removeCourse();
						break;
					case 8:
						newadmin.approveStudents();
					case -1:
						System.out.println("Logged Out Successfully");
						break;
					default:
						System.out.println("Invalid Choice");
						break;
				}
			}
			while(choice != -1);
			sc.close();
		}
}
