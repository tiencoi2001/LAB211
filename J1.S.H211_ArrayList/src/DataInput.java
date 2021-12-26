
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

    public int inputInt(String mess, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mess);
        while (true) {
            String raw = scanner.nextLine().trim();
            if (!raw.isEmpty()) {
                try {
                    int choice = Integer.parseInt(raw);
                    if (choice >= min && choice <= max) {
                        return choice;
                    } else {
                        System.out.print("Element must in range [" + min + "-"
                                + max + "], enter again: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Element must be an integer, enter again: ");
                }
            } else {
                System.out.print("Element can not empty, enter again: ");
            }
        }
    }
}
