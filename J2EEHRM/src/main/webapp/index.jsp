<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>J2EEHRM FULLSTACK</title>
</head>
<body style="background-color: pink;">

<form action="EmployeeController" method="post">

<label>Employee ID</label>
<input type="text" name="empid"><br>
<label>Employee Name</label>
<input type="text" name="empname"><br>
<label>Employee Address</label>
<input type="text" name="empaddress"><br>
<label>Employee Salary</label>
<input type="text" name="empsalary"><br>
<label>Employee Contact Number</label>
<input type="text" name="empcontactnumber"><br>
<label>Employee Email</label>
<input type="text" name="empemailid"><br>
<label>Employee Password</label>
<input type="password" name="emppassword"><br>

<input type="submit" value="SignUp">
</form>

</body>
</html>