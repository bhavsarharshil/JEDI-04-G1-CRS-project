package com.flipkart.application;

import java.util.Scanner;
import com.flipkart.bean.*;
import com.flipkart.service.*;

public class ProfessorCRSMenu {

	//static for testing
	public static void professorClient(Professor professor) {
		System.out.println("Welcome Professor");

		int choice = 0;
		Scanner input= new Scanner(System.in);;
		ProfessorInterface professorInterface = new ProfessorInterfaceImpl();
		do {
			showChoices();
			choice = input.nextInt();
			switch(choice) {

				case 1:
					professorInterface.gradeStudents(professor);
					break;
				case 2:
					professorInterface.viewGrades(professor);
					break;
				case 3:
					professorInterface.showAssignedCourses(professor);
					break;
				case 4:
					professorInterface.addAssignedCourse(professor);
					break;
				case 5:
					professorInterface.removeAssignedCourse(professor);
					break;
				case 6:
					professorInterface.viewEnrolledStudentsInCourse(professor);
					break;
				default:
					System.out.println("Invalid Choice");
					break;
			}
		}
		while(choice != -1);
//		input.close();


	}

	public static void showChoices() {
		System.out.println("Please select an operation: ");
		System.out.println("1. Grade Student");
		System.out.println("2. View students grade ");
		System.out.println("3. show assigned courses");
		System.out.println("4. add assigned courses");
		System.out.println("5. Remove assigned courses");
		System.out.println("6. view assigned student");
		System.out.println("-1. exit");
	}
}