/**
 * 
 */
package com.flipkart.restController;

import java.util.ArrayList;

import javax.validation.ValidationException;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.Course;
import com.flipkart.bean.Grades;
import com.flipkart.bean.Payment;
import com.flipkart.bean.Student;
import com.flipkart.service.StudentInterface;
import com.flipkart.service.StudentOperation;

/**
 * @author hp
 *
 */
@Path("/studentApi")
public class StudentRESTAPI {
	
	StudentInterface stdao = new StudentOperation();
	
	/**
     * Method to get the details of a student.
     *
     * @param id of the student whose details are to be fetched 
     * @return Response success when request serviced else bad request or something went wrong.
     * @throws ValidationException  
     */
	
	@GET
	@Path("/details/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Student getStudentDetails(@PathParam("id") int id)  {
		Student student = stdao.getStudentById(id);
		return student;
	}
	
	
	/**
     * Method to get all the courses in course catalog.
     *
     * @return Response success when request serviced else bad request or something went wrong.
     */
	@GET
	@Path("/showCourses")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Course> showCourses() { 
		ArrayList<Course> allCourses = stdao.showCourses();
		return allCourses;
	}
	
	//view grades
	
	@GET
	@Path("/viewGrades/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response viewGrades(@PathParam("id") int id){
		System.out.println("id = " + id);
		ArrayList<Grades> grades = stdao.viewGrades(id);
		if(grades == null) {
			String res = "No Grades to show";
			return Response.status(500).entity(res).build();
		}else {
			return Response.status(200).entity(grades).build();
		}
	}
	
	//view primary courses
	@GET
	@Path("/viewPrimaryCourses/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Course> viewPrimaryCourses(@PathParam("id") int id){
		ArrayList<Course> courses = stdao.viewPrimaryRegisteredCourses(id);
		return courses;
	}
	
	//view secondary courses
	@GET
	@Path("/viewSecondaryCourses/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Course> viewSecondaryCourses(@PathParam("id") int id){
		ArrayList<Course> courses = stdao.viewSecondaryRegisteredCourses(id);
		return courses;
	}
	
	//view payment
	@GET
	@Path("/viewPayment/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Payment viewPayment(@PathParam("id") int sid){
		Payment payment = stdao.viewPayments(sid);
		return payment;
	}
	
	
	//make payment
	
	@POST
	@Path("/makePayment/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response makePayment(@PathParam("id") int sid,String method) {
		int amountDue = stdao.makePayment(sid, method);
		String res;
		if(amountDue == 0) {
			res = "Payment Already Done!";
			return Response.status(200).entity(res).build();
		}else if(amountDue < 0) {
			res = "No Payments to show";
			return Response.status(500).entity(res).build();
		}else {
			res = "Payment Successfull";
			return Response.status(200).entity(res).build();
		}
	}
	
	//view payment Amount
	@POST
	@Path("/viewPaymentAmount/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response viewPaymentAmount(@PathParam("id") int sid,String method) {
		int amountDue = stdao.makePayment(sid, method);
		String res;
		if(amountDue == 0) {
			res = "Payment Already Done!";
			return Response.status(200).entity(res).build();
		}else if(amountDue < 0) {
			res = "No Payments to show";
			return Response.status(500).entity(res).build();
		}else {
			res = "Amount Due : " + String.valueOf(amountDue);
			return Response.status(200).entity(res).build();
		}
	}
	//add primary courses
	
	@POST
	@Path("/addPrimaryCourse/{id}")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addPrimaryCourses(@PathParam("id") int studentId ,int courseID) {
		String result;
		if(stdao.addPrimaryCourse(studentId, courseID))
			result = "Course Added Successfully";
		else
			result = "Course couldn't be added";
		return Response.status(201).entity(result).build();
	}
	
	//add secondary courses
	
	@POST
	@Path("/addSecondaryCourse/{id}")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addSecondaryCourses(@PathParam("id") int studentId ,int courseID) {
		String result;
		if(stdao.addSecondaryCourse(studentId, courseID))
			result = "Course Added Successfully";
		else
			result = "Course couldn't be added";
		return Response.status(201).entity(result).build();
	}
	
	//remove primary courses
	
	@POST
	@Path("/removePrimaryCourse/{id}")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removePrimaryCourses(int courseID,@PathParam("id") int studentId ) {
		String result;
		if(stdao.removePrimaryCourse(studentId, courseID)) {
			result = "Course Removed Successfully";
			return Response.status(201).entity(result).build();
		}
		else {
			result = "Course couldn't be removed";
			return Response.status(500).entity(result).build();
		}
	}
	
	
	//remove secondary courses
	
	@POST
	@Path("/removeSecondaryCourse/{id}")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeSecondaryCourses(int courseID,@PathParam("id") int studentId ) {
		String result;
		if(stdao.removeSecondaryCourse(studentId, courseID)) {
			result = "Course Removed Successfully";
			return Response.status(201).entity(result).build();
		}
		else {
			result = "Course couldn't be removed";
			return Response.status(500).entity(result).build();
		}
	}
		
}
