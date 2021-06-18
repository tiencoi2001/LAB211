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
        ChangeBaseProgram program = new ChangeBaseProgram();
        Main m = new Main();
        boolean isStop = false;
        while (!isStop) {
            m.displayMenu();
            int choice = in.inputChoice(0, 6);
            switch (choice) {
                case 1: {
                    while (true) {
                        program.displayChangeDecToBin();
                        if (!in.checkYesNo()) {
                            break;
                        } else {
                            continue;
                        }
                    }
                    break;
                }
                case 2: {
                    while (true) {
                        program.displayChangeBinToDec();
                        if (!in.checkYesNo()) {
                            break;
                        } else {
                            continue;
                        }
                    }
                    break;
                }
                case 3: {
                    while (true) {
                        program.displayChangeDecToHex();
                        if (!in.checkYesNo()) {
                            break;
                        } else {
                            continue;
                        }
                    }
                    break;
                }
                case 4: {
                    while (true) {
                        program.displayChangeHexToDec();
                        if (!in.checkYesNo()) {
                            break;
                        } else {
                            continue;
                        }
                    }
                    break;
                }
                case 5: {
                    while (true) {
                        program.displayChangeBinToHex();
                        if (!in.checkYesNo()) {
                            break;
                        } else {
                            continue;
                        }
                    }
                    break;
                }
                case 6: {
                    while (true) {
                        program.displayChangeHexToBin();
                        if (!in.checkYesNo()) {
                            break;
                        } else {
                            continue;
                        }
                    }
                    break;
                }
                case 0: {
                    isStop = true;
                    break;
                }
            }
        }

    }

    public void displayMenu() {
        System.out.println("====CONVERT BASE NUMBER PROGRAM====");
        System.out.println("1. From decimal to binary");
        System.out.println("2. From binary to decimal");
        System.out.println("3. From decimal to hex");
        System.out.println("4. From hex to decimal");
        System.out.println("5. From binary to hex");
        System.out.println("6. From hex to binary");
        System.out.println("0. Exit");
        System.out.print("Your choice: ");
    }
}
