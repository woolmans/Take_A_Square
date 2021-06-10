package com.mypackage.state;

import com.mypackage.Round;

public class TooLarge implements State {

    public TooLarge() {
    }

    public String createPrompt(Round round) {
        round.setPrompt(new TooLarge());
        return "The number is equal or greater than the amount of remaining sticks.";
    }
}
