package com.healthcare.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.healthcare.dto.AppointmentDTO;
import com.healthcare.entities.Appointment;

public interface AppointmentDao extends BaseDao{
//add a method to get list of patient's upcoming appointments
	List<AppointmentDTO> getUpcomingPatientAppointments(long patientId) throws SQLException;
	//add a method to check doc's availability
	boolean isDoctorAvailable(long doctorId,Timestamp dateTime) throws SQLException;
	//add a method to insert new appointment record
	String bookAppointment(Appointment appointment) throws SQLException;
	String cancelAppointment(long appointmentId) throws SQLException;
}
