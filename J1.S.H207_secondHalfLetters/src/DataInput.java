
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

    public int secondHalfLetters(String stringInput) {
        stringInput = stringInput.toLowerCase();
        int count = 0;

        for (int i = 0; i < stringInput.length(); i++) {
            if (Character.isAlphabetic(stringInput.charAt(i)) && stringInput.charAt(i) >= 'n') {
                System.out.print("\"" + stringInput.charAt(i) + "\" ");
                count++;
            }
        }
        return count;
    }
}
