package com.mypackage;

class NotASquare implements Prompt {

    public NotASquare() {
    }

    public String writePrompt(Logic logic) {
        return "Not a perfect square. Please try again.";
    }
}