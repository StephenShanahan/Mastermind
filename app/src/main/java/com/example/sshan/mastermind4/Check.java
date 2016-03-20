package com.example.sshan.mastermind4;


import java.util.ArrayList;
//import java.util.Iterator;

public class Check {

    static ArrayList<Integer> pegCode = new ArrayList<>();
    static ArrayList<Integer> countCode = new ArrayList<>();
    static int[] pins = new int[2];
    static int codeLength;


    public static boolean CheckGame(int code[]) {
         boolean win = false;


        int[] peg = getPegCode();

        codeLength = getCodeLength();
        if(codeLength == 4) {
            for (int i = 0; i < 1; i++)
                if ((peg[0] == code[0]) && (peg[1] == code[1]) && (peg[2] == code[2]) && (peg[3] == code[3]))
                    win = true;
                else
                    win = false;
        }
        else if(codeLength == 6){
            for (int i = 0; i < 1; i++)
                if ((peg[0] == code[0]) && (peg[1] == code[1]) && (peg[2] == code[2]) && (peg[3] == code[3]) && (peg[4] == code[4]) && (peg[5] == code[5]))
                    win = true;
                else
                    win = false;
        }

        pins  = Pin.showPin(peg);
        clearPegCode();
        return win;
    }

    public static void setPegCode(int x) {

       // Iterator iterator = pegCode.iterator();
        boolean b = true;

        if(pegCode.size() == 0) {
            pegCode.add(x);
        }
        else {
            for (int i = 0; i < pegCode.size(); i++) {
                if (pegCode.get(i) == 9) {
                    pegCode.set(i, x);
                    b = true;
                    break;
                }
                else
                    b = false;
            }
        }

        if(b == false)
            pegCode.add(x);

    }

    public static void removePegCode(int x){

        x = x-1;
        pegCode.set(x, 9);// keeps index position alive. can then implement like a next of code of some sort. replace null with number

        //pegCode.clear();

    }

    public static void clearPegCode() {

        pegCode.clear();
    }

    public static int[] getPegCode() {

        int[] ret = new int[pegCode.size()];
        for (int i = 0; i < pegCode.size(); i++) {
            countCode.add(pegCode.get(i));
        }

        for (int i = 0; i < pegCode.size(); i++) {
            ret[i] = pegCode.get(i);
        }

        return ret;
    }

    public static ArrayList<Integer> getCountCode(){

        return countCode;
    }

    public static void clearCountcode(){
        countCode.clear();
    }

    public static int[] ReturnPins(){

        if(pins == null)
        {
            pins[0] = 9;
            pins[1] = 9;
        }
        return pins;
    }

    public static void setCodeLength(int x){
        codeLength = x;
    }

    public static int getCodeLength(){
        return codeLength;
    }

}
