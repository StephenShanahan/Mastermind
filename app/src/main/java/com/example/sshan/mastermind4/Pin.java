package com.example.sshan.mastermind4;

import java.util.ArrayList;

public class Pin {

    public static int[] showPin(int[] p) {

        int[] code = Code.getCodePins();
        int[] pegCode = p;
        int black = 0;
        int white = 0;
        int[] pins = new int[2];
        boolean[] codeUsed = new boolean[code.length];
        boolean[] guessUsed = new boolean[pegCode.length];



        for (int i = 0; i < code.length; i++) {
            if (code[i] == pegCode[i]) {
                black++;
                codeUsed[i] = guessUsed[i] = true;
            }
        }

        // Compare matching colors for "pins" that were not used
        for (int i = 0; i < code.length; i++) {
            for (int j = 0; j < pegCode.length; j++) {
                if (codeUsed[i] == false && guessUsed[j] == false && code[i] == pegCode[j]) {
                    white++;
                    codeUsed[i] = guessUsed[j] = true;
                    break;
                }
            }
        }

        pins[0] = black;
        pins[1] = white;

        return pins;
    }
}
// TODO: 14/02/2016 Need to figure out dimension problem!!!!!!! ALso this loop will give out too much information if duplicates are allowed. Replicate other drawing system for pins. Redundant
// TODO: 15/02/2016 sure but other method is glitchy and breaks in place method of drawing. 