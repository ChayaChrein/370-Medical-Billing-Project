package com.company;
import com.company.Appointment;
import com.company.Company;

import javax.swing.*;
import java.util.Iterator;

/* @author Chaya Chrein
   @description Invoice class creates invoices for a company to send with a patient's appointment information
   from a specific date to an insurance company.
* */

public class Invoice {
	private boolean paid;
	public Company company;
	public Patient patient;
	public String date;
	public int invNumber;
	
	public Invoice(Company c, Patient p, String d) {
		paid = false;
		company = c;
		patient = p;
		date = d;
		invNumber = Company.getCInvN();
		Company.setCInvN(invNumber+1);	
	}

	//make sure appointment from that date exists for that patient
	public Appointment findAppt() {
		int i=0;
		while (i<patient.appointmentNotes.size()) {
			if (patient.appointmentNotes.get(i).date.equals(date)) return patient.appointmentNotes.get(i);
			i++;	
		}
		System.out.println ("No appointment on that date for specified patient.");
		return null;
	}
	
	public boolean isPaid() {
		return paid;
	}
	
	public boolean setPaid(boolean paid) {
		this.paid = paid;
		return paid;
	}
	
	public void printInvoice() {
		//print basic info
		StringBuilder printedInvoice = new StringBuilder();

		printedInvoice.append("INVOICE \n \n" + company.name + "\n" + company.address + "\n" + company.phone + "\n \n" +
				date + "\nInvoice #: " + invNumber +
				"\n \nBill to: \n" + patient.insCompany.name + "\n" + patient.insCompany.address + "\n" + patient.insCompany.phone + "\n \n" +
				"Regarding Patient: \n" + patient.firstName + " " + patient.lastName +
				"\n\nAppointment Details:\n");

//		System.out.print("INVOICE \n \n" + company.name + "\n" + company.address + "\n" + company.phone + "\n \n" +
//				date + "\ncom.company.Invoice #: " + invNumber +
//				"\n \nBill to: \n" + patient.insCompany.name + "\n" + patient.insCompany.address + "\n" + patient.insCompany.phone + "\n \n" +
//				"Regarding com.company.Patient: \n" + patient.firstName + " " + patient.lastName +
//				"\n\ncom.company.Appointment Details:\n");

//		//print medical procedures at that appointment
//		Appointment.MedProcIterator fi;
//		fi = (Appointment.MedProcIterator) Appointment.createIterator();
//		while (fi.hasNext()) {
//			MedProcedure medProc = (MedProcedure) fi.next();
//			if (medProc != null) System.out.print(medProc);
//		}

		Appointment.MedProcIterator fi;
		fi = (Appointment.MedProcIterator) Appointment.createIterator();
		while (fi.hasNext()) {
			MedProcedure medProc = (MedProcedure) fi.next();
			if (medProc != null) printedInvoice.append(medProc);
		}
		//print total fee and whether it's paid or not
		String status;
		if (paid==true) status = "PAID";
		else status = "DUE";
		printedInvoice.append("\n\nTotal: $" + (findAppt()).getTotalFee() + "\n\nPayment Status: "+ status);
//		//print total fee and whether it's paid or not
//		String status;
//		if (paid==true) status = "PAID";
//		else status = "DUE";
//		System.out.print("\n\nTotal: $" + (findAppt()).getTotalFee() + "\n\nPayment Status: "+ status);
		JFrame frame = new JFrame("MedPal");
		frame.setSize(200, 600);
		frame.setLocationRelativeTo(null);
		//frame.setVisible(true);
		JOptionPane.showMessageDialog(frame, printedInvoice.toString());
	}
}
