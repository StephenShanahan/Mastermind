package com.example.sshan.mastermind4;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity implements OnClickListener {

    MediaPlayer mp;
    int codeLength;
    int[] code = {0};
    ImageButton codeButton, orangeButton, purpleButton, pinkButton, evergreenButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());   // SHARED PREFERENCES
        boolean boo = SP.getBoolean("duplicates", false);
        String str = SP.getString("pegs", "1");
        String colour = SP.getString("colours", "4");

        if(str.equalsIgnoreCase("1")){
            setContentView(R.layout.activity_main);
        }
        else if(str.equalsIgnoreCase("2"))
            setContentView(R.layout.test_game_6);

        ImageButton redButton = (ImageButton) findViewById(R.id.redPeg);
        redButton.setOnClickListener(this);

        ImageButton greenButton = (ImageButton) findViewById(R.id.greenPeg);
        greenButton.setOnClickListener(this);

        ImageButton blueButton = (ImageButton) findViewById(R.id.bluePeg);
        blueButton.setOnClickListener(this);

        ImageButton yellowButton = (ImageButton) findViewById(R.id.yellowPeg);
        yellowButton.setOnClickListener(this);

        codeButton = (ImageButton) findViewById(R.id.CodeButton);
        codeButton.setOnClickListener(this);

        Button lineButton = (Button) findViewById(R.id.LineButton);
        lineButton.setOnClickListener(this);

        purpleButton = (ImageButton) findViewById(R.id.purplePeg);
        purpleButton.setOnClickListener(this);

        orangeButton = (ImageButton) findViewById(R.id.orangePeg);
        orangeButton.setOnClickListener(this);

        pinkButton = (ImageButton) findViewById(R.id.pinkPeg);
        pinkButton.setOnClickListener(this);

        evergreenButton = (ImageButton) findViewById(R.id.evergreenPeg);
        evergreenButton.setOnClickListener(this);


        if(str.equalsIgnoreCase("2"))
            codeLength = 6;
        else
            codeLength = 4;

        setColourPegs(Integer.parseInt(colour));

        Peg.pegFalse();

        Code.setDuplicates(boo);

        Code.setColours(Integer.parseInt(colour));

        Code.setCodeLength(codeLength);
        Check.setCodeLength(codeLength);

        code = Code.Generate();
    }

    public void onClick(View v) {

        int[] code = codeGenerator();

        boolean constant = false;
        if(codeLength == 6)
            constant = true;

        Toast pieceToast;
        ImageButton imgBus;
        String buttonID;
        int resID;
        int z = 0;
        int[] pins;

        boolean b;
        boolean win;

        switch (v.getId()) {

            case R.id.redPeg:

                b = Full();
                if (!b) {
                    z = pegPosition();
                    buttonID = "pegimage" + String.valueOf(z);
                    resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                    imgBus = ((ImageButton) findViewById(resID));
                    if(constant)
                        imgBus.setImageResource(R.drawable.red_peg_nobg_small);
                    else
                        imgBus.setImageResource(R.drawable.red_peg_nobg);

                    imgBus.setTag("1");
                    Check.setPegCode(1);
                } else {
                    pieceToast = Toast.makeText(getApplicationContext(), "Press the Check Button", Toast.LENGTH_SHORT);
                    pieceToast.show();
                }
                break;

            case R.id.greenPeg:

                b = Full();
                if (!b) {
                    z = pegPosition();
                    buttonID = "pegimage" + String.valueOf(z);
                    resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                    imgBus = ((ImageButton) findViewById(resID));
                    if(constant)
                        imgBus.setImageResource(R.drawable.green_peg2_nobg_small);
                    else
                        imgBus.setImageResource(R.drawable.green_peg2_nobg);

                    imgBus.setTag("3");
                    Check.setPegCode(3);
                } else {
                    pieceToast = Toast.makeText(getApplicationContext(), "Press the Check Button", Toast.LENGTH_SHORT);
                    pieceToast.show();
                }

                break;

            case R.id.bluePeg:

                b = Full();
                if (!b) {
                    z = pegPosition();
                    buttonID = "pegimage" + String.valueOf(z);
                    resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                    imgBus = ((ImageButton) findViewById(resID));
                    if(constant)
                        imgBus.setImageResource(R.drawable.blue_peg2_nobg_small);
                    else
                        imgBus.setImageResource(R.drawable.blue_peg2_nobg);

                    imgBus.setTag("2");
                    Check.setPegCode(2);
                } else {
                    pieceToast = Toast.makeText(getApplicationContext(), "Press the Check Button", Toast.LENGTH_SHORT);
                    pieceToast.show();
                }

                break;

            case R.id.yellowPeg:
                b = Full();
                if (!b) {
                    z = pegPosition();
                    buttonID = "pegimage" + String.valueOf(z);
                    resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                    imgBus = ((ImageButton) findViewById(resID));
                    if(constant)
                        imgBus.setImageResource(R.drawable.yellow_peg2_nobg_small);
                    else
                        imgBus.setImageResource(R.drawable.yellow_peg2_nobg);

                    imgBus.setTag("4");
                    Check.setPegCode(4);
                } else {
                    pieceToast = Toast.makeText(getApplicationContext(), "Press the Check Button", Toast.LENGTH_SHORT);
                    pieceToast.show();
                }

                break;

            case R.id.purplePeg:
                b = Full();
                if (!b) {
                    z = pegPosition();
                    buttonID = "pegimage" + String.valueOf(z);
                    resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                    imgBus = ((ImageButton) findViewById(resID));
                    if(constant)
                        imgBus.setImageResource(R.drawable.purple_peg2_nobg_small);
                    else
                        imgBus.setImageResource(R.drawable.purple_peg2_nobg);

                    imgBus.setTag("5");
                    Check.setPegCode(5);
                } else {
                    pieceToast = Toast.makeText(getApplicationContext(), "Press the Check Button", Toast.LENGTH_SHORT);
                    pieceToast.show();
                }

                break;

            case R.id.orangePeg:
                b = Full();
                if (!b) {
                    z = pegPosition();
                    buttonID = "pegimage" + String.valueOf(z);
                    resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                    imgBus = ((ImageButton) findViewById(resID));
                    if(constant)
                        imgBus.setImageResource(R.drawable.orange_peg2_nobg_small);
                    else
                        imgBus.setImageResource(R.drawable.orange_peg2_nobg);

                    imgBus.setTag("6");
                    Check.setPegCode(6);
                } else {
                    pieceToast = Toast.makeText(getApplicationContext(), "Press the Check Button", Toast.LENGTH_SHORT);
                    pieceToast.show();
                }

                break;

            case R.id.pinkPeg:
                b = Full();
                if (!b) {
                    z = pegPosition();
                    buttonID = "pegimage" + String.valueOf(z);
                    resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                    imgBus = ((ImageButton) findViewById(resID));
                    if(constant)
                        imgBus.setImageResource(R.drawable.pink_peg2_nobg_small);
                    else
                        imgBus.setImageResource(R.drawable.pink_peg2_nobg);

                    imgBus.setTag("7");
                    Check.setPegCode(7);
                } else {
                    pieceToast = Toast.makeText(getApplicationContext(), "Press the Check Button", Toast.LENGTH_SHORT);
                    pieceToast.show();
                }

                break;

            case R.id.evergreenPeg:
                b = Full();
                if (!b) {
                    z = pegPosition();
                    buttonID = "pegimage" + String.valueOf(z);
                    resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                    imgBus = ((ImageButton) findViewById(resID));
                    if(constant)
                        imgBus.setImageResource(R.drawable.evergreen_peg2_nobg_small);
                    else
                        imgBus.setImageResource(R.drawable.evergreen_peg2_nobg);

                    imgBus.setTag("8");
                    Check.setPegCode(8);
                } else {
                    pieceToast = Toast.makeText(getApplicationContext(), "Press the Check Button", Toast.LENGTH_SHORT);
                    pieceToast.show();
                }

                break;

            case R.id.CodeButton:

                String displayCode = "";
                for (int q = 0; q < code.length; q++) {
                    displayCode += String.valueOf(code[q]);
                }

                pieceToast = Toast.makeText(getApplicationContext(), displayCode, Toast.LENGTH_SHORT);
                pieceToast.show();


                break;

            case R.id.LineButton:

                b = Full();
                if(!b){
                    pieceToast = Toast.makeText(getApplicationContext(), "Please fill in all available peg slots", Toast.LENGTH_SHORT);
                    pieceToast.show();
                }
                else {
                    Peg.pegRelease();
                    win = Check.CheckGame(code);
                    pins = Check.ReturnPins();
                    drawPin(pins);
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                    if (win) {

                        mp = MediaPlayer.create(this, R.raw.win_noise);
                        mp.start();
                        String message = getString(R.string.dialog_text_win);
                        alertDialog.setTitle("Congratulations! You win");
                        alertDialog.setMessage(message);
                        alertDialog.setPositiveButton("Play", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent mIntent = getIntent();
                                finish();
                                startActivity(mIntent);
                                stopMedia();
                                Check.clearPegCode();
                                Check.clearCountcode();
                            }
                        });
                        alertDialog.setNegativeButton("Menu", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                stopMedia();
                            }
                        });
                        alertDialog.show();
                    }
                    else{
                        buttonID = "pegimage101";
                        resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                        imgBus = ((ImageButton) findViewById(resID));
                        if(imgBus.getTag().toString().matches("\\d")){
                            removeCheat();
                            displayText();
                            displayCode();
                            String message = getString(R.string.dialog_text_lose);
                            alertDialog.setTitle("Sorry! You lose.");
                            alertDialog.setMessage(message);
                            alertDialog.setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent mIntent = getIntent();
                                    finish();
                                    startActivity(mIntent);
                                    Check.clearPegCode();
                                    Check.clearCountcode();
                                }
                            });
                            alertDialog.setNegativeButton("Menu", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            });
                            alertDialog.show();
                        }
                    }
                }

                break;

            default:
                break;
        }

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

    public int pegPosition() {

        int[] pegList4 = {11, 12, 13, 14, 21, 22, 23, 24, 31, 32, 33, 34, 41, 42, 43, 44, 51, 52, 53, 54, 61, 62, 63, 64, 71, 72, 73, 74, 81, 82, 83, 84, 91, 92, 93, 94, 101, 102, 103, 104};

        int[] pegList6 = {11, 12, 13, 14, 15, 16, 21, 22, 23, 24, 25, 26, 31, 32, 33, 34, 35, 36, 41, 42, 43, 44, 45, 46, 51, 52, 53, 54, 55, 56, 61, 62, 63, 64, 65, 66, 71, 72, 73, 74, 75, 76, 81, 82, 83, 84, 85, 86, 91, 92, 93, 94, 95, 96, 101, 102, 103, 104, 105, 106};

        int[] pegList = {0};

        int x = 0;
        int z = 0;
        ImageButton testImg;
        int testID;
        String image2;

        if(codeLength == 4)
            pegList = pegList4.clone();
        else if(codeLength == 6)
            pegList = pegList6.clone();

        for (int i = 0; i < pegList.length; i++) {
            image2 = "pegimage" + String.valueOf(pegList[i]);
            testID = getResources().getIdentifier(image2, "id", getPackageName());
            testImg = ((ImageButton) findViewById(testID));
            if (!testImg.getTag().toString().matches("\\d")) {
                x = i;
                i = i + 100;
            }

        }

        z = (pegList[x]);
        return z;

    }

    public boolean Full() {
        int[] pegList4 = {11, 12, 13, 14, 21, 22, 23, 24, 31, 32, 33, 34, 41, 42, 43, 44, 51, 52, 53, 54, 61, 62, 63, 64, 71, 72, 73, 74, 81, 82, 83, 84, 91, 92, 93, 94, 101, 102, 103, 104};

        int[] pegList6 = {11, 12, 13, 14, 15, 16, 21, 22, 23, 24, 25, 26, 31, 32, 33, 34, 35, 36, 41, 42, 43, 44, 45, 46, 51, 52, 53, 54, 55, 56, 61, 62, 63, 64, 65, 66, 71, 72, 73, 74, 75, 76, 81, 82, 83, 84, 85, 86, 91, 92, 93, 94, 95, 96, 101, 102, 103, 104, 105, 106};

        int[] pegList = {0};

        int constant=0;

        if(codeLength == 4) {
            pegList = pegList4.clone();
            constant = 4;
        }
        else if(codeLength == 6) {
            pegList = pegList6.clone();
            constant = 6;
        }


        ImageButton testImg1, testImg2, testImg3, testImg4, testImg5, testImg6;

        int placeholder;
        placeholder = getResources().getIdentifier("pegimage11", "id", getPackageName());
        testImg5 = ((ImageButton) findViewById(placeholder));

        testImg6 = ((ImageButton) findViewById(placeholder));

        int testID;
        String image2;
        boolean b = false;
        boolean release = Peg.isPegReleased();
        int c = 0;
        if (release == true) {
            c = Check.getCountCode().size();
        }
        for (int a = c; a < pegList.length; a = a + constant) {

            image2 = "pegimage" + String.valueOf(pegList[a]);
            testID = getResources().getIdentifier(image2, "id", getPackageName());
            testImg1 = ((ImageButton) findViewById(testID));

            image2 = "pegimage" + String.valueOf(pegList[a + 1]);
            testID = getResources().getIdentifier(image2, "id", getPackageName());
            testImg2 = ((ImageButton) findViewById(testID));

            image2 = "pegimage" + String.valueOf(pegList[a + 2]);
            testID = getResources().getIdentifier(image2, "id", getPackageName());
            testImg3 = ((ImageButton) findViewById(testID));

            image2 = "pegimage" + String.valueOf(pegList[a + 3]);
            testID = getResources().getIdentifier(image2, "id", getPackageName());
            testImg4 = ((ImageButton) findViewById(testID));

            if(constant == 6) {
                image2 = "pegimage" + String.valueOf(pegList[a + 4]);
                testID = getResources().getIdentifier(image2, "id", getPackageName());
                testImg5 = ((ImageButton) findViewById(testID));

                image2 = "pegimage" + String.valueOf(pegList[a + 5]);
                testID = getResources().getIdentifier(image2, "id", getPackageName());
                testImg6 = ((ImageButton) findViewById(testID));

            }

            if(constant == 4) {

                if (testImg1.getTag().toString().matches("\\d") && testImg2.getTag().toString().matches("\\d") &&
                        testImg3.getTag().toString().matches("\\d") && testImg4.getTag().toString().matches("\\d")) {
                    b = true;
                    a = 100;
                } else
                    b = false;
            }
            else if(constant == 6){
                if(testImg1.getTag().toString().matches("\\d") && testImg2.getTag().toString().matches("\\d") &&
                        testImg3.getTag().toString().matches("\\d") && testImg4.getTag().toString().matches("\\d")
                        && testImg5.getTag().toString().matches("\\d") && testImg6.getTag().toString().matches("\\d")){
                    b = true;
                    a = 100;
                }
                else
                    b = false;
            }
        }

        return b;
    }

    //int[] code = Code.Generate();

    public int[] codeGenerator() {

        return code;
    }

    public void drawPin(int[] pins) {

        int[] pinsNeeded = pins;

        int[] pinList4 = {11, 12, 13, 14, 21, 22, 23, 24, 31, 32, 33, 34, 41, 42, 43, 44, 51, 52, 53, 54, 61, 62, 63, 64, 71, 72, 73, 74, 81, 82, 83, 84, 91, 92, 93, 94, 101, 102, 103, 104};

        int[] pinList6 = {11, 12, 13, 14, 15, 16, 21, 22, 23, 24, 25, 26, 31, 32, 33, 34, 35, 36, 41, 42, 43, 44, 45, 46, 51, 52, 53, 54, 55, 56, 61, 62, 63, 64, 65, 66, 71, 72, 73, 74, 75, 76, 81, 82, 83, 84, 85, 86, 91, 92, 93, 94, 95, 96, 101, 102, 103, 104, 105, 106};

        int[] pinList = {0};

        if(codeLength == 4)
            pinList = pinList4.clone();
        else if(codeLength == 6)
            pinList = pinList6.clone();


        int black = pinsNeeded[0];
        int white = pinsNeeded[1];
        int colour = white + black;

        ImageView testImg1, testImg2, testImg3, testImg4,testImg5,testImg6;

        int testID;
        String image2;
        boolean release = Peg.isPegReleased();
        int c = 0;
        if (release == true) {
            c = Check.getCountCode().size();
            if(codeLength == 4)
                c = c - 4;
            else if(codeLength == 6)
                c = c-6;
        }

        for (int a = c; a < pinList.length; a = a + 100) {

            if (colour == 1) {

                image2 = "pinImage" + String.valueOf(pinList[a]);
                testID = getResources().getIdentifier(image2, "id", getPackageName());
                testImg1 = ((ImageView) findViewById(testID));
                if (testImg1.getTag().toString().matches("empty")) {
                    if(black >0)
                    testImg1.setImageResource(R.drawable.blackpin);
                    else
                    testImg1.setImageResource(R.drawable.whitepin);
                    testImg1.setTag("full");
                    // black--;
                }
            } else if (colour == 2) {

                image2 = "pinImage" + String.valueOf(pinList[a]);
                testID = getResources().getIdentifier(image2, "id", getPackageName());
                testImg1 = ((ImageView) findViewById(testID));
                if (testImg1.getTag().toString().matches("empty")) {
                    if(black>0) {
                        testImg1.setImageResource(R.drawable.blackpin);
                        black--;
                    }
                    else if(white>0){
                        testImg1.setImageResource(R.drawable.whitepin);
                        white--;
                    }
                    testImg1.setTag("full");
                }

                image2 = "pinImage" + String.valueOf(pinList[a + 1]);
                testID = getResources().getIdentifier(image2, "id", getPackageName());
                testImg2 = ((ImageView) findViewById(testID));
                if (testImg2.getTag().toString().matches("empty")) {
                    if(black>0) {
                        testImg2.setImageResource(R.drawable.blackpin);
                        black--;
                    }
                    else if(white>0){
                        testImg2.setImageResource(R.drawable.whitepin);
                        white--;
                    }
                    testImg2.setTag("full");
                }
            } else if (colour == 3) {

                image2 = "pinImage" + String.valueOf(pinList[a]);
                testID = getResources().getIdentifier(image2, "id", getPackageName());
                testImg1 = ((ImageView) findViewById(testID));
                if (testImg1.getTag().toString().matches("empty")) {
                    if(black>0) {
                        testImg1.setImageResource(R.drawable.blackpin);
                        black--;
                    }
                    else if(white>0){
                        testImg1.setImageResource(R.drawable.whitepin);
                        white--;
                    }
                    testImg1.setTag("full");
                }

                image2 = "pinImage" + String.valueOf(pinList[a + 1]);
                testID = getResources().getIdentifier(image2, "id", getPackageName());
                testImg2 = ((ImageView) findViewById(testID));
                if (testImg2.getTag().toString().matches("empty")) {
                    if(black>0) {
                        testImg2.setImageResource(R.drawable.blackpin);
                        black--;
                    }
                    else if(white>0){
                        testImg2.setImageResource(R.drawable.whitepin);
                        white--;
                    }
                    testImg2.setTag("full");
                }

                image2 = "pinImage" + String.valueOf(pinList[a + 2]);
                testID = getResources().getIdentifier(image2, "id", getPackageName());
                testImg3 = ((ImageView) findViewById(testID));
                if (testImg3.getTag().toString().matches("empty")) {
                    if(black>0) {
                        testImg3.setImageResource(R.drawable.blackpin);
                        black--;
                    }
                    else if(white>0){
                        testImg3.setImageResource(R.drawable.whitepin);
                        white--;
                    }
                    testImg3.setTag("full");
                }

            } else if (colour == 4) {

                image2 = "pinImage" + String.valueOf(pinList[a]);
                testID = getResources().getIdentifier(image2, "id", getPackageName());
                testImg1 = ((ImageView) findViewById(testID));
                if (testImg1.getTag().toString().matches("empty")) {
                    if(black>0) {
                        testImg1.setImageResource(R.drawable.blackpin);
                        black--;
                    }
                    else if(white>0){
                        testImg1.setImageResource(R.drawable.whitepin);
                        white--;
                    }
                    testImg1.setTag("full");
                }

                image2 = "pinImage" + String.valueOf(pinList[a + 1]);
                testID = getResources().getIdentifier(image2, "id", getPackageName());
                testImg2 = ((ImageView) findViewById(testID));
                if (testImg2.getTag().toString().matches("empty")) {
                    if(black>0) {
                        testImg2.setImageResource(R.drawable.blackpin);
                        black--;
                    }
                    else if(white>0){
                        testImg2.setImageResource(R.drawable.whitepin);
                        white--;
                    }
                    testImg2.setTag("full");
                }

                image2 = "pinImage" + String.valueOf(pinList[a + 2]);
                testID = getResources().getIdentifier(image2, "id", getPackageName());
                testImg3 = ((ImageView) findViewById(testID));
                if (testImg3.getTag().toString().matches("empty")) {
                    if(black>0) {
                        testImg3.setImageResource(R.drawable.blackpin);
                        black--;
                    }
                    else if(white>0){
                        testImg3.setImageResource(R.drawable.whitepin);
                        white--;
                    }
                    testImg3.setTag("full");
                }

                image2 = "pinImage" + String.valueOf(pinList[a + 3]);
                testID = getResources().getIdentifier(image2, "id", getPackageName());
                testImg4 = ((ImageView) findViewById(testID));
                if (testImg4.getTag().toString().matches("empty")) {
                    if(black>0) {
                        testImg4.setImageResource(R.drawable.blackpin);
                        black--;
                    }
                    else if(white>0){
                        testImg4.setImageResource(R.drawable.whitepin);
                        white--;
                    }
                    testImg4.setTag("full");
                }
            }  else if(colour == 5){

                image2 = "pinImage" + String.valueOf(pinList[a]);
                testID = getResources().getIdentifier(image2, "id", getPackageName());
                testImg1 = ((ImageView) findViewById(testID));
                if (testImg1.getTag().toString().matches("empty")) {
                    if(black>0) {
                        testImg1.setImageResource(R.drawable.blackpin);
                        black--;
                    }
                    else if(white>0){
                        testImg1.setImageResource(R.drawable.whitepin);
                        white--;
                    }
                    testImg1.setTag("full");
                }

                image2 = "pinImage" + String.valueOf(pinList[a + 1]);
                testID = getResources().getIdentifier(image2, "id", getPackageName());
                testImg2 = ((ImageView) findViewById(testID));
                if (testImg2.getTag().toString().matches("empty")) {
                    if(black>0) {
                        testImg2.setImageResource(R.drawable.blackpin);
                        black--;
                    }
                    else if(white>0){
                        testImg2.setImageResource(R.drawable.whitepin);
                        white--;
                    }
                    testImg2.setTag("full");
                }

                image2 = "pinImage" + String.valueOf(pinList[a + 2]);
                testID = getResources().getIdentifier(image2, "id", getPackageName());
                testImg3 = ((ImageView) findViewById(testID));
                if (testImg3.getTag().toString().matches("empty")) {
                    if(black>0) {
                        testImg3.setImageResource(R.drawable.blackpin);
                        black--;
                    }
                    else if(white>0){
                        testImg3.setImageResource(R.drawable.whitepin);
                        white--;
                    }
                    testImg3.setTag("full");
                }

                image2 = "pinImage" + String.valueOf(pinList[a + 3]);
                testID = getResources().getIdentifier(image2, "id", getPackageName());
                testImg4 = ((ImageView) findViewById(testID));
                if (testImg4.getTag().toString().matches("empty")) {
                    if(black>0) {
                        testImg4.setImageResource(R.drawable.blackpin);
                        black--;
                    }
                    else if(white>0){
                        testImg4.setImageResource(R.drawable.whitepin);
                        white--;
                    }
                    testImg4.setTag("full");
                }

                image2 = "pinImage" + String.valueOf(pinList[a + 4]);
                testID = getResources().getIdentifier(image2, "id", getPackageName());
                testImg5 = ((ImageView) findViewById(testID));
                if (testImg5.getTag().toString().matches("empty")) {
                    if(black>0) {
                        testImg5.setImageResource(R.drawable.blackpin);
                        black--;
                    }
                    else if(white>0){
                        testImg5.setImageResource(R.drawable.whitepin);
                        white--;
                    }
                    testImg4.setTag("full");
                }
            }   else if(colour == 6){

                image2 = "pinImage" + String.valueOf(pinList[a]);
                testID = getResources().getIdentifier(image2, "id", getPackageName());
                testImg1 = ((ImageView) findViewById(testID));
                if (testImg1.getTag().toString().matches("empty")) {
                    if(black>0) {
                        testImg1.setImageResource(R.drawable.blackpin);
                        black--;
                    }
                    else if(white>0){
                        testImg1.setImageResource(R.drawable.whitepin);
                        white--;
                    }
                    testImg1.setTag("full");
                }

                image2 = "pinImage" + String.valueOf(pinList[a + 1]);
                testID = getResources().getIdentifier(image2, "id", getPackageName());
                testImg2 = ((ImageView) findViewById(testID));
                if (testImg2.getTag().toString().matches("empty")) {
                    if(black>0) {
                        testImg2.setImageResource(R.drawable.blackpin);
                        black--;
                    }
                    else if(white>0){
                        testImg2.setImageResource(R.drawable.whitepin);
                        white--;
                    }
                    testImg2.setTag("full");
                }

                image2 = "pinImage" + String.valueOf(pinList[a + 2]);
                testID = getResources().getIdentifier(image2, "id", getPackageName());
                testImg3 = ((ImageView) findViewById(testID));
                if (testImg3.getTag().toString().matches("empty")) {
                    if(black>0) {
                        testImg3.setImageResource(R.drawable.blackpin);
                        black--;
                    }
                    else if(white>0){
                        testImg3.setImageResource(R.drawable.whitepin);
                        white--;
                    }
                    testImg3.setTag("full");
                }

                image2 = "pinImage" + String.valueOf(pinList[a + 3]);
                testID = getResources().getIdentifier(image2, "id", getPackageName());
                testImg4 = ((ImageView) findViewById(testID));
                if (testImg4.getTag().toString().matches("empty")) {
                    if(black>0) {
                        testImg4.setImageResource(R.drawable.blackpin);
                        black--;
                    }
                    else if(white>0){
                        testImg4.setImageResource(R.drawable.whitepin);
                        white--;
                    }
                    testImg4.setTag("full");
                }

                image2 = "pinImage" + String.valueOf(pinList[a + 4]);
                testID = getResources().getIdentifier(image2, "id", getPackageName());
                testImg5 = ((ImageView) findViewById(testID));
                if (testImg5.getTag().toString().matches("empty")) {
                    if(black>0) {
                        testImg5.setImageResource(R.drawable.blackpin);
                        black--;
                    }
                    else if(white>0){
                        testImg5.setImageResource(R.drawable.whitepin);
                        white--;
                    }
                    testImg4.setTag("full");
                }

                image2 = "pinImage" + String.valueOf(pinList[a + 5]);
                testID = getResources().getIdentifier(image2, "id", getPackageName());
                testImg6 = ((ImageView) findViewById(testID));
                if (testImg6.getTag().toString().matches("empty")) {
                    if(black>0) {
                        testImg6.setImageResource(R.drawable.blackpin);
                        black--;
                    }
                    else if(white>0){
                        testImg6.setImageResource(R.drawable.whitepin);
                        white--;
                    }
                    testImg4.setTag("full");
                }
            }
        }
    }

    public void Undo(View v){
        int image = v.getId();

        String IdAsString = v.getResources().getResourceName(v.getId());

        String image2;
        int testID;
        ImageButton testImg;
        image2 = String.valueOf(image);
        testID = getResources().getIdentifier(image2, "id", getPackageName());
        testImg = ((ImageButton) findViewById(testID));

        testImg.setTag("empty");
        testImg.setImageResource(android.R.color.transparent);

        String token = "com.example.sshan.mastermind4:id/pegimage";
        String IdAsString1 = IdAsString.replace(token, "");

        int x;

        if(IdAsString1.matches("101") || IdAsString1.matches("102") || IdAsString1.matches("103") || IdAsString1.matches("104") || IdAsString.matches("105") || IdAsString.matches("106")){
            x = Integer.parseInt(IdAsString1.substring(2));
        }
        else {
            x = Integer.parseInt(IdAsString1.substring(1));
        }

        Check.removePegCode(x);

    }

    public void Close(){

        Check.clearPegCode();
        finish();
    }

    public void stopMedia(){
            if (mp != null) {
                mp.stop();
                mp.release();
                mp = null;
            }
    }

    public void setColourPegs(int colour){

        int constant = 0;

        if(codeLength == 4)
            constant = 4;
        else if(codeLength == 6)
            constant = 6;

        if(colour == 5){
            purpleButton.setBackgroundColor(Color.parseColor("#ffffff")); // 29th - changed drawable to small
            if(constant == 4)
                purpleButton.setImageResource(R.drawable.purple_peg2);
            else
                purpleButton.setImageResource(R.drawable.purple_peg2_small_test);

            purpleButton.setClickable(true);
        }
        else if (colour == 6){
            purpleButton.setBackgroundColor(Color.parseColor("#ffffff")); // 29th - changed drawable to small
            if(constant == 4)
                purpleButton.setImageResource(R.drawable.purple_peg2);
            else
                purpleButton.setImageResource(R.drawable.purple_peg2_small_test);

            purpleButton.setClickable(true);

            orangeButton.setBackgroundColor(Color.parseColor("#ffffff"));
            if(constant == 4)
                orangeButton.setImageResource(R.drawable.orange_peg2);
            else
                orangeButton.setImageResource(R.drawable.orange_peg2_small_test);

            orangeButton.setClickable(true);

        }

        else if (colour == 7){
            purpleButton.setBackgroundColor(Color.parseColor("#ffffff")); // 29th - changed drawable to small
            if(constant == 4)
                purpleButton.setImageResource(R.drawable.purple_peg2);
            else
                purpleButton.setImageResource(R.drawable.purple_peg2_small_test);

            purpleButton.setClickable(true);

            orangeButton.setBackgroundColor(Color.parseColor("#ffffff"));
            if(constant == 4)
                orangeButton.setImageResource(R.drawable.orange_peg2);
            else
                orangeButton.setImageResource(R.drawable.orange_peg2_small_test);

            orangeButton.setClickable(true);

            pinkButton.setBackgroundColor(Color.parseColor("#ffffff"));
            if(constant == 4)
                pinkButton.setImageResource(R.drawable.pink_peg2);
            else
                pinkButton.setImageResource(R.drawable.pink_peg2_small_test);

            pinkButton.setClickable(true);
        }

        else if (colour == 8){
            purpleButton.setBackgroundColor(Color.parseColor("#ffffff")); // 29th - changed drawable to small
            if(constant == 4)
                purpleButton.setImageResource(R.drawable.purple_peg2);
            else
                purpleButton.setImageResource(R.drawable.purple_peg2_small_test);

            purpleButton.setClickable(true);

            orangeButton.setBackgroundColor(Color.parseColor("#ffffff"));
            if(constant == 4)
                orangeButton.setImageResource(R.drawable.orange_peg2);
            else
                orangeButton.setImageResource(R.drawable.orange_peg2_small_test);

            orangeButton.setClickable(true);

            pinkButton.setBackgroundColor(Color.parseColor("#ffffff"));
            if(constant == 4)
                pinkButton.setImageResource(R.drawable.pink_peg2);
            else
                pinkButton.setImageResource(R.drawable.pink_peg2_small_test);

            pinkButton.setClickable(true);

            evergreenButton.setBackgroundColor(Color.parseColor("#ffffff"));
            if(constant == 4)
                evergreenButton.setImageResource(R.drawable.evergreen_peg2);
            else
                evergreenButton.setImageResource(R.drawable.evergreen_peg2_small_test);

            evergreenButton.setClickable(true);
        }
    }

    public void displayCode(){

        int[] codeList = codeGenerator();

        String[] colours = {"red_peg_nobg", "blue_peg2_nobg", "green_peg2_nobg", "yellow_peg2_nobg", "purple_peg2_nobg", "orange_peg2_nobg", "pink_peg2_nobg", "evergreen_peg2_nobg"};

        String[] colours6 = {"red_peg2_small_test", "blue_peg2_small_test", "green_peg2_small_test", "yellow_peg2_small_test", "purple_peg2_small_test", "orange_peg2_small_test", "pink_peg2_small_test", "evergreen_peg2_small_test"};

        int constant;
        String image;
        int testID;
        int id=0, id2=0, id3=0, id4=0, id5=0, id6=0;

        ImageView codeImg1, codeImg2, codeImg3, codeImg4, codeImg5, codeImg6;

        if(codeLength == 4)
            constant = 4;
        else
            constant = 6;


        image = "codeimage1";
        testID = getResources().getIdentifier(image, "id", getPackageName());
        codeImg1 = ((ImageView) findViewById(testID));
        if(constant == 4)
            id = getResources().getIdentifier( getPackageName() + ":drawable/" + colours[codeList[0] - 1], null, null);
        else
            id = getResources().getIdentifier( getPackageName() + ":drawable/" + colours6[codeList[0] - 1], null, null);

        codeImg1.setImageResource(id);

        image = "codeimage2";
        testID = getResources().getIdentifier(image, "id", getPackageName());
        codeImg2 = ((ImageView) findViewById(testID));
        if(constant == 4)
            id2 = getResources().getIdentifier( getPackageName() + ":drawable/" + colours[codeList[1] - 1], null, null);
        else
            id2 = getResources().getIdentifier( getPackageName() + ":drawable/" + colours6[codeList[1] - 1], null, null);

        codeImg2.setImageResource(id2);

        image = "codeimage3";
        testID = getResources().getIdentifier(image, "id", getPackageName());
        codeImg3 = ((ImageView) findViewById(testID));
        if(constant == 4)
            id3 = getResources().getIdentifier( getPackageName() + ":drawable/" + colours[codeList[2] - 1], null, null);
        else
            id3 = getResources().getIdentifier( getPackageName() + ":drawable/" + colours6[codeList[2] - 1], null, null);

        codeImg3.setImageResource(id3);

        image = "codeimage4";
        testID = getResources().getIdentifier(image, "id", getPackageName());
        codeImg4 = ((ImageView) findViewById(testID));
        if(constant == 4)
            id4 = getResources().getIdentifier( getPackageName() + ":drawable/" + colours[codeList[3] - 1], null, null);
        else
            id4 = getResources().getIdentifier( getPackageName() + ":drawable/" + colours6[codeList[3] - 1], null, null);

        codeImg4.setImageResource(id4);

        if(constant == 6){

            image = "codeimage5";
            testID = getResources().getIdentifier(image, "id", getPackageName());
            codeImg5 = ((ImageView) findViewById(testID));
            if(constant == 4)
                id5 = getResources().getIdentifier( getPackageName() + ":drawable/" + colours[codeList[4] - 1], null, null);
            else
                id5 = getResources().getIdentifier( getPackageName() + ":drawable/" + colours6[codeList[4] - 1], null, null);

            codeImg5.setImageResource(id5);

            image = "codeimage6";
            testID = getResources().getIdentifier(image, "id", getPackageName());
            codeImg6 = ((ImageView) findViewById(testID));
            if(constant == 4)
                id6 = getResources().getIdentifier( getPackageName() + ":drawable/" + colours[codeList[5] - 1], null, null);
            else
                id6 = getResources().getIdentifier( getPackageName() + ":drawable/" + colours6[codeList[5] - 1], null, null);

            codeImg6.setImageResource(id6);
        }

    }

    public void removeCheat(){

        codeButton.setImageResource(android.R.color.transparent);
        codeButton.setBackgroundColor(Color.TRANSPARENT);
    }

    public void displayText(){

        TextView answerText = (TextView) findViewById(R.id.textAnswer);
        answerText.setVisibility(View.VISIBLE);
    }

}