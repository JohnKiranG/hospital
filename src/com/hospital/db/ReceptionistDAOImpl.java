package com.hospital.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ReceptionistDAOImpl {
	public static void insert(String name, String psswd) {
		
		// query to create database table
		//	CREATE TABLE RECEPTIONIST(
		//	    ID INT NOT NULL AUTO_INCREMENT,
		//	    NAME VARCHAR(50),
		//	    PSSWD VARCHAR(50),
		//		PRIMARY KEY (ID)
		//	)
		
		Connection conn = CreateConnect.createConnection();
		Statement st = null;
		try {
			st = conn.createStatement();

			st.executeUpdate("insert into receptionist(name,psswd) values ('" + name + "'," + psswd + ")");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void delete(String name, String psswd) {
		Connection conn = CreateConnect.createConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("delete from receptionist where name=? and psswd=?");
			ps.setString(1, name);
			ps.setString(2, psswd);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void update(String name, String newName, String psswd) {
		Connection conn = CreateConnect.createConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update receptionist set name=?,psswd=?  where name=? ");
			ps.setString(1, newName);
			ps.setString(2, psswd);
			ps.setString(3, name);

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
