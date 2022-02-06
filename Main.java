package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        Company company = new Company("Medical Office", "123 123rd Street \nCity, NY 00012", "111-111-1111");
        MedProcedure mp = new MedProcedure("Strep Test", 25.00);
        Company insCompany = new Company("MY INSURANCE", "123 123rd Street \nCity, NY 00012", "222-222-2222");
        Patient p = new Patient("Chaya", "Chrein", "001001", insCompany);
        Appointment a = new Appointment("10/13/2021");
        a.addMP(mp);

        a.addMP(new MedProcedure("XRAY", (double) 100));
        p.addNote(a);
        Invoice i = new Invoice(company, p, "10/13/2021");

        //i.setPaid(true);

        i.printInvoice();

    }
}
