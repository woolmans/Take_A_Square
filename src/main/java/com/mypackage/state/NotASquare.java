package com.mypackage.state;

import com.mypackage.Round;

public class NotASquare implements State {

    public NotASquare() {
    }

    public String createPrompt(Round round) {
        return "Not a perfect square. Please try again.";
    }
}
