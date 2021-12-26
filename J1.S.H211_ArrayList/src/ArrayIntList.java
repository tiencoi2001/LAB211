/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vu Duc Tien
 */
public class ArrayIntList {

    private int[] elementData;
    private int size;

    public ArrayIntList() {
    }

    public ArrayIntList(int[] elementData, int size) {
        this.elementData = elementData;
        this.size = size;
    }

    public int[] getElementData() {
        return elementData;
    }

    public void setElementData(int[] elementData) {
        this.elementData = elementData;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void output() {
        for (int i = 0; i < size; i++) {
            System.out.print(elementData[i] + " ");
        }
    }
    
    public ArrayIntList fromCounts() {
        ArrayIntList list = new ArrayIntList();
        int size2 = 0;
        for (int i = 0; i < size; i += 2) {
            size2 += elementData[i];
        }

        int[] arr2 = new int[size2];
        
        for (int i = 0; i < size2; i++) {
            for (int j = 0; j < size; j += 2) {
                for (int k = 0; k < elementData[j]; k++) {
                    arr2[i] = elementData[j+1];
                    i++;
                }
            }
        }
        list.setElementData(arr2);
        list.setSize(size2);
        return list;
    }
}
