package com.company;
/* @author Chaya Chrein
   @description MedProcedure stores details of what was done at a given appointment
   with the name of the procedure and the charge for it.
* */
public class MedProcedure {
	
	String name;
	Double fee;
	
	public MedProcedure(String n, Double f) {
		name=n;
		fee=f;
	}
	
	public String toString() {
		return name + " ....... $" + fee + "\n"; 
	}
}
