package com.csi.dao;

import java.sql.Connection;
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
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbchrm?useSSL=false", "root",
						"root");
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
					"insert into employee(empid, empname, empaddress, empcontactnumber, empsalary, empemailid, emppassword)values(?, ?, ?, ?, ?, ?, ?)");

			preparedStatement.setInt(1, employee.getEmpId());
			preparedStatement.setString(2, employee.getEmpName());
			preparedStatement.setString(3, employee.getEmpAddress());
			preparedStatement.setLong(4, employee.getEmpContactNumber());
			preparedStatement.setDouble(5, employee.getEmpSalary());
			preparedStatement.setString(6, employee.getEmpEmailId());
			preparedStatement.setString(7, employee.getEmpPassword());

			preparedStatement.executeUpdate();

			System.out.println("Employee Signup done successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean signIn(String empEmailId, String empPassword) {
		// TODO Auto-generated method stub

		/*
		 * boolean flag = false;
		 * 
		 * try { PreparedStatement preparedStatement = connection
		 * .prepareStatement("select * from employee where empemailid=? and emppassword=?"
		 * );
		 * 
		 * preparedStatement.setString(1, empEmailId); preparedStatement.setString(2,
		 * empPassword); ResultSet resultSet = preparedStatement.executeQuery();
		 * 
		 * flag = resultSet.next();
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * return flag;
		 */

		boolean flag = false;

		for (Employee employee : getAllData()) {
			if (employee.getEmpEmailId().equals(empEmailId) && employee.getEmpPassword().equals(empPassword)) {
				flag = true;

				break;
			}
		}

		return flag;
	}

	@Override
	public List<Employee> getAllData() {
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
				employee.setEmpContactNumber(resultSet.getLong(4));
				employee.setEmpSalary(resultSet.getDouble(5));
				employee.setEmpEmailId(resultSet.getString(6));
				employee.setEmpPassword(resultSet.getString(7));

				empList.add(employee);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return empList;
	}

	@Override
	public void deleteById(int empId) {
		// TODO Auto-generated method stub

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from employee where empid=?");

			preparedStatement.setInt(1, empId);

			preparedStatement.executeUpdate();
			System.out.println("Data Deleted Successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
