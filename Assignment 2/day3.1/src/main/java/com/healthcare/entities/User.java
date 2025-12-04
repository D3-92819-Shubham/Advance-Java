package com.healthcare.entities;

import java.sql.*;

/*
 * user_id | first_name | last_name | dob        | email                        | password   | phone      | reg_amount | role
 */
public class User {
	private long userId;
	private String firstName;
	private String lastName;
	private Date dob;
	private String email;
	private String password;
	private String phone;
	private int regAmount;
	private String userRole;
	//add parameterized ctor
	
	
	
	
	
	public User(long userId, String firstName, String lastName, Date dob, String email, String password, String phone,
			int regAmount, String userRole) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.regAmount = regAmount;
		this.userRole = userRole;
	}
	//getters & setters
		public long getUserId() {
			return userId;
		}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(int regAmount) {
		this.regAmount = regAmount;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	  @Override public String toString() { return "User [userId=" + userId +
	  ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob +
	  ", email=" + email + ", phone=" + phone + ", regAmount=" + regAmount +
	  ", userRole=" + userRole + "]"; }
	 
//	@Override
//	public String toString() {
//		return this.firstName+this.lastName;
//	}
	

}
