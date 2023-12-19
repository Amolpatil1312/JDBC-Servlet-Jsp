package com.csi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.csi.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	Connection connection = null;

	public EmployeeDaoImpl() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrmfullstack?useSSL=false",
						"root", "root");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void signUp(Employee employee) {
		// TODO Auto-generated method stub

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"insert into employee(empid, empname, empaddress, empsalary, empcontactnumber, empdob, empemailid, emppassword)values(?, ?, ?, ?, ?, ?, ?, ?)");

			preparedStatement.setInt(1, employee.getEmpId());
			preparedStatement.setString(2, employee.getEmpName());
			preparedStatement.setString(3, employee.getEmpAddress());
			preparedStatement.setDouble(4, employee.getEmpSalary());
			preparedStatement.setLong(5, employee.getEmpContactNumber());
			preparedStatement.setDate(6, new java.sql.Date(employee.getEmpDOB().getTime()));
			preparedStatement.setString(7, employee.getEmpEmailId());
			preparedStatement.setString(8, employee.getEmpPassword());

			preparedStatement.executeUpdate();
			System.out.println("Employee Signup Done Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean signIn(String empEmailId, String empPassword) {
		// TODO Auto-generated method stub

		boolean flag = false;

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("select * from employee where empemailid=? and emppassword=?");

			preparedStatement.setString(1, empEmailId);
			preparedStatement.setString(2, empPassword);

			ResultSet resultSet = preparedStatement.executeQuery();

			flag = resultSet.next();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

}
