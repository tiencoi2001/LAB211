
import java.util.List;
import java.util.Scanner;
import entity.Employee;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

        // loop until have valid choice were inputted
        while (true) {
            String raw = scanner.nextLine().trim();
            raw = raw.replace("\\s+", "");
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

    public String inputID(List<Employee> employee) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID: ");
        // loop until have valid name were inputted
        while (true) {
            String id = scanner.nextLine().trim();
            id = id.replace("\\s+", "");
            if (!id.isEmpty()) { // not empty ~> next condition
                if (checkID(id)) {//not special character ~> next condition
                    if (!isDuplicatedID(id, employee)) { // not duplicate ~> finish
                        return id;
                    } else {
                        System.out.print("ID is already in use "
                                + " please enter another ID: ");
                    }
                } else {
                    System.out.print("ID unvalible, enter again: ");
                }
            } else { // empty string ~> display error & re-enter
                System.out.print("ID can not empty, enter again: ");
            }
        }
    }

    private boolean checkID(String id) {
        for (int i = 0; i < id.length(); i++) {
            if ((id.charAt(i) < '0' || id.charAt(i) > '9')
                    && (id.charAt(i) < 'a' || id.charAt(i) > 'z')
                    && (id.charAt(i) < 'A' || id.charAt(i) > 'Z')) {
                return false;
            }
        }
        return true;
    }

    private boolean isDuplicatedID(String id, List<Employee> employee) {
        for (Employee em : employee) {
            if (em.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public String inputExistedID(List<Employee> employee) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Employee ID: ");
        // loop until have valid choice were inputted
        while (true) {
            String id = scanner.nextLine().trim();
            if (!id.isEmpty()) { // not empty ~> check next condition               
                if (isDuplicatedID(id, employee)) {
                    return id;
                } else {
                    System.out.print("ID not found, enter again: ");
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
            if (!string.isEmpty()) { // not empty ~> finish
                return upperCaseFirstChar(string);
            } else { // empty string ~> display error & re-enter
                System.out.print(name + " can not empty, enter again: ");
            }
        }
    }

    public String inputName(String name) {
        Scanner scanner = new Scanner(System.in);

        System.out.print(name + ": ");
        // loop until have valid name were inputted
        while (true) {
            String string = scanner.nextLine().trim();
            if (!string.isEmpty()) { // not empty ~> check next condition
                if (isValidStringLetter(string)) {
                    return upperCaseFirstChar(string);
                } else {
                    System.out.print(name + "can not contain special "
                            + "characters or digits, enter again: ");
                }
            } else { // empty string ~> display error & re-enter
                System.out.print(name + "can not empty, enter again: ");
            }
        }
    }

    private boolean isValidStringLetter(String name) {
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true;
//        Pattern p = Pattern.compile("^[a-zA-Z\\s]+$");
//        return p.matcher(name).find();
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
        for (String string : strA) {

        }
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

    public String inputPhone() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Phone number: ");
        // loop until have valid phone number were inputted
        while (true) {
            String raw = scanner.nextLine().trim();
            if (!raw.isEmpty()) { // not empty ~> check next condition
                if (checkPhone(raw)) {
                    return raw;
                }
            } else { // empty string ~> display error & re-enter
                System.out.print("Phone number can not empty, enter again: ");
            }
        }
    }

    private boolean checkPhone(String stringPhone) {
        Pattern p = Pattern.compile("^[0-9]{11,20}$");
        String s = stringPhone.substring(1);
        if (stringPhone.charAt(0) == '+') {
            if (s.isEmpty()) {
                System.out.print("Phone number can not empty, enter again: ");
                return false;
            }
            if (p.matcher(s).find()) {
                return true;
            } else {
                System.out.print("Phone must a string of numbers and has 11-20 digits, enter again: ");
                return false;
            }
        } else {
            System.out.print("Phone number must start by '+', enter again: ");
            return false;
        }
    }

    public String inputEmail() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Email: ");
        // loop until have valid name were inputted
        while (true) {
            String string = scanner.nextLine().trim();
            string = string.replace("\\s+", " ");
            Pattern p = Pattern.compile("^[a-z0-9A-Z]+@[a-zA-Z]+(\\.[a-zA-Z]+){1,3}+$");
            if (!string.isEmpty()) { // not empty ~> finish
                if (p.matcher(string).find()) {
                    return string;
                } else {
                    System.out.print("Email must in format "
                            + "Local-Part(name(.name2)@Domain(domain.something(.domain2.domain3))(max 3 '.'), enter again: ");
                }
            } else { // empty string ~> display error & re-enter
                System.out.print("Email can not empty, enter again: ");
            }
        }
    }

    public String inputSearchValue() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter search keywords: ");
        // loop until have valid name were inputted
        while (true) {
            String string = scanner.nextLine().trim();
            string = string.replace("\\s+", " ");
            if (!string.isEmpty()) { // not empty ~> finish

                return string;
            } else { // empty string ~> display error & re-enter
                System.out.print("String can not empty, enter again: ");
            }
        }
    }

    public Date inputDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Date of birth: ");
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
                    System.out.print("Date of birth must in format dd/MM/yyyy, enter again: ");
                }
            } else { // empty string ~> display error & re-enter
                System.out.print("Date of birth can not empty, enter again: ");
            }
        }
    }

    public String inputSex() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Sex: ");
        // loop until have valid sex were inputted
        while (true) {
            String s = scanner.nextLine();
            s = s.replaceAll("\\s", " ");
            if (!s.isEmpty()) {
                if (isValidStringLetter(s)) {
                    if (s.toLowerCase().equals("male")
                            || s.toLowerCase().equals("female")) {
                        return upperCaseFirstChar(s);
                    } else {
                        System.out.print("Gender must be male or female, enter again: ");
                    }
                } else {
                    System.out.print("Gender can not contain special "
                            + "characters or digits, enter again: ");
                }
            } else {
                System.out.print("Gender can not empty, enter again: ");
            }
        }
    }

    public double inputSalary() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Salary: ");
        // loop until have valid choice were inputted
        while (true) {
            String raw = scanner.nextLine().trim();
            if (!raw.isEmpty()) { // not empty ~> check next condition
                try {
                    double price = Double.parseDouble(raw);
                    if (price > 0) {
                        return price;
                    } else {
                        System.out.print("Salary must more than 0, enter again: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Salary must be a numberical value, enter again: ");
                }
            } else { // empty string ~> display error & re-enter
                System.out.print("Salary can not empty, enter again: ");
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
