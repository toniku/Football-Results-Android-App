package com.example.footballresultsapp;

public class Position {

    public int getPositionNumber() {
        return positionNumber;
    }

    int positionNumber;
    String team;
    int points;
    int games;
    int wins;
    int draws;
    int losts;

    public String getTeam() {
        return team;
    }

    public int getGames() {
        return games;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getLosts() {
        return losts;
    }

    public int getPoints() {
        return points;
    }


    public Position(int positionNumber, String team, int games, int wins, int draws, int losts, int points) {
        this.positionNumber = positionNumber;
        this.team = team;
        this.games = games;
        this.wins = wins;
        this.draws = draws;
        this.losts = losts;
        this.points = points;
    }
}
