package com.example.sshan.mastermind4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton redButton = (ImageButton) findViewById(R.id.redPeg);
        redButton.setOnClickListener(this);

        ImageButton greenButton = (ImageButton) findViewById(R.id.greenPeg);
        greenButton.setOnClickListener(this);

        ImageButton blueButton = (ImageButton) findViewById(R.id.bluePeg);
        blueButton.setOnClickListener(this);

        ImageButton yellowButton = (ImageButton) findViewById(R.id.yellowPeg);
        yellowButton.setOnClickListener(this);

        ImageButton codeButton = (ImageButton) findViewById(R.id.CodeButton);
        codeButton.setOnClickListener(this);

        ImageButton lineButton = (ImageButton) findViewById(R.id.LineButton);
        lineButton.setOnClickListener(this);

    }

    public void onClick(View v) {

        int[] code = Code.Generate();

        Toast pieceToast=null;
        ImageButton imgBus;
        String buttonID;
        int resID;
        int x = 1;
        int y = 1;
        int z = 0;

        boolean b;

                switch (v.getId()) {

                    case R.id.redPeg:

                        b = Full();
                        if(b == false) {
                            z = pegPosition();
                            buttonID = "pegimage" + String.valueOf(z);
                            // buttonID = position();
                            resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                            imgBus = ((ImageButton) findViewById(resID));
                            imgBus.setImageResource(R.drawable.red_peg_nobg); // to remove this image, imgBus.setImageDrawable(null)
                            imgBus.setTag("full");
                        }
                        else {
                            pieceToast = Toast.makeText(getApplicationContext(), "Press the LineButton", Toast.LENGTH_SHORT);
                            pieceToast.show();
                        }
                        break;

                    case R.id.greenPeg:

                        b = Full();
                        if(b == false) {
                        z =  pegPosition();
                        buttonID = "pegimage" + String.valueOf(z);
                        // buttonID = position();
                        resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                        imgBus = ((ImageButton) findViewById(resID));
                        imgBus.setImageResource(R.drawable.green_peg2_nobg);
                        imgBus.setTag("full");
                        }
                        else {
                            pieceToast = Toast.makeText(getApplicationContext(), "Press the LineButton", Toast.LENGTH_SHORT);
                            pieceToast.show();
                        }

                        break;

                    case R.id.bluePeg:

                        b = Full();
                        if(b == false) {
                        z =  pegPosition();
                        buttonID = "pegimage" + String.valueOf(z);
                        // buttonID = position();
                        resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                        imgBus = ((ImageButton) findViewById(resID));
                        imgBus.setImageResource(R.drawable.blue_peg2_nobg);
                        imgBus.setTag("full");
                        }
                        else {
                            pieceToast = Toast.makeText(getApplicationContext(), "Press the LineButton", Toast.LENGTH_SHORT);
                            pieceToast.show();
                        }

                    break;

                     case R.id.yellowPeg:
                         b = Full();
                         if(b == false) {
                         z =  pegPosition();
                         buttonID = "pegimage" + String.valueOf(z);
                         // buttonID = position();
                         resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                         imgBus = ((ImageButton) findViewById(resID));
                         imgBus.setImageResource(R.drawable.yellow_peg2_nobg);
                         imgBus.setTag("full");
                         }
                         else {
                             pieceToast = Toast.makeText(getApplicationContext(), "Press the LineButton", Toast.LENGTH_SHORT);
                             pieceToast.show();
                         }

                    break;

                    case R.id.CodeButton:

                        String displayCode= "";
                        for(int q=0;q<code.length;q++){
                            displayCode += String.valueOf(code[q]);
                        }

                        pieceToast = Toast.makeText(getApplicationContext(), displayCode, Toast.LENGTH_SHORT);
                        pieceToast.show();


                        break;

                    case R.id.LineButton:



                        break;

                default:
                    break;
               }
           // }
       // }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

  /*  public void select(View v)
    {

        ImageView iv = new ImageView(this);
        iv.setImageResource(R.drawable.red_peg2);
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.gameRow1);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
             RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.BELOW, R.id.gameRow1);
        //lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        lp.addRule(RelativeLayout.ALIGN_LEFT);
        rl.addView(iv, lp);

    }*/

    public void select(View v)
    {
        ImageButton imgBug;
        String buttonID;
        int z = 21;
        //String jumble = String.valueOf(z);

        for(int x=0;x<2;x++) {
            if (x == 0) {
                buttonID = "pegimage" + String.valueOf(z);//"21"
            } else {
                buttonID = "testimg1";
            }
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            imgBug = ((ImageButton) findViewById(resID));
            imgBug.setImageResource(R.drawable.red_peg_nobg);
        }

    }//one for loop for row and one inner for loop for position. judge click off id pressed have all buttons flow into smae onclikc select method.

    public void selectBlue(View v) //put another method that handles the row and position movements and passes the id to the clcikable.
    {

        //adds source image to blank imageview on click
        ImageView imgBus;
        //imgBus = (ImageView) findViewById(R.id.testimg2);
        imgBus = (ImageView) findViewById(R.id.pegimage22);
        imgBus.setImageResource(R.drawable.blue_peg2_nobg);
    }

    public void selectRed(View v)
    {

        //adds source image to blank imageview on click
        ImageButton imgBus;
        String buttonID;
       // imgBus = (ImageView) findViewById(R.id.testimg1);
        //imgBus = (ImageView) findViewById(R.id.pegimage21);
        for( int x=0;x<2;x++) {
            if(x == 0) {
                 buttonID = "pegimage" + "21";
            }
            else{
                buttonID = "testimg1";
            }
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            imgBus = ((ImageButton) findViewById(resID));
            imgBus.setImageResource(R.drawable.red_peg_nobg);
        }

    }// add a for loop y that relates to row position. have an undo method that removes the position from an array so it can go back into for loop?

    public void selectGreen(View v)
    {

        //adds source image to blank imageview on click
        ImageView imgBus;
        //imgBus = (ImageView) findViewById(R.id.testimg3);
        imgBus = (ImageView) findViewById(R.id.pegimage23);
        imgBus.setImageResource(R.drawable.green_peg2_nobg);

    }

    public void selectYellow(View v)
    {

        //adds source image to blank imageview on click
        ImageView imgBus;
        //imgBus = (ImageView) findViewById(R.id.testimg4);
        imgBus = (ImageView) findViewById(R.id.pegimage24);
        imgBus.setImageResource(R.drawable.yellow_peg2_nobg);

    }


  /*  public String position()
    {
        String position = "pegimage";

        return position + String.valueOf(guessRow()) + String.valueOf(guessPosition());
        //a whole other class that uses the check if source on an array that has every source image or whatever. to check if they're full. if they're not if sends that back to position to
        //return the correct value to the row managment

    }*/

    public int pegPosition() {

        //               0               4                   9                   14                  19                  24                  29                  34                     39
        int[] pegList = {11, 12, 13, 14, 21, 22, 23, 24, 31, 32, 33, 34, 41, 42, 43, 44, 51, 52, 53, 54, 61, 62, 63, 64, 71, 72, 73, 74, 81, 82, 83, 84, 91, 92, 93, 94, 101, 102, 103, 104};


        String image;
        int resID;
        int x = 0;
        int z = 0;
        ImageButton testImg;

        int testID;
        String image2;
        boolean b;

            for (int i = 0; i < 40; i++) {
                image2 = "pegimage" + String.valueOf(pegList[i]);
                testID = getResources().getIdentifier(image2, "id", getPackageName());
                testImg = ((ImageButton) findViewById(testID));
                if (!testImg.getTag().toString().equalsIgnoreCase("full")) {
                    x = i;
                    i = i + 40;
                    //testImg.setTag("full");
                }

            }

           // image = "pegimage" + String.valueOf(pegList[z]);
          //  resID = getResources().getIdentifier(image, "id", getPackageName());// "com.example.sshan.mastermind4");
          //  ImageButton imgBus = ((ImageButton) findViewById(resID));
          //  imgBus.setImageResource(R.drawable.yellow_peg2_nobg);

          //  imgBus.setTag("full");

           // boolean b = false;

           // if (imgBus.getTag().toString().equalsIgnoreCase("full")) {
           //     b = true;
                //x++;
          //  } else {
          //      b = false;
                //x++;
          //  }


        //Toast pieceToast;
          //  pieceToast = Toast.makeText(getApplicationContext(), String.valueOf(x), Toast.LENGTH_SHORT);
            //pieceToast.show();

            z = (pegList[x]);
            return z;

        }

    public boolean Full()
    {
        int[] pegList = {11, 12, 13, 14, 21, 22, 23, 24, 31, 32, 33, 34, 41, 42, 43, 44, 51, 52, 53, 54, 61, 62, 63, 64, 71, 72, 73, 74, 81, 82, 83, 84, 91, 92, 93, 94, 101, 102, 103, 104};


        ImageButton testImg1, testImg2, testImg3, testImg4;

        int testID;
        String image2;
        boolean b = false;
        //int a = 0;
        for(int a = 0;a < 40; a = a + 4) {

            image2 = "pegimage" + String.valueOf(pegList[a]);
            testID = getResources().getIdentifier(image2, "id", getPackageName());
            testImg1 = ((ImageButton) findViewById(testID));

            image2 = "pegimage" + String.valueOf(pegList[a+1]);
            testID = getResources().getIdentifier(image2, "id", getPackageName());
            testImg2 = ((ImageButton) findViewById(testID));

            image2 = "pegimage" + String.valueOf(pegList[a+2]);
            testID = getResources().getIdentifier(image2, "id", getPackageName());
            testImg3 = ((ImageButton) findViewById(testID));

            image2 = "pegimage" + String.valueOf(pegList[a+3]);
            testID = getResources().getIdentifier(image2, "id", getPackageName());
            testImg4 = ((ImageButton) findViewById(testID));
            if(testImg1.getTag().toString().equalsIgnoreCase("full") && testImg2.getTag().toString().equalsIgnoreCase("full") &&
                    testImg3.getTag().toString().equalsIgnoreCase("full") && testImg4.getTag().toString().equalsIgnoreCase("full")) {
                b = true;
                a = 50;
            }
            else
                b = false;
        }

        return b;
    }

    public int[] PegCodeGenerate(){

        int[] peg = new int[4];



        return peg;
    }

    public boolean PegRelease(){

        boolean b = true;

        //need to put a call in here that reads a finished code generated line and then we return true to Full to reduce the int a from 50 to the next 4 digits.

        return b;
    }

}
//set a int array code of 4 digits at the start. once a peg image is set, add a tag of the number (red for 1 etc.) and then on click of row accept, check code vs tags. or add tags to
// then check against using sorting algorithms.