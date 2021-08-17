
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
public class Matrix {

    public Matrix() {
    }

    public void displayMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }

    public int[][] inputMatrix(int n) {
        DataInput in = new DataInput();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Row Matrix" + n + ": ");
        int row = in.inputSize();
        System.out.print("Enter Colum Matrix" + n + ": ");
        int col = in.inputSize();
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Enter Matrix" + n + "[" + (i + 1) + "]" + "[" + (j + 1) + "]: ");
                matrix[i][j] = in.inputInt();
            }
        }
        return matrix;
    }

    public int[][] additionMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            return null;
        }

        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] matrixResult = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrixResult[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return matrixResult;
    }

    public int[][] subtractionMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            return null;
        }

        int row = matrix1.length;
        int col = matrix1[0].length;
        int[][] matrixResult = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrixResult[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return matrixResult;
    }

    public int[][] multiplicationMatrix(int[][] matrix1, int[][] matrix2) {
        if (matrix1[0].length != matrix2.length) {
            return null;
        }

        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int col2 = matrix2[0].length;

        int[][] matrixResult = new int[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                matrixResult[i][j] = 0;
            }
        }
        for (int i = 0; i < row1; i++) {  // chạy từng phần tử trong hàng của matrix 1
            for (int j = 0; j < col2; j++) { // chạy từng phần tử của trong cột của matrix 2
                for (int k = 0; k < col1; k++) { // chạy từng phần tử trong cột của matrix 1
                    matrixResult[i][j] += matrix1[i][k] * matrix2[k][j]; // tổng (từng phần tử trong hàng của m1 x từng phần tử trong cột của m2)
                }
            }
        }
        return matrixResult;
    }
}
