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
public class Player {
    private String p_name;
    private int p_shirtNo;
    private String p_id;
    private String catagory;  // catagoris are 'batsman','baller','wicketkeeper','all-rounder'
    private String team_id;
    int ans;
    
    //  default constructor 
    Player()
    {
        
    }
    //parametreized constructor
    Player(String playerName,String p_cat,int shirtNo,String teamID,boolean flag) throws InterruptedException
    {
        this.p_id = generatePID(playerName,shirtNo);
        this.p_name = playerName;
        this.p_shirtNo =  shirtNo;
        this.team_id = teamID;
        this.catagory = p_cat;
        
        //if flag == true   add new to database 
        
        String query;
        query = "insert into player values('" + this.p_id + "' , '" + this.p_name + "' , "  + this.p_shirtNo  + " , '" + catagory +  "' , '" + team_id + "' )";
        System.out.println(query);
        Database db = new Database();
        this.ans=db.insertToTable(query);
        System.out.println( ans + " player added ");
        //end of inserting
    }
    String generatePID(String  playerName,int shirtNo)
    {
        String str = "";
        for(int i=0;i<playerName.length();i++)
        {
            if(playerName.charAt(i)==' ')   str = str + '_';
            else                            str = str + playerName.charAt(i);
        }
        str = str + '_';
        str = str + Integer.toString(shirtNo);
        System.out.println(str);
        return str;
    }
    String getP_ID()
    {
        return this.p_id;
    }
    int getAns()
    {
        return this.ans;
    }
}
