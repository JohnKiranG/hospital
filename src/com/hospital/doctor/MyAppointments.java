package com.hospital.doctor;

import java.util.Scanner;

import com.hospital.common.Patient;

public class MyAppointments extends Patient{
	static {
		System.out.println("===============================================================");
		System.out.println("\t\t\tMy Appointments");
		System.out.println("===============================================================");
	}
	public static void appointmentList(Scanner input, Scanner str,int index) {
		String location=String.valueOf(index);
		if(doctorID.contains(location)) {
			String docarr[]=doctorID.toArray(new String[doctorID.size()]);
			for(int i=0;i<docarr.length;i++) {
				if(docarr[i].equals(location)) {
					printList(i);
					System.out.println();
				}
			}
			DoctorActivity.doctorActivity(input, str, index);
		}else {
			System.out.println("No appointments");
			DoctorActivity.doctorActivity(input, str, index);
		}
	}
	private static void printList(int i)  {
		System.out.println("The Patient ID: "+patientID.elementAt(i));
		System.out.println("Patient Name: "+patientNames.elementAt(i));
		System.out.println("Patient Age: "+patientAge.elementAt(i));
		System.out.println("Patient Gender: "+patientGender.elementAt(i));
		System.out.println("Patient Phonenumber: "+patientPhonenumber.elementAt(i));
		System.out.println("Patient Disease: "+patientDisease.elementAt(i));
	}

}
