
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
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataInput in = new DataInput();
        System.out.println("Enter string:");
        String str = sc.nextLine();

        if (!str.trim().isEmpty()) {
            System.out.print("String after reverse: ");
            in.printReverse(str);
        }
    }
}
