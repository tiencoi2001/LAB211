/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hoang Tran
 */
public class Main {

    public static void main(String[] args) {
        while (true) {
            DataInput in = new DataInput();
            String str = in.inputString();
            System.out.print("String after reverse: ");
            in.printReverse(str);
            if(!in.checkYesNo("Do you want to reverse another string?")){
                break;
            }else{
                continue;
            }
        }
    }
}
