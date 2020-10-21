package com.mypackage;

import java.util.Random;

import static com.mypackage.InputOutput.*;

/* David: the "API" of the core business logic should be like:
 * * create new game, eventually through the constructor
 * * player interacts and makes a move
 * * who is next?
 * * what status does the game have? (Ongoing, finished, who won)
 * Make sure that the API has low coupling with the "viewer" as
 * well as with the persistence.
 * Afterwards, you can test the logic without interfering with
 * persistence and viewer. A test would be like: this is the
 * gameState, these are the actions of the players => this
 * is the expected new gameState.
 */
public class Game {

    public int gameState;
    String player = "Player1";

    // Constructor.
    public Game() {
        this(new Random().nextInt(21) + 5);
    }

    public Game(int sticks) {
        gameState = sticks;
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
            /* David: try to avoid, that you have this kind of coupling
             * between two classes.
             */
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

        /* David: try to avoid, that you have this kind of coupling
         * between two classes.
         */
        public int askQuestion() {
            return drawSticks(player + " : " + "How many sticks would you like to take?");
        }

        boolean isPerfectSquare(double x) {
            double sr = Math.sqrt(x);
            return ((sr - Math.floor(sr)) == 0);
        }
    }

}
