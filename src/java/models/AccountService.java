/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author 749300
 */
public class AccountService {

    public static User login(String username, String password) {
        if (username.equalsIgnoreCase("adam")
                && password.equalsIgnoreCase("password")) {
            User user = new User(username, password);
            return user;
        }
        if (username.equalsIgnoreCase("betty")
                && password.equalsIgnoreCase("password")) {
            User user = new User(username, password);
            return user;
        } else {
            return null;
        }

    }
}
