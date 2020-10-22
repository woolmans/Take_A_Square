package com.mypackage;

public class Round {

    private Prompt prompt = new NotASquare();
    private int sticksLeft;
    final InputOutput myIO;

    public Round(InputOutput myIO, boolean player, int sticksLeft) {
        this.myIO = myIO;
        this.sticksLeft = sticksLeft;
        myIO.announcePlayer(player);
    }

    void makeMove() {
        while (this.prompt.getClass() != PerfectSquare.class) {
            int number = myIO.clInt();
            if (number > 0 && number < sticksLeft)
                isPerfectSquare(number);
            else
                prompt = new SubZero(number);
            myIO.printToCI(prompt.createPrompt(this));
        }
        myIO.displaySticks(sticksLeft);
    }

    void isPerfectSquare(double x) {
        double sr = Math.sqrt(x);
        if ((sr - Math.floor(sr)) == 0) {
            sticksLeft -= x;
            prompt = new PerfectSquare();
        }
    }

    void setPrompt(Prompt newPrompt) {
        prompt = newPrompt;
    }

    public int getSticksLeft() {
        return sticksLeft;
    }

}
