package edu.stu.bean;

import javax.xml.bind.annotation.*;

@XmlRootElement
public class User {
  private int id;
  private String userName;
  private String userAddress;
  
  public User() {
	  
  }
  
  public User(int id, String userName, String userAddress) {
	this.id = id;
	this.userName = userName;
	this.userAddress = userAddress;
  }
  
  @XmlTransient
  public int getId(){
	  return id;
  }
  
  public void setId(int id) {
	  this.id = id;
  }
  
  @XmlTransient
  public String getUserName(){
	  return userName;
  }
  
  public void setUserName(String userName) {
	  this.userName = userName;
  }
  
  @XmlTransient
  public String getUserAddress() {
	  return userAddress;
  }
  
  public void setUserAddress(String userAddress) {
	  this.userAddress = userAddress;
  }
}
