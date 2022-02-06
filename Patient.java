package com.company;

import com.company.Appointment;
import com.company.Company;

import java.util.ArrayList;
/* @author Chaya Chrein
   @description Patient class stores patient information specifically their name, ID for out database,
   insurance information, and an arraylist of appointments to store the information from each time they are seen.
* */
public class Patient {
	public String firstName;
	public String lastName;
	private int ID;
	private String insID;
	public Company insCompany;
	public ArrayList<Appointment> appointmentNotes = new ArrayList<Appointment>(10);
	
	public Patient(String fn, String ln, String insid, Company insComp) {
		firstName = fn;
		lastName = ln;
		setID(Company.getCIDN());
		Company.setCIDN(Company.getCIDN()+1);
		setInsID(insid);
		insCompany = insComp;
		}
	
	public void addNote(Appointment A) {
		(appointmentNotes).add(A);
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getInsID() {
		return insID;
	}

	public void setInsID(String insID) {
		this.insID = insID;
	}
}
