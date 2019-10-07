package com.example.footballresultsapp;

public class Scorer {

    private String scorerName, teamName;
    private int goals;

    public Scorer(String scorerName, String team, int scorerGoals) {
        this.scorerName = scorerName;
        this.teamName = team;
        this.goals = scorerGoals;
    }

    public String getScorerName() {
        return scorerName;
    }

    public void setScorerName(String scorerName) {
        this.scorerName = scorerName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }
}
