
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
    public int inputInterger(String mes,int min, int max) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(mes);
        
        while (true) {
            String raw = scanner.nextLine().trim();
            if (!raw.isEmpty()) {
                try {
                    int choice = Integer.parseInt(raw);
                    if (choice >= min && choice <= max) {
                        return choice;
                    } else {
                        System.out.print("Number must in range [" + min + "-"
                                + max + "], enter again: ");
                    }
                } catch (NumberFormatException e) {
                    System.out.print("Number must be an integer, enter again: ");
                }
            } else {
                System.out.print("Number can not empty, enter again: ");
            }
        }
    }
    
    public int[] inputArray(int n) {
        DataInput in = new DataInput();
        System.out.println("Enter elements of Array: ");
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.inputInterger("arr[" + i + "] = ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        return arr;
    }
}
