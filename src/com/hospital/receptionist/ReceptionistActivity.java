
package com.hospital.receptionist;

import java.util.Scanner;
import com.hospital.patient.Appointment;
import com.hospital.common.Hospital;
import com.hospital.common.Patient;
import com.hospital.db.PatientDAOImpl;

public class ReceptionistActivity extends Patient{
	static {
		System.out.println("===============================================================");
		System.out.println("\t\t\tReceptionistPortal");
		System.out.println("===============================================================");
	}
	public static void receptionistActivity(Scanner input,Scanner str) {
		System.out.println("Enter which you want to Manage: ");
		System.out.println("a:Add Patient u:Update Patient  d:Delete Patient s:Search Patient" +
				"\nv:View Patient c:Create Appointment b:Back e:Exit");
		
		char c=str.nextLine().charAt(0);
		switch (c) {
			case 'c':	Appointment.appointmentlist(input, str);
						break;
			case 'a':	add(input,str);
						break;
			case 'd':	delete(input,str);
						break;
			case 'u':	update(input,str);
						break;
			case 's':   search(input,str);
						break;
			case 'v':   view(input,str);
						break;
			case 'b':   Hospital.displayScreen(input,str);
						break;
			case 'e':	System.out.println("\t\t\tThank you for visiting");
						break;
			default:	System.out.println("Enter valid option");
						receptionistActivity(input, str);
						break;
		}
	}
	public static void add(Scanner input, Scanner str) {
		System.out.print("Enter Patient Name: ");
		String name=str.nextLine();
		patientNames.add(name);
	
		System.out.print("Enter Patient ID: ");
		String id=str.nextLine();
		patientID.add(id);
		
		System.out.print("Enter Patient Age: ");
		String age=str.nextLine();
		patientAge.add(age);
		
		System.out.print("Enter Patient Gender: ");
		String gender=str.nextLine();
		patientGender.add(gender);
		
		System.out.print("Enter Patient Phonenumber: ");
		String pnumber=str.nextLine();
		patientPhonenumber.add(pnumber);
		
		System.out.print("Enter Patient Disease: ");
		String disease=str.nextLine();
		patientDisease.add(disease);
		
		PatientDAOImpl.insert(name, id, age, gender, pnumber, disease);
		
		System.out.println("\t\t\tSuccessfully added");
		ReceptionistActivity.receptionistActivity(input, str);		
	}
	public static void delete(Scanner input, Scanner str) {
		System.out.print("Enter Patient ID to remove: ");

		String id = str.nextLine();
		if (patientID.contains(id)) {
			patientNames.remove(patientID.indexOf(id));
			patientAge.remove(patientID.indexOf(id));
			patientGender.remove(patientID.indexOf(id));
			patientPhonenumber.remove(patientID.indexOf(id));
			patientDisease.remove(patientID.indexOf(id));
			patientID.remove(id);
			
			PatientDAOImpl.delete(id);
			
			System.out.println("\t\t\tSuccessfully removed");
			ReceptionistActivity.receptionistActivity(input, str);
		} else {
			System.out.println("Enter valid ID");
			delRepeat(input, str);
		}

	}

	private static void delRepeat(Scanner input, Scanner str) {
		System.out.println("Press c:continue b:back e:exit");
		char c=str.nextLine().charAt(0);
		switch (c) {
			case 'c':   delete(input, str);
						break;
			case 'b':   ReceptionistActivity.receptionistActivity(input, str);
						break;
			case 'e':	System.out.println("\t\t\tThank you for visiting");
						break;
			default:    System.out.println("Enter valid option");
						delRepeat(input, str);
						break;
		}
	}
	public static void search(Scanner input, Scanner str) {
		System.out.print("Enter ID of Patient: ");
		String id=str.nextLine();
		if(patientID.contains(id)) {
			System.out.println("It is present");
			System.out.println("Location: "+patientID.indexOf(id));
			System.out.println("Patient Name is: "+patientNames.elementAt(patientID.indexOf(id)));
			System.out.println("Patient Age is: "+patientAge.elementAt(patientID.indexOf(id)));
			System.out.println("Patient Gender is: "+patientGender.elementAt(patientID.indexOf(id)));
			System.out.println("Patient Phone number is: "+patientPhonenumber.elementAt(patientID.indexOf(id)));
			System.out.println("Patient Disease is: "+patientDisease.elementAt(patientID.indexOf(id)));
			
			ReceptionistActivity.receptionistActivity(input, str);
		} else {
			System.out.println("It is not in records \nPlease check the ID");
			serRepeat(input, str);
		}
	}

	private static void serRepeat(Scanner input, Scanner str) {
		System.out.println("Press c:continue b:back e:exit");
		char c=str.nextLine().charAt(0);
		switch (c) {
			case 'c':   search(input, str);
						break;
			case 'b':   ReceptionistActivity.receptionistActivity(input, str);
						break;
			case 'e':	System.out.println("\t\t\tThank you for visiting");
						break;
			default:    System.out.println("Enter valid option");
						serRepeat(input, str);
						break;
		}
		
	}
	public static void update(Scanner input, Scanner str) {
		System.out.print("Enter the name you want to edit: ");
		String name=str.nextLine();
		if(patientNames.contains(name)) {
			
			System.out.print("Enter the new name to change: ");
			String newName = str.nextLine();
			
			System.out.print("Enter the new ID to change: ");
			String newID = str.nextLine();
			patientID.setElementAt(newID, patientNames.indexOf(name));

			System.out.print("Enter the new Age to change: ");
			String newAge = str.nextLine();
			patientAge.setElementAt(newAge, patientNames.indexOf(name));

			System.out.print("Enter the new gender to change: ");
			String newGender = str.nextLine();
			patientGender.setElementAt(newGender, patientNames.indexOf(name));

			System.out.print("Enter the new disease to change: ");
			String newDisease = str.nextLine();
			patientDisease.setElementAt(newDisease, patientNames.indexOf(name));

			System.out.print("Enter new phone number: ");
			String newPhone = str.nextLine();
			patientPhonenumber.setElementAt(newPhone, patientNames.indexOf(name));
			
			//this is kept last because if change the name first it shows error
			patientNames.setElementAt(newName, patientNames.indexOf(name));
			
			PatientDAOImpl.update(name,newName,newID,newAge,newGender,newDisease,newPhone);
			
			 upRepeat(input, str);
		
			//System.out.println("Press n:EditName i:EditId a:EditAge g:EditGender p:EditPhoneNumber d:EditDisease");
			//char c=str.nextLine().charAt(0);
			//switch (c) {
//			case 'n' : System.out.print("Enter the new name to change: ");
//					   String newName=str.nextLine();
//					   patientNames.setElementAt(newName, patientNames.indexOf(name));
//					   System.out.println("\tSuccessfull");
//					   upRepeat(input, str);
//					   break;
//			case 'i' : System.out.print("Enter the new ID to change: ");
//			   		   String newID=str.nextLine();
//			           patientID.setElementAt(newID, patientNames.indexOf(name));
//			           System.out.println("\tSuccessfull");
//			           upRepeat(input, str);
//			           break;
//			case 'a' : System.out.print("Enter the new Age to change: ");
//			   		   String newAge=str.nextLine();
//			           patientAge.setElementAt(newAge, patientNames.indexOf(name));
//			           System.out.println("\tSuccessfull");
//			           upRepeat(input, str);
//			           break;
//			case 'g' : System.out.print("Enter the new gender to change: ");
//			   		   String newGender=str.nextLine();
//			           patientGender.setElementAt(newGender, patientNames.indexOf(name));
//			           System.out.println("\tSuccessfull");
//			           upRepeat(input, str);
//			           break;
//			case 'd' : System.out.print("Enter the new disease to change: ");
//			   		   String newDisease=str.nextLine();
//			           patientDisease.setElementAt(newDisease, patientNames.indexOf(name));
//			           System.out.println("\tSuccessfull");
//			           upRepeat(input, str);
//			           break;
//			case 'p' : System.out.print("Enter new phone number: ");
//					   String newPhone=str.nextLine();
//					   patientPhonenumber.setElementAt(newPhone, patientNames.indexOf(name));
//					   System.out.println("\tSuccessfull");
//					   upRepeat(input, str);
//					   break;
//			default  : System.out.println("Enter valid option");
//					   upRepeat(input, str);
//					   break;
//			}
		}else {
			System.out.println("It is not in records \nPlease check the name");
			upRepeat(input, str);
		}
	}

	private static void upRepeat(Scanner input, Scanner str) {
		System.out.println("Press c:continue b:back e:exit");
		char c=str.nextLine().charAt(0);
		switch (c) {
			case 'c':   update(input, str);
						break;
			case 'b':   ReceptionistActivity.receptionistActivity(input, str);
						break;
			case 'e':	System.out.println("\t\t\tThank you for visiting");
						break;
			default:    System.out.println("Enter valid option");
						upRepeat(input, str);
						break;		
		}
	}
	public static void view(Scanner input, Scanner str) {
		System.out.println("The Patients present in the records are: "+patientID);
		System.out.println("There Names: "+patientNames);
		System.out.println("There Ages: "+patientAge);
		System.out.println("There Genders: "+patientGender);
		System.out.println("There Phonenumbers: "+patientPhonenumber);
		System.out.println("There Diseases: "+patientDisease);
		viewRepeat(input, str);
		
	}

	private static void viewRepeat(Scanner input, Scanner str) {
		System.out.println("Press b:back e:exit");
		char c=str.nextLine().charAt(0);
	
		switch (c) {
			case 'b':   ReceptionistActivity.receptionistActivity(input, str);
						break;
			case 'e':	System.out.println("\t\t\tThank you for visiting");
						break;
			default:    System.out.println("Enter valid option");
						viewRepeat(input, str);
						break;
		}
		
	}
}
