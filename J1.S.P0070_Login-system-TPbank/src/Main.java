
import entity.Users;
import java.util.ArrayList;
import java.util.Locale;

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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Users> lu = new ArrayList<>();
        DataInput in = new DataInput();
        LoginSystem ls = new LoginSystem();
        Locale en = Locale.ENGLISH;
        Locale vi = new Locale("vi");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
        System.out.print("Your choice: ");
        int choice = in.inputChoice(1, 3);

        switch (choice) {
            case 1: {
                ls.login(vi, lu);
                break;
            }
            case 2: {
                ls.login(en, lu);
                break;
            }
            case 3: {
                return;
            }
        }
    }

}
