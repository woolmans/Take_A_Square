package com.mypackage.state;

import com.mypackage.Round;

public class Zero implements State {

    private int sticks;

    public Zero(int sticks) {
        this.sticks = sticks;
    }
    public String createPrompt(Round round) {
        if (sticks == 0) {
            round.setPrompt(new Zero(sticks));
            return "You typed letters, zero or just return (↵). Try again.";
        }
        return new TooLarge().createPrompt(round);
    }
}
