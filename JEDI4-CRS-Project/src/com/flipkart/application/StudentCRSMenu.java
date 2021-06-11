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
public class StudentCRSMenu {
	
	public static void showChoices() {
		System.out.println("======================Select an operation====================== ");
		System.out.println("1. View grades");
		System.out.println("2. Make payment");
		System.out.println("3.Register For Courses");
		System.out.println("4. Add Primary Course");
		System.out.println("5. Remove Primary Course(");
		System.out.println("6. Add Secondary Course");
		System.out.println("7. Remove Secondary Course ");
		System.out.println("Press -1 to Logout");
	}
	
	public static void studentClient() 
	{
		Scanner input = new Scanner(System.in);
		StudentInterface student = new StudentOperation(); 
//		Student student1 = new Student();
		int choice;
		System.out.println("===============WELCOME====================\n");
		do
		{
			showChoices();
			choice = input.nextInt();
			switch (choice) {
				case 1:
					student.viewGrades(121);
					break;
				case 2:
					student.makePayment(null,null);
					break;
				case 3:
					student.registerCourses(null,null);
					break;
				case 4:
					 student.addPrimaryCourse(null,1);
					break;
				case 5:
					 student.removePrimaryCourse(null,1);
					break;
				case 6:
					 student.addSecondaryCourse(null,1);
					break;
				case 7:
					 student.removeSecondaryCourse(null,1);
					break;
				case -1:
					System.out.println("============================EXIT==============================");
					break;
				default:
					System.out.println("Invalid Choice");
					break;
			}
		} while (choice != -1);	
	}
	
}
