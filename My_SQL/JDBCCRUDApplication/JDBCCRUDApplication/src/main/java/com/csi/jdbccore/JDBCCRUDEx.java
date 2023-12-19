package com.csi.jdbccore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCCRUDEx {

	// Steps for JDBC
	// 1. Load Driver class
	// 2. Establish Connection
	// 3. Create Statement
	// 4. Execute Query
	// 5. Close DB Connection

	public static void main(String[] args) {

		Connection connection = null;
		// 1. Load Driver class
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. Establish Connection
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hrmapplications?useSSL=false",
						"root", "root");

				// 3. Create Statement

				// 1. Create Database
				/*
				 * PreparedStatement preparedStatement =
				 * connection.prepareStatement("create database hrmapplications");
				 * 
				 * // 4. Execute Query
				 * 
				 * preparedStatement.executeUpdate();
				 * 
				 * System.out.println("Database created successfully");
				 */

				// 2. Create table

				/*
				 * String createTableSQL =
				 * "create table employee(empid int, empname varchar(255), empaddress varchar(255), empsalary double, empemailid varchar(255), primary key(empid), unique key(empemailid))"
				 * ; PreparedStatement preparedStatement =
				 * connection.prepareStatement(createTableSQL);
				 * 
				 * preparedStatement.executeUpdate();
				 * 
				 * System.out.println("Table created successfully");
				 */

				// 3. Insert Data

				/*
				 * String insertSQL =
				 * "insert into employee values(129, 'VAIBHAV', 'PUNE', 85000, 'VAIBHAV@cs.com')"
				 * ;
				 * 
				 * PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
				 * 
				 * preparedStatement.executeUpdate();
				 * 
				 * System.out.println("Data Inserted successfully");
				 */

				// 4. Update data

				/*
				 * String updateSQL = "update employee set empsalary=99000.22 where empid=129";
				 * 
				 * PreparedStatement preparedStatement = connection.prepareStatement(updateSQL);
				 * 
				 * preparedStatement.executeUpdate();
				 * 
				 * System.out.println("Data Updated Successfully");
				 */
				// 5. Delete Data
				/*
				 * String deleteSQL = "delete from employee where empid=129";
				 * 
				 * PreparedStatement preparedStatement = connection.prepareStatement(deleteSQL);
				 * 
				 * preparedStatement.executeUpdate();
				 * 
				 * System.out.println("Data Deleted Successfully");
				 */

				// 6. Read Data

				/*
				 * String selectSQL = "select * from employee";
				 * 
				 * PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
				 * 
				 * ResultSet resultSet = preparedStatement.executeQuery();
				 * 
				 * while (resultSet.next()) { System.out.println(resultSet.getInt(1) + "\t" +
				 * resultSet.getString(2) + "\t" + resultSet.getString(3) + "\t" +
				 * resultSet.getDouble(4) + "\t" + resultSet.getString(5)); }
				 */

				// 7. Truncate

				String truncateSQL = "truncate table employee";

				PreparedStatement preparedStatement = connection.prepareStatement(truncateSQL);

				preparedStatement.executeUpdate();

				System.out.println("Table truncated successfully");

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
