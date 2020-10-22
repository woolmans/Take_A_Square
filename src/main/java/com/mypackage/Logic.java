package com.mypackage;

public class Logic {

    private Prompt prompt = new NotASquare();
    private int sticksLeft;
    final InputOutput myIO;

    // For testing purpose.
    public Logic(InputOutput myIO, int sticksLeft) {
        this.sticksLeft = sticksLeft;
        this.myIO = myIO;
    }

    public Logic(int sticksLeft) {
        this.sticksLeft = sticksLeft;
        myIO = new InputOutput();
    }

    void createPrompt(Prompt newPrompt) {
        prompt = newPrompt;
    }

    void makeMove() {
        while (this.prompt.getClass() != PerfectSquare.class) {
            int number = myIO.clInt();
            // If number is out of the value range.
            if (number <= 0 || number >= sticksLeft) {
                prompt = new SubZero(number);
            }
            // Else.
            else {
                isPerfectSquare(number);
            }
            myIO.printToCI(prompt.writePrompt(this));
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

    public Prompt getPrompt() {
        return prompt;
    }

    void setPrompt(Prompt newPrompt) {
        prompt = newPrompt;
    }

    public int getSticksLeft() {
        return sticksLeft;
    }

}
