package com.example.sshan.mastermind4;

public class Peg extends MainActivity{


    static boolean b;

    public static void pegFalse(){
        if(b == true)
            b = false;
    }

    public static void pegRelease(){

        b = true;

    }

    public static boolean isPegReleased(){
            return b;

    }
}
