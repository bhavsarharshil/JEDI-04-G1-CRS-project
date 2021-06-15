/**
 * 
 */
package com.flipkart.application;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.Student;
import com.flipkart.service.*;
/**
 * @author froz1
 *
 */
public class StudentCRSMenu {
	
	public static void showChoices() {
		System.out.println("1. View grades");
		System.out.println("2. Make payment");
		System.out.println("3. Add Primary Course");
		System.out.println("4. Remove Primary Course");
		System.out.println("5. Add Secondary Course");
		System.out.println("6. Remove Secondary Course ");
		System.out.println("7. View Primary registered Courses");
		System.out.println("8. View Secondary registered Courses");
		System.out.println("9. Show available courses");
		System.out.println("10. View Payments");
		System.out.println("Press -1 to Logout");
	}
	
	public  void studentClient(Student student) 
	{
		Scanner input = new Scanner(System.in);
		StudentInterface studentI = new StudentOperation();
		Logger logger = Logger.getLogger(StudentCRSMenu.class);
		int choice = 0, cid;
		System.out.println("=======================================================");
		System.out.println("\t\tWelcome " + student.getName());
		System.out.println("=======================================================\n");
		do
		{
			showChoices();
			try {
			System.out.print("\nInput :");
			choice = input.nextInt();
			switch (choice) {
				case 1:
					studentI.viewGrades(student.getId());
					break;
				case 2:
					System.out.println("Enter the payment method : ");
					System.out.println("1. Online");
					System.out.println("2. Offline");
					System.out.print("\nInput : ");
					int method1 = input.nextInt();
					if(method1 == 2)
						studentI.makePayment(student,"offline");
					else
					{
						System.out.println("======================Select Online Payment Method====================== ");
						System.out.println("1. NetBanking");
						System.out.println("2. Debit Card");
						System.out.println("3. Credit Card");
						System.out.println("4. Scholarship");
						System.out.print("\nInput : ");
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
					System.out.println("\n============Add Primary Course============\n");
					System.out.print("Enter the course ID : ");
					cid = input.nextInt();
					studentI.addPrimaryCourse(student.getId(),cid);
					break;
				case 4:

					System.out.println("\n============Remove Primary Course============\n");
					System.out.print("Enter the course ID : ");
					cid = input.nextInt();
					studentI.removePrimaryCourse(student.getId(),cid);
					break;
				case 5:

					System.out.println("\n============Add Secondary Course============\n");
					System.out.print("Enter the course ID : ");
					cid = input.nextInt();
					studentI.addSecondaryCourse(student.getId(),cid);
					break;
				case 6:
					System.out.println("\n============Remove Secondary Course============\n");
					System.out.print("Enter the course ID : ");
					cid = input.nextInt();
					studentI.removeSecondaryCourse(student.getId(),cid);
					break;
				case 7:
					studentI.viewPrimaryRegisteredCourses(student.getId());
					break;
				case 8:
					studentI.viewSecondaryRegisteredCourses(student.getId());
					break;
				case 9:
					studentI.showCourses();
					break;
				case 10:
					studentI.viewPayments(student);
					break;
				case -1:
					System.out.println("\n---Logged out successfully---\n");
					return;
				default:
					logger.error("\nInvalid Choice\n");
					break;
			}
			}catch(InputMismatchException e) {
				input.next();
				logger.error("\nThe input format is invalid\n\n");
			}catch(Exception e) {
				input.next();
				logger.error("\n"+e.getMessage()+"\n");
			}
		} while (choice != -1);	
		input.close();
	}
}
