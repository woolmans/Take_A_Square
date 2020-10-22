package com.mypackage;

public class Zero implements Prompt {

    private int sticks;

    public Zero(int sticks) {
        this.sticks = sticks;
    }
    public String writePrompt(Logic logic) {
        if (sticks == 0) {
            logic.setPrompt(new Zero(sticks));
            return "You typed zero. Try again.";
        }
        return new TooLarge().writePrompt(logic);
    }
}
