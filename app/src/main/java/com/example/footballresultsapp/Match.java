package com.example.footballresultsapp;

public class Match {

    String winner, homeTeam, awayTeam, date;
    int homeGoals, awayGoals;

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

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
