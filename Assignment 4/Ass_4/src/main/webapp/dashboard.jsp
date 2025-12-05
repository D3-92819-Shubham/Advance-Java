<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>welcome to dashboard</h1>

<h1> Name:-${sessionScope.user_details.name} </h1>
<h1> password:-${sessionScope.user_details.passward} </h1>
<h1> dob:-${sessionScope.user_details.dob} </h1>



<h1><%session.invalidate();%><a href="login.jsp">logout</a></h1>







</body>
</html>