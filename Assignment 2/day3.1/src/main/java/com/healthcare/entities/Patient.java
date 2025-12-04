package com.healthcare.entities;

//patient_id | blood_group | family_history                | gender | user_id
public class Patient {
	private long patientId;// PK
	private String bloodGroup;
	private String familyHistory;
	private String gender;
	private long userId;// FK
	public Patient() {
		// TODO Auto-generated constructor stub
	}
	//add all arguments constructor
	
	public Patient(long patientId, String bloodGroup, String familyHistory, String gender, long userId) {
		super();
		this.patientId = patientId;
		this.bloodGroup = bloodGroup;
		this.familyHistory = familyHistory;
		this.gender = gender;
		this.userId = userId;
	}
	public long getPatientId() {
		return patientId;
	}
	


	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public String getFamilyHistory() {
		return familyHistory;
	}
	public void setFamilyHistory(String familyHistory) {
		this.familyHistory = familyHistory;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", bloodGroup=" + bloodGroup + ", familyHistory=" + familyHistory
				+ ", gender=" + gender + ", userId=" + userId + "]";
	}
	
}
