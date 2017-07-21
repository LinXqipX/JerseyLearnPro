package edu.stu.client;

import java.lang.annotation.Target;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.ibatis.session.SqlSession;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

import edu.stu.bean.User;
import edu.stu.mybatis.inter.UserOperation;
import edu.stu.tool.SqlUtil;
import edu.stu.tool.XmlUtil;

//客户端调用接口流程：建立客户端、输入目标uri、构造相应符合request要求的response
public class UserClient {
    private static String serverUri = "http://localhost:9009/learnJersey/rest";
    
    public static void main(String[] args) {
//       User user = new User(26, "Leung", "CC,FOSHAN");
//       addUser(user);
//    	getUserById(26);
    	deleteUser(25);
    }  
      
    public static void getUserById(int id) {
    	Client client = ClientBuilder.newClient();
    	WebTarget target = client.target(serverUri+"/User/"+id);
    	Response response = target.request().get();
    	String value = response.readEntity(String.class);
    	
    	if (value.equals(""))
    		System.out.println("No exist");
    	else
    	    System.out.println(value);
    	
    	response.close();
    }
    
    public static void addUser(User user) {
    	Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);  
    	WebTarget target = client.target(serverUri+"/User");
    	Response response = target.request().buildPost(Entity.entity(user, MediaType.APPLICATION_JSON)).invoke();
    	response.close();
    }
    
    public static void deleteUser(int id) {
    	Client client = ClientBuilder.newClient();
    	WebTarget target = client.target(serverUri+"/User/"+id);
    	Response response = target.request().delete();
    	response.close();
    }
}  
    
    
