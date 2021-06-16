package com.dropwizard;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flipkart.restController.AdminRestApi;
import com.flipkart.restController.ProfessorRestApi;
import com.flipkart.restController.StudentRESTAPI;
import com.flipkart.restController.UserRestApi;


public class App extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
 
    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }
 
    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");
      //  e.jersey().register(new EmployeeRESTController(e.getValidator()));
        e.jersey().register(new AdminRestApi());
        e.jersey().register(new ProfessorRestApi());
        e.jersey().register(new StudentRESTAPI());
        e.jersey().register(new UserRestApi());
    }
 
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}
