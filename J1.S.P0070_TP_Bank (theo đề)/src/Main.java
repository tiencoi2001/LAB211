
import controller.AccountDatabase;
import controller.Ebank;
import entity.Account;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import view.ViewAccount;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Duc Ky
 */
public class Main {
    
    public static void main(String[] args) {
        Account acc = new Account();
        AccountDatabase ad = new AccountDatabase();
        ViewAccount va = new ViewAccount(acc, ad);
        va.changeLanguage();
        va.login();
    }
}
