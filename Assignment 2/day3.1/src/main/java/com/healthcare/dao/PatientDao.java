package com.healthcare.dao;

import java.sql.SQLException;

import com.healthcare.entities.Patient;

public interface PatientDao extends BaseDao{
	//get patient details from user id
	Patient getPatientDetailsFromUserId(long userId) throws SQLException;

}
