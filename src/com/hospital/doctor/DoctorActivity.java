package com.hospital.doctor;

import java.util.Scanner;

import com.hospital.common.Hospital;

public class DoctorActivity {
	static {
System.out.println("===============================================================");
		System.out.println("\t\t\tDoctorPortal");
System.out.println("===============================================================");
	}
	public static void doctorActivity(Scanner input,Scanner str,int index) {
		System.out.println("Enter which you want to Manage");
		System.out.println("a:Appointments b:back e:exit");
		
		char c=str.nextLine().charAt(0);
		switch (c) {
			case 'a':	MyAppointments.appointmentList(input, str, index);
						break;
			case 'b':   Hospital.displayScreen(input,str);
						break;
			case 'e':	System.out.println("\t\t\tThank you for visiting");
						break;
			default:	System.out.println("Enter valid option");
						doctorActivity(input, str, index);
						break;
		}
	}

}
