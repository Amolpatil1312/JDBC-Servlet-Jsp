package com.csi.jdbccore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConcept {
	// Steps for JDBC
	// 1. Load Driver Class
	// 2. Establish DB Connection
	// 3. Create Statement
	// 4. Execute Query
	// 5. Close DB Connection

	public static void main(String[] args) throws SQLException {

		Connection connection = null;

		// 1. Load Driver Class
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 2. Establish DB Connection

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdbs?useSSL=false", "root", "root");

			// 3. Create Statement

			Statement statement = connection.createStatement();

			// 4. Execute Query

			ResultSet resultSet = statement.executeQuery("select * from employee");

			while (resultSet.next()) {
				System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getLong(3)
						+ "\t" + resultSet.getDouble(4));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 5. Close DB Connection

		finally {
			connection.close();
		}

	}

}
