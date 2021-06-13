/**
 * 
 */
package com.flipkart.service;

import java.util.ArrayList;

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

	AdminInterface adminI = new AdminOperation();
	@Override
	public void showCourses() {
		// TODO Auto-generated method stub
		try{
            		ArrayList<Course> courses = coursesDaoOperation.getAllCourses();
            		System.out.println("====================AVAILABLE COURSES====================\n");
            		System.out.println("Course ID    Course Name    Credits    Professor Allotted");
            		courses.forEach((course) ->{
            				String professorAllotted = professorDAOOperation.getProfessorByIdName(course.getProfessorAllotted());
            		if(professorAllotted == null) {
            			professorAllotted = "Not yet alloted";
            		}
            		System.out.println(String.format("%-9d    %-11s    %-7d    %-18s", course.getCourseID(), course.getCourseName(), course.getCredits(), professorAllotted));
            	});
            	System.out.println("=========================================================\n");
        	}
        	catch (Exception e){
        		System.out.println(e.getMessage());
        	}
		
	}

	@Override
	public ArrayList<Grades> viewGrades(int studentId) {
		System.out.println("GRADES LIST");
		// TODO Auto-generated method stub
		ArrayList<Grades> grades = null;
		
		try{
            grades = studentDaoOperation.getGrades(studentId);
            System.out.println("======================GRADES===================\n");
            System.out.println("Course ID    Course Name    Grade");
            grades.forEach(grade -> {
            	System.out.println(String.format("%-9d    %-11s    %-5s", grade.getCourseId(), grade.getCourseName(), grade.getGrade()));
            });
            System.out.println("=================================================\n");
        }
        catch(Exception e){
        	System.out.println(e.getMessage());
        }
		System.out.println("GRADES LIST");
    	return grades;
		
	}

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

	@Override
	public boolean registerCourses(ArrayList<Integer> courseCart, int studentId) {
		System.out.println("REGISTRATION COMPLETE");
//		ArrayList<Course> primary = stdao.getPrimaryRegisteredCourses(studentId);
//		ArrayList<Course> secondary = stdao.getSecondaryRegisteredCourses(studentId);
//		adminI.approveStudent(studentId,primary,secondary);
//		stdao.deleteFromSemiRegistration(studentId);
		return false;
	}

	@Override
	public boolean addPrimaryCourse(int studentId, int courseId) {
		try {
			stdao.addPrimaryCourse(studentId, courseId);
			return true;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean removePrimaryCourse(int studentId, int courseId) {
		try {
			stdao.removePrimaryCourse(studentId, courseId);
			return true;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean addSecondaryCourse(int studentId, int courseId) {
		try {
			stdao.addSecondaryCourse(studentId, courseId);
			return true;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean removeSecondaryCourse(int studentId, int courseId) {
		try {
			stdao.removeSecondaryCourse(studentId, courseId);
			return true;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public Student getStudentById(int id) {
		// TODO Auto-generated method stub
//		StudentDAOInterface stdao = new StudentDAOInterfaceIMPL(); 
		return stdao.getStudentById(id);
	}
	
	@Override
	public void viewPrimaryRegisteredCourses(int studentId) {
		try {
			ArrayList<Course> primaryCourses = stdao.getPrimaryRegisteredCourses(studentId);
			if(primaryCourses.isEmpty()) {
				System.out.println("You have not registered for any primary course");
			}else {
				System.out.println("LIST OF PRIMARY COURSES");
				for(Course course : primaryCourses){
					System.out.println(course.getCourseID() + "   " + course.getCourseName() + "   " + course.getCredits());
				}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void viewSecondaryRegisteredCourses(int studentId) {
		try {
		ArrayList<Course> secondaryCourses = stdao.getSecondaryRegisteredCourses(studentId);
		if(secondaryCourses.isEmpty()) {
			System.out.println("You have not registered for any secondary course");
		}else {
			System.out.println("LIST OF SECONDARY COURSES");
			for(Course course : secondaryCourses){
				System.out.println(course.getCourseID() + "   " + course.getCourseName() + "   " + course.getCredits());
			}
		}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}


}
