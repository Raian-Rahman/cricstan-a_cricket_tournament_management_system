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
public class Teams {
    private String teamName;
    private String shortName;
    private String teamID;
    private String tournamentID;
    private boolean flag = false;
    private int num = 0;
    //default consttuctor
    
    //parametreized constructor
    Teams(String teamName,String shortName,String t_id,boolean flag) throws InterruptedException
    {
        System.out.println("afab " + t_id);
        this.teamID = generateTeamID(teamName,t_id);
        System.out.println(teamID);
        this.teamName = teamName;
        this.shortName = shortName;
        
        this.flag = flag;
        
        
        
        //flag == true hole insert krte hbe 
        if(flag==true)
        {
            String query = "";
            //insert into team values('teamID','
            query = "insert into team values ('" + teamID + "' , '" + teamName + "' , '" + shortName + "' , '" + t_id + "')";
            System.out.println(query);
            Database db = new Database();
            int res = db.insertToTable(query);
            this.num = res;
            System.out.println(res);
        }
    }
    
    
    String generateTeamID(String teamName,String tournamentID)
    {
        String str = "";
        for(int i=0;i<teamName.length();i++)
        {
            if(teamName.charAt(i) == ' ')
            {
                str = str + '_';
            }
            else str = str + teamName.charAt(i);
        }
        str = str + '_';
        str = str + tournamentID;
        return str;
    }
    String getTeamID()
    {
        return this.teamID;
    }
    int getnum()
    {
        return this.num;
    }
    
}
