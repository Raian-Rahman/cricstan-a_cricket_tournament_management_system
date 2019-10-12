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
import java.sql.*;
import java.util.ArrayList;



public final class Fixture {

    /**
     * @param args the command line arguments
     */
    
    ArrayList<String> teams = new ArrayList<>();
    Database db;
    String tid="lol";
    int type;
    Fixture(String tournamentid, Database db){
        this.tid=tournamentid;
        this.db=db;
        String qry="select TEAMID from TEAM where TOURNAMENTID='"+tournamentid+"'";
        ResultSet rs=db.getData(qry);
        try{
            while(rs.next()){
                teams.add(rs.getString(1));
            }
        }
        catch(SQLException e){
            System.out.println(e);
        }
        qry = "select rule from tournament where tournamentid = '" + tournamentid + "'";
        int res = db.getCountfromTable(qry);
        switch (res) {
            case 1:
                single();
                break;
            case 2:
                homeAndAway();
                break;
            case 3:
                knockout();
                break;
            default:
                break;
        }
        
    }
    
    boolean knockout(){
        if(teams.size()%2!=0){
            return false;
        }else{
            for(int i=0,j=teams.size()-1;i<teams.size()/2;i++,j--){
                String matchid=tid+i;
                String qry="insert into FIXTURE values('"+matchid+"','"+teams.get(i)+"','"+teams.get(j)+"',null,'"+tid+"')";
                try{
                    db.insertToTable(qry);
                    System.out.println(qry);
                }catch(Exception e){
                    
                    System.out.println(e);
        
                }
                
            }
            
            return true;
        }
        
    }
    
    void homeAndAway(){
        int id=0;
        for(String i:teams){
            for(String j:teams){
                if(i.compareTo(j)==0) continue;
                String matchid=tid+id;
                ++id;
                String qry="insert into FIXTURE values('"+matchid+"','"+i+"','"+j+"',null,'"+tid+"')";
                 try{
                    db.insertToTable(qry);
                    System.out.println(qry);
                }catch(Exception e){
                    
                    System.out.println(e);
        
                }
                
            }
        }
    }
    
    void single(){
        int id=0;
        for(int i=0;i<teams.size();i++){
            for(int j=i+1;j<teams.size();j++){
                String matchid=tid+id;
                ++id;
                String qry="insert into FIXTURE values('"+matchid+"','"+teams.get(i)+"','"+teams.get(j)+"',null,'"+tid+"')";
                try{
                    db.insertToTable(qry);
                    System.out.println(qry);
                }catch(Exception e){
                    
                    System.out.println(e);
        
                }
            }
        }
    }
}
