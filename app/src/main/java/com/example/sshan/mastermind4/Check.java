package com.example.sshan.mastermind4;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;

public class Check {

    static ArrayList<Integer> pegCode = new ArrayList<>();
    static ArrayList<Integer> countCode = new ArrayList<>();
    static int[] pins = new int[2];


 /*   public static int[] CheckPin(int [] c){

        int[] peg = getPegCode();
        int[] code = c;

        int[] pins  = Pin.showPin(code, peg);

        return pins;
    }*/

    public static boolean CheckGame(int code[]) {
         boolean win = false;

        //int[] ret = new int[peg.size()];
        //Iterator<Integer> iterator = peg.iterator();
        //for (int i = 0; i < ret.length; i++)
        //{
        //    ret[i] = iterator.next().intValue();
        //}

        // 1 red 2 blue 3 green 4 yellow

      /*  for(int c = 0;c < peg.size();c++) {
            for (int q = 0; q < code.length; q++) {
                if (peg.get(c).equals(code[q])) {
                    win = true;
                }
            }
        }*/


      /*  Toast pieceToast;
        String displayCode= "";
        for(int q=0;q<ret.length;q++){
            displayCode += String.valueOf(ret[q]);
        }

        pieceToast = Toast.makeText(null, displayCode, Toast.LENGTH_SHORT);
        pieceToast.show();*/
        int[] peg = getPegCode();

       /* for(int c = 0;c < peg.length;c++) {
            for (int q = 0; q < code.length; q++) {//problem! pegcode is continually added, so will eventually be a 40 size array(solved) and this is only as good as checking the last position
                if (peg[c] == code[q]) {            //vs. the last positon of pegcode vs the last position of code(solved). could use the arraylist size to calc the a value in Full().
                    win = true;                     //gonna run into problems when implementing removing buttons - how to remove from arraylist if not the last one clicked, e.g. add 2 pegs,
                }                                   //remove the first one. how to remove from list. need to check list each time and fill in gaps then add numbers in other area?
                else
                    win = false;
            }
        }*/

    /*    for (int i = 0; i < peg.length; i++) {
            if (peg[i] != code[i]) {
                return false;
            }
        }
        //return true; */

        for(int i = 0; i < 1;i++)
            if((peg[0] == code[0]) && (peg[1] == code[1]) && (peg[2] == code[2]) && (peg[3] == code[3]))
                win = true;
            else
                win = false;

        pins  = Pin.showPin(peg);
        clearPegCode();
        return win;
    }

    public static void setPegCode(int x) {

        //ArrayList<Integer> pegCode= new ArrayList<>();
        pegCode.add(x);

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

}
