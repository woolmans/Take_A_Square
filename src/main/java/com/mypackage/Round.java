package com.mypackage;

import com.mypackage.state.*;
import com.mypackage.state.PerfectSquare;

public class Round {

    private State state = new NotASquare();
    private int sticksLeft;
    final InputOutput myIO;

    public Round(InputOutput myIO, boolean player, int sticksLeft) {
        this.myIO = myIO;
        this.sticksLeft = sticksLeft;
        myIO.announcePlayer(player);
    }

    void makeMove() {
        while (!PerfectSquare.class.equals(this.state.getClass())) {
            checkForPerfectSquare();
            myIO.printToCl(state.createPrompt(this));
        }
        myIO.displaySticks(sticksLeft);
    }

    private void checkForPerfectSquare() {
        int number = myIO.clInt();
        if (number > 0 && number < sticksLeft)
            isPerfectSquare(number);
        else
            state = new SubZero(number);
    }

    void isPerfectSquare(double x) {
        double sr = Math.sqrt(x);
        if ((sr - Math.floor(sr)) == 0) {
            sticksLeft -= x;
            state = new PerfectSquare();
        }
    }

    public void setPrompt(State newState) {
        state = newState;
    }

    public int getSticksLeft() {
        return sticksLeft;
    }

}
