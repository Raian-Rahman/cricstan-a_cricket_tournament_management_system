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
public class Tournament {
    private String tournamentname;
    private String season;
    private int teams;
    private int minimumPlayer;
    private int rules;
    private boolean flag = false ; //true hole new tournament //otherwise false
    private String tournamentId;
    private int status = 0;
    private Tournament obj =  null;
    //default constructor
    Tournament()
    {
        
    }
    Tournament(Tournament x)
    {
        this.obj = x;
    }
    //parametreized constructor 
    Tournament(String tournamentname,String season,int teams,int minimumPlayer,int rules,boolean flag) throws InterruptedException
    {
        this.tournamentId = generateTournamentID(tournamentname,season);
        this.tournamentname = tournamentname;
        this.season = season;
        this.teams = teams;
        this.minimumPlayer = minimumPlayer;
        this.rules = rules;
        this.flag = flag;
        //if new tournament add it to database and provide a tournamentId;
        if(flag==true)
        {
            //create String and  add to database 
            String query = "";
            query = query + "insert into  tournament values ( " + "'" +tournamentId + "'" + " , " + "'" + tournamentname + "'" + " , " + "'" + season + "'" + " , " + teams + " , " + minimumPlayer + " , " + rules + " )"   ;
            System.out.println(query);
            Database obj = new Database();
            this.status =  obj.insertToTable(query);
            
            System.out.println("done inserting");
        }
    }
    String generateTournamentID(String tournamentname,String season)
    {
        String newID = "";
        for(int i=0;i<tournamentname.length();i++)
        {
            if(tournamentname.charAt(i)==' ')   newID = newID + '_';
            else                                newID = newID + tournamentname.charAt(i);
        }
        newID = newID + "_";
        newID = newID + season;
        System.out.println(newID);
        return newID;
    }
    int getStatus()
    {
        return this.status;
    }
    String getTournamentID()
    {
        return this.tournamentId;
    }
    int getTeams()
    {
        return this.teams;
    }
}
