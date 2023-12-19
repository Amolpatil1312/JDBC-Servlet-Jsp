<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HRM SIGNUP</title>
</head>
<body style="background-color: purple;">
<form action="EmployeeController" method="get">

<input type="hidden" name="action" value="signup">

Employee ID<input type="text" name="empid"><br>
Employee Name<input type="text" name="empname"><br>
Employee Address<input type="text" name="empaddress"><br>
Employee Salary<input type="text" name="empsalary"><br>
Employee Contact Number<input type="text" name="empcontactnumber"><br>
Employee DOB<input type="date" name="empdob"><br>
Employee Gender<br>
Male<input type="radio" name="empgender" value="Male">
Female<input type="radio" name="empgender" value="Female"><br>
Employee Email Id<input type="text" name="empemailid"><br>
Employee Password<input type="password" name="emppassword"><br>
<input type="submit" value="SignUp">


</form>
</body>
</html>