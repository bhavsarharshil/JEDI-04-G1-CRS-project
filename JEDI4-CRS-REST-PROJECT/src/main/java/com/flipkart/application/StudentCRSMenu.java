/**
 * 
 */
package com.flipkart.application;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.DAO.ProfessorDAOInterface;
import com.flipkart.DAO.ProfessorDAOInterfaceIMPL;
import com.flipkart.bean.Course;
import com.flipkart.bean.Grades;
import com.flipkart.bean.Payment;
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
		ProfessorDAOInterface professorDAOOperation = new ProfessorDAOInterfaceIMPL();
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
				ArrayList<Grades> grades = studentI.viewGrades(student.getId());
				System.out.println("GRADES LIST");
				System.out.println("\n========================================================================");
				System.out.println("\t\t\tGrades");
				System.out.println("========================================================================\n");
				if(grades != null) {
					System.out.println("Course ID\t\tCourse Name\t\tGrade");
		    		System.out.println("_______________________________________________________________________\n");
			        grades.forEach(grade -> {
			            	System.out.println(String.format("%-9d\t\t%-11s\t\t%-5s", grade.getCourseId(), grade.getCourseName(), grade.getGrade()));
			         });
			        System.out.println("_______________________________________________________________________\n");
				}else {
					System.out.println("\nThere are no available grades\n");
				}
				break;
				
				
			case 2:
				String method;
				System.out.println("Enter the payment method : ");
				System.out.println("1. Online");
				System.out.println("2. Offline");
				System.out.print("\nInput : ");
				int method1 = input.nextInt();
				if(method1 == 2)
					method = "offline"; 
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
						method = "Netbanking"; 
					else if(c==2)
						method = "Debit Card";
					else if(c==3)
						method = "Credit Card";
					else
						method = "Scholarship";
					int dueAmount = studentI.makePayment(student,method);
					System.out.println("\n============================================================");
					System.out.println("\t\tPayments");
					System.out.println("============================================================\n");
					if(dueAmount == 0) {
						System.out.println("\nPayment already done!\n");
					}else if(dueAmount < 0) {
						System.out.println("\nThere are no payments to show\n");
					}else {
						System.out.println("\nAmount to be Paid : " + String.valueOf(dueAmount));
						System.err.println("---------Payment Successfull----------");
					}
				}
				break;
			case 3:
				System.out.println("\n============Add Primary Course============\n");
				System.out.print("Enter the course ID : ");
				cid = input.nextInt();
				if(studentI.addPrimaryCourse(student.getId(),cid)) {
					System.out.println("Course Added Successfully");
				}else {
					System.out.println("Course could not be added");
				}
				break;
			case 4:

				System.out.println("\n============Remove Primary Course============\n");
				System.out.print("Enter the course ID : ");
				cid = input.nextInt();
				if(studentI.removePrimaryCourse(student.getId(),cid)) {
					System.out.println("Course Removed Successfully");
				}else {
					System.out.println("Course could not be removed");
				}
				break;
			case 5:

				System.out.println("\n============Add Secondary Course============\n");
				System.out.print("Enter the course ID : ");
				cid = input.nextInt();
				if(studentI.addSecondaryCourse(student.getId(),cid)) {
					System.out.println("Course Added Successfully");
				}else {
					System.out.println("Course could not be added");
				}
				break;
			case 6:
				System.out.println("\n============Remove Secondary Course============\n");
				System.out.print("Enter the course ID : ");
				cid = input.nextInt();
				if(studentI.removeSecondaryCourse(student.getId(),cid)) {
					System.out.println("Course Removed Successfully");
				}else {
					System.out.println("Course could not be removed");
				}
				break;
			case 7:
				ArrayList<Course> primaryCourses = studentI.viewPrimaryRegisteredCourses(student.getId());
				System.out.println("========================================================================\n");
				System.out.println("\t\t\tPrimary Courses");
				System.out.println("\n========================================================================");
				if(primaryCourses != null) {
					System.out.println("Course ID\t\tCourse Name\t\tCredits");
	    			System.out.println("_______________________________________________________________________\n");
	    			primaryCourses.forEach((course) -> {
	    				System.out.println(String.format("%-9d\t\t%-11s\t\t%-7d", course.getCourseID(), course.getCourseName(), course.getCredits()));
	    			});
	    			System.out.println("_______________________________________________________________________\n\n");
				}else {
					System.out.println("You have not registered for any primary course\n");
				}
				break;
				
				
			case 8:
				ArrayList<Course> secondaryCourses = studentI.viewSecondaryRegisteredCourses(student.getId());
				System.out.println("\n========================================================================");
				System.out.println("\t\t\tSecondary Courses");
				System.out.println("========================================================================\n");
				if(secondaryCourses != null) {
					System.out.println("Course ID\t\tCourse Name\t\tCredits");
					System.out.println("_______________________________________________________________________\n");
					secondaryCourses.forEach(course -> {
						System.out.println(String.format("%-9d\t\t%-11s\t\t%-7d", course.getCourseID(), course.getCourseName(), course.getCredits()));
					});
					System.out.println("_______________________________________________________________________\n\n");
				}else {
					System.out.println("You have not registered for any secondary course\n");
				}
				break;
				
				
			case 9:
				ArrayList<Course> courses = studentI.showCourses();
				System.out.println("\n========================================================================");
				System.out.println("\t\t\tAvailable Courses");
				System.out.println("========================================================================\n");
				if(courses != null) {
					System.out.println("Course ID\t\tCourse Name\t\tCredits\t\tProfessor Allotted");
        			System.out.println("_______________________________________________________________________\n");
            		courses.forEach((course) ->{
            				String professorAllotted = professorDAOOperation.getProfessorByIdName(course.getProfessorAllotted());
            		if(professorAllotted == null) {
            			professorAllotted = "Not yet alloted";
            		}
            		System.out.println(String.format("%-9d\t\t%-11s\t\t%-7d\t\t%-18s", course.getCourseID(), course.getCourseName(), course.getCredits(), professorAllotted));
            		});
            		System.out.println("_______________________________________________________________________\n");
				}else {
					System.out.println("\nThere are no available courses\n");
				}

				break;
			case 10:
				Payment payment = studentI.viewPayments(student);
				if(payment == null) {
					System.out.println("Payment Not Done");
				}else {
					System.out.println("\n-------------------------------------------------PAYMENT DETAILS---------------------------------------------------\n");
					System.out.println("Payment ID\t\tMODE\t\t\tPayment Date\t\tAmount");
					System.out.println("-------------------------------------------------------------------------------------------------------------------");
					System.out.println(String.format("%-9d\t\t%-11s\t\t\t%-9s\t\t%-9s\n", payment.getPaymentID(),payment.getMethod(),payment.getDate(), payment.getAmount()));
					
				}
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
