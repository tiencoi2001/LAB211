

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

    public void printReverse(String stringInput) {
        stringInput = stringInput.replaceAll("\\s+", " ");
        String result = "";
        for (int i = stringInput.length() - 1; i >= 0; i--) {
            result += stringInput.charAt(i);
        }
        System.out.println(result);
    }
}
