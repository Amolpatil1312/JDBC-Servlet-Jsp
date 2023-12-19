package com.csi.jdbccore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadSQLImgEx {

	// Steps for JDBC
	// 1. Load Driver Class
	// 2. Establish DB Connection
	// 3. Create Statement
	// 4. Execute Query
	// 5. Close DB Connection

	public static void main(String[] args) {

		Connection connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/imagedatabase?useSSL=false",
						"root", "root");

				PreparedStatement preparedStatement = connection.prepareStatement("select * from imgtable");

				ResultSet resultSet = preparedStatement.executeQuery();

				if (resultSet.next()) {
					Blob blob = resultSet.getBlob(2);

					byte barr[] = blob.getBytes(1, (int) blob.length());
					File file = new File("D://FINTECH.png");
					try {
						FileOutputStream fileOutputStream = new FileOutputStream(file);

						try {
							fileOutputStream.write(barr);
							fileOutputStream.close();

							System.out.println("\n Please check image on D Drive: " + file.getName());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
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
