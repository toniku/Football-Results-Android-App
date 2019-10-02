package com.example.footballresultsapp;

public class Team {

    private String teamName;
    private int rankingNumber, points, playedGames, wins, draws, losses;

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

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getRankingNumber() {
        return rankingNumber;
    }

    public void setRankingNumber(int rankingNumber) {
        this.rankingNumber = rankingNumber;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPlayedGames() {
        return playedGames;
    }

    public void setPlayedGames(int playedGames) {
        this.playedGames = playedGames;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }
}
