package com.flipkart.application;

import java.util.Scanner;

public class ProfessorCRSMenu {
	public void professorClient(Professor professor) {
		System.out.println("Welcome Professor " + getName());
		int choice;
		Scanner input;
		try {
			input = new Scanner(System.in);
			do {

				showChoices();
				choice = input.nextInt();
				switch(choice) {
				
				case 1:
					gradeStudents();
					break;
				
				case 2:
					viewEnrolledStudents();
					break;
				case 3:
					addAssignedCourse();
					break;
				
				case 4:
					removeAssignedCourse();
					break;
				}

			}
		}
	}
	
	public static void showChoices() {
		System.out.println("Please select an operation: ");
		System.out.println("1. Grade Student");
		System.out.println("2. View enrolled students ");
		System.out.println("3. Add assigned courses");
		System.out.println("4. Remove assigned courses");
	}
}
