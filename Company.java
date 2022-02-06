package com.company;
/* @author Chaya Chrein
   @description Company creates a basis for the medical company and the insurance company.
   It also stores and invoice start and current number to keep track when creating invoices and the same for patients.
* */
public class Company {
	
	public String name;
	public String address;
	public String phone;
	private static int invoiceStartNumber=100000;
	private static int currInvNum;
	private int IDStartNumber=1000;
	private static int currIDNum;
	
	
	public Company(String n, String a, String p) {
		name=n;
		address=a;
		phone=p;
		currInvNum=invoiceStartNumber;
		currIDNum=IDStartNumber;
	}
	
	public static int getISN() {
		return invoiceStartNumber;
	}
	
	public static int getCInvN() {
		return currInvNum;
	}
	
	public static void setCInvN(int cin) {
		currInvNum = cin;
	}
	
	public static int getCIDN() {
		return currIDNum;
	}
	
	public static void setCIDN(int cIDn) {
		currIDNum = cIDn;
	}
	
	
}
