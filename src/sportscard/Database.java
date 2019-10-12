/**
 *
 * @author raian
 * @author rizvi_hasan
 * @author abdullah_al_farhad
 * @author shahriar_nur_nahin
 * 
 */



package sportscard;
import java.sql.*;


public class Database{
    
    String className = "oracle.jdbc.driver.OracleDriver";
    String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    String username;
    String password;
    String dbusername = "cricstan";
    String dbpassword = "cricstan";
    Statement stmt;
    Connection con;
    Database()
    {
        //System.out.println("haha");
        try{
            Class.forName(this.className);
            con = DriverManager.getConnection(URL, dbusername, dbpassword);
            stmt  = con.createStatement();
            String query = "select username, password from logininfos";
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next())
            {
                
                this.username = rs.getString(1);
                this.password = rs.getString(2);
               // System.out.println(username+password);
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
     void setpassword(String password) 
    {
        this.password = password;
        try{
            String query = "update logininfos set password =  '" + password  + "' where username = '" + this.username+"'"  ;
            ResultSet rs = stmt.executeQuery(query);
           // Thread.sleep(1000);
        }catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    
    int insertToTable(String query) throws InterruptedException
    {
        int rs=0;
        try{
          //  System.out.print(query);
            rs = stmt.executeUpdate(query);
            System.out.println(rs + " rows affected");
            con.commit();
            Thread.sleep(10);
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return rs;
    }
    int getCountfromTable(String query) 
    {
        ResultSet rs=null;
        int res =0;
        try{
            
            rs = stmt.executeQuery(query);
            while(rs.next())
            {
                res = rs.getInt(1);
            }
            System.out.println(res + " rows affected");
           // Thread.sleep(1000);
        }
        catch( SQLException e)
        {
            System.out.println(e);
        }
        
        return res;
    }
    
    String selectHomeTeamName(String matchID) throws SQLException 
    {
        ResultSet rs =null;
        int res =0;
        String qu = "select hometeam from fixture where matchid = '"
                    + matchID  +"' ";
        rs = stmt.executeQuery(qu);
        String ret = "";
        while(rs.next())
        {
            ret = rs.getString(1);
        }
        qu = "select teamname from team where teamid = '"
                + ret + "'";
        rs = stmt.executeQuery(qu);
        while(rs.next())
        {
            ret = rs.getString(1);
        }
        return ret;
    }
    String selectAwayTeamName(String matchID) throws SQLException
    {
        ResultSet rs =null;
        int res =0;
        String qu = "select awayteam from fixture where matchid = '"
                    + matchID  +"' ";
        rs = stmt.executeQuery(qu);
        String ret = "";
        while(rs.next())
        {
            ret = rs.getString(1);
        }
        qu = "select teamname from team where teamid = '"
                + ret + "'";
        rs = stmt.executeQuery(qu);
        while(rs.next())
        {
            ret = rs.getString(1);
        }
        return ret;
    }
    
    ResultSet getData(String query){
        ResultSet rs=null;
        try{
            rs = stmt.executeQuery(query);
        }
        catch(SQLException e){
            System.out.println(e);
        }
        return rs;
    }
    void updateResult(String matchID,String teamName) throws SQLException
    {
        int res;
        String query = "update fixture" + " set result = '" + teamName + "' " + " where matchid = '" + matchID + "'";
        res = stmt.executeUpdate(query);
        if(res!=1)
        {
            System.out.println("Error in updating");
        }
      //  return res;
    }
}