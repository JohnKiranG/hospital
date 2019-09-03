package com.hospital.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class PatientDAOImpl  {
	public static void insert(String name, String id,String age,String gender,String phonenumber,String disease) {
		
		// query to create database table
		//	CREATE TABLE PATIENT(
		//	    SERIAL INT NOT NULL,
		//	    NAME VARCHAR(50),
		//	    ID INT,
		//	    AGE INT,
		//	    GENDER VARCHAR(6),
		//	    PHONENUMBER VARCHAR(50),
		//	    DISEASE VARCHAR(50),
		//	    DOCTORID VARCHAR(10),
		//		PRIMARY KEY (SERIAL)
		//	)
		
		Connection conn = CreateConnect.createConnection();
		Statement st = null;
		try {
			st = conn.createStatement();
			
			int id1=Integer.parseInt(id);
			//int pno=Integer.parseInt(phonenumber);

			st.executeUpdate("insert into patient(name,id,age,gender,phonenumber,disease) values ('" + name + "'," + id1 + ""
					+ ",'" +age+ "','" +gender+ "','" +phonenumber+ "','" +disease+ "',)");

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

	public static void delete(String id) {
		Connection conn = CreateConnect.createConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("delete from patient where id=?");
			ps.setString(1, id);
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

	public static void update(String name,String newName,String newID,String newAge,String newGender,String newDisease,String newPhone) {
		Connection conn = CreateConnect.createConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("update patient set name=?,id=?,age=?,gender=?,phonenumber=?,disease=?  where name=? ");
			ps.setString(1, newName);
			ps.setInt(2,Integer.parseInt(newID));
			ps.setInt(3,Integer.parseInt(newAge));
			ps.setString(4, newGender);
			ps.setString(5, newPhone);
			ps.setString(6, newDisease);
			ps.setString(7, name);

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
	
	public static void createAppointment(String ptid, String docID) {
		Connection conn = CreateConnect.createConnection();
		PreparedStatement ps= null;
		try {
			String query="update patient set doctorid=? where id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, docID);
			ps.setString(2, ptid);
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
