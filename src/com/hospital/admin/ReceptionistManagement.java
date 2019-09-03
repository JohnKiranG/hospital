package com.hospital.admin;

import java.util.Scanner;
import com.hospital.common.Receptionist;
import com.hospital.db.ReceptionistDAOImpl;

public class ReceptionistManagement extends Receptionist{
	static {
		System.out.println("===============================================================");
		System.out.println("\t\t\tReceptionistManagement");
		System.out.println("===============================================================");
	}
	public static void repOperations(Scanner input,Scanner str) {
		System.out.println("Enter which you want to manage: ");
		System.out.println("a:add u:update d:delete s:search v:view b:back e:exit");
		
		char c=str.nextLine().charAt(0);
		switch (c) {
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
			case 'e':	System.out.println("\t\t\tThank you for visiting");
						break;
			case 'b':	AdminActivity.adminActivity(input, str);
						break;
			default:	System.out.println("Enter valid option");
						repOperations(input, str);
						break;
		}
	}
	public static void add(Scanner input,Scanner str) {
		System.out.print("Enter Receptionist Name: ");
		String name=str.nextLine();
		receptionistNames.add(name);
	
		System.out.print("Enter psswd: ");
		String psswd=str.nextLine();
		receptionistPsswds.add(psswd);
		
		ReceptionistDAOImpl.insert(name, psswd);
		
		System.out.println("\t\t\tSuccessfully added\n");
		
		ReceptionistManagement.repOperations(input, str);
	}
	public static void delete(Scanner input, Scanner str) {
		System.out.print("Enter Receptionist Name to remove: ");

		String name = str.nextLine();
		if (receptionistNames.contains(name)) {
			String psswd = receptionistPsswds.elementAt(receptionistNames.indexOf(name));
			
			receptionistPsswds.remove(receptionistNames.indexOf(name));
			
			receptionistNames.remove(name);
			
			ReceptionistDAOImpl.delete(name, psswd);
			
			System.out.println("\t\t\tSuccessfully removed\n");
			
			ReceptionistManagement.repOperations(input, str);
		} else {
			System.out.println("Enter valid name");
			delRepeat(input, str);
		}

	}

	private static void delRepeat(Scanner input, Scanner str) {
		System.out.println("Press c:continue b:back e:exit");
		char c=str.nextLine().charAt(0);
		switch (c) {
			case 'c':   delete(input, str);
						break;
			case 'b':   ReceptionistManagement.repOperations(input, str);
						break;
			case 'e':	System.out.println("\t\t\tThank you for visiting");
						break;
			default:    System.out.println("Enter valid option");
						delRepeat(input, str);
						break;
		}
	}
	public static void search(Scanner input,Scanner str) {
		System.out.print("Enter name of Receptionist: ");
		String name=str.nextLine();
		if(receptionistNames.contains(name)) {
			System.out.println("It is present");
			System.out.println("Location: "+receptionistNames.indexOf(name));
			System.out.println("psswd is: "+receptionistPsswds.elementAt(receptionistNames.indexOf(name)));
			ReceptionistManagement.repOperations(input, str);
		} else {
			System.out.println("It is not in records \nPlease check the name");
			serRepeat(input, str);
		}
	}

	private static void serRepeat(Scanner input, Scanner str) {
		System.out.println("Press c:continue b:back e:exit");
		char c=str.nextLine().charAt(0);
		switch (c) {
			case 'c':   search(input, str);
						break;
			case 'b':   ReceptionistManagement.repOperations(input, str);
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
		String name = str.nextLine();
		if (receptionistNames.contains(name)) {
			
			System.out.print("Enter the new name to change: ");
			String newName = str.nextLine();

			receptionistNames.setElementAt(newName, receptionistNames.indexOf(name));

			System.out.print("Enter new passwd: ");

			String newPsswd = str.nextLine();

			receptionistPsswds.setElementAt(newPsswd, receptionistNames.indexOf(newName));

			ReceptionistDAOImpl.update(name, newName, newPsswd);

			System.out.println("\tSuccessfull");

			upRepeat(input, str);

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
			case 'b':   ReceptionistManagement.repOperations(input, str);
						break;
			case 'e':	System.out.println("\t\t\tThank you for visiting");
						break;
			default:    System.out.println("Enter valid option");
						upRepeat(input, str);
						break;		
		}
	}
	public static void view(Scanner input, Scanner str) {
		System.out.println("The Receptionists present in the records are: "+receptionistNames);
		System.out.println("There psswds: "+receptionistPsswds);
		viewRepeat(input, str);
		
	}

	private static void viewRepeat(Scanner input, Scanner str) {
		System.out.println("Press b:back e:exit");
		char c=str.nextLine().charAt(0);
	
		switch (c) {
			case 'b':   ReceptionistManagement.repOperations(input, str);
						break;
			case 'e':	System.out.println("\t\t\tThank you for visiting");
						break;
			default:    System.out.println("Enter valid option");
						viewRepeat(input, str);
						break;
		}
	}

}
