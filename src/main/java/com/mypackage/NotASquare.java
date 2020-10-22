package com.mypackage;

class NotASquare implements Prompt {

    public NotASquare() {
    }

    public String createPrompt(Round round) {
        return "Not a perfect square. Please try again.";
    }
}