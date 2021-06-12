package com.flipkart.application;

import java.util.Scanner;
import com.flipkart.bean.*;
import com.flipkart.service.*;

public class ProfessorCRSMenu {

	//static for testing
	public static void professorClient() {
		System.out.println("Welcome Professor");

		int choice = 0;
		Scanner input;
		ProfessorInterface professor = new ProfessorInterfaceImpl();
		input = new Scanner(System.in);
		while(choice != -1) {
			showChoices();
			choice = input.nextInt();
			switch(choice) {

				case 1:
					professor.gradeStudents();
					break;
				case 2:
					professor.viewGrades();
					break;
				case 3:
					professor.showAssignedCourses();
					break;

				case 4:
					professor.addAssignedCourse();
					break;
				case 5:
					professor.removeAssignedCourse();
					break;
				case 6:
					professor.viewEnrolledStudentsInCourse();
				default:
					System.out.println("Invalid Choice");
					break;
			}
		}
		input.close();


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