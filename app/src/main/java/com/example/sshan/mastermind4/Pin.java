package com.example.sshan.mastermind4;

import java.util.ArrayList;

public class Pin {

    public static int[] showPin(int[] c, int[] p) {

        int[] code = c;
        int[] pegCode = p;
        int black = 0;
        int white = 0;
        int temp = 10;
        int whiteCheck;
        int[] pins = new int[2];
        //ArrayList<Integer> pins = new ArrayList<>();

        for(int x=0;x<code.length;x++)
        {
            for(int y=0;y<pegCode.length;y++)
            {
                if(x==y &&(code[x] == pegCode[y]))
                    black++;
                else if(code[x] == pegCode[y])
                {
                    whiteCheck = code[x];
                    if(whiteCheck == temp)
                        temp=whiteCheck;
                    else{
                        white++;
                        temp = code[x];
                    }
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