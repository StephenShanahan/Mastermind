package com.example.sshan.mastermind4;


public class Code {

    public static int[] Generate() {

        // 1 red 2 blue 3 green 4 yellow

        int[] pegs = {1,2,3,4};
        int code[] = new int [4];
        for (int i = 0; i < code.length; i++) {
            code[i] = (int) ((Math.random() * pegs.length) + 1);
            for (int j = 0; j < i; j++) {//no duplicates. add in a boolean check to see if duplicates allowed.
                if (code[i] == code[j]) {
                    i--;
                    break;
                }
            }
        }
        return code;
    }
}
