<%@page import="shubham.User"%>

<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<%! 
		java.util.HashMap<String, User> users = new java.util.HashMap<>();

	public void jspInit()
	{
		users.put(
	            "shubham@gmail.com",
	            new User(
	                "Shubham",
	                "shubham@gmail.com",
	                "12345",
	                java.sql.Date.valueOf("2002-05-10")
	            )
	        );
		
		 users.put(
		            "user@mail.com",
		            new User(
		                "Rahul",
		                "user@mail.com",
		                "11111",
		                java.sql.Date.valueOf("2001-01-15")
		            )
		        );
	
	}

%>
<body>

<%
	String email = request.getParameter("em");

	String pass = request.getParameter("pass");
	
	User u = users.get(email);
	
	
	
	if(u!=null && u.getPassward().equals(pass))
	{
		session.setAttribute("user_details", u);
		response.sendRedirect("dashboard.jsp");
	}
	
	else
	{
		
		
		response.sendRedirect("invalid_login.jsp");
	}
%>

</body>
</html>