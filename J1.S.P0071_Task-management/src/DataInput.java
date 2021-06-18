
import entity.Task;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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

    public String getType() {
        boolean isStop = false;
        String result = null;
        while (!isStop) {
            System.out.print("Task Type: ");
            int choice = inputInt();
            switch (choice) {
                case 1:
                    return result = "Code";
                case 2:
                    return result = "Test";
                case 3:
                    return result = "Manager";
                case 4:
                    return result = "Learn";
                default:
                    System.out.println("Invalid type");
                    break;
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

    public Date inputDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Date: ");
        while (true) {
            String raw = scanner.nextLine().trim();
            if (!raw.isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date date = sdf.parse(raw);
                    String result_str = sdf.format(date);
                    if (result_str.equals(raw)) {
                        return date;
                    } else {
                        System.out.print("Please enter a right date, enter again: ");
                    }
                } catch (ParseException e) {
                    System.out.print("Date must in format dd/MM/yyyy, enter again: ");
                }
            } else {
                System.out.print("Date can not empty, enter again: ");
            }
        }
    }

    public double inputPlanFrom() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("From: ");
        while (true) {
            String planFrom = scanner.nextLine().trim();
            planFrom = planFrom.replaceAll("\\s+", "");
            if (planFrom.isEmpty()) {
                System.out.print("Start can not empty, enter again: ");
            } else {
                Pattern p = Pattern.compile("^\\d{1,2}\\.5|\\d{1,2}\\.0$$");
                if (p.matcher(planFrom).find()) {
                    try {
                        double time = Double.parseDouble(planFrom);
                        if (time >= 8 && time <= 17) {
                            return time;
                        } else {
                            System.out.print("Start time must be between 8 and 17, enter again: ");
                        }
                    } catch (Exception e) {
                        System.out.print("Start time must be a numberical value, enter again: ");
                    }
                } else {
                    System.out.print("Start time must in format hh.0 or hh.5, enter again: ");
                }
            }

        }
    }

    public double inputPlanTo(double planFrom) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("To: ");
        while (true) {
            String planTo = scanner.nextLine().trim();
            planTo = planTo.replaceAll("\\s+", "");
            if (planTo.isEmpty()) {
                System.out.print("Start can not empty, enter again: ");
            } else {
                Pattern p = Pattern.compile("^\\d{1,2}\\.5|\\d{1,2}\\.0$");
                if (p.matcher(planTo).find()) {
                    try {
                        double time = Double.parseDouble(planTo);
                        if (time > planFrom && time <= 17.5) {
                            return time;
                        } else {
                            System.out.print("End time must be between 8.5 and 17.5, enter again: ");
                        }
                    } catch (Exception e) {
                        System.out.print("End time must be a numberical value, enter again: ");
                    }
                } else {
                    System.out.print("End time must in format hh.0 or hh.5, enter again: ");
                }
            }

        }
    }

    public int inputExistedID(List<Task> list) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Task ID: ");
        while (true) {
            int id = inputInt();
            if (isDuplicatedID(id, list)) {
                return id;
            } else {
                System.out.print("ID not found, enter again: ");
            }
        }
    }

    private boolean isDuplicatedID(int id, List<Task> list) {
        for (Task t : list) {
            if (t.getId() == id) {
                return true;
            }
        }
        return false;
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
