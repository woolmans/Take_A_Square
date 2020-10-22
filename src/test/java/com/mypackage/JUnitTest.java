package com.mypackage;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class JUnitTest {

    Round newRound;
    Game newGame;
    InputOutput myIO = Mockito.mock(InputOutput.class);

    public JUnitTest() {
    }

    @Test
    public void makeMove() {
        newRound = new Round(myIO, true, 20);
        when(myIO.clInt()).thenReturn(4);
        newRound.makeMove();
        assertEquals(16, newRound.getSticksLeft());
        verify(myIO).clInt();
    }

    @Test
    public void getWinner() {
        newGame = new Game(19);
        newGame.setMyIO(myIO);
        when(myIO.clInt()).thenReturn(1);
        assertEquals(true, newGame.player2Won());
        verify(myIO, atLeast(1)).clInt();
    }
}