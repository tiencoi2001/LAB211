
import java.math.BigInteger;
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
public class ChangeBaseProgram {

    public void displayChangeDecToBin() {
        DataInput in = new DataInput();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number you want to convert: ");
        while (true) {
            String number = in.inputString();
            if (in.checkBigInteger(number)) {
                String output = changeFromDecToBase(number, 2);
                System.out.println("Number " + number + " in decimal after convert to binary: " + output);
                break;
            }
            System.out.print("Number you entered isn't decimal number, enter again: ");
        }
    }

    public void displayChangeBinToDec() {
        DataInput in = new DataInput();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number you want to convert: ");
        while (true) {
            String number = in.inputString();
            if (in.checkBin(number)) {
                String output = changeFromBaseToDec(2, number);
                System.out.println("Number " + number + " in binary after convert to decimal: " + output);
                break;
            }
            System.out.print("Number you entered isn't binary number, enter again: ");
        }
    }

    public void displayChangeDecToHex() {
        DataInput in = new DataInput();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number you want to convert: ");
        while (true) {
            String number = in.inputString();
            if (in.checkBigInteger(number)) {
                String output = changeFromDecToBase(number, 16);
                System.out.println(output);
                break;
            }
            System.out.print("Number you entered isn't decimal number, enter again: ");
        }
    }

    public void displayChangeHexToDec() {
        DataInput in = new DataInput();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number you want to convert: ");
        while (true) {
            String number = in.inputString();
            if (in.checkBin(number)) {
                String output = changeFromBaseToDec(16, number);
                System.out.println("Number " + number + " in hex after convert to decimal: " + output);
                break;
            }
            System.out.print("Number you entered isn't hex number, enter again: ");
        }
    }

    public void displayChangeBinToHex() {
        DataInput in = new DataInput();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number you want to convert: ");
        while (true) {
            String number = in.inputString();
            if (in.checkBin(number)) {
                String output = changeFromBaseToDec(2, number);
                output = changeFromDecToBase(output, 16);
                System.out.println("Number " + number + " in binary after convert to hex: " + output);
                break;
            }
            System.out.print("Number you entered isn't binary number, enter again: ");
        }
    }

    public void displayChangeHexToBin() {
        DataInput in = new DataInput();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number you want to convert: ");
        while (true) {
            String number = in.inputString();
            if (in.checkHex(number)) {
                String output = changeFromBaseToDec(16, number);
                output = changeFromDecToBase(output, 2);
                System.out.println("Number " + number + " in hex after convert to binary: " + output);
                break;
            }
            System.out.print("Number you entered isn't hex number, enter again: ");
        }
    }

    public String changeFromDecToBase(String dec, int baseInput) {
        BigInteger DEC = new BigInteger(dec);
        BigInteger zero = new BigInteger("0");
        BigInteger base = new BigInteger(Integer.toString(baseInput));
        String result = "";
        if (DEC.compareTo(zero) == 0) {
            result += "0";
        } else {
            while (DEC.compareTo(zero) != 0) {
                BigInteger remainder = DEC.mod(base);
                if (remainder.intValue() < 10) {
                    result = result + Integer.toString(remainder.intValue());
                } else {
                    switch (remainder.intValue()) {
                        case 10:
                            result += "A";
                            break;
                        case 11:
                            result += "B";
                            break;
                        case 12:
                            result += "C";
                            break;
                        case 13:
                            result += "D";
                            break;
                        case 14:
                            result += "E";
                            break;
                        case 15:
                            result += "F";
                            break;
                    }
                }
                DEC = DEC.divide(base);
            }
        }
        StringBuilder s = new StringBuilder(result);
        result = new String(s.reverse());
        return result;
    }

    public String changeFromBaseToDec(int base, String str) {
        String Letters = "0123456789ABCDEF";
        str = str.toUpperCase();
        BigInteger BASE = new BigInteger(Integer.toString(base));
        BigInteger dec = new BigInteger("0");
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int n = Letters.indexOf(ch);
            BigInteger a = new BigInteger(Integer.toString(n));
            dec = (dec.multiply(BASE)).add(a);
        }
        return dec.toString();
    }
}
