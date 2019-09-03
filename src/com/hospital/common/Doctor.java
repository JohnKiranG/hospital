package com.hospital.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Vector;

import com.hospital.db.CreateConnect;
import com.hospital.doctor.DoctorActivity;

public class Doctor {
	public static Vector<String> doctorNames = new Vector<String>(10);
	public static Vector<String> doctorPsswds = new Vector<String>(10);
	static {
		// doctorNames.add("Ram");
		// doctorPsswds.add("acs");
		// doctorNames.add("John");
		// doctorPsswds.add("123");
		Connection conn = CreateConnect.createConnection();
		Statement st = null;

		try {
			st = conn.createStatement();

			ResultSet rs = st.executeQuery("select name,psswd from doctor");

			while (rs.next()) {
				String name = rs.getString("name");
				String psswd = rs.getString("psswd");
				doctorNames.add(name);
				doctorPsswds.add(psswd);
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

	public static void docVerify(Scanner input, Scanner str) {

		System.out.print("Enter Doctor Name: ");
		String name = str.nextLine();
		System.out.print("Enter psswd: ");
		String pass = str.nextLine();
		if (doctorNames.contains(name) && pass.equals(doctorPsswds.elementAt(doctorNames.indexOf(name)))) {
			System.out.println("Welcome: " + doctorNames.elementAt(doctorNames.indexOf(name)));
			DoctorActivity.doctorActivity(input, str, doctorNames.indexOf(name));
		} else {
			System.out.println("Enter valid username and psswd");
			docVerify(input, str);
		}
	}

}
