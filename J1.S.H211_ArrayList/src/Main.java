

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
        ArrayIntList list1 = new ArrayIntList();
        int size = 0;
        while (true) {
            size = in.inputInt("Enter size of array: ", 0, Integer.MAX_VALUE);
            if (size % 2 != 0) {
                System.out.println("Size must be even!");
            } else {
                break;
            }
        }
        list1.setSize(size);
        int[] arr1 = new int[size];
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0) {
                arr1[i] = in.inputInt("Enter element " + (i + 1) + ": ", 0, Integer.MAX_VALUE);
            } else {
                arr1[i] = in.inputInt("Enter element " + (i + 1) + ": ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        }
        list1.setElementData(arr1);

        System.out.println("List 1: ");
        list1.output();
        System.out.println("");
        ArrayIntList list2 = list1.fromCounts();
        System.out.println("List 2: ");
        list2.output();
    }

}
