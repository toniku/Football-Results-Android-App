package com.example.footballresultsapp;

public class Match {

    private String winner;
    private final String homeTeam;
    private final String awayTeam;
    private final String date;
    private int homeGoals, awayGoals;

    public Match(String date, String winner, String homeTeam, String awayTeam, int homeGoals, int awayGoals) {
        this.winner = winner;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.awayGoals = awayGoals;
        this.homeGoals = homeGoals;
        this.date = date;
    }

    public Match(String date, String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.date = date;
    }

    public String getWinner() {
        return winner;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public String getDate() {
        return date;
    }

}
