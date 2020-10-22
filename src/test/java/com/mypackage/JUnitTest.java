package com.mypackage;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class JUnitTest {

    Player rx;
    Player ry;
    Logic newLog;
    InputOutput myIO = Mockito.mock(InputOutput.class);

    public JUnitTest() {
    }

    @Test
    public void makeMove() {
        newLog = new Logic(myIO, 20);
        when(myIO.clInt()).thenReturn(4);
        newLog.makeMove();
        assertEquals(16, newLog.getSticksLeft());
        verify(myIO).clInt();
    }

}