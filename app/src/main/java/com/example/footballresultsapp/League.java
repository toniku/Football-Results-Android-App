package com.example.footballresultsapp;

public class League {

    private String name, competitionID;

    public League(String name, String competitionID) {
        this.name = name;
        this.competitionID = competitionID;
    }

    public String getCompetitionID() {
        return competitionID;
    }

    public void setCompetitionID(String competitionID) {
        this.competitionID = competitionID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
