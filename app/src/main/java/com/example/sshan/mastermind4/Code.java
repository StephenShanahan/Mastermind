package com.example.sshan.mastermind4;


public class Code extends MainActivity{

    static int[] codePins;
    private static boolean b;
    private static int codeLength;
    private static int colours;


    public static int[] Generate() {

        // 1 red 2 blue 3 green 4 yellow 5 purple 6 orange 7 pink 8 evergreen

        boolean boo = getDuplicates();
        codeLength = getCodeLength();
        colours = getColours();

        int[] pegs = {0};
        int [] pegs4 = {1,2,3,4};
        int [] pegs5 = {1,2,3,4,5};
        int[] pegs6 = {1,2,3,4,5,6};
        int[] pegs7 = {1,2,3,4,5,6,7};
        int[] pegs8 = {1,2,3,4,5,6,7,8};

        if(colours == 4)
            pegs = pegs4.clone();
        else if(colours == 5)
            pegs = pegs5.clone();
        else if(colours == 6)
            pegs = pegs6.clone();
        else if(colours == 7)
            pegs = pegs7.clone();
        else if(colours == 8)
            pegs = pegs8.clone();

        int code[] = new int [codeLength];
        if(!boo) {
            for (int i = 0; i < code.length; i++) {
                code[i] = (int) ((Math.random() * pegs.length) + 1);
                for (int j = 0; j < i; j++) {//no duplicates. add in a boolean check to see if duplicates allowed.
                    if (code[i] == code[j]) {
                        i--;
                        break;
                    }
                }
            }
        }
        else{
            for (int i = 0; i < code.length; i++) {
                code[i] = (int) ((Math.random() * pegs.length) + 1);
            }
        }

        codePins = code;

        return code;
    }

    public static int[] getCodePins(){

        return codePins;
    }

    public static void setDuplicates(boolean boo){
        b = boo;
    }

    public static boolean getDuplicates(){
        return b;
    }

    public static void setCodeLength(int x){
        codeLength = x;
    }

    public static int getCodeLength(){
        return codeLength;
    }

    public static void setColours(int x){
        colours = x;
    }

    public static int getColours(){
        return colours;
    }
}
