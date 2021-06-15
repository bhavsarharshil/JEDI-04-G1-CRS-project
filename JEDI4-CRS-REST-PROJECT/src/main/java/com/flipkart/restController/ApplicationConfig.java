package com.flipkart.restController;

import org.glassfish.jersey.server.ResourceConfig;


/**
 * @author 91883
 *
 */
public class ApplicationConfig extends ResourceConfig{
		
	public ApplicationConfig() {

		register(AdminRestApi.class);
		register(UserRestApi.class);
	}
}