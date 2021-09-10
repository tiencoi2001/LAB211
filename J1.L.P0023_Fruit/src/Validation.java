
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Vu Duc Tien
 */
public class Validation {

    public static Scanner in = new Scanner(System.in);

    public static int inputInt(String p) {
        String tmp;
        int i = 0;

        do {
            System.out.print(p);
            try {
                tmp = in.nextLine();
                if (Integer.parseInt(tmp) == Integer.parseInt(tmp)) {
                    i = Integer.parseInt(tmp);
                    if (i <= 0) {
                        System.err.println("Quantity must bigger than 0! Re-enter.");
                        continue;
                    } else {
                        break;
                    }
                }
                break;
            } catch (Exception e) {
                System.err.print("Quantity must be a positive integer, enter again.\n");
            }
        } while (true);
        return i;
    }

    public static double inputDouble(String p) {
        String tmp;
        double d = 0;

        do {
            System.out.print(p);
            try {
                tmp = in.nextLine();
                if (Double.parseDouble(tmp) == Double.parseDouble(tmp)) {
                    d = Double.parseDouble(tmp);
                    if (d <= 0) {
                        System.err.println("Price must bigger than 0! Re-enter.");
                        continue;
                    } else {
                        break;
                    }
                }
                break;
            } catch (Exception e) {
                System.err.print("Price is real number, enter again.\n");
            }
        } while (true);
        return d;
    }
    
    public static boolean isLetter(String p) {
        boolean check = true;
        for (int i = 0; i < p.length(); i++) {
            if (!Character.isLetter(p.charAt(i))) {
                check = false;
            }
        }
        return check;
    }

    public static boolean isDigit(String p) {
        boolean check = true;
        for (int i = 0; i < p.length(); i++) {
            if (!Character.isDigit(p.charAt(i))) {
                check = false;
            }
        }
        return check;
    }

    public static boolean isAlphanumeric(String p) {

        boolean check = true;
        for (int i = 0; i < p.length(); i++) {
            if (!Character.isDigit(p.charAt(i)) && !Character.isLetter(p.charAt(i))) {
                check = false;
            }
        }
        return check;
    }

    public static boolean checkYesNo(String tmp) {
        while (true) {
            System.out.print(tmp);
            String s = in.nextLine();
            s = s.replaceAll(" ", "");
            if (s.compareToIgnoreCase("yes") == 0 || s.compareToIgnoreCase("y") == 0) {
                return true;
            }
            if (s.compareToIgnoreCase("no") == 0 || s.compareToIgnoreCase("n") == 0) {
                return false;
            }
            System.err.print("You must choose Yes(Y) or No(N)!\n");
        }
    }

    public static String inputName(String s) {

        String name = "";
        String str = "";
        do {
            System.out.print(s);
            name = in.nextLine();
            if (name.isEmpty()) {
                System.err.println("You must enter your name! Re-enter.");
            } else {
                if (isLetter(name) || name.contains(" ")) {
                    name = name.replaceAll("\\s+", " ").trim();
                    str = str + Character.toUpperCase(name.charAt(0));
                    for (int i = 1; i < name.length(); i++) {
                        if (name.charAt(i) == ' ') {
                            str = str + name.charAt(i) + Character.toUpperCase(name.charAt(i + 1));
                            i++;
                        } else {
                            str = str + Character.toLowerCase(name.charAt(i));
                        }
                    }
                    break;
                } else {
                    System.err.println("Name must be letter! Re-enter.");
                }
            }
        } while (true);
        return str;
    }

    public static String inputNameProduct(String s) {
        String name = "";
        String str = "";
        do {
            System.out.print(s);
            name = in.nextLine();
            if (name.isEmpty()) {
                System.err.println("You must enter your name! Re-enter.");
            } else {
                if (isAlphanumeric(name) || name.contains(" ")) {
                    name = name.replaceAll("\\s+", " ").trim();
                    str = str + Character.toUpperCase(name.charAt(0));
                    for (int i = 1; i < name.length(); i++) {
                        if (name.charAt(i) == ' ') {
                            str = str + name.charAt(i) + Character.toUpperCase(name.charAt(i + 1));
                            i++;
                        } else {
                            str = str + Character.toLowerCase(name.charAt(i));
                        }
                    }
                    break;
                } else {
                    System.err.println("Product name invalid! Re-enter.");
                }
            }
        } while (true);
        return str;
    }

    public static String inputID(String s) {
        while (true) {
            System.out.print(s);
            String id = in.nextLine();
            if (isAlphanumeric(id)) {
                return id;
            } else {
                System.err.println("ID must be Alphanumeric! Re-enter.");
            }
        }
    }
}

