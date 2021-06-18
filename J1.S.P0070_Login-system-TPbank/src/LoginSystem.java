/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vu Duc Tien
 */
import entity.Users;
import java.util.ArrayList;
import java.util.Locale;

public class LoginSystem {
    public boolean checkUser(Locale language, ArrayList <Users> lu) {
        DataInput in = new DataInput();
        String acc = in.inputAccount(language);
        String pass = in.checkPassword(language);
        for (Users user : lu) {
            if (acc.equals(user.getAccNumber()) && pass.equals(user.getPw())) {
                return true;
            }
        }
        return false;
    }

    public void login(Locale language, ArrayList <Users> lu) {
        lu.add(new Users("1234567890", "abcd1234"));
        DataInput in = new DataInput();
        boolean checkUser = checkUser(language, lu);
        boolean check = in.checkCaptcha(language);

        while (!check) {
            check = in.checkCaptcha(language);
        }
        if (checkUser) {
            in.getNotification(language, "loginSuccess");
            System.out.println("");
            return;
        } else {
            in.getNotification(language, "incorrectInput");
            System.out.println("");
            login(language, lu);
            return;
        }
    }
}
