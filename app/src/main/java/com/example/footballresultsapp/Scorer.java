package com.example.footballresultsapp;

public class Scorer {

    private final String scorerName;
    private final String teamName;
    private final int goals;

    public Scorer(String scorerName, String team, int scorerGoals) {
        this.scorerName = scorerName;
        this.teamName = team;
        this.goals = scorerGoals;
    }

    public String getScorerName() {
        return scorerName;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getGoals() {
        return goals;
    }

}
