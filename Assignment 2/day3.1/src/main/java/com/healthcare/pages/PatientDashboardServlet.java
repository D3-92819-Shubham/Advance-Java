package com.healthcare.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.healthcare.dao.AppointmentDao;
import com.healthcare.dao.AppointmentDaoImpl;
import com.healthcare.dao.PatientDao;
import com.healthcare.dao.PatientDaoImpl;
import com.healthcare.dto.AppointmentDTO;
import com.healthcare.entities.Patient;
import com.healthcare.entities.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class PatientDashboardServlet
 */
@WebServlet(urlPatterns = "/patient_dashboard",loadOnStartup = 2)
public class PatientDashboardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatientDao patientDao;
	private AppointmentDao appointmentDao;

	@Override
	public void destroy() {
		try {
			patientDao.cleanUp();
			appointmentDao.cleanUp();
		} catch (Exception e) {
			System.out.println("err " + e);
		}
	}

	@Override
	public void init() throws ServletException {
		try {
			// create daos (dependencies)
			patientDao = new PatientDaoImpl();
			appointmentDao = new AppointmentDaoImpl();
		} catch (Exception e) {
			// to inform WC about init 's failure
			throw new ServletException("err in init of " + getClass(), e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. set resp cont type
		response.setContentType("text/html");
		// 2. get writer
		try (PrintWriter pw = response.getWriter()) {
			pw.print("<h4> Welcome to Patient Dashboard! </h4>");
			
			
			//pw.print("<h5>"+request.getParameter("message")+"</h5>");
				
			// 3. Get HttpSession from WC
			HttpSession hs = request.getSession();
			System.out.println("From auth servlet - session is new " + hs.isNew());// f
			System.out.println("session id " + hs.getId());// same session id
			User userDetails = (User) hs.getAttribute("user_details");
			if (userDetails != null) {
				pw.print("<h5> Hello , " + userDetails.getFirstName() + "  " + userDetails.getLastName() + " </h5>");
				//4. get & render patient details
				Patient patient=patientDao.getPatientDetailsFromUserId(userDetails.getUserId());
				//5. save patient details under Session
				hs.setAttribute("patient_details", patient);
				pw.print("<h5> Gender "+patient.getGender()+" Blood Group "+patient.getBloodGroup()+" </h5>");
				//6. get list of apppointments & render
				List<AppointmentDTO> appointments = appointmentDao.getUpcomingPatientAppointments(patient.getPatientId());
				for(AppointmentDTO dto : appointments)
				{
					pw.print("<h6> ID "+dto.getAppointmentId()+" TS "+dto.getAppointmentDateTime()+" Doc Name "+dto.getFirstName()+" "+dto.getLastName()+"<a href='appointments?app_id=" +dto.getAppointmentId()+ " '>  Cancel</a></h6>");
				}
				//7. render a link - to book appointment
				
			
				pw.print("<h5> <a href='book_appointment.html'>Book Appointment</a></h5>");
				//7. render a link - to logout
				pw.print("<h5> <a href='logout'>Log Out</a></h5>");
		
				
			} else {
				// in case of no cookies - redirect the client to index page
				response.sendRedirect("index.html");
			}

		} catch (Exception e) {
			throw new ServletException("err in servicing "+getClass(), e);
		}
	}

}
