package com.healthcare.entities;

//doctor_id | experience_in_years | fees | qualifications              | speciality         | user_id
public class Doctor {
	private long doctorId;
	private int experienceInYears;
	private int fees;
	private String qualifications;
	private long userId;
	public Doctor() {
		// TODO Auto-generated constructor stub
	}
	public long getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}
	public int getExperienceInYears() {
		return experienceInYears;
	}
	public void setExperienceInYears(int experienceInYears) {
		this.experienceInYears = experienceInYears;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}
	public String getQualifications() {
		return qualifications;
	}
	public void setQualifications(String qualifications) {
		this.qualifications = qualifications;
	}
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", experienceInYears=" + experienceInYears + ", fees=" + fees
				+ ", qualifications=" + qualifications + ", userId=" + userId + "]";
	}
	
	
}
