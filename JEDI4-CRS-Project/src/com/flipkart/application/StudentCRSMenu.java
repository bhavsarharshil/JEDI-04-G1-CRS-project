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
		System.out.println("8. View Primary registered Courses");
		System.out.println("9. View Secondary registered Courses");
		System.out.println("Press -1 to Logout");
	}
	
	public  void studentClient(Student student) 
	{
		Scanner input = new Scanner(System.in);
		StudentInterface studentI = new StudentOperation(); 
		int choice,cid;
		System.out.println("===============WELCOME====================\n");
		System.out.println("Welcome " + student.getName());
		do
		{
			showChoices();
			choice = input.nextInt();
			switch (choice) {
				case 1:
					studentI.viewGrades(student.getId());
					break;
				case 2:
					System.out.println("Enter the payment method : ");
					String method1 = input.nextLine();
					if(method1.equals("offline"))
						studentI.makePayment(student,method1);
					else
					{
						System.out.println("======================Select Online Payment Method====================== ");
						System.out.println("1. NetBanking");
						System.out.println("2. Debit Card");
						System.out.println("3. Credit Card");
						System.out.println("4. Scholarship");
						int c = input.nextInt();
						if(c==1)
							studentI.makePayment(student,"Netbanking");
						else if(c==2)
							studentI.makePayment(student,"Debit Card");
						else if(c==3)
							studentI.makePayment(student,"Credit Card");
						else
							studentI.makePayment(student,"Scholarship");
					}
					break;
				case 3:
					studentI.registerCourses(null,student.getId());
					break;
				case 4:
					 System.out.println("Enter the course ID ");
					 cid = input.nextInt();
					 studentI.addPrimaryCourse(student.getId(),cid);
					break;
				case 5:
					 System.out.println("Enter the course ID ");
					 cid = input.nextInt();
					 studentI.removePrimaryCourse(student.getId(),cid);
					break;
				case 6:
					 System.out.println("Enter the course ID ");
					 cid = input.nextInt();
					 studentI.addSecondaryCourse(student.getId(),cid);
					break;
				case 7:
					 System.out.println("Enter the course ID ");
					 cid = input.nextInt();
					 studentI.removeSecondaryCourse(student.getId(),cid);
					break;
				case 8:
					studentI.viewPrimaryRegisteredCourses(student.getId());
					break;
				case 9:
					studentI.viewSecondaryRegisteredCourses(student.getId());
					break;
				case -1:
					System.out.println("============================Logged out successfully==============================");
					return;
				default:
					System.out.println("Invalid Choice");
					break;
			}
		} while (choice != -1);	
		input.close();
	}
}
