<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HRM SIGNUP</title>
</head>
<body style="background-color: tomato">
<form action="EmployeeController" method="get" style="text-align: center;">
<input type="hidden" name="action" value="signup">
Employee Id<input type="text" name="empid"><br>
Employee Name<input type="text" name="empname"><br>
Employee Address<input type="text" name="empaddress"><br>
Employee Salary<input type="text" name="empsalary"><br>
Employee Contact Number<input type="text" name="empcontactnumber"><br>
Employee DOB<input type="text" name="empdob"><br>
Employee Email Id<input type="email" name="empemailid"><br>
Employee Password<input type="password" name="emppassword"><br>
<input type="submit" value="SignUp"><br>

</form>
</body>
</html>