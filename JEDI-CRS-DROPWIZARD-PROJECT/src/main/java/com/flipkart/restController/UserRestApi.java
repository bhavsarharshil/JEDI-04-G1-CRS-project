package com.flipkart.restController;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.flipkart.DAO.UserDAOInterface;
import com.flipkart.bean.User;
import com.flipkart.service.VerificationSystemOperation;

@Path("/userApi")
public class UserRestApi {
	public static Logger logger=Logger.getLogger(UserRestApi.class);
	@Path("/login")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response login(User user) {
		logger.error(user.getId()+ user.getPassword());
		VerificationSystemOperation vi = new VerificationSystemOperation();
		String role = vi.loginWithCredential(user.getId(), user.getPassword());
		if(role.equals("student") || role.equals("professor") || role.equals("admin")) {
			return Response.status(200).entity(role +" "+  user.getId() + " logged in").build();
		}
		return Response.status(400).entity("invalid credentials").build();
		
	}
}
