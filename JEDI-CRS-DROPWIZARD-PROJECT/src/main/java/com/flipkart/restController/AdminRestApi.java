package com.flipkart.restController;

import java.util.Vector;

import javax.validation.ValidationException;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.util.ValidationEventCollector;

import com.flipkart.DAO.AdminDAOInterface;
import com.flipkart.DAO.AdminDAOInterfaceIMPL;
import com.flipkart.DAO.StudentDAOInterface;
import com.flipkart.DAO.StudentDAOInterfaceIMPL;
import com.flipkart.bean.Admin;
import com.flipkart.bean.Course;
import com.flipkart.bean.Grades;
import com.flipkart.bean.Professor;
import com.flipkart.bean.Student;
import com.flipkart.service.AdminOperation;
import com.flipkart.service.StudentOperation;

@Path("/adminApi")
public class AdminRestApi {
	AdminOperation adminOperation = new AdminOperation();
	AdminDAOInterface adminDAOOperation = new AdminDAOInterfaceIMPL();
    
    @GET
    @Path("/getReportCard")
    @Produces(MediaType.APPLICATION_JSON)
    public Vector<Grades> getReportCard(
    		@NotNull @QueryParam("id") int id
    		) 
    {
    	return adminOperation.generateReportCard(id);
    }
    
    @GET
    @Path("/getStudents")
    @Produces(MediaType.APPLICATION_JSON)
    public Vector<Student> getStudents()
    {
    	Vector<Student> studentList = new Vector<Student>();
    	studentList = adminOperation.viewStudents();
    	return studentList;
    }
    
    @POST
	@Path("/addStudent")
	@Consumes("application/json")
//	@Produces(MediaType.APPLICATION_JSON)
	public Response addStudent(Student student) throws ValidationException
	{
    	StudentDAOInterface studentDao = new StudentDAOInterfaceIMPL();
		if(studentDao.addStudent(student)) {
			return Response.status(201).entity("student "+student.getId()+" added").build();
		}
		return Response.status(400).entity("failed").build();
		
	}
    
    @GET
    @Path("/getProfessor")
    @Produces(MediaType.APPLICATION_JSON)
    public Vector<Professor> getProfessor()
    {
    	Vector<Professor> professorList = new Vector<Professor>();
    	professorList = adminOperation.viewProfessors();
    	return professorList;
    }
    
    @POST
	@Path("/addProfessor")
	@Consumes("application/json")
//	@Produces(MediaType.APPLICATION_JSON)
	public Response addProfessor(Professor professor) throws ValidationException
	{
		if(adminOperation.addProfessor(professor)) {
			return Response.status(201).entity("professor "+professor.getId()+" added").build();
		}
		return Response.status(400).entity("failed").build();
		
	}
    
    @GET
    @Path("/viewCourses")
    @Produces(MediaType.APPLICATION_JSON)
    public Vector<Course> viewCourse() throws ValidationException
    {
    	System.out.println("HSD");
    	Vector<Course> courseList = adminOperation.viewCourses();
    	return courseList;
    	
    }
    
    @POST
    @Path("/addCourse")
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCourse(Course course)  throws ValidationException{
    	if(adminOperation.addCourse(course)) {
    		return Response.status(201).entity("course " +course.getCourseID()+" created").build();
    	}

		return Response.status(400).entity("course could not be created" ).build();
    }
    
    @GET
    @Path("/approveStudent")
    public Response approveStudent(	) {
    	if(adminOperation.approveStudents()) {
    		return Response.status(200).entity("all students approved").build();
    	}

		return Response.status(400).entity("student approval failed").build();
    }
    
    @GET
    @Path("/approveStudentRegistration")
    public Response approveStudentRegistration(
    		@NotNull @QueryParam("id") int id) throws ValidationException
    {
    	if(adminOperation.approveStudentsRequest(id)) {
    		return Response.status(200).entity("student registration approved").build();
    	}
    	return Response.status(400).entity("student approval failed").build();
    }
    
    @GET
    @Path("/viewUnapprovedStudent")
    @Produces(MediaType.APPLICATION_JSON)
    public Vector<Student> viewUnapprovedStuden(){
    	return adminDAOOperation.viewUnapprovedStudent();
    }
    
    @GET
    @Path("/removeStudent")
    public Response removeStudent(
    		@NotNull @QueryParam("id") int id) throws ValidationException
    {
    	if(adminOperation.removeStudent(id)) {
    		return Response.status(200).entity("student removed").build();
    	}
    	return Response.status(400).entity("student removal failed").build();
    }
    
    @GET
    @Path("/removeProfessor")
    public Response removeProfessor(
    		@NotNull @QueryParam("id") int id) throws ValidationException
    {
    	if(adminOperation.removeProfessor(id)) {
    		return Response.status(200).entity("professor removed").build();
    	}
    	return Response.status(400).entity("professor removal failed").build();
    }
    
    @GET
    @Path("/removeCourse")
    public Response removeCourse(
    		@NotNull @QueryParam("id") int id) throws ValidationException
    {
    	if(adminOperation.removeCourse(id)) {
    		return Response.status(200).entity("course removed").build();
    	}
    	return Response.status(400).entity("course removal failed").build();
    }
}