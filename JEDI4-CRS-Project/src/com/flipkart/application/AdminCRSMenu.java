/**
 * 
 */
package com.flipkart.Application;
import java.util.Scanner;

import com.flipkart.bean.*;
import com.flipkart.service.*;
/**
 * @author froz1
 *
 */
public class AdminCRSMenu {
	
	public void showChoices()
	{
		System.out.println("Select an operation");
		System.out.println("Enter 1 to generate report card of a student");
		System.out.println("Enter 2 to add professor");
		System.out.println("Enter 3 to remove professor");
		System.out.println("Enter 4 to add student");
		System.out.println("Enter 5 to remove student");
		System.out.println("Enter 6 to add course");
		System.out.println("Enter 7 to remove course");
		System.out.println("Enter -1 to logout");
	}
	public void AdminClient()
	{
		System.out.println("\n");
		System.out.println("=========================================");
		System.out.println("Welcome Admin!!");
		System.out.println("=========================================");
		Scanner sc = new Scanner(System.in);
			int choice = -1;
			do
			{		
				showChoices();
				choice = sc.nextInt();
				
				switch(choice)
				{
					case 1:
//						generateReportCard();
						break;
					case 2:
//						addProfessor();
						break;
					case 3:				
						removeProfessor();
						break;
					case 4:
						addStudents();
						break;
					case 5:
						removeStudents();
						break;
					case 6:
						addCourse();
						break;
					case 7:
						removeCourse();
						break;
					case -1:
						logger.info("Logged Out Successfully");
						break;
					default:
						logger.info("Invalid Choice");
						break;
				}
			}
			while(choice != -1);
		}

}
