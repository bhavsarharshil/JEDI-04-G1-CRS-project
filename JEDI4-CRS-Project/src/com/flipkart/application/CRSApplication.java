/**
 * 
 */
package com.flipkart.application;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.bean.Admin;
import com.flipkart.service.AdminInterface;
import com.flipkart.service.AdminOperation;
import com.flipkart.service.CourseInterfaceImpl;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorInterfaceImpl;
import com.flipkart.service.StudentInterface;
import com.flipkart.service.StudentOperation;
import com.flipkart.service.VerificationSystem;
import com.flipkart.service.VerificationSystemOperation;

/**
 * @author harshil
 *
 */
public class CRSApplication {

	
	public static Logger logger=Logger.getLogger(CRSApplication.class);
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("=======================================================");
			System.out.println("\t\tWelcome to the CRS System");
			System.out.println("=======================================================\n");
			System.out.println("Enter 1 to login");
			System.out.println("Enter 2 to view the course catalog");
			System.out.println("Enter 3 to register as a new student");
			System.out.println("Enter -1 to exit\n");
			try {
				System.out.print("Input: ");
				int a=sc.nextInt();
				if(a==1) {
					System.out.println("\n============LOGIN============\n");
					System.out.print("Please enter your ID : ");
					int id=sc.nextInt();
					System.out.print("Enter your password : ");
					String password=sc.next();
					VerificationSystem newverfiy=new VerificationSystemOperation();
					//loginWithCredentials(id,password);
					String person=newverfiy.loginWithCredential(id, password);
//					System.out.println(person);
					if(person.equals("student"))
					{
						StudentCRSMenu newclient =new StudentCRSMenu();
						StudentInterface studentI = new StudentOperation();
						Student student = studentI.getStudentById(id);
						newclient.studentClient(student);
					}
					else if(person.equals("professor"))
					{
						ProfessorCRSMenu newclient=new ProfessorCRSMenu();
						ProfessorInterface profI = new ProfessorInterfaceImpl();
						Professor professor = profI.getProfessorById(id);
						newclient.professorClient(professor);
					}
					else if(person.equals("admin"))
					{
						AdminCRSMenu newclient=new AdminCRSMenu();
						AdminInterface AdminI = new AdminOperation();
						Admin admin = AdminI.getAdminById(id);
						newclient.AdminClient(admin);
					}
					else if(person.equals("unApproved")) {
					}
					else {
						logger.error("\nInvalid Credentials\n");
					}
				}
				else if(a==2) {
					CourseInterfaceImpl courseClient=new CourseInterfaceImpl();
					courseClient.viewCourseCatalog();
				}
				else if(a==3) {
					StudentOperation studentClient=new StudentOperation();
					studentClient.addStudent();
				}
				else if(a==-1) {
					System.out.println("\n---Exiting the application---\n");
					break;
				}
				else {
					System.out.println("\nPlease enter a valid input\n");
				}
			}catch(InputMismatchException e) {
				sc.next();
				logger.error("\nThe input format is invalid\n\n");
			}catch(Exception e) {
				sc.next();
				logger.error(e.getMessage());
			}
		}
	}
}

