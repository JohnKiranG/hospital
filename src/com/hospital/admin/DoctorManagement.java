package com.hospital.admin;

import java.util.Scanner;
import com.hospital.common.Doctor;
import com.hospital.db.DoctorDAOImpl;

public class DoctorManagement extends Doctor {
	static {
		System.out.println("===============================================================");
		System.out.println("\t\t\tDoctorManagement");
		System.out.println("===============================================================");
	}

	public static void docOperations(Scanner input, Scanner str) {
		System.out.println("Enter which you want to manage");
		System.out.println("a:AddDoctor u:UpdateDoctor d:DeleteDoctor s:SearchDoctor\nv:ViewDoctors b:Back e:Exit");

		char c = str.nextLine().charAt(0);
		switch (c) {
		case 'a':
			add(input, str);
			break;
		case 'd':
			delete(input, str);
			break;
		case 'u':
			update(input, str);
			break;
		case 's':
			search(input, str);
			break;
		case 'v':
			view(input, str);
			break;
		case 'e':
			System.out.println("\t\t\tThank you for visiting");
			break;
		case 'b':
			AdminActivity.adminActivity(input, str);
			break;
		default:
			System.out.println("\tEnter valid option");
			docOperations(input, str);
			break;
		}
	}

	public static void add(Scanner input, Scanner str) {
		System.out.print("Enter Doctor Name: ");
		String name = str.nextLine();
		doctorNames.add(name);

		System.out.print("Enter psswd: ");
		String psswd = str.nextLine();
		doctorPsswds.add(psswd);
		
		DoctorDAOImpl.insert(name, psswd);
		
		System.out.println("\t\t\tSuccessfully added\n");
		DoctorManagement.docOperations(input, str);
	}

	public static void delete(Scanner input, Scanner str) {
		System.out.print("Enter Doctor Name to remove: ");

		String name = str.nextLine();
		if (doctorNames.contains(name)) {

			String psswd = doctorPsswds.elementAt(doctorNames.indexOf(name));

			doctorPsswds.remove(doctorNames.indexOf(name));

			doctorNames.remove(name);

			DoctorDAOImpl.delete(name, psswd);

			System.out.println("\t\t\tSuccessfully removed\n");
			DoctorManagement.docOperations(input, str);
		} else {
			System.out.println("Enter valid name");
			delRepeat(input, str);
		}
	}

	private static void delRepeat(Scanner input, Scanner str) {
		System.out.println("Press c:continue b:back e:exit");
		char c = str.nextLine().charAt(0);
		switch (c) {
		case 'c':
			delete(input, str);
			break;
		case 'b':
			DoctorManagement.docOperations(input, str);
			break;
		case 'e':
			System.out.println("\t\t\tThank you for visiting");
			break;
		default:
			System.out.println("\tEnter valid option");
			delRepeat(input, str);
			break;
		}
	}

	public static void update(Scanner input, Scanner str) {
		System.out.print("Enter the name you want to edit: ");
		String name = str.nextLine();
		if (doctorNames.contains(name)) {
			System.out.print("Enter the new name to change: ");
			String newName = str.nextLine();

			doctorNames.setElementAt(newName, doctorNames.indexOf(name));

			System.out.print("Enter new passwd: ");

			String newPsswd = str.nextLine();

			doctorPsswds.setElementAt(newPsswd, doctorNames.indexOf(newName));

			DoctorDAOImpl.update(name, newName, newPsswd);

			System.out.println("\tSuccessfull");

			updateRepeat(input, str);

		} else

		{
			System.out.println("It is not in records \nPlease check the name");
			updateRepeat(input, str);
		}
	}

	private static void updateRepeat(Scanner input, Scanner str) {
		System.out.println("Press c:continue b:back e:exit");
		char c = str.nextLine().charAt(0);
		switch (c) {
		case 'c':
			update(input, str);
			break;
		case 'b':
			DoctorManagement.docOperations(input, str);
			break;
		case 'e':
			System.out.println("\t\t\tThank you for visiting");
			break;
		default:
			System.out.println("Enter valid option");
			updateRepeat(input, str);
			break;
		}
	}

	public static void search(Scanner input, Scanner str) {
		System.out.print("Enter name of Doctor: ");
		String name = str.nextLine();
		if (doctorNames.contains(name)) {
			System.out.println("It is present");
			System.out.println("Location: " + doctorNames.indexOf(name));
			System.out.println("psswd is: " + doctorPsswds.elementAt(doctorNames.indexOf(name)));
			DoctorManagement.docOperations(input, str);
		} else {
			System.out.println("It is not in records \nPlease check the name");
			searchRepeat(input, str);
		}
	}

	private static void searchRepeat(Scanner input, Scanner str) {
		System.out.println("Press c:continue b:back e:exit");
		char c = str.nextLine().charAt(0);
		switch (c) {
		case 'c':
			search(input, str);
			break;
		case 'b':
			DoctorManagement.docOperations(input, str);
			break;
		case 'e':
			System.out.println("\t\t\tThank you for visiting");
			break;
		default:
			System.out.println("Enter valid option");
			searchRepeat(input, str);
			break;
		}
	}

	public static void view(Scanner input, Scanner str) {
		System.out.println("The Doctors present in the records are: " + doctorNames);
		System.out.println("There psswds: " + doctorPsswds);
		viewRepeat(input, str);

	}

	private static void viewRepeat(Scanner input, Scanner str) {
		System.out.println("Press b:back e:exit");
		char c = str.nextLine().charAt(0);

		switch (c) {
		case 'b':
			DoctorManagement.docOperations(input, str);
			break;
		case 'e':
			System.out.println("\t\t\tThank you for visiting");
			break;
		default:
			System.out.println("Enter valid option");
			viewRepeat(input, str);
			break;
		}
	}
}
