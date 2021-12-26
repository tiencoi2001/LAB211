/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Vu Duc Tien
 */
public class DataInput {

    public Date inputDate(String p, String pattern) {

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String tmp;

        System.out.print(p);

        while (true) {
            try {
                tmp = scanner.nextLine();
                String[] s = tmp.split("/");
                if (s[0].length() != 2 && pattern.equals("dd/MM/yyyy")) { // 5/12/2021 -> 05/12/2021
                    tmp = "0" + tmp;
                }
                if (!tmp.isEmpty()) {
                    Date date = sdf.parse(tmp);
                    if (tmp.equalsIgnoreCase(sdf.format(date))) {
                        return date;
                    } else {
                        System.err.print("Please enter a right date, enter again: ");
                    }
                } else {
                    System.err.print("Date can not be empty, Enter again: ");
                }
            } catch (ParseException e) {
                System.err.print("Format must be " + pattern + ", Enter again: ");
            }
        }
    }

}
