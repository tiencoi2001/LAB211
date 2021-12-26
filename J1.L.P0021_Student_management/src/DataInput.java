
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author duy
 */
public class DataInput {

    public int inputChoice(int min, int max, String str) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(str + ": ");
        while (true) {
            String raw = scanner.nextLine().trim();
            if (!raw.isEmpty()) {
                try {
                    int choice = Integer.parseInt(raw);
                    if (choice >= min && choice <= max) {
                        return choice;
                    } else {
                        System.out.print(str + " must in range [" + min + "-"
                                + max + "], enter again: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print(str + " must be an integer, enter again: ");
                }
            } else {
                System.out.print(str + " can not empty, enter again: ");
            }
        }
    }

    public String inputString(String name) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(name + ": ");
        while (true) {
            String string = scanner.nextLine().trim();
            if (!string.isEmpty()) {
                return upperCaseFirstChar(string);
            } else {
                System.out.print(name + " can not empty, enter again: ");
            }
        }
    }

    private String upperCaseFirstChar(String stringInput) {
        if (stringInput.isEmpty()) {
            return null;
        }
        String[] strA = stringInput.replaceAll("\\s+", " ").trim().split(" ");
        if (stringInput.replaceAll(" ", "").isEmpty()) {
            return null;
        }
        String tmp = "";
        String result = "";
        for (String s : strA) {
            s = s.toLowerCase();
            if (s.length() == 1) {
                result = result + s.toUpperCase() + " ";
                continue;
            }
            tmp = s.substring(0, 1).toUpperCase() + s.substring(1) + " ";
            result += tmp;
        }
        return result.trim();
    }

    public String getCourseByChoice() {
        boolean isStop = false;
        String result = null;
        while (!isStop) {
            System.out.println("Course");
            System.out.println("1. Java");
            System.out.println("2. .Net");
            System.out.println("3. C/C++");
            int choice = inputChoice(1, 3, "Your choice");
            switch (choice) {
                case 1:
                    return result = "Java";
                case 2:
                    return result = ".Net";
                case 3:
                    return result = "C/C++";
            }
        }
        return null;
    }

    public int inputInt() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String raw = scanner.nextLine().trim();
            try {
                int num = Integer.parseInt(raw);
                if (Integer.parseInt(raw) == Integer.parseInt(raw)) {
                    return num;
                }
            } catch (Exception e) {
                System.out.print("You must enter number, enter again: ");
            }
        }
    }

    public boolean checkYesNo(String str) {
        Scanner in = new Scanner(System.in);
        System.out.println(str);
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

    public String UorD() {
        Scanner in = new Scanner(System.in);
        System.out.println("Press \"U\" if you want to update, press \"D\" if you want to delete.");
        System.out.print("Enter your choice: ");
        while (true) {
            String s = in.nextLine();
            if (!s.isEmpty()) {
                s = s.replaceAll(" ", "");
                if (s.equalsIgnoreCase("u") || s.equalsIgnoreCase("d")) {
                    return s;
                }
                System.out.print("You must choose Update(U) or Delete(D)!\nEnter again: ");
            } else {
                System.out.print("Choice can not empty, enter again: ");
            }
        }
    }
    
    public String ForS() {
        Scanner in = new Scanner(System.in);
        System.out.println("Press \"S\" if you want to find, press \"S\" if you want to sort.");
        System.out.print("Enter your choice: ");
        while (true) {
            String s = in.nextLine();
            if (!s.isEmpty()) {
                s = s.replaceAll(" ", "");
                if (s.equalsIgnoreCase("f") || s.equalsIgnoreCase("s")) {
                    return s;
                }
                System.out.print("You must choose Find(F) or Sort(S)!\nEnter again: ");
            } else {
                System.out.print("Choice can not empty, enter again: ");
            }
        }
    }
}
