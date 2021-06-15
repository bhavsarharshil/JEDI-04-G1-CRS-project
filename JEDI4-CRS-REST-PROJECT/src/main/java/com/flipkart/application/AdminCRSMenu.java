/**
 * 
 */
package com.flipkart.application;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.*;
import com.flipkart.service.*;
/**
 * @author froz1
 *
 */
public class AdminCRSMenu {
	public static Logger logger=Logger.getLogger(AdminCRSMenu.class);
	
	public static void showChoices()
	{
		System.out.println("Enter 1 to generate report card of a student");
		System.out.println("Enter 2 to add professor");
		System.out.println("Enter 3 to remove professor");
		System.out.println("Enter 4 to remove student");
		System.out.println("Enter 5 to add course");
		System.out.println("Enter 6 to remove course");
		System.out.println("Enter 7 to approve students");
		System.out.println("Enter 8 to view professors");
		System.out.println("Enter 9 to view students");
		System.out.println("Enter 10 to view courses");
		System.out.println("Enter 11 to approve student request");
		System.out.println("Enter -1 to logout");
	}
	public  void AdminClient(Admin admin)
	{
		System.out.println("=======================================================");
		System.out.println("\t\tWelcome " + admin.getAdminName());
		System.out.println("=======================================================\n");
		Scanner sc = new Scanner(System.in);
		AdminOperation newadmin= new AdminOperation();
			int choice = 0;
			do
			{		
				showChoices();
				try {
					System.out.print("\nInput : ");
					choice = sc.nextInt();
					
					switch(choice)
					{
						case 1:
							newadmin.viewStudents();
							newadmin.generateReportCard();
							break;
						case 2:
							newadmin.addProfessor();
							break;
						case 3:				
							newadmin.viewProfessors();
							newadmin.removeProfessor();
							break;
						case 4:
							newadmin.viewStudents();
							newadmin.removeStudent();
							break;
						case 5:
							newadmin.addCourse();
							break;
						case 6:
							newadmin.viewCourses();
							newadmin.removeCourse();
							break;
						case 7:
							newadmin.approveStudents();
							break;
						case 8:
							newadmin.viewProfessors();
							break;
						case 9:
							newadmin.viewStudents();
							break;
						case 10:
							newadmin.viewCourses();
							break;
						case 11:
							newadmin.approveStudentsRequest();
							break;
						case -1:
							System.out.println("\n---Logged Out Successfully---\n");
							break;
						default:
							System.out.println("\nInvalid Choice\n");
					}
				}catch(InputMismatchException e){
					sc.next();
					logger.error("\nThe input formal is invalid\n");
				}catch(Exception e) {
					sc.next();
					logger.error("\n"+e.getMessage()+"\n");
				}
			}
			while(choice != -1);
		}
}
