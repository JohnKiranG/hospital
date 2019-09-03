 package com.hospital.common;

import java.util.Scanner;
import java.util.Vector;

import com.hospital.admin.AdminActivity;

public class Admin {
	public static Vector<String> adminNames=new Vector<String>(10);
	public static Vector<String> adminPsswds=new Vector<String>(10);
	static {
		adminNames.add("Ram");
		adminPsswds.add("acs");
		adminNames.add("John");
		adminPsswds.add("123");
	}

	// private static String admin[]={"john"};
	// private static String psswd[]={"123"};
	
	public static void adminVerify(Scanner input, Scanner str) {
		System.out.print("Enter Admin Name: ");
		String name=str.nextLine();
		System.out.print("Enter psswd: ");
		String pass=str.nextLine();

		if (adminNames.contains(name) && pass.equals(adminPsswds.elementAt(adminNames.indexOf(name)))) {
			System.out.println("Welcome: "+ adminNames.elementAt(adminNames.indexOf(name)));
			AdminActivity.adminActivity(input,str);
		} else {
			System.out.println("Enter valid username and psswd");
			adminVerify(input, str);
		}
		// if(name.equals(admin[0]) && pass.equals(psswd[0]) ) {
		// System.out.println("Welcome: "+admin[0]);
		// AdminActivity.adminActivity(input,str);
		// }
	}
}
