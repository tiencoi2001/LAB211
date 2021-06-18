
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

    public int inputSize() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String raw = scanner.nextLine().trim();
            try {
                int num = Integer.parseInt(raw);
                if (Integer.parseInt(raw) == Integer.parseInt(raw) && num > 0) {
                    return num;
                } else {
                    System.out.print("Size of matrix must bigger 0, enter again: ");
                }
            } catch (Exception e) {
                System.out.print("Size of matrix must bigger 0, enter again: ");
            }
        }
    }
}
