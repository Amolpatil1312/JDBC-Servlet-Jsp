<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HRM SIGNIN</title>
</head>
<body style="background-color: aqua;">

<%
if(null!= request.getAttribute("message")){
	out.println(request.getAttribute("message"));
}
%>
<form action="EmployeeController" method="get">
<input type="hidden" name="action" value="signin">

Employee Email<input type="email" name="empemailid"><br>
Employee Password<input type="password" name="emppassword"><br>

<input type="submit" value="SignIn"><br>
</form>

</body>
</html>