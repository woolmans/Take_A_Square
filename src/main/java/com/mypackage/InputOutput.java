package com.mypackage;

import java.util.Arrays;
import java.util.Scanner;

public class InputOutput {

    public int clInt() {
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }

    public void printToCI(String str) {
        System.out.println(str);
    }

    public void announcePlayer(boolean player1) {
        if (player1)
            System.out.print("Player 1: ");
        else
            System.out.print("Player 2: ");
    }

    public void announceWinner(boolean player1) {
        if (player1)
            System.out.println("Player 2 won!");
        else
            System.out.println("Player 1 won!");
    }

    public void displaySticks(int sticks) {
        char[] myArray = new char[sticks];
        int i = 5;
        Arrays.fill(myArray, '|');
        StringBuilder sb = new StringBuilder(myArray.length);
        for (Character ch : myArray) {
            sb.append(ch);
        }
        for (int j = 0; j < sticks / 5; j++) {
            sb.insert(i, ' ');
            i = i + 6;
        }
        System.out.print(sb.toString());
        if (sticks > 1)
            System.out.println(" (" + sticks + " sticks left.)");
        else
            System.out.println(" (" + sticks + " stick left.)");
    }

    public boolean playAgain() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Do you want to play again?\nType Y/N: ");
        return sc.next().toLowerCase().equals("y");
    }

}
