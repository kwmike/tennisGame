package org.example;

public class TennisGame {
    private static final int MIN_WINNING_SCORE = 4;
    private int player1Points = 0;
    private int player2Points = 0;
    private boolean isGameWon = false;

    public void incrementPlayerPoints(int player) {
        switch (player) {
            case 1:
                player1Points++;
                break;
            case 2:
                player2Points++;
                break;
        }
    }

    public String getScore() {
        if (isDeuce()) {
            return "Deuce";
        } else if (isAdvantage()) {
            return "Advantage " + (player1Points > player2Points ? "Player 1" : "Player 2");
        } else if (isWon()) {
            setGameWon(true);
            return "Game " + (player1Points > player2Points ? "Player 1" : "Player 2");
        } else {
            return translateScore(player1Points) + "-" + translateScore(player2Points);
        }
    }

    public boolean isWon() {
        if ((player1Points >= MIN_WINNING_SCORE || player2Points >= MIN_WINNING_SCORE) && Math.abs(player1Points - player2Points) >= 2) {
            setGameWon(true);
            return true;
        }
        return false;
    }

    private boolean isDeuce() {
        return player1Points >= 3 && player2Points == player1Points;
    }

    private boolean isAdvantage() {
        if (player1Points >= MIN_WINNING_SCORE || player2Points >= MIN_WINNING_SCORE) {
            return Math.abs(player1Points - player2Points) == 1;
        }
        return false;
    }

    private void setGameWon(boolean value) {
        isGameWon = value;
    }

    private String translateScore(int score) {
        switch (score) {
            case 0: return "Love";
            case 1: return "15";
            case 2: return "30";
            case 3: return "40";
            default: return "";
        }
    }

    public boolean isGameWon() {
        return isGameWon;
    }

    public void resetGame() {
        player1Points = 0;
        player2Points = 0;
        isGameWon = false;
    }
}
