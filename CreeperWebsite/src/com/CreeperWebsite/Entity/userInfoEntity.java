package com.CreeperWebsite.Entity;
import java.sql.Date;

public class userInfoEntity {
	private int id;	
	private int userId;
	private String userPwd;
	private String userName;
	private int userType;
	private int userSex;
	private Date userBirth;
	private String telNumber;
	
	public userInfoEntity() {
		// TODO Auto-generated constructor stub
	}

	public int getid() {		
		return id;	
	}
	
	public void setid(int id) 
	{		
		this.id = id;	
	}
	
	public int getuserId() {		
		return userId;	
	}
	
	public void setuserId(int userId) 
	{		
		this.userId = userId;	
	}
	
	public String getuserPwd() {		
		return userPwd;	
	}
	
	public void setuserPwd(String userPwd) 
	{		
		this.userPwd = userPwd;	
	}
	
	public String getuserName() {		
		return userName;	
	}
	
	public void setuserName(String userName) 
	{		
		this.userName = userName;	
	}
	
	public int getuserType() {		
		return userType;	
	}
	
	public void setuserType(int userType) 
	{		
		this.userType = userType;	
	}
	
	public int getuserSex() {		
		return userSex;	
	}
	
	public void setuserSex(int userSex) 
	{		
		this.userSex = userSex;	
	}
	
	public Date getuserBirth() {		
		return userBirth;	
	}
	
	public void setuserBirth(Date userBirth) 
	{		
		this.userBirth = userBirth;	
	}
	public String gettelNumber() {		
		return telNumber;	
	}
	
	public void settelNumber(String telNumber) 
	{		
		this.telNumber = telNumber;	
	}
}
