package com.hospital.common;

import java.util.Scanner;

public class Hospital {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		Scanner str=new Scanner(System.in);
		System.out.println("===============================================================");
		System.out.println("\t\t\tWelcome To Hospital");		
		System.out.println("===============================================================");
		displayScreen(input, str);
	}

	public static void displayScreen(Scanner input, Scanner str) {
		char c;
		System.out.println("Enter which ID you want to login:"); 
		System.out.println("a:Admin d:Doctor r:Receptionist e:exit");
		c=str.nextLine().charAt(0);
		switch (c) {
			case 'a':	Admin.adminVerify(input,str);
						break;
			case 'd':	Doctor.docVerify(input,str);
						break;
			case 'r':	Receptionist.repVerify(input,str);
						break;
			case 'e':	System.out.println("\t\t\tThank you for visiting");
						break;
			default:	System.out.println("Enter valid option");
						displayScreen(input, str);
						break;
		}
	}
	
}
