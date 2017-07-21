package edu.stu.client;

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
    private static String serverUri = "http://localhost:8080/learJersey/rest";
    
    public static void main(String[] args) {
       addUser();
       getAllUsers();
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
    	Client client = ClientBuilder.newClient();
    	WebTarget target = client.target(serverUri+"/User/getUserJson");
    	Response response = target.request().get();
//    	String value = response.readEntity(String.class);
//    	System.out.println(value);
    	response.close();
    }
       
}  
    
    
