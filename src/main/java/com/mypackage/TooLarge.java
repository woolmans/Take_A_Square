package com.mypackage;

public class TooLarge implements Prompt {

    public TooLarge() {
    }

    public String writePrompt(Logic logic) {
        logic.setPrompt(new TooLarge());
        return "The number is equal or greater than the amount of remaining sticks.";
    }
}