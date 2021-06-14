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
		System.out.println("Enter 8 to approve students");
		System.out.println("Enter 9 to view professors");
		System.out.println("Enter 10 to view students");
		System.out.println("Enter 11 to view courses");
		System.out.println("Enter 12 to approve student request");
		System.out.println("Enter -1 to logout");
	}
	public  void AdminClient(Admin admin)
	{
		System.out.println("\n");
		System.out.println("=========================================");
		System.out.println("Welcome Admin!" + admin.getAdminName());
		System.out.println("=========================================");
		Scanner sc = new Scanner(System.in);
		AdminOperation newadmin= new AdminOperation();
			int choice = 0;
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
						break;
					case 9:
						newadmin.viewProfessors();
						break;
					case 10:
						newadmin.viewStudents();
						break;
					case 11:
						newadmin.viewCourses();
						break;
					case 12:
						newadmin.approveStudentsRequest();
						break;
					case -1:
						System.out.println("Logged Out Successfully");
						break;
					default:
						System.out.println("Invalid Choice");
				}
			}
			while(choice != -1);
		}
}
