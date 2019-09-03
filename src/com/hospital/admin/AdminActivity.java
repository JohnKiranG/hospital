
package com.hospital.admin;

import java.util.Scanner;

import com.hospital.common.Hospital;

public class AdminActivity {
	static {
		System.out.println("===============================================================");
		System.out.println("\t\t\tAdminPortal");
		System.out.println("===============================================================");
	}
	public static void adminActivity(Scanner input,Scanner str) {
		System.out.println("Enter which you to Manage: ");
		System.out.println("d:Doctor r:Receptionist b:Back e:Exit");
		
		char c=str.nextLine().charAt(0);
		switch (c) {
			case 'd':	DoctorManagement.docOperations(input,str);
						break;
			case 'r':	ReceptionistManagement.repOperations(input,str);
						break;
			case 'b':   Hospital.displayScreen(input,str);
						break;
			case 'e':	System.out.println("\t\t\tThank you for visiting");
						break;
			default:	System.out.println("Enter valid option");
						adminActivity(input, str);
						break;
		}
	}
}
