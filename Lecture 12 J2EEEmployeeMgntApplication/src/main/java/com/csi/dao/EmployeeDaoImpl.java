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
						"jdbc:mysql://localhost:3306/j2eeemployeemanagement?useSSL=false", "root", "root");
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
					"insert into employee(empid, empname, empaddress, empstate, empsalary, empcontactnumber, empgender, empdob, empdept, empuid, emppancard, empemailid, emppassword)values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

			preparedStatement.setInt(1, employee.getEmpId());
			preparedStatement.setString(2, employee.getEmpName());
			preparedStatement.setString(3, employee.getEmpAddress());
			preparedStatement.setString(4, employee.getEmpState());
			preparedStatement.setDouble(5, employee.getEmpSalary());
			preparedStatement.setLong(6, employee.getEmpContactNumber());
			preparedStatement.setString(7, employee.getEmpGender());
			preparedStatement.setDate(8, new Date(employee.getEmpDOB().getTime()));
			preparedStatement.setString(9, employee.getEmpDept());
			preparedStatement.setLong(10, employee.getEmpUID());
			preparedStatement.setString(11, employee.getEmpPanCard());
			preparedStatement.setString(12, employee.getEmpEmailId());
			preparedStatement.setString(13, employee.getEmpPassword());

			preparedStatement.executeUpdate();

			System.out.println("\n Employee signup done successfully");
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
	public Employee findById(int empId) {
		// TODO Auto-generated method stub

		Employee employee = new Employee();
		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("select * from employee where empid=?");
			preparedStatement.setInt(1, empId);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				employee.setEmpId(resultSet.getInt(1));
				employee.setEmpName(resultSet.getString(2));
				employee.setEmpAddress(resultSet.getString(3));
				employee.setEmpState(resultSet.getString(4));
				employee.setEmpSalary(resultSet.getDouble(5));
				employee.setEmpContactNumber(resultSet.getLong(6));
				employee.setEmpGender(resultSet.getString(7));
				employee.setEmpDOB(resultSet.getDate(8));
				employee.setEmpDept(resultSet.getString(9));
				employee.setEmpUID(resultSet.getLong(10));
				employee.setEmpPanCard(resultSet.getString(11));
				employee.setEmpEmailId(resultSet.getString(12));
				employee.setEmpPassword(resultSet.getString(13));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employee;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub

		List<Employee> employeeList = new ArrayList<Employee>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select * from employee");

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				Employee employee = new Employee();
				employee.setEmpId(resultSet.getInt(1));
				employee.setEmpName(resultSet.getString(2));
				employee.setEmpAddress(resultSet.getString(3));
				employee.setEmpState(resultSet.getString(4));
				employee.setEmpSalary(resultSet.getDouble(5));
				employee.setEmpContactNumber(resultSet.getLong(6));
				employee.setEmpGender(resultSet.getString(7));
				employee.setEmpDOB(resultSet.getDate(8));
				employee.setEmpDept(resultSet.getString(9));
				employee.setEmpUID(resultSet.getLong(10));
				employee.setEmpPanCard(resultSet.getString(11));
				employee.setEmpEmailId(resultSet.getString(12));
				employee.setEmpPassword(resultSet.getString(13));

				employeeList.add(employee);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employeeList;
	}

	@Override
	public void updateData(int empId, Employee employee) {
		// TODO Auto-generated method stub

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(
					"update employee set empname=?, empaddress=?, empstate=?, empsalary=?, empcontactnumber=?, empgender=?, empdob=?, empdept=?, empuid=?, emppancard=?, empemailid=?, emppassword=? where empid=?");

			preparedStatement.setString(1, employee.getEmpName());
			preparedStatement.setString(2, employee.getEmpAddress());
			preparedStatement.setString(3, employee.getEmpState());
			preparedStatement.setDouble(4, employee.getEmpSalary());
			preparedStatement.setLong(5, employee.getEmpContactNumber());
			preparedStatement.setString(6, employee.getEmpGender());
			preparedStatement.setDate(7, new Date(employee.getEmpDOB().getTime()));
			preparedStatement.setString(8, employee.getEmpDept());
			preparedStatement.setLong(9, employee.getEmpUID());
			preparedStatement.setString(10, employee.getEmpPanCard());
			preparedStatement.setString(11, employee.getEmpEmailId());
			preparedStatement.setString(12, employee.getEmpPassword());
			preparedStatement.setInt(13, employee.getEmpId());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteById(int empId) {
		// TODO Auto-generated method stub

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from employee where empid=?");

			preparedStatement.setInt(1, empId);

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

		try {
			PreparedStatement preparedStatement = connection.prepareStatement("truncate table employee");

			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
