package com.example.footballresultsapp;

public class Team {

    private final String teamName;
    private final int rankingNumber;
    private final int points;
    private final int playedGames;
    private final int wins;
    private final int draws;
    private final int losses;

    public Team(int rankingNumber, String teamName, int playedGames, int wins, int draws, int losses, int points) {
        this.rankingNumber = rankingNumber;
        this.teamName = teamName;
        this.playedGames = playedGames;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
        this.points = points;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getRankingNumber() {
        return rankingNumber;
    }

    public int getPoints() {
        return points;
    }

    public int getPlayedGames() {
        return playedGames;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getLosses() {
        return losses;
    }

}
