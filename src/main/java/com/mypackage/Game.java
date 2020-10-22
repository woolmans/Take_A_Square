package com.mypackage;

import java.util.Random;

/* David: the "API" of the core business logic should be like:
 * * create new game, eventually through the constructor
 * * player interacts and makes a move
 * * who is next?
 * * what status does the game have? (Ongoing, finished, who won)
 * Make sure that the API has low coupling with the "viewer" as
 * well as with the persistence.
 * Afterwards, you can test the logic without interfering with
 * persistence and viewer.
 */
public class Game {

    private boolean gameOver;
    private int sticksLeft;

    {
        System.out.println("Welcome! Two players alternatingly take sticks from a heap.\n"
                + "The player who has to take the last stick looses the game. The number\n"
                + "of sticks to be taken has to equal a perfect square. Player 1 starts!");
    }

    // For testing purpose.
    public Game() {
        this(new Random().nextInt(21) + 5);
    }

    public Game(int sticks) {
        sticksLeft = sticks;
    }

    public boolean runGame() {
        new InputOutput().displaySticks(sticksLeft);
        boolean player1 = true;
        while (sticksLeft > 1) {
            Player player = new Player(player1, sticksLeft);
            player.makeMove();
            sticksLeft = player.getSticksLeft();
            player1 = !player1;
        }
        return player1;
    }

    public static void main(String... kong) {
        Game game = new Game(16);
        while (true) {
            InputOutput myIO = new InputOutput();
            myIO.announceWinner(game.runGame());
            if (!myIO.playAgain())
                break;
        }
    }
}
