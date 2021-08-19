/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author Hoang Tran
 */
public class DataInput {

    public String inputString() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string: ");
        while (true) {
            String string = scanner.nextLine().trim();
            if (!string.isEmpty()) {
                return string;
            } else {
                System.out.print("String can not empty, enter again: ");
            }
        }
    }

    public void printReverse(String stringInput) {
        String[] strA = stringInput.replaceAll("\\s+", " ").split(" ");
        String tmp = "";
        for (int i = strA.length - 1; i >= 0; i--) {
            tmp += strA[i];
            tmp += " ";
        }
        String result = tmp.substring(0, 1).toUpperCase() + tmp.substring(1);

        System.out.println(result.trim());
    }

    public boolean checkYesNo(String notification) {
        Scanner in = new Scanner(System.in);
        System.out.println(notification);
        System.out.print("Enter your choice: ");
        while (true) {
            String s = in.nextLine();
            if (!s.isEmpty()) {
                s = s.replaceAll(" ", "");
                if (s.compareToIgnoreCase("Y") == 0 || s.compareToIgnoreCase("y") == 0) {
                    return true;
                }
                if (s.compareToIgnoreCase("N") == 0 || s.compareToIgnoreCase("n") == 0) {
                    return false;
                }
                System.out.print("You must choose Yes(Y) or No(N)!\nEnter again: ");
            } else {
                System.out.print("Choice can not empty, enter again: ");
            }
        }
    }

}
