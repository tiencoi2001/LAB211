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

    private static int [] selectionSort(int [] a) {
        for (int i = 0; i < a.length - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min_idx]) {
                    min_idx = j;
                }
            }
            if (min_idx != i) {
                int temp = a[min_idx];
                a[min_idx] = a[i];
                a[i] = temp;
            }
        }
        return a;
    }
    
    public static void main(String[] args) {
        DataInput in = new DataInput();
        int size = in.inputInterger("Enter number of array: ", 1, Integer.MAX_VALUE);
        int [] arr = in.inputArray(size);
        displayArray("Unsorted array", arr);
        arr = selectionSort(arr);
        displayArray("Sorted array", arr);
    }
}
