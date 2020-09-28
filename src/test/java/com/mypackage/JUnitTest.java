package com.mypackage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

// @RunWith(Parameterized.class)
public class JUnitTest {

    String expectedWinner = "Player 2 won.";

    @Test
    public void getWinner() {
        Game game = new Game();
        // game.getWinner();
        assertEquals(this.expectedWinner, game.getWinner());
    }

}