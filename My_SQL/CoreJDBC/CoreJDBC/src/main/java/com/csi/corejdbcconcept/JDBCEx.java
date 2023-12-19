package com.csi.corejdbcconcept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.DatabaseMetaData;
import com.mysql.cj.xdevapi.CreateIndexParams;

public class JDBCEx {

	// Steps for JDBC
	// 1. Load Driver class
	// 2. Establish connection
	// 3. Create Statement
	// 4. Execute Query
	// 5. Close Database connection

	public static void main(String[] args) {

		Connection connection = null;

		// 1. Load Driver class

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2. Establish connection
			connection = DriverManager.getConnection("jdbc:mysql://127.0.1:3306/swarajdb?useSSL=false", "root", "root");
			// 3. Create Statement

			// String createDBSQL="create database swarajdb";
			// String createTableSQL="create table employee(empid int, empname varchar(255),
			// empsalary double)";
			// String insertSQL="insert into employee values(129, 'VAIBHAV', 95000)";

			// String updateSQL="update employee set empsalary=99000.96 where empid=121";

			// String deleteSQL="delete from employee where empid=121";
			String truncateSQL = "truncate table employee";
			PreparedStatement preparedStatement = connection.prepareStatement(truncateSQL);

			// 4. Execute Query

			preparedStatement.executeUpdate();
			System.out.println("Table truncate successfully");

			/*
			 * ResultSet resultSet = preparedStatement.executeQuery();
			 * 
			 * while (resultSet.next()) { System.out.println(resultSet.getInt(1) + "\t" +
			 * resultSet.getString(2) + "\t" + resultSet.getDouble(3) + "\t" +
			 * resultSet.getLong(4) + "\t" + resultSet.getString(5)); }
			 */

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 5. Close Database connection
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
