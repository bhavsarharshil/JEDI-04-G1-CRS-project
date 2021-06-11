/**
 * 
 */
package com.flipkart.application;
import java.util.Scanner;

import com.flipkart.bean.Student;
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
	
	public static void studentClient(Student student) 
	{
		Scanner input = new Scanner(System.in);
		StudentInterface studentI = new StudentOperation(); 
//		Student student1 = new Student();
		int choice;
		System.out.println("===============WELCOME====================\n");
		System.out.println("Welcome " + student.getName());
		do
		{
			showChoices();
			choice = input.nextInt();
			switch (choice) {
				case 1:
					studentI.viewGrades(121);
					break;
				case 2:
					studentI.makePayment(null,null);
					break;
				case 3:
					studentI.registerCourses(null,null);
					break;
				case 4:
					 studentI.addPrimaryCourse(null,1);
					break;
				case 5:
					 studentI.removePrimaryCourse(null,1);
					break;
				case 6:
					 studentI.addSecondaryCourse(null,1);
					break;
				case 7:
					 studentI.removeSecondaryCourse(null,1);
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
