package com.mypackage;

import java.util.Random;

/* David: the "API" of the core business logic should be like:
 * * create new game, eventually through the constructor
 * * player interacts and makes a move
 * * who is next?
 * * what status does the game have? (Ongoing, finished, who won)
 */
public class Game {

    private int sticksLeft;
    private InputOutput myIO = new InputOutput();

    {
        System.out.println("Welcome! Two players alternatingly take sticks from a heap.\n"
                + "Player 1 starts!");
    }

    public Game() {
        this(new Random().nextInt(21) + 5);
    }

    public void setMyIO(InputOutput myIO) {
        this.myIO = myIO;
    }

    public Game(int sticks) {
        sticksLeft = sticks;
    }

    public boolean player2Won() {
        myIO.displaySticks(sticksLeft);
        boolean player1 = true;
        while (sticksLeft > 1) {
            Round round = new Round(myIO, player1, sticksLeft);
            round.makeMove();
            sticksLeft = round.getSticksLeft();
            player1 = !player1;
        }
        return player1;
    }

    public static void main(String... kong) {
        while (true) {
            Game game = new Game(20);
            InputOutput myIO = new InputOutput();
            myIO.announceWinner(game.player2Won());
            if (!myIO.playAgain())
                break;
        }
    }
}
