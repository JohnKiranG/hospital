package com.hospital.common;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Vector;

import com.hospital.db.CreateConnect;
import com.hospital.receptionist.ReceptionistActivity;

public class Receptionist {
	public static Vector<String> receptionistNames = new Vector<String>(10);
	public static Vector<String> receptionistPsswds = new Vector<String>(10);
	static {
		// receptionistNames.add("Ram");
		// receptionistPsswds.add("acs");
		// receptionistNames.add("John");
		// receptionistPsswds.add("123");
		Connection conn = CreateConnect.createConnection();
		Statement st = null;

		try {
			st = conn.createStatement();

			ResultSet rs = st.executeQuery("select name,psswd from receptionist");

			while (rs.next()) {
				String name = rs.getString("name");
				String psswd = rs.getString("psswd");
				receptionistNames.add(name);
				receptionistPsswds.add(psswd);
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

	public static void repVerify(Scanner input, Scanner str) {
		System.out.print("Enter Receptionist Name: ");
		String name = str.nextLine();
		System.out.print("Enter psswd: ");
		String pass = str.nextLine();
		if (receptionistNames.contains(name)
				&& pass.equals(receptionistPsswds.elementAt(receptionistNames.indexOf(name)))) {
			System.out.println("Welcome: " + receptionistNames.elementAt(receptionistNames.indexOf(name)));
			ReceptionistActivity.receptionistActivity(input, str);
		} else {
			System.out.println("Enter valid username and psswd");
			repVerify(input, str);
		}
	}

}
