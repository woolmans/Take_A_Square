package com.mypackage;

import java.util.Arrays;
import java.util.Random;
import static com.mypackage.InputOutput.*;


public class Game {

    public int gameState;

    public Game() {
        var rand = new Random();
        gameState = rand.nextInt(21) + 5;
        returnSticks(gameState);
        gameFlow();
    }

    /* This method essentially keeps the game going until the
     end condition is reached. */
    public void gameFlow() {
        int player = 1;
        while (gameState > 1) {
            rounds("Player " + player);
            if (player == 1)
                player = 2;
            else
                player = 1;
        }
        if (player == 1)
            System.out.println("Player 2 won.");
        else
            System.out.println("Player 1 won.");
    }

    /* This method together with the method "isPerfectSquare" is validation
    whether the input of the player is valid. It has an IO-Stream with an
    appropriate prompt, if the input is not matching any expected input. At
    the end it is printing the current state on the command line. It can be
    considered at the core of the domain logic of this program.
     */
    public void rounds(String iterator) {
        int x = gameState;
        do {
            String str = "";
            int number = InputOutput.drawSticks(iterator + " : How many sticks do you want to draw?");
            subtract(number);
            if (gameState == x)
                str = "You didn't enter a perfect square or your number\n" +
                        "was greater than the amount of remaining sticks. Please try again.\n";
            System.out.print(str);
        } while (gameState == x);
        returnSticks(gameState);
    }

    static boolean isPerfectSquare(double x) {
        double sr = Math.sqrt(x);
        return ((sr - Math.floor(sr)) == 0);
    }

    public void subtract(int points) {
        if (isPerfectSquare(points) && points < gameState)
            gameState -= points;
    }

}