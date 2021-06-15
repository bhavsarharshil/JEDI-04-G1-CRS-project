/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.flipkart.DAO.StudentDAOInterface;
import com.flipkart.DAO.StudentDAOInterfaceIMPL;
import com.flipkart.DAO.CoursesDAOInterfaceIMPL;
import com.flipkart.DAO.ProfessorDAOInterfaceIMPL;
import com.flipkart.bean.Course;
import com.flipkart.bean.Grades;
import com.flipkart.bean.Student;

/**
 * @author hp
 *
 */
public class StudentOperation implements StudentInterface {

	StudentDAOInterface stdao = new StudentDAOInterfaceIMPL();

	StudentDAOInterfaceIMPL studentDaoOperation = StudentDAOInterfaceIMPL.getInstance();

	CoursesDAOInterfaceIMPL coursesDaoOperation = CoursesDAOInterfaceIMPL.getInstance();

	ProfessorDAOInterfaceIMPL professorDAOOperation = ProfessorDAOInterfaceIMPL.getInstance();

	private static Logger logger = Logger.getLogger(StudentOperation.class);

	AdminInterface adminI = new AdminOperation();

	/**
	 * method to show courses
	 */
	@Override
	public void showCourses() {
		// TODO Auto-generated method stub
		System.out.println("\n========================================================================");
		System.out.println("\t\t\tAvailable Courses");
		System.out.println("========================================================================\n");
		try{
        		ArrayList<Course> courses = coursesDaoOperation.getAllCourses();
        		if(courses.isEmpty()) {
        			System.out.println("\nThere are no available courses\n");
        		}
        		else {
            		System.out.println("Course ID\t\tCourse Name\t\tCredits\t\tProfessor Allotted");
        			System.out.println("_______________________________________________________________________\n");
            		courses.forEach((course) ->{
            				String professorAllotted = professorDAOOperation.getProfessorByIdName(course.getProfessorAllotted());
            		if(professorAllotted == null) {
            			professorAllotted = "Not yet alloted";
            		}
            		System.out.println(String.format("%-9d\t\t%-11s\t\t%-7d\t\t%-18s", course.getCourseID(), course.getCourseName(), course.getCredits(), professorAllotted));
            		});
        		}
    			System.out.println("_______________________________________________________________________\n\n");
        	}
        	catch (Exception e){
        		logger.error(e.getMessage());
        	}
		
	}

	/**
	 * @param studentId id of student
	 * @return Array list of grades
	 */
	@Override
	public ArrayList<Grades> viewGrades(int studentId) {
//		System.out.println("GRADES LIST");
		// TODO Auto-generated method stub
		ArrayList<Grades> grades = null;
		System.out.println("\n========================================================================");
		System.out.println("\t\t\tGrades");
		System.out.println("========================================================================\n");
		
		try{
            grades = studentDaoOperation.getGrades(studentId);
            if(grades.isEmpty()) {
            	System.out.println("\nThere are no available grades\n");
            }
            else {
	            System.out.println("Course ID\t\tCourse Name\t\tGrade");
    			System.out.println("_______________________________________________________________________\n");
	            grades.forEach(grade -> {
	            	System.out.println(String.format("%-9d\t\t%-11s\t\t%-5s", grade.getCourseId(), grade.getCourseName(), grade.getGrade()));
	            });
            }
			System.out.println("_______________________________________________________________________\n\n");
        }
        catch(Exception e){
        	logger.error(e.getMessage());
        }
    	return grades;
		
	}

	/**
	 * @param student Student bean
	 * @param method method of payment
	 */
	@Override
	public void makePayment(Student student, String method) {
		try {
			studentDaoOperation.setPaymentStatus(student,method);
        	student.setPaymentStatus(true);
        }
        catch(Exception e) {
        	System.out.println(e.getMessage());
        }
		// TODO Auto-generated method stub
	}


	/**
	 * @param studentId id of student
	 * @param courseId id of course
	 * @return boolean: true if primary course added correctly
	 */
	@Override
	public boolean addPrimaryCourse(int studentId, int courseId) {
		try {
			stdao.addPrimaryCourse(studentId, courseId);
			return true;
		}catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		return false;
	}

	/**
	 * @param studentId id of student
	 * @param courseId id of course
	 * @return boolean: true if primary course removed correctly
	 */
	@Override
	public boolean removePrimaryCourse(int studentId, int courseId) {
		try {
			stdao.removePrimaryCourse(studentId, courseId);
			return true;
		}catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		return false;
	}

	/**
	 * @param studentId id of student
	 * @param courseId id of course
	 * @return boolean: true if secondary course added correctly
	 */
	@Override
	public boolean addSecondaryCourse(int studentId, int courseId) {
		try {
			stdao.addSecondaryCourse(studentId, courseId);
			return true;
		}catch(Exception e) {
			logger.error(e.getMessage());
		}
		return false;
	}

	/**
	 * @param studentId id of student
	 * @param courseId id of course
	 * @return boolean true: if secondary course removed correctly
	 */
	@Override
	public boolean removeSecondaryCourse(int studentId, int courseId) {
		try {
			stdao.removeSecondaryCourse(studentId, courseId);
			return true;
		}catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
		return false;
	}

	/**
	 * @param id id of student
	 * @return Student bean
	 */
	@Override
	public Student getStudentById(int id) {
		
		return stdao.getStudentById(id);
	}

	/**
	 * method to add student
	 */
	@Override
	public void addStudent() {
//		 TODO Auto-generated method stub
		try {
		Scanner sc=new Scanner(System.in);
		Student student=new Student();
		System.out.print("Enter new student id : ");
		int id=sc.nextInt();
		student.setId(id);
		System.out.print("Enter student email : ");
		String email=sc.next();
		student.setEmail(email);
		System.out.print("Enter password : ");
		String password=sc.next();
		student.setPassword(password);
		student.setRole("student");
		student.setLoggedin(false);
		System.out.print("Enter student name : ");
		String name=sc.next();
		student.setName(name);
		System.out.print("Enter branch : ");
		String branch = sc.next();
		student.setBranch(branch);
		System.out.print("Enter semester : ");
		int semester = sc.nextInt();
		student.setSemester(semester);
		stdao.addStudent(student);
		}catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
	}

	/**
	 * @param studentId id of student
	 * method to view primary registered courses
	 */
	@Override
	public void viewPrimaryRegisteredCourses(int studentId) {
		System.out.println("\n========================================================================");
		System.out.println("\t\t\tPrimary Courses");
		System.out.println("========================================================================\n");
		try {
			ArrayList<Course> primaryCourses = stdao.getPrimaryRegisteredCourses(studentId);
			if(primaryCourses.isEmpty()) {
				System.out.println("You have not registered for any primary course\n");
			}
			else {
				System.out.println("Course ID\t\tCourse Name\t\tCredits");
    			System.out.println("_______________________________________________________________________\n");
				for(Course course : primaryCourses){
					System.out.println(course.getCourseID() + "\t\t\t" + course.getCourseName() + "\t\t\t" + course.getCredits());
				}
    			System.out.println("_______________________________________________________________________\n\n");
			}
		}catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
	}

	/**
	 * @param studentId id of student
	 * method to view primary registered courses
	 */
	@Override
	public void viewSecondaryRegisteredCourses(int studentId) {
		System.out.println("\n========================================================================");
		System.out.println("\t\t\tSecondary Courses");
		System.out.println("========================================================================\n");
		try {
		ArrayList<Course> secondaryCourses = stdao.getSecondaryRegisteredCourses(studentId);
		if(secondaryCourses.isEmpty()) {
			System.out.println("You have not registered for any secondary course\n");
		}
		else {
			System.out.println("Course ID\t\tCourse Name\t\tCredits");
			System.out.println("_______________________________________________________________________\n");
			for(Course course : secondaryCourses){
				System.out.println(course.getCourseID() + "\t\t\t" + course.getCourseName() + "\t\t\t" + course.getCredits());
			}
			System.out.println("_______________________________________________________________________\n\n");
		}
		}catch(Exception e) {
			logger.error("\n"+e.getMessage()+"\n");
		}
	}

	@Override
	public void viewPayments(Student student) {
		// TODO Auto-generated method stub
		try {
			studentDaoOperation.viewPayments(student);
        }
        catch(Exception e) {
        	System.out.println(e.getMessage());
        }
	}


}
