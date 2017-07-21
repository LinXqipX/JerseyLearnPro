package edu.stu.service;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
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
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import edu.stu.bean.User;
import edu.stu.mybatis.inter.UserOperation;
import edu.stu.tool.SqlUtil;
import edu.stu.tool.XmlUtil;

@Path("/User")
public class UserResource {
  private static Map<String, User> userMap = new HashMap<String, User>();
  
  //添加用户
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  public void addUser(User user) {
	  SqlSession session = SqlUtil.createSqlSession();
	  try {
		  UserOperation userOperation = session.getMapper(UserOperation.class);
		  userOperation.addOneUser(user);
		  session.commit();
	  } finally {
		  session.close();
	  }
  }
  
  //删除用户
  @DELETE
  @Path("{id}")
  public void deleteUser(@PathParam("id") int id) {
	  SqlSession session = SqlUtil.createSqlSession();
	  try {
		  UserOperation userOperation = session.getMapper(UserOperation.class);
		  userOperation.deleteOneUserById(id);
		  session.commit();
	  } finally {
		  session.close();
	  }
  }
  
  //修改用户
  @PUT
  @Consumes(MediaType.APPLICATION_XML)
  public void updateUser(User user) {
	  userMap.put(user.getUserName(), user);
  }
  
  //查询
  @GET
  @Path("/username/{userName}")
  @Produces(MediaType.APPLICATION_JSON)
  public User searchUserByName(@PathParam("userName") String userName) {
	  User target = userMap.get(userName);
	  
	  return target;
  }
  
  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public User searchUserById(@PathParam("id") int id) {
	  SqlSession session = SqlUtil.createSqlSession();
	  User user;
	  
	  try{
		  UserOperation userOperation = session.getMapper(UserOperation.class);
		  user = userOperation.seletctUserById(id);
	  } finally{
		  session.close();
	  }
	  
	  System.out.println(id);
	  return user;
  }
  
  //查询所有
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<User> searchAllUsers() {
	  List<User> temp = new ArrayList<User>();
	  
	  temp.addAll(userMap.values());
	  return temp;
  }
}
