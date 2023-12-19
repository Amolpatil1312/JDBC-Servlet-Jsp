<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HRM SIGNUP</title>
</head>
<body style="background-color: lime;">
<form action="EmployeeController" method="get">

<input type="hidden" name="action" value="signup">
Employee Id<input type="number" name="empid"><br>
Employee Name<input type="text" name="empname"><br>
Employee Address<input type="text" name="empaddress"><br>
Employee State
<select name="empstate">
<option value="MH">Maharashtra</option>
<option value="KA">Karnataka</option>
<option value="GJ">Gujrat</option>
<option value="GA">GOA</option>
<option value="PB">PUNJAB</option>
<option value="AS">ASSAM</option>
<option value="KL">KERALA</option>
<option value="MP">MADHYA PRADESH</option>
</select>
Employee Salary<input type="number" name="empsalary"><br>
Employee Contact Number<input type="number" name="empcontactnumber"><br>

Employee Gender<br>
Male<input type="radio" name="empgender" value="Male">
Female<input type="radio" name="empgender" value="Female"><br>
Employee Dept<br>
HR<input type="checkbox" name="empdept" value="HR">
F3INANCE<input type="checkbox" name="empdept" value="FINANCE">
R&D<input type="checkbox" name="empdept" value="R&D">
Production<input type="checkbox" name="empdept" value="Production">
QA<input type="checkbox" name="empdept" value="QA"><br>


Employee DOB<input type="date" name="empdob"><br>

Employee UID<input type="number" name="empuid"><br>
Employee PAN CARD<input type="text" name="emppancard"><br>

Employee Email<input type="email" name="empemailid"><br>

Employee Password<input type="password" name="emppassword"><br>

<input type="submit" value="SignUp">

</form>
</body>
</html>