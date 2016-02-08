package com.example.sshan.mastermind4;


import android.app.Fragment;
import android.widget.ImageButton;
import android.view.View;
import android.widget.Toast;


public class Peg extends MainActivity{

    public static boolean pegPosition(View v) {

                       //1               5                   10                  15
        int[] pegList = {11, 12, 13, 14, 21, 22, 23, 24, 31, 32, 33, 34, 41, 42, 43, 44, 51, 52, 53, 54, 61, 62, 63, 64, 71, 72, 73, 74, 81, 82, 83, 84, 91, 92, 93, 94, 101, 102, 103, 104};


        //String image = "pegimage" + String.valueOf(pegList[7]);
        int resID;
       //setContentView(R.layout.activity_main);
       // ImageButton imgBus;
        resID = v.getResources().getIdentifier("pegimage14", "id", "com.example.sshan.mastermind4");
        ImageButton imgBus = ((ImageButton) v.findViewById(resID));
        //imgBus.setImageResource(R.drawable.yellow_peg2_nobg);

        //imgBus.setTag("full");

      //  Toast pieceToast=null;

     //   pieceToast = Toast.makeText(null, "Image Button Three Clicked", Toast.LENGTH_SHORT);
     //   pieceToast.show();

        boolean b = false;

        if(imgBus.getTag().toString().equalsIgnoreCase("full")){
            b = true;
        }
        else
          b = false;

        return b;
    }
}
