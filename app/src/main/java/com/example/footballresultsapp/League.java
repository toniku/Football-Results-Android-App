package com.example.footballresultsapp;

public class League {

    public String getLeagueCode() {
        return leagueCode;
    }

    public void setLeagueCode(String leagueCode) {
        this.leagueCode = leagueCode;
    }

    String leagueCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    public League(String leagueCode, String name) {
        this.leagueCode = leagueCode;
        this.name = name;
    }


}
