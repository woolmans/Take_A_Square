package com.mypackage;

import java.text.NumberFormat;

public class Player {

    private int sticksLeft;
    private Logic logic;

    public Player(boolean player, int sticksLeft) {
        this.sticksLeft = sticksLeft;
        new InputOutput().announcePlayer(player);
    }

    public void makeMove() {
        Logic newLog = new Logic(sticksLeft);
        newLog.makeMove();
        sticksLeft = newLog.getSticksLeft();
    }

    public int getSticksLeft() {
        return sticksLeft;
    }
}
