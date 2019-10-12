/**
 *
 * @author raian
 * @author rizvi_hasan
 * @author abdullah_al_farhad
 * @author shahriar_nur_nahin
 * 
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
