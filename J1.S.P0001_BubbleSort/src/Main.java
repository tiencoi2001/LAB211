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
    private static void displayArray(String mes, int [] a) {
        System.out.print(mes  + ": [");
        for (int i = 0; i < a.length; i++) {
            if (i != a.length - 1) {
                System.out.print(a[i] + ", ");
            } else {
                System.out.print(a[i] + "]");
            }
        }
        System.out.println("");
    }

    private static int [] bubbleSort(int [] a){
        int n = a.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (a[j] > a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
        return a;
    }
    
    public static void main(String[] args) {
        DataInput in = new DataInput();
        int size = in.inputInterger("Enter number of array: ", 1, Integer.MAX_VALUE);
        int [] arr = in.randomNumber(size, -100, 100);
        displayArray("Unsorted array", arr);
        arr = bubbleSort(arr);
        displayArray("Sorted array", arr);
    }
}
