/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sportscard;
import java.sql.*;

/**
 *
 * @author raian
 */
public class Database {
    String className = "oracle.jdbc.driver.OracleDriver";
    String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    String username;
    String password;
    String dbusername = "cricstan";
    String dbpassword = "cricstan";
    
    Database()
    {
        try{
            Class.forName(this.className);
            Connection con = DriverManager.getConnection(URL, dbusername, dbpassword);
            Statement stmt  = con.createStatement();
            String query = "select username, password from logininfos";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())
            {
                this.username = rs.getString(1);
                this.password = rs.getString(2);
            }
        }catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
    }
    String getusername()
    {
        return this.username;
    }
    String getpassword()
    {
        return this.password;
    }
    void setpassword(String password) throws InterruptedException
    {
        this.password = password;
        try{
            Class.forName(this.className);
            Connection con = DriverManager.getConnection(URL, dbusername, dbpassword);
            Statement stmt  = con.createStatement();
            String query = "update logininfos set password =  " + password  + "where username = " + this.username  ;
            ResultSet rs = stmt.executeQuery(query);
            con.close();
            Thread.sleep(1000);
        }catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
    }
    
    int insertToTable(String query) throws InterruptedException
    {
        int rs=0;
        try{
            Class.forName(this.className);
            Connection con = DriverManager.getConnection(URL,dbusername,dbpassword);
            Statement stmt = con.createStatement();
            rs = stmt.executeUpdate(query);
            System.out.println(rs + " rows affected");
            con.commit();
            con.close();
            Thread.sleep(1000);
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
        return rs;
    }
    int getCountfromTable(String query) throws InterruptedException
    {
        ResultSet rs=null;
        int res =0;
        try{
            Class.forName(this.className);
            Connection con = DriverManager.getConnection(URL,dbusername,dbpassword);
            Statement stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while(rs.next())
            {
                res = rs.getInt(1);
            }
            System.out.println(res + " rows affected");
            
            con.close();
            Thread.sleep(1000);
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
        
        return res;
    }
}
