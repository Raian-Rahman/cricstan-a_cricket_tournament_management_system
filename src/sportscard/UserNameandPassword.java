/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportscard;

/**
 *
 * @author raian
 */
public class UserNameandPassword {
    private String loginUserName;
    private String loginUserPassword;
    //default constructor
    

    public UserNameandPassword() {
        Database Loader = new Database();
        this.loginUserName = Loader.username;
        this.loginUserPassword = Loader.password;
    }
    String getloginUserName()
    {
        return this.loginUserName;
        
    }
    String getloginPassword()
    {
        return this.loginUserPassword;
    }

    //different methods
    
}
