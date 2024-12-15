package com.Library.restapi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="user")
public class User{
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
      private int userid;
	 @Column(name="User Name")
      private String Uname;
	 @Column(name="User_PhoneNumber")
	 private String Upno;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUname() {
		return Uname;
	}
	public void setUname(String uname) {
		Uname = uname;
	}
	public String getUpno() {
		return Upno;
	}
	public void setUpno(String upno) {
		Upno = upno;
	}
	@Override
	public String toString() {
		return "user [userid=" + userid + ", Uname=" + Uname + ", Upno=" + Upno + "]";
	}
	public User() {
		
	}
	public User(String uname, String upno) {
		super();
		
		Uname = uname;
		Upno = upno;
	}
	 
}
