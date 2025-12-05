package shubham;

import java.sql.Date;

public class User {
	
	private String name;
	private String email;
	private String passward;
	private Date dob;
	
	public User(String name, String email, String passward, Date dob) {
	
		this.name = name;
		this.email = email;
		this.passward = passward;
		this.dob = dob;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassward() {
		return passward;
	}

	public void setPassward(String passward) {
		this.passward = passward;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", passward=" + passward + ", dob=" + dob + "]";
	}
	
	
	
	
}
