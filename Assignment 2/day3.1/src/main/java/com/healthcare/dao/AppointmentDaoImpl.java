package com.healthcare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.healthcare.dto.AppointmentDTO;
import com.healthcare.entities.Appointment;
import com.healthcare.utils.DBUtils;

public class AppointmentDaoImpl implements AppointmentDao {
	private Connection cn;
	private PreparedStatement pst1,pst2,pst3,pst4,pst5;
	
	//default constructor - will be invoked by Servlet - init
	public AppointmentDaoImpl() throws SQLException{
		//open connection
		cn=DBUtils.getConnection();
		//pst1 - to get list of upcoming appointments
		pst1=cn.prepareStatement("""
				select a.appointment_id,a.appointment_date_time , u.first_name,u.last_name 
from
appointments a join doctors d on a.doctor_id=d.doctor_id
join users u on d.user_id=u.user_id
where a.patient_id=? and a.status='SCHEDULED' and a.appointment_date_time > now() order by a.appointment_date_time asc
				""");
		//pst2 - check  doctor's availability
		pst2=cn.prepareStatement("select appointment_id from appointments where doctor_id =? and appointment_date_time=?");
		//pst3 - to insert new appointment rec.
		pst3=cn.prepareStatement("insert into appointments (appointment_date_time,doctor_id,patient_id,status) values(?,?,?,'SCHEDULED')");
		//validate - get appointment details by id
		pst4=cn.prepareStatement("select appointment_date_time from appointments where appointment_id=?");
		//pst5 - to cancel (soft delete) 	`12
		pst5=cn.prepareStatement("update appointments set status='CANCELLED' where appointment_id=? and status='SCHEDULED'");
		System.out.println("appointment dao created ");
	}

	@Override
	public void cleanUp() throws SQLException {
		if(pst1 != null)
		{
			pst1.close();
			pst1=null;
		}
		if(pst2 != null)
		{
			pst2.close();
			pst2=null;
		}
		if(pst3 != null)
		{
			pst3.close();
			pst3=null;
		}
		if(pst4 != null)
		{
			pst4.close();
			pst4=null;
		}
		if(pst5 != null)
		{
			pst5.close();
			pst5=null;
		}
		if(cn != null)
		{
			cn.close();
			cn=null;
		}

	}

	@Override
	public List<AppointmentDTO> getUpcomingPatientAppointments(long patientId) throws SQLException {
		//1. Set IN param
		pst1.setLong(1, patientId);
		List<AppointmentDTO> list=new ArrayList<>();
		try(ResultSet rst=pst1.executeQuery()) {
			/*
			 * long appointmentId, Timestamp appointmentDateTime, String firstName, String lastName
			 */
			while (rst.next())
			{
				list.add(new AppointmentDTO(rst.getLong(1), rst.getTimestamp(2), rst.getString(3), rst.getString(4)));
			}
		}		
		return list;
	}

	@Override
	public boolean isDoctorAvailable(long doctorId, Timestamp dateTime) throws SQLException {
		//1. set IN params
		pst2.setLong(1, doctorId);
		pst2.setTimestamp(2, dateTime);
		try (ResultSet rst=pst2.executeQuery()) {
			if(rst.next())
				return false;
		}
		return true;
	}

	@Override
	public String bookAppointment(Appointment appointment) throws SQLException {
		// chk doc's availability
		boolean doctorAvailable = isDoctorAvailable(appointment.getDoctorId(), appointment.getAppointmentDateTime());
		if(doctorAvailable)
		{
			//=> insert -> set IN params
			pst3.setTimestamp(1, appointment.getAppointmentDateTime());
			pst3.setLong(2, appointment.getDoctorId());
			pst3.setLong(3, appointment.getPatientId());
			//exec method - exec update
			pst3.executeUpdate();
			return "Appointment Booked!";			
		}
		
		return "Doctor Un available , Pls choose another date time.....";
	}

	@Override
	public String cancelAppointment(long appointmentId) throws SQLException{
		
		pst4.setLong(1, appointmentId);
		
		try(ResultSet rst =  pst4.executeQuery()) {
			
			if(!rst.next())
			{
				 return "Appointment not found.";
			}
			
			Timestamp apptTs = rst.getTimestamp(1);
			
			if (apptTs == null) {
	            return "Invalid appointment record.";
	        }
			
			 java.time.LocalDate apptDate = apptTs.toLocalDateTime().toLocalDate();
		     java.time.LocalDate today = java.time.LocalDate.now();
		     
		     if (apptDate.isEqual(today)) {
		            return "Same Day Appointment can't be cancelled.";
		        }
		     
		     pst5.setLong(1, appointmentId);
		     
		     int rows = pst5.executeUpdate();

		     if (rows == 1) {
		            return "Appointment cancelled successfully.";
		        } else {
		            return "Unable to cancel appointment";
		        }
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "Same Day Appointment can't be cancelled.....";
		
		
	}
}
