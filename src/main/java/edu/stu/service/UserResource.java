package edu.stu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.stu.bean.User;

@Path("/User")
public class UserResource {
  private static Map<String, User> userMap = new HashMap<String, User>();
  
  @GET  
  @Path("/getUserXml")  
  @Produces(MediaType.APPLICATION_XML)  
  public User getUserXml() {  
   User user  = new User();  
   user.setId(4);  
   user.setUserName("Amand");  
   return user;  
  }
  
  @GET
  @Path("/getUserJson")
  @Produces(MediaType.APPLICATION_JSON)
  public User getUserJson() {
	  User user = new User();
	  user.setId(5);
	  user.setUserName("JsonAmand");
	  return user;
  }
  
  //添加用户
  @POST
  @Consumes(MediaType.APPLICATION_XML)
  public void addUser(User user) {
	  userMap.put(user.getUserName(), user);
  }
  
  //删除用户
  @DELETE
  @Path("{userName}")
  public void deleteUser(@PathParam("userName") String userName) {
	  userMap.remove(userName);
  }
  
  //修改用户
  @PUT
  @Consumes(MediaType.APPLICATION_XML)
  public void updateUser(User user) {
	  userMap.put(user.getUserName(), user);
  }
  
  //查询
  @GET
  @Path("{userName}")
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public User searchUserByName(@PathParam("userName") String userName) {
	  User target = userMap.get(userName);
	  
	  return target;
  }
  
  //查询所有
  @GET
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public List<User> searchAllUsers() {
	  List<User> temp = new ArrayList<User>();
	  
	  temp.addAll(userMap.values());
	  return temp;
  }
}
