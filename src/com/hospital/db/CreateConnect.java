package com.hospital.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class CreateConnect {
	public static Connection createConnection() {
		// DOWNLOAD AND ADD H2 JAR.
		
		Connection conn = null;

		try {

			Class.forName("org.h2.Driver");

			conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","john","12345");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		return conn;
	}
}
