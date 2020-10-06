package com.mypackage;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

// A utility class with three IO methods.
public class InputOutput {

    public static int clInt() {
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }

    public static int drawSticks(String question) {
        System.out.println(question);
        int drawSticks;
        return clInt();
    }

    public static void displaySticks(int sticks) {
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

}
