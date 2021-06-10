/**
 * 
 */
package com.flipkart.Application;
import com.flipkart.bean.*;
import com.flipkart.service.*;
/**
 * @author froz1
 *
 */
public class StudentCRSMenu {
	public void showChoices() {
		System.out.println("Select an operation: ");
		System.out.println("1. vIew grades");
		System.out.println("2. make payment");
		System.out.println("3. add Primary Course");
		System.out.println("4. remove Primary Course(");
		System.out.println("5. add Secondary Course");
		System.out.println("6. remove Secondary Course ");
		System.out.println("-1 to Logout");
	}
	public void studentClient() 
	{
		Scanner input = Scanner(System.in);
		int choice;
		System.out.println("Welcome " + student.getUserName() + "!\n");
		do
		{
			showChoices();
			choice = input.nextInt();
			switch (choice) {
			case 1:
				viewGrades(studentId);
				break;
			case 2:
				makePayment();
				break;
			case 3:
				registerCourses();
				break;
			case 4:
				 addPrimaryCourse();
				break;
			case 5:
				 removePrimaryCourse();
				break;
			case 6:
				 addSecondaryCourse();
				break;
			case 7:
				 removeSecondaryCourse();
				break;
			default:
				logger.info("Invalid choice.\n");
				break;
			}
		} while (choice != -1);
		
		
	}
	
}
