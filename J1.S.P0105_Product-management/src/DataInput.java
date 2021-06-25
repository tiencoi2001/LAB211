
import entity.Product;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
public class DataInput {

    public int inputChoice(int min, int max) {
        Scanner scanner = new Scanner(System.in);

        // loop until have valid choice were inputted
        while (true) {
            String raw = scanner.nextLine().trim();
            if (!raw.isEmpty()) { // not empty ~> check next condition
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
            } else { // empty string ~> display error & re-enter
                System.out.print("Choice can not empty, enter again: ");
            }
        }
    }

    public String inputStorekeeperName() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Storekeeper name: ");
        // loop until have valid name were inputted
        while (true) {
            String name = scanner.nextLine().trim();
            if (!name.isEmpty()) { // not empty ~> check next condition
                if (isValidName(name)) {
                    return upperCaseFirstChar(name);
                } else {
                    System.out.print("Shopkeeper name can not contain special "
                            + "characters or digits, enter again: ");
                }
            } else { // empty string ~> display error & re-enter
                System.out.print("Name can not empty, enter again: ");
            }
        }
    }

    public int inputID() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Product ID: ");
        // loop until have valid choice were inputted
        while (true) {
            String raw = scanner.nextLine().trim();
            if (!raw.isEmpty()) { // not empty ~> check next condition
                try {
                    int id = Integer.parseInt(raw);
                    return id;
                } catch (NumberFormatException e) {
                    System.out.print("ID must be an integer, enter again: ");
                }
            } else { // empty string ~> display error & re-enter
                System.out.print("ID can not empty, enter again: ");
            }
        }
    }

    public int inputExistedID(List<Product> products) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Product ID: ");
        // loop until have valid choice were inputted
        while (true) {
            String raw = scanner.nextLine().trim();
            if (!raw.isEmpty()) { // not empty ~> check next condition
                try {
                    int id = Integer.parseInt(raw);
                    if (isDuplicatedID(id, products)) {
                        return id;
                    } else {
                        System.out.print("ID not found, enter again: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("ID must be an integer, enter again: ");
                }
            } else { // empty string ~> display error & re-enter
                System.out.print("ID can not empty, enter again: ");
            }
        }
    }

    public String inputString(String name) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(name + ": ");
        // loop until have valid name were inputted
        while (true) {
            String string = scanner.nextLine().trim();
            if (!string.isEmpty()) { // not empty ~> finish;
                return upperCaseFirstChar(string);
            } else { // empty string ~> display error & re-enter
                System.out.print(name + " can not empty, enter again: ");
            }
        }
    }

    private String upperCaseFirstChar(String stringInput) {
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

    public double inputPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Price: ");
        // loop until have valid choice were inputted
        while (true) {
            String raw = scanner.nextLine().trim();
            if (!raw.isEmpty()) { // not empty ~> check next condition
                try {
                    double price = Double.parseDouble(raw);
                    if (price > 0) {
                        return price;
                    } else {
                        System.out.print("Price must more than 0, enter again: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Price must be a numberical value, enter again: ");
                }
            } else { // empty string ~> display error & re-enter
                System.out.print("Price can not empty, enter again: ");
            }
        }
    }

    public Date inputExpDate() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Expiry Date: ");
        // loop until have valid name were inputted
        while (true) {
            String raw = scanner.nextLine().trim();
            if (!raw.isEmpty()) { // not empty ~> check next condition
                // 35-2
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date date = sdf.parse(raw);  // 7-3
                    String result_str = sdf.format(date);
                    if (result_str.equals(raw)) {
                        return date;
                    } else {
                        System.out.print("Please enter a right date, enter again: ");
                    }
                } catch (ParseException e) {
                    System.out.print("Expiry Date must in format dd/MM/yyyy, enter again: ");
                }
            } else { // empty string ~> display error & re-enter
                System.out.print("Expiry Date can not empty, enter again: ");
            }
        }
    }

    public Date inputManufactureDate(Date expDate) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Manufacture date: ");
        // loop until have valid name were inputted
        while (true) {
            String raw = scanner.nextLine().trim();
            if (!raw.isEmpty()) { // not empty ~> check next condition
                // 35-2
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date date = sdf.parse(raw);  // 7-3
                    String result_str = sdf.format(date);
                    if (result_str.equals(raw)) {
                        if (date.before(expDate)) {
                            return date;
                        } else {
                            System.out.print("Manufacture date must before "
                                    + "expiry date, enter again: ");
                        }
                    } else {
                        System.out.print("Please enter a right date, enter again: ");
                    }
                } catch (Exception e) {
                    System.out.print("Manufacture date must in format dd/MM/yyyy, enter again: ");
                }
            } else { // empty string ~> display error & re-enter
                System.out.print("Manufacture date can not empty, enter again: ");
            }
        }
    }

    public Date inputReceiptDate(Date manuDate, Date expDate) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Receipt date: ");
        // loop until have valid name were inputted
        while (true) {
            String raw = scanner.nextLine().trim();
            if (!raw.isEmpty()) { // not empty ~> check next condition
                // 35-2
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date date = sdf.parse(raw);  // 7-3
                    String result_str = sdf.format(date);
                    if (result_str.equals(raw)) {
                        if (date.after(manuDate) && date.before(expDate)) {
                            return date;
                        } else {
                            System.out.println("Receipt date must "
                                    + "after manufacture date and before expiry date");
                        }
                    } else {
                        System.out.print("Please enter a right date, enter again: ");
                    }
                } catch (ParseException e) {
                    System.out.print("Receipt date must in format dd/MM/yyyy, enter again: ");
                }
            } else { // empty string ~> display error & re-enter
                System.out.print("Receipt date can not empty, enter again: ");
            }
        }
    }

    private boolean isValidName(String name) {
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }

    private boolean isDuplicatedID(int id, List<Product> products) {
        for (Product p : products) {
            if (p.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public String EoD() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your choice: ");
        // loop until have valid name were inputted
        while (true) {
            String string = scanner.nextLine().trim();
            if (!string.isEmpty() && (string.equalsIgnoreCase("e") || (string.equalsIgnoreCase("d")))) { // not empty + satisfy conditions  ~> finish
                return string;
            } else { // empty string ~> display error & re-enter
                System.out.print("Choice can not empty, enter again: ");
            }
        }
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
