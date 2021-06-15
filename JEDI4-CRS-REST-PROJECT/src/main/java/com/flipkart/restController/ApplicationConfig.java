
package com.flipkart.restController;

/**
 * @author Nishita
 *
 */

import org.glassfish.jersey.server.ResourceConfig;


public class ApplicationConfig extends ResourceConfig {
	public ApplicationConfig() {
		register(StudentRESTAPI.class);
		register(AdminRESTAPI.class);
		register(ProfessorRESTAPI.class);
	}
}
