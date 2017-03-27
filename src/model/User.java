package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class User {

	private int id;                     //用户注册id
	private  String userName;   //用户名
	private  String userPwd;   //用户密码
	private int i;                  
	private String str;      
	private String date;         //  用户注册日期
 

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", userPwd=" + userPwd + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public  User(String userName, String userPwd,String date){
		this.userName = userName;
		this.userPwd = userPwd;
		this.date = date;
	}
	
	public User() {

          super();
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public User(int i, String str) {
	
		this.i = i;
		this.str = str;
	}

	public User(String string) {
		// TODO Auto-generated constructor stub
		this.str = string;
	}

	public User(String userName, String userPwd) {
		// TODO Auto-generated constructor stub
		this.userName = userName;
		this.userPwd = userPwd;
	}



}
