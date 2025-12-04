package com.healthcare.pages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class PatientDashboardServlet
 */
@WebServlet("/admin_dashboard")
public class AdminDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. set resp cont type 
		response.setContentType("text/html");
		//2. get writer
		try(PrintWriter pw=response.getWriter()) {
			pw.print("<h4> Welcome to Admin Dashboard! </h4>");
		}
	}

}
