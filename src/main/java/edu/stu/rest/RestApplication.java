package edu.stu.rest;

import org.glassfish.jersey.server.ResourceConfig;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class RestApplication extends ResourceConfig{
    public RestApplication() {
    	packages("edu.stu.service");
    	register(JacksonJsonProvider.class);
    }
}
