
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
        DataInput in = new DataInput();
        String str = in.inputString();
        int count = in.secondHalfLetters(str);
        System.out.println("");
        System.out.println("Number of letters in the string come from the second half of the alphabet: " + count);
    }
}
