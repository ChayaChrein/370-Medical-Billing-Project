package com.company;
/* @author Chaya Chrein
   @description Appointment has 2 fields: a date and an array of medical procedures performed on that
   day which makes it iterable
* */
import java.util.Iterator;

public class Appointment implements Iterable<MedProcedure> {
	
	String date;
	private static MedProcedure[] mp;

	public Appointment(String d) {
		date=d;
		mp = new MedProcedure[10];
	}//constructor
	
	public void addMP (MedProcedure m) {
		int i=0;
		while (mp[i] != null) i++;
		mp[i] = m;
	}//add a medical procedure
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		int i = 0;
		while (i < mp.length) {
			s.append(mp[i]);
		}
		return s.toString();
	}

	public double getTotalFee() {
		double total=0;
		int i=0;
		while (mp[i] != null) {
			total+=mp[i].fee;
			i++;
		}
			return total;
	}//returns total fee of appointment

				/* @description MedProcIterator implements the iterator interface and creates an iterator
				for MedProcedures and overrides the necessary methods
				* */
				public static class MedProcIterator<MedProcedure> implements Iterator<MedProcedure>{

					private int index;

					public MedProcIterator() {
						index = 0;
					}

					@Override
					public boolean hasNext() {
						return (mp[index] != null);
					}

					@Override
					public MedProcedure next() {
						return (MedProcedure) mp[index++];
					}
				}

	public static Iterator<MedProcedure> createIterator() {
		return new MedProcIterator<>();
	}

	@Override
	public Iterator<MedProcedure> iterator() {
		return new MedProcIterator();
	}
}
