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
public class Match {
    private String mID;
    private String hID;
    private String aID;
    private int hTeamRun;
    private int aTeamRun;
    private int hTeamWkt;
    private int aTeamWkt;
    private int aTeamBall;
    private int hTeamBall;
    private int maxOver;
    private int maxWkt;
    //default constructor
    public Match()
    {
       
    }
    //parametreized constructor
    public Match(String mid,String hid,String aid, int maxover, int  maxwkt)
    {
        this.mID = mid;
        this.hID = hid;
        this.aID = aid;
        this.maxOver = maxover;
        this.maxWkt = maxwkt;
    }
    String getmID()
    {
        return this.mID;
    }
    String gethID()
    {
        return this.hID;
    }
    String getaID()
    {
        return this.aID;
    }
    int getMaxOver()
    {
        return this.maxOver;
    }
    int getMaxWkt()
    {
        return this.maxWkt;
    }
    //other methods
    
}
