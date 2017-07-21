package edu.stu.client;

import java.lang.annotation.Target;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import edu.stu.bean.User;

//客户端调用接口流程：建立客户端、输入目标uri、构造相应符合request要求的response
public class UserClient {
    private static String serverUri = "http://localhost:9009/learnJersey/rest";
    
    public static void main(String[] args) {
       addUser();
       getUserByUsername("LIN");
    }  
    
    public static void addUser() {
      System.out.println("********增加用户********");
      User user = new User(6, "LIN", "SHANTOU");
      Client client = ClientBuilder.newClient();
      WebTarget target = client.target(serverUri+"/User");
      Response response = target.request().buildPost(Entity.entity(user, MediaType.APPLICATION_XML)).invoke();
      response.close();
    }
    
    public static void getAllUsers() {
    	System.out.println("********搜索用户********");
    	 Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
    	WebTarget target = client.target(serverUri+"/User");
    	Response response = target.request().get();
    	System.out.println(response.readEntity(String.class));
    	response.close();
    }
    
    public static void getUserByUsername(String username) {
    	System.out.println("********查询某个用户********");
    	Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
    	WebTarget target = client.target(serverUri+"/User/"+username);
    	Response response = target.request().get();
    	String value = response.readEntity(String.class);
    	
    	if (value.equals(""))
    		System.out.println("No exist");
    	else
    	    System.out.println(value);
    	
    	response.close();
    }
}  
    
    
