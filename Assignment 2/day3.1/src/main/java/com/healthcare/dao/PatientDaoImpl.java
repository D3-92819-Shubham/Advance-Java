package com.healthcare.dao;

import java.sql.*;

import com.healthcare.entities.Patient;
import static com.healthcare.utils.DBUtils.getConnection;

public class PatientDaoImpl implements PatientDao {
	private Connection connection;
	private PreparedStatement pst1;
	// default constructor
	public PatientDaoImpl() throws SQLException{
		//1. get conn
		connection=getConnection();
		//2. create PSTs
		pst1=connection.prepareStatement("""				
				select * from patients where user_id=?				
				""");
		System.out.println("patient dao created ....");
	}

	@Override
	public void cleanUp() throws SQLException {
		if(pst1 != null)
		{
			pst1.close();
			pst1=null;
		}
		if(connection != null)
		{
			connection.close();
			connection=null;
		}
		System.out.println("patient dao cleaned up....");
			

	}

	@Override
	public Patient getPatientDetailsFromUserId(long userId) throws SQLException {
		// 1. set IN params
		pst1.setLong(1, userId);
		try(ResultSet rst=pst1.executeQuery()) {
			/*
			 * long patientId, String bloodGroup, String familyHistory, String gender, long userId
			 */
			if(rst.next())
				return new Patient(rst.getLong(1), rst.getString(2), rst.getString(3), rst.getString(4), userId);
		}
		return null;
	}

}
