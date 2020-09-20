package com.mypackage;
import java.util.Random;

public class CalculateSquareNumbers {

    int totalNumber;
    int subtractNumber;

    public CalculateSquareNumbers(){
        var rand = new Random();
        totalNumber = rand.nextInt(199) + 1;
    }

    public int subtract(int total) {
        return totalNumber - total;
    }

}