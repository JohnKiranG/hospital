package com.hospital.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.hospital.db.CreateConnect;

public class Patient {
	public static Vector<String> patientNames = new Vector<String>(10);
	public static Vector<String> patientID = new Vector<String>(10);
	public static Vector<String> patientAge = new Vector<String>(10);
	public static Vector<String> patientGender = new Vector<String>(10);
	public static Vector<String> patientPhonenumber = new Vector<String>(10);
	public static Vector<String> patientDisease = new Vector<String>(10);
	public static Vector<String> doctorID = new Vector<String>(10);
	static {
		String set="null";
		doctorID.add(set);	
		doctorID.add(set);
		doctorID.add(set);
		doctorID.add(set);
		doctorID.add(set);
		doctorID.add(set);
		doctorID.add(set);
		doctorID.add(set);
		doctorID.add(set);
		doctorID.add(set);
		Connection conn = CreateConnect.createConnection();
		Statement st = null;

		try {
			st = conn.createStatement();

			ResultSet rs = st.executeQuery("select name,id,age,gender,phonenumber,disease,doctorid from patient");

			while (rs.next()) {
				String name = rs.getString("name");
				String id = rs.getString("id");
				String age = rs.getString("age");
				String genger = rs.getString("gender");
				String pno = rs.getString("phonenumber");
				String disease = rs.getString("disease");
				String dID = rs.getString("doctorid");
				
				patientNames.add(name);
				patientID.add(id);
				patientAge.add(age);
				patientGender.add(genger);
				patientPhonenumber.add(pno);
				patientDisease.add(disease);
				doctorID.add(dID);
				
			}

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
	
}
