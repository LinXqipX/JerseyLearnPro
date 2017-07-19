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
//        getAllUsers();  
//        updateUser();  
//        getUserById();  
//        getAllUsers();  
//        delUser();  
//        getAllUsers();  
  
    }  
    
    /** 
     * 添加用户 
     */  
     private static void addUser() {  
         System.out.println("****增加用户addUser****");  
         User user = new User(6,"Susan","21");    
         Client client = ClientBuilder.newClient();  
         WebTarget target = client.target(serverUri + "/User");  
         Response response = target.request().buildPost(Entity.entity(user, MediaType.APPLICATION_XML)).invoke();  
         response.close();  
    }  
       
    /** 
     * 删除用户 
     */  
     private static void delUser() {  
         System.out.println("****删除用户****");  
         Client client = ClientBuilder.newClient();  
         WebTarget target = client.target(serverUri + "/users/006");  
         Response response = target.request().delete();  
         response.close();  
    }  
       
       
    /** 
     * 修改用户 
     */  
     private static void updateUser() {  
         System.out.println("****修改用户updateUser****");  
         User user = new User(6,"Susan","33");    
         Client client = ClientBuilder.newClient();  
         WebTarget target = client.target(serverUri + "/users");  
         Response response = target.request().buildPut( Entity.entity(user, MediaType.APPLICATION_XML)).invoke();  
         response.close();  
    }  
    /** 
     * 根据id查询用户 
     */  
     private static void getUserById() {  
         System.out.println("****根据id查询用户****");  
         Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);// 注册json 支持  
         WebTarget target = client.target(serverUri + "/users/006");  
         Response response = target.request().get();  
         User user = response.readEntity(User.class);  
         System.out.println(user.getId() + user.getUserName()  +  user.getId());  
         response.close();  
    }  
    /** 
     * 查询所有用户 
     */  
     private static void getAllUsers() {  
         System.out.println("****查询所有getAllUsers****");  
           
         Client client = ClientBuilder.newClient();  
  
         WebTarget target = client.target(serverUri + "/users");  
         Response response = target.request().get();  
 		 String value = response.readEntity(String.class);  
    	 System.out.println(value);  
		 response.close();  //关闭连接  
     }  
       
}  
    
    
