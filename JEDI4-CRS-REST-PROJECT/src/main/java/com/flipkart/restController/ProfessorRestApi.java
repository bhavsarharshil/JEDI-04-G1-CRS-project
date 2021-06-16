package com.flipkart.restController;

import java.util.ArrayList;

import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.flipkart.bean.Grades;
import com.flipkart.bean.Professor;
import com.flipkart.service.ProfessorInterface;
import com.flipkart.service.ProfessorInterfaceImpl;

@Path("/professorApi")
public class ProfessorRestApi {
	@POST
	@Path("/gradeStudents")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response gradeStudents(
			@NotNull @QueryParam("professorid") int professorid,
			@NotNull @QueryParam("courseid") int courseid,
			@NotNull @QueryParam("studentid") int studentid,
			@NotNull @QueryParam("courseid") String grade
			) {

		//  client --- service ---- dao ----> SQL
		ProfessorInterfaceImpl professorInterface = new ProfessorInterfaceImpl();
		String result;
		boolean status = professorInterface.gradeStudents(professorid,studentid,courseid,grade);
		if(status == true)
		{
			result = "Students Graded Successfully!!";
		}
		else
		{
			result = "Students not graded!!";
		}
		return Response.status(201).entity(result).build();
	}
	
	
	@GET
	@Path("/viewGrades")
	@Produces(MediaType.APPLICATION_JSON)
	public Grades viewGrades(
			@NotNull @QueryParam("professorid") int professorid,
			@NotNull @QueryParam("studentid") int studentid,
			@NotNull @QueryParam("courseid") int courseid) {

		//  client --- service ---- dao ----> SQL
		ProfessorInterfaceImpl professorInterface = new ProfessorInterfaceImpl();
		
		return professorInterface.viewGrades(professorid,studentid,courseid);

	}
	
	@GET
	@Path("/showAssignedCourses")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Integer> showAssignedCourses(@NotNull @QueryParam("professorid") int professorid)
	{
		ProfessorInterfaceImpl professorInterface = new ProfessorInterfaceImpl();
		
		return professorInterface.showAssignedCourses(professorid);
	}
	
	@GET
	@Path("/viewEnrolledStudentsInCourse")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Integer> viewEnrolledStudentsInCourse(@NotNull @QueryParam("professorid") int professorid,
			@NotNull @QueryParam("courseid") int courseID){
		ProfessorInterfaceImpl professorInterface = new ProfessorInterfaceImpl();
		
		return professorInterface.viewEnrolledStudentsInCourse(professorid, courseID);
	}
	
	
	@GET
	@Path("/getProfessorById")
	@Produces(MediaType.APPLICATION_JSON)
	public Professor getProfessorById(@NotNull @QueryParam("professorid") int professorid)
	{
		ProfessorInterfaceImpl professorInterface = new ProfessorInterfaceImpl();
		
		return professorInterface.getProfessorById(professorid);
		
	}
	@POST
	@Path("/addAssignedCourse")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addAssignedCourse(@NotNull @QueryParam("professorid") int professorID,
			@NotNull @QueryParam("courseid") int courseID)
	{
		ProfessorInterfaceImpl professorInterface = new ProfessorInterfaceImpl();
		boolean status = professorInterface.addAssignedCourse(professorID,courseID);
		
		String result;
		if(status == true)
		{
			result = "Course Assigned Successfully!!";
		}
		else
		{
			result = "Course not assigned!!";
		}
		return Response.status(201).entity(result).build();
	}	
	@POST
	@Path("/removeAssignedCourse")
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response removeAssignedCourse(@NotNull @QueryParam("professorid") int professorID,
			@NotNull @QueryParam("courseid") int courseID)
	{
		ProfessorInterfaceImpl professorInterface = new ProfessorInterfaceImpl();
		boolean status = professorInterface.removeAssignedCourse(professorID,courseID);
		
		String result;
		if(status == true)
		{
			result = "Course Removed Successfully!!";
		}
		else
		{
			result = "Course not removed!!";
		}
		return Response.status(201).entity(result).build();
	}
	
	
}