package edu.stu.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/Hello")
public class HelloResource {
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String responseHello() {
	  return "Hello world\n";
  }
}
