package com.mypackage;

import org.junit.Test;

public class HowManySticksLeftTest {
    CalculateSquareNumbers calc;

    public HowManySticksLeftTest() {
        calc = new CalculateSquareNumbers();
    }

    @Test
    public void validateSubtraction() {
        this.calc.subtract(5);
    }

}