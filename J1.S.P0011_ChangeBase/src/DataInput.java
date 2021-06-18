
import java.util.Scanner;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Vu Duc Tien
 */
public class DataInput {

    public int inputChoice(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String raw = scanner.nextLine().trim();
            if (!raw.isEmpty()) {
                try {
                    int choice = Integer.parseInt(raw);
                    if (choice >= min && choice <= max) {
                        return choice;
                    } else {
                        System.out.print("Choice must in range [" + min + "-"
                                + max + "], enter again: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Choice must be an integer, enter again: ");
                }
            } else {
                System.out.print("Choice can not empty, enter again: ");
            }
        }
    }

    public String inputString() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String string = scanner.nextLine().trim();
            if (!string.isEmpty()) {
                return string.toUpperCase();
            } else {
                System.out.print("Number can not empty, enter again: ");
            }
        }
    }

    public boolean checkBigInteger(String input) {
        Pattern p = Pattern.compile("^[0-9]+$");
        if (p.matcher(input).find()) {
            return true;
        }
        return false;
    }

    public boolean checkBin(String input) {
        Pattern p = Pattern.compile("^[01]+$");
        if (p.matcher(input).find()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkHex(String input) {
        Pattern p = Pattern.compile("^[0-9ABCDEFabcdef]+$");
        if (p.matcher(input).find()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkYesNo() {
        Scanner in = new Scanner(System.in);
        System.out.println("Press \"Y\" if you want to keep taking action,"
                + " press \"N\" if you want to end the action.");
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
