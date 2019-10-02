package com.example.footballresultsapp;

public class Position {

    private String team;
    private int positionNumber, points, games, wins, draws, loses;


    public Position(int positionNumber, String team, int games, int wins, int draws, int loses, int points) {
        this.positionNumber = positionNumber;
        this.team = team;
        this.games = games;
        this.wins = wins;
        this.draws = draws;
        this.loses = loses;
        this.points = points;
    }

    public int getPositionNumber() {
        return positionNumber;
    }

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

    public int getLoses() {
        return loses;
    }

    public int getPoints() {
        return points;
    }
}
