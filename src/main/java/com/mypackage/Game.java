package com.mypackage;

import java.util.Random;

import static com.mypackage.InputOutput.*;

/* This class contains the major part of the domain logic because
 * it checks whether the input is according to the rules of the game.
 */
public class Game {

    public int gameState;
    String player = "Player1";

    // Constructor.
    public Game() {
        var rand = new Random();
        gameState = rand.nextInt(21) + 5;
        System.out.println("Welcome! Two players alternatingly take sticks from a heap.\n"
                + "The player who has to take the last stick looses the game. The number\n"
                + "of sticks to be taken has to equal a perfect square. Player 1 starts!");
        displaySticks(gameState);
    }

    /* getWinner() keeps the game going until
     * the end condition is reached.
     */
    public String getWinner() {
        while (gameState > 1) {
            oneTurn();
            displaySticks(gameState);
            changePlayer();
        }
        if (player.equals("Player2"))
            return "Player1 won.";
        else
            return "Player2 won.";
    }

    private void oneTurn() {
        CheckPerfectSquare check = new CheckPerfectSquare();
        int x = check.checkInput();
        if (x < gameState)
            gameState = x;
        else
            oneTurn();
    }

    public void changePlayer() {
        if (player.equals("Player1"))
            player = "Player2";
        else
            player = "Player1";
    }

    /* CheckPerfectSquare can directly access instance variables of
     * the Game class. But it also holds a state on its won.
     */
    private class CheckPerfectSquare {
        int x = gameState;

        private int checkInput() {
            String str = "";
            int number = askQuestion();
            if (number >= x)
                str = "The number is greater than the amount of remaining sticks.\n";
            else if (number <= 0)
                str = "The number must be greater than zero.\n";
            else if (!isPerfectSquare(number))
                str = "Not a perfect square.\n";
            else
                x -= number;
            System.out.print(str);
            return x;
        }

        public int askQuestion() {
            return drawSticks(player + " : " + "How many sticks would you like to take?");
        }

        boolean isPerfectSquare(double x) {
            double sr = Math.sqrt(x);
            return ((sr - Math.floor(sr)) == 0);
        }
    }

}
