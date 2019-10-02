package com.example.footballresultsapp;

public class League {

    String leagueCode;
    String name;

    public League(String leagueCode, String name) {
        this.leagueCode = leagueCode;
        this.name = name;
    }

    public String getLeagueCode() {
        return leagueCode;
    }

    public void setLeagueCode(String leagueCode) {
        this.leagueCode = leagueCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
