package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Duc Ky
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation{   public static Scanner in = new Scanner(System.in);
    /**
     * Check if input is String or not
     * @param message
     * @return 
     */
    public static String inputString(String p, boolean canNull){
        String s = "";
        System.out.print(p);
        do{
            s = in.nextLine();
            if (canNull == true && s.isEmpty()) return null; 
            if (!s.replaceAll("\\s+", "").isEmpty())
                break;
            else System.err.print("Invalid input, enter again: "); 
        }while(true);
        return s;
    }
    /**
     * Check if input is int or not
     * @param message
     * @return 
     */
    public static Integer inputInt(String p){
        String tmp;
        int i = 0;
        System.out.print(p);
        do{
            try{
                tmp = in.nextLine();
                if (tmp.replaceAll(" ", "").trim().isEmpty()){
                    return null;
                }
                if (Integer.parseInt(tmp) == Integer.parseInt(tmp)){
                    i = Integer.parseInt(tmp);
                }
                break;
            }catch(Exception e){
                System.err.print("Invalid input, enter again: ");
            }
        }while(true);
        return i;
    }
    /**
     * Check if input is double or not
     * @param message
     * @return 
     */
    public static double inputDouble(String p){
        String tmp;
        double d = 0;
        System.out.print(p);
        do{
            try{
                tmp = in.nextLine();
                if (Double.parseDouble(tmp) == Double.parseDouble(tmp)){
                    d = Double.parseDouble(tmp);
                }
                break;
            }catch(Exception e){
                System.err.print("Invalid input, enter again: ");
            }
        }while(true);
        return d;
    }
    /**
     * Check if input is boolean or not
     * @param message
     * @return 
     */
    public static boolean inputBoolean(String p){
        String tmp;
        boolean b = true;
        System.out.print(p);
        do{
            try{
                tmp = in.nextLine();
                if (Boolean.parseBoolean(tmp) == Boolean.parseBoolean(tmp)){
                    b = Boolean.parseBoolean(tmp);
                }
                break;
            }catch(Exception e){
                System.err.print("Invalid input, enter again: ");
            }
        }while(true);
        return b;
    }
    /**
     * Check if input is char or not
     * @param message
     * @return 
     */
    public static char inputChar(String p){
        System.out.print(p);
        String c;
        while(true){
            c = in.nextLine();
            if (c.length() == 1){
                return c.charAt(0);
            }else{
                System.err.print("Invalid input, enter again: ");
            }
        }
    }
    /**
     * Check if input date is valid or not
     * @param message
     * @param format date
     * @return 
     */
    public static String inputDate(String p, String pattern){
        System.out.print(p);
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date date = new Date();
        String tmp;
        while(true){
            try{
                tmp = in.nextLine();
                date = sdf.parse(tmp);
                if (tmp.equals(sdf.format(date))){
                    return tmp;
                }else{
                    System.err.print("Invalid input, enter again: ");
                }
            }catch(Exception e){
                System.err.print("Invalid input, enter again: ");
            }
        }
    } 
    /**
     * return 0 is not a positive number
     * return 1 is integer number
     * return 2 is double number
     * @param num
     * @return 
     */
    public static int isPositiveNumber(String num){
        boolean result = false;
        double numDouble = 0;
        int numInt = 0;
        try{
            if (Integer.parseInt(num) == Integer.parseInt(num)){
                numInt = Integer.parseInt(num);
                if (numInt < 0){
                    System.err.println("The number must be positive!");
                    return 0;
                }
                return 1;
            }
            if (Double.parseDouble(num) == Double.parseDouble(num)){
                numDouble = Double.parseDouble(num);
                if (numDouble < 0){
                    System.err.println("The number must be positive!");
                    return 0;
                }
                return 2;
            }
            
            if (numDouble < 0 || numInt < 0){
                System.err.println("The number must be positive!");
                return 0;
            }
        }catch(NumberFormatException e){
            System.err.println("Invalid input! Please enter number!");
            return 0;
        }
        return 0;
    }
    
    public static Integer inputIntLimit(int first, int end){
        Integer input;
        
        while(true){
            input = inputInt("");
            if (input == null) return null;
            if (first <= input && input <= end){
                return input;
            }else{
                if (first != end) System.err.printf("Enter a integer number from %d to %d: ", first, end);
                else System.err.printf("A integer valiable is %d! Enter again: ", first);
            }
        }
    }
    public static boolean checkYesNo(String tmp){
        System.out.print(tmp);

        boolean check = false;
        while(true){
            String s = in.nextLine();
            s.replaceAll(" ", "");
            if (s.compareToIgnoreCase("yes") == 0 || s.compareToIgnoreCase("y") == 0){
                return true;
            }
            if (s.compareToIgnoreCase("no") == 0 || s.compareToIgnoreCase("n") == 0){
                return false;
            }
            System.err.print("Invalid input! Enter again: ");
        }
    }
        
    public static String beautyName(String stringInput){
        if (stringInput.isEmpty()) return null;
        String [] strA = stringInput.replaceAll("\\s+", " ").trim().split(" ");
        if (stringInput.replaceAll(" ", "").isEmpty()) return null;
        String tmp = "";
        String result = "";
        for (String s : strA){
            s = s.toLowerCase();
            if (s.length() == 1){
                result = result + s.toUpperCase() + " ";
                continue;
            }
            tmp = s.substring(0, 1).toUpperCase() + s.substring(1) + " ";
            result += tmp;
        }
        return result.trim();
    }
    public static boolean hasNumeric(String stringInput){
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(stringInput);
        while (matcher.find()) return true;
        return false;
    }
}
