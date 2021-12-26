/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;

/**
 *
 * @author Vu Duc Tien
 */
public class Main {

    public static void main(String[] args) {
        DataInput in = new DataInput();
        Date firstDate = in.inputDate("Please enter first date: ", "MMM/dd/yyyy"); // dec/12/2021
        Date secondDate = in.inputDate("Please enter second date: ", "dd/MM/yyyy");
        if (firstDate.after(secondDate)) {
            System.out.println("Date1 is after date2");
        } else if (firstDate.before(secondDate)) {
            System.out.println("Date1 is before date2");
        } else {
            System.out.println("Date1 and date2 is the same");
        }
    }
}
