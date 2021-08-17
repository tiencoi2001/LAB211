/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AccountDatabase;
import controller.Ebank;
import entity.Account;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author Duc Ky
 */
public class ViewAccount {
    private ResourceBundle rb;
    private Locale locale;
    private Account acc;
    private AccountDatabase ad;
    private Ebank eb = new Ebank(locale);
    
    public ViewAccount(Account acc, AccountDatabase ad) {
        this.acc = acc;
        this.ad = ad;
    }
    private String inputAccountNumber(){
        String accountNumber;
        accountNumber = util.Validation.inputString(rb.getString("username"), true);
        return accountNumber;
    }
    private String inputPassword(){
        String password;
        password = util.Validation.inputString(rb.getString("password"), true);
        return password;
    }
    private String inputCaptcha(){
        String captcha;
        System.out.println(rb.getString("captcha") + eb.generateCaptcha());
        captcha = util.Validation.inputString(rb.getString("enterCaptcha"), false);
        return captcha;
    }
    public void changeLanguage(){
        //init
        Integer choice;
        //display
        GUI.languageGUI();
        //Process
        while(true){
            choice = util.Validation.inputIntLimit(1, 3);
            if (choice != null) break;
        }
        if (choice == 1){
            locale = new Locale("vi");
        }else if(choice == 2){
            locale = new Locale("en");
        }else{
            locale = new Locale("vi");
        }
        eb.setLocale(locale);
        this.rb = ResourceBundle.getBundle("entity.language", locale);
    }
    public void login(){
        String accNumber;
        String accPassword;
        while(true){    
            while(true){
                accNumber = inputAccountNumber();
                if (accNumber == null){
                    break;
                }
                if (eb.checkAccountNumber(accNumber) == null){
                    System.err.println(rb.getString("username_wrongInput"));
                }else{
                    break;
                }
                
            }
            while(true){
                accPassword = inputPassword();
                if (accPassword == null){
                    break;
                }
                if (eb.checkPassword(accPassword) == null){
                    System.err.println(rb.getString("password_wrongInput"));
                }else{
                    break;
                }
                
            }
            if (accNumber == null && accPassword == null){
                if (util.Validation.checkYesNo(rb.getString("loginAgain"))){
                    continue;
                }else{
                    break;
                } 
            }
            this.acc = new Account(accNumber, accPassword);
            if (inputCaptcha() != null){
                if (ad.checkAccount(acc)){
                    System.err.println(rb.getString("loginSuccessful"));
                    break;
                }else{
                    System.err.println(rb.getString("loginFailed"));
                    if (util.Validation.checkYesNo(rb.getString("loginAgain"))){
                        continue;
                    }else{
                        break;
                    } 
                }
            }
        }
    }
}
