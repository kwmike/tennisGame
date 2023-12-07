package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        TennisGame game = new TennisGame();
        Random random = new Random();

        int gameCount = 10; // the number of games you want to play
        int currentGameCount = 0; // a counter to keep track of which game we are on

        while (currentGameCount < gameCount) {
            int player = random.nextInt(2) + 1; // randomly give a point to a player
            game.incrementPlayerPoints(player);
            System.out.println(game.getScore());

            if (game.isGameWon()) {
                game.resetGame();
                currentGameCount++; // increment the reset counter
            }
        }
    }
}