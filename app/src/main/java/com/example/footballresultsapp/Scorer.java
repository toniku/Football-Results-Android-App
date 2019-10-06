package com.example.footballresultsapp;

public class Scorer {

    private String scorerName, teamName;
    private int goals;

    public Scorer(String team) {
        this.scorerName = scorerName;
        this.teamName = teamName;
        this.goals = goals;
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
