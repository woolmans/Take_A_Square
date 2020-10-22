package com.mypackage;

public class TooLarge implements Prompt {

    public TooLarge() {
    }

    public String createPrompt(Round round) {
        round.setPrompt(new TooLarge());
        return "The number is equal or greater than the amount of remaining sticks.";
    }
}