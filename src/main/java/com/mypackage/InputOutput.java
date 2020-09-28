package com.mypackage;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

/* This seems to be a utility class with IO methods. Probably they can be
moved to the GameStarter class at some point, because this class doesn't
need to have state at all. Alternatively you could try to make a static
import of this class in the GameStarter class. */
public class InputOutput {

    public static String clString() {
        return "";
    }

    public static int clInt() {
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }

    public static int drawSticks(String question) {
        System.out.println(question);
        int drawSticks;
        // return 1;
        return clInt();
    }

    public static void returnSticks(int sticks) {
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
