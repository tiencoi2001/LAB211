/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Account;
import java.util.ArrayList;

/**
 *
 * @author Duc Ky
 */
public class AccountDatabase {
    private ArrayList<Account> accountList = new ArrayList<>();

    public AccountDatabase() {
        create();
    }
    private void create(){
        accountList.add(new Account("1231231231", "javalab123"));
        accountList.add(new Account("1234567890", "javalab123"));
        accountList.add(new Account("2342342341", "javalab123"));
        accountList.add(new Account("3453453451", "javalab123"));
        accountList.add(new Account("4564564561", "javalab123"));
        accountList.add(new Account("5675675671", "javalab123"));
    }
    public boolean checkAccount(Account inputAcc){
        for (Account a : accountList){
            if (a.equals(inputAcc)){
                return true;
            }
        }
        return false;
    }
}
