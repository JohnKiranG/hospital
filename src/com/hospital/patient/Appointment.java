package com.hospital.patient;

import java.util.Scanner;
import com.hospital.receptionist.ReceptionistActivity;
import com.hospital.common.Doctor;
import com.hospital.common.Patient;
import com.hospital.db.PatientDAOImpl;

public class Appointment extends Doctor {
	static {
		System.out.println("===============================================================");
		System.out.println("\t\t\tCreating Appointment");
		System.out.println("===============================================================");
	}

	public static void appointmentlist(Scanner input, Scanner str) {
		System.out.print("Enter name of the Doctor: ");
		String name = str.nextLine();
		String ptID;
		if (doctorNames.contains(name)) {
			System.out.print("Enter patient ID: ");
			ptID=str.nextLine();
//			int loc=Patient.patientID.indexOf(ptID);
//			String element=String.valueOf(doctorNames.indexOf(name));
//			Patient.doctorID.setElementAt(element, loc);
			String doctorNumber=String.valueOf(doctorNames.indexOf(name));
			Patient.doctorID.setElementAt(doctorNumber, Patient.patientID.indexOf(ptID));
			
			PatientDAOImpl.createAppointment(ptID,doctorNumber);
			
			System.out.println("\tSuccessfully Appointment added");
			ReceptionistActivity.receptionistActivity(input, str);
		}else {
			System.out.println("Enter valid name of Doctor");
			calling(input, str);
		}

	}

	private static void calling(Scanner input, Scanner str) {
		System.out.println("Press c:continue b:back e:exit");
		char c=str.nextLine().charAt(0);
		switch (c) {
			case 'c':   appointmentlist(input, str);
						break;
			case 'b':   ReceptionistActivity.receptionistActivity(input, str);
						break;
			case 'e':	System.out.println("\t\t\tThank you for visiting");
						break;
			default:    System.out.println("Enter valid option");
						calling(input, str);
						break;
		}
	}

}
