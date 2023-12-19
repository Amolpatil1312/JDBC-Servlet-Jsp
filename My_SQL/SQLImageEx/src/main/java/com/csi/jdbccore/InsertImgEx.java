package com.csi.jdbccore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertImgEx {
	// Steps for JDBC

	// 1. Load Driver Class
	// 2. Establish Connection
	// 3. Create Statement
	// 4. Execute Query
	// 5. Close DB Connection
	public static void main(String[] args) throws IOException, SQLException {

		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/imagedatabase?useSSL=false",
						"root", "root");

				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into imgtable(imgname, img)values(?, ?)");

				preparedStatement.setString(1, "CSI LOGO");

				File file = new File("D://AA/CS.png");

				try {
					FileInputStream fileInputStream = new FileInputStream(file);

					preparedStatement.setBinaryStream(2, fileInputStream, fileInputStream.available());

					preparedStatement.executeUpdate();

					System.out.println("File Inserted Successfully");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connection.close();
		}

	}

}
