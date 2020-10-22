package com.mypackage;

public class SubZero implements Prompt {

    private int sticks;

    public SubZero(int sticks) {
        this.sticks = sticks;
    }

    public String createPrompt(Round round) {
        if (sticks < 0) {
            round.setPrompt(new SubZero(sticks));
            return "You chose a number below zero. Try again.";
        }
        Zero zero = new Zero(sticks);
        return zero.createPrompt(round);
    }
}
