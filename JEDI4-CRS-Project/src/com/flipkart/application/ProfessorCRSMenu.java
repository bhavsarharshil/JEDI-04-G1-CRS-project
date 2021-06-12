package com.flipkart.application;

import java.util.Scanner;
import com.flipkart.bean.*;
import com.flipkart.service.*;

public class ProfessorCRSMenu {
	private static ProfessorInterface professorI = new ProfessorInterfaceImpl();
	//static for testing
	public  void professorClient(Professor professor) {
		System.out.println("Welcome Professor " + professor.getName()  );

		int choice = 0;
		Scanner input;
		
		input = new Scanner(System.in);
		while(choice != -1) {
			showChoices();
			choice = input.nextInt();
			switch(choice) {
			
			case 1:
				professorI.gradeStudents(1);
				break;
			case 2:
				professorI.viewEnrolledStudentsInCourse(1);
				break;
			case 3:
				professorI.addAssignedCourse(1);
				break;
			
			case 4:
				professorI.removeAssignedCourse(1);
				break;
			case 5:
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}

		
	}
	
	public static void showChoices() {
		System.out.println("Please select an operation: ");
		System.out.println("1. Grade Student");
		System.out.println("2. View enrolled students ");
		System.out.println("3. Add assigned courses");
		System.out.println("4. Remove assigned courses");
		System.out.println("5. exit");
	}
}
