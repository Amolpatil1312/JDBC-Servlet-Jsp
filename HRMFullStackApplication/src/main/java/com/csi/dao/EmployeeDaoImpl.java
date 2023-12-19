package com.csi.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.csi.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	Connection connection = null;

	public EmployeeDaoImpl() {
		// TODO Auto-generated constructor stub

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			try {
				connection = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/hrmfullstackapplication?useSSL=false", "root", "root");
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
					"insert into employee(empid, empname, empaddress, empsalary, empcontactnumber, empdob, empgender, empemailid, emppassword)values(?, ?, ?, ?, ?, ?, ?, ?, ?)");

			preparedStatement.setInt(1, employee.getEmpId());
			preparedStatement.setString(2, employee.getEmpName());
			preparedStatement.setString(3, employee.getEmpAddress());
			preparedStatement.setDouble(4, employee.getEmpSalary());
			preparedStatement.setLong(5, employee.getEmpContactNumber());
			preparedStatement.setDate(6, new java.sql.Date(employee.getEmpDOB().getTime()));
			preparedStatement.setString(7, employee.getEmpGender());
			preparedStatement.setString(8, employee.getEmpEmailId());
			preparedStatement.setString(9, employee.getEmpPassword());

			preparedStatement.executeUpdate();

			System.out.println("Signup done successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean signIn(String empEmailId, String empPassword) {
		// TODO Auto-generated method stub

		boolean flag = false;

		for (Employee employee : findAll()) {
			if (employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassword().equals(empPassword)) {
				flag = true;

				break;
			}
		}

		return flag;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub

		List<Employee> empList = new ArrayList<Employee>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from employee");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Employee employee = new Employee();

				employee.setEmpId(resultSet.getInt(1));
				employee.setEmpName(resultSet.getString(2));
				employee.setEmpAddress(resultSet.getString(3));
				employee.setEmpSalary(resultSet.getDouble(4));
				employee.setEmpContactNumber(resultSet.getLong(5));
				employee.setEmpDOB(resultSet.getDate(6));
				employee.setEmpGender(resultSet.getString(7));
				employee.setEmpEmailId(resultSet.getString(8));
				employee.setEmpPassword(resultSet.getString(9));

				empList.add(employee);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return empList;
	}

}
