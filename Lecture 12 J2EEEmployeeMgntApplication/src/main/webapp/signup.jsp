<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HRM SIGNUP</title>
</head>
<body style="background-color: orange;">


<form action="EmployeeController" method="get">

<input type="hidden" name="action" value="signup">

Employee Id<input type="number" name="empid"><br>
Employee Name<input type="text" name="empname"><br>
Employee Address<input type="text" name="empaddress"><br>
Employee State<br>

<select name="empstate">
<option value="MH">MH</option>
<option value="PB">PB</option>
<option value="KA">KA</option>
<option value="HY">HY</option>
<option value="NCR">NCR</option>
</select>
Employee Salary<input type="text" name="empsalary"><br>
Employee Contact Number<input type="number" name="empcontactnumber"><br>

Employee Gender<br>
Male<input type="radio" name="empgender" value="Male">
Female<input type="radio" name="empgender" value="Female"><br>
Employee DOB<input type="date" name="empdob"><br>
Employee Dept<br>
HR<input type="checkbox" name="empdept" value="HR">
R&D<input type="checkbox" name="empdept" value="R&D">
FIN<input type="checkbox" name="empdept" value="FIN">
QA<input type="checkbox" name="empdept" value="QA">
<br>
Employee UID<input type="number" name="empuid"><br>

Employee Pan Card<input type="text" name="emppancard"><br>
Employee Email<input type="email" name="empemailid"><br>
Employee Password<input type="password" name="emppassword"><br>

<input type="submit" value="SignUp"><br>
</form>

</body>
</html>