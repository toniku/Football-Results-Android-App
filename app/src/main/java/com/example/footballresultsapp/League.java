package com.example.footballresultsapp;

public class League {

    private final String name;
    private final String competitionID;

    public League(String name, String competitionID) {
        this.name = name;
        this.competitionID = competitionID;
    }

    public String getCompetitionID() {
        return competitionID;
    }

    public String getName() {
        return name;
    }


}
