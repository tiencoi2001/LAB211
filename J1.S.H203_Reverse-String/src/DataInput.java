

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
    
    /*
    hello there. abc xyz
    hello there  abc xyz
    there hello  xyz abc
    There hello. Xyz abc
    There hello  Xyz abc
    Xyz abc. There hello
    */

    public void printReverse(String stringInput) {
        DataInput in = new DataInput();
        String[] strA = stringInput.replaceAll("\\s+", " ").split("\\.");
        String result = "";
        for (String str : strA) {
            String tmp = "";
            String[] strB = str.split(" ");
            for (int i = strB.length - 1; i >= 0; i--) {
                tmp += strB[i];
                tmp += " ";
            }
            result += tmp.substring(0, 1).toUpperCase() + tmp.substring(1).toLowerCase();
            result = result.trim();
            result += ". ";
        }
        result = result.substring(0, result.length() - 2);

        result = in.reverseSentence(result);
        System.out.println(result);
    }

    private String reverseSentence(String stringInput) {
        String[] strA = stringInput.replaceAll("\\s+", " ").split("\\.");
        String tmp = "";

        for (int i = strA.length - 1; i >= 0; i--) {
            tmp += strA[i].trim();
            tmp += ". ";
        }
        String result = tmp.substring(0, tmp.length() - 2);
        return result;
    }
}
