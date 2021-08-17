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
        Main main = new Main();
        DataInput in = new DataInput();
        Matrix m = new Matrix();
        int[][] matrix1;
        int[][] matrix2;
        int[][] matrixResult;

        boolean isStop = false;
        while (!isStop) {
            main.menu();
            int choice = in.inputChoice(1, 4);
            switch (choice) {
                case 1: {
                    System.out.println("--------Addition--------");
                    matrix1 = m.inputMatrix(1);
                    System.out.println("");
                    matrix2 = m.inputMatrix(2);
                    System.out.println("--------Result--------");
                    
                    matrixResult = m.additionMatrix(matrix1, matrix2);

                    if (matrixResult == null) {
                        System.out.println("Can't Addition Matrix");
                        break;
                    }

                    m.displayMatrix(matrix1);
                    System.out.println("+");
                    m.displayMatrix(matrix2);
                    System.out.println("=");
                    m.displayMatrix(matrixResult);
                    break;
                }
                case 2: {
                    System.out.println("--------Subtraction--------");
                    matrix1 = m.inputMatrix(1);
                    System.out.println("");
                    matrix2 = m.inputMatrix(2);
                    System.out.println("--------Result--------");
                    
                    matrixResult = m.subtractionMatrix(matrix1, matrix2);

                    if (matrixResult == null) {
                        System.out.println("Can't Subtraction Matrix");
                        break;
                    }

                    m.displayMatrix(matrix1);
                    System.out.println("-");
                    m.displayMatrix(matrix2);
                    System.out.println("=");
                    m.displayMatrix(matrixResult);
                    break;
                }
                case 3: {
                    System.out.println("--------Multiplication--------");
                    matrix1 = m.inputMatrix(1);
                    System.out.println("");
                    matrix2 = m.inputMatrix(2);
                    System.out.println("--------Result--------");
                    
                    matrixResult = m.multiplicationMatrix(matrix1, matrix2);

                    if (matrixResult == null) {
                        System.out.println("Can't Multiplication Matrix");
                        break;
                    }

                    m.displayMatrix(matrix1);
                    System.out.println("*");
                    m.displayMatrix(matrix2);
                    System.out.println("=");
                    m.displayMatrix(matrixResult);
                    break;
                }
                case 4: {
                    isStop = true;
                    break;
                }
            }
        }
    }

    private void menu() {
        System.out.println("=======Calculator program=======");
        System.out.println("1. Addition Matrix");
        System.out.println("2. Subtraction Matrix");
        System.out.println("3. Multiplication Matrix");
        System.out.println("4. Quit");
        System.out.print("Your choice: ");
    }
}
