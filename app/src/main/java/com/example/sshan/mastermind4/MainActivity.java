package com.example.sshan.mastermind4;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
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

        ImageButton pegCodeButton = (ImageButton) findViewById(R.id.PegCodeButton);
        pegCodeButton.setOnClickListener(this);

        Peg.pegFalse();

    }

    public void onClick(View v) {

        int[] code = codeGenerator();


        Toast pieceToast;
        ImageButton imgBus;
        String buttonID;
        int resID;
        int x = 1;
        int y = 1;
        int z = 0;
        int[] pins;
        //int[] pegCode = new int[4];
        //ArrayList<Integer> pegCode= new ArrayList<>();

        boolean b;
        boolean win;

        switch (v.getId()) {

            case R.id.redPeg:

                b = Full();
                if (b == false) {
                    z = pegPosition();
                    buttonID = "pegimage" + String.valueOf(z);
                    // buttonID = position();
                    resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                    imgBus = ((ImageButton) findViewById(resID));
                    imgBus.setImageResource(R.drawable.red_peg_nobg); // to remove this image, imgBus.setImageDrawable(null)
                    imgBus.setTag("1");
                    Check.setPegCode(1);
                    //pegCode[0] = Integer.getInteger(imgBus.getTag().toString());
                } else {
                    pieceToast = Toast.makeText(getApplicationContext(), "Press the LineButton", Toast.LENGTH_SHORT);
                    pieceToast.show();
                }
                break;

            case R.id.greenPeg:

                b = Full();
                if (b == false) {
                    z = pegPosition();
                    buttonID = "pegimage" + String.valueOf(z);
                    // buttonID = position();
                    resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                    imgBus = ((ImageButton) findViewById(resID));
                    imgBus.setImageResource(R.drawable.green_peg2_nobg);
                    imgBus.setTag("3");
                    Check.setPegCode(3);
                } else {
                    pieceToast = Toast.makeText(getApplicationContext(), "Press the LineButton", Toast.LENGTH_SHORT);
                    pieceToast.show();
                }

                break;

            case R.id.bluePeg:

                b = Full();
                if (b == false) {
                    z = pegPosition();
                    buttonID = "pegimage" + String.valueOf(z);
                    // buttonID = position();
                    resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                    imgBus = ((ImageButton) findViewById(resID));
                    imgBus.setImageResource(R.drawable.blue_peg2_nobg);
                    imgBus.setTag("2");
                    Check.setPegCode(2);
                } else {
                    pieceToast = Toast.makeText(getApplicationContext(), "Press the LineButton", Toast.LENGTH_SHORT);
                    pieceToast.show();
                }

                break;

            case R.id.yellowPeg:
                b = Full();
                if (b == false) {
                    z = pegPosition();
                    buttonID = "pegimage" + String.valueOf(z);
                    // buttonID = position();
                    resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                    imgBus = ((ImageButton) findViewById(resID));
                    imgBus.setImageResource(R.drawable.yellow_peg2_nobg);
                    imgBus.setTag("4");
                    Check.setPegCode(4);
                } else {
                    pieceToast = Toast.makeText(getApplicationContext(), "Press the LineButton", Toast.LENGTH_SHORT);
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

                Peg.pegRelease();
                win = Check.CheckGame(code);
                pins = Check.ReturnPins();
                drawPin(pins);
                //toastPins(pins);
                if (win == true) {


                    final View bubble = v;
                    String message = getString(R.string.dialog_text);
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
                    alertDialog.setTitle("Congratulations! You win");
                    alertDialog.setMessage(message);
                    alertDialog.setPositiveButton("Play", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(bubble.getContext(), MainActivity.class);
                            startActivityForResult(intent, 0);
                        }
                    });
                    alertDialog.setNegativeButton("Menu", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    });
                    alertDialog.show();
                }

                break;

            case R.id.PegCodeButton:

                int[] test = Check.getPegCode();
                String displayPegCode = "";
                for (int q = 0; q < test.length; q++) {
                    displayPegCode += String.valueOf(test[q]);
                }
                pieceToast = Toast.makeText(getApplicationContext(), displayPegCode, Toast.LENGTH_SHORT);
                pieceToast.show();
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
            if (!testImg.getTag().toString().matches("\\d")) {
                x = i;
                i = i + 40;
                //testImg.setTag("full");
            }

        }


        z = (pegList[x]);
        return z;

    }

    public boolean Full() {
        int[] pegList = {11, 12, 13, 14, 21, 22, 23, 24, 31, 32, 33, 34, 41, 42, 43, 44, 51, 52, 53, 54, 61, 62, 63, 64, 71, 72, 73, 74, 81, 82, 83, 84, 91, 92, 93, 94, 101, 102, 103, 104};


        ImageButton testImg1, testImg2, testImg3, testImg4;

        int testID;
        String image2;
        boolean b = false;
        Toast pieceToast;
        boolean release = Peg.isPegReleased();
        // Peg.pegFalse();
        int c = 0;
        // int temp;
        if (release == true) {///every time this method is called c = 0 and then 4 gets added. it will always start at 4 from the 2nd time on
            //   c = c + 4;
            // temp = count(c);
            //  c = temp + 4;
            // Peg.setCount();
            //c = Peg.getCount();
            c = Check.getCountCode().size();
            pieceToast = Toast.makeText(getApplicationContext(), "Number is:" + c, Toast.LENGTH_SHORT);
            pieceToast.show();

        }
      /*  else{
            pieceToast = Toast.makeText(getApplicationContext(), "Not released", Toast.LENGTH_SHORT);
            pieceToast.show();
        }*/
        for (int a = c; a < 40; a = a + 4) {

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
            if (testImg1.getTag().toString().matches("\\d") && testImg2.getTag().toString().matches("\\d") &&
                    testImg3.getTag().toString().matches("\\d") && testImg4.getTag().toString().matches("\\d")) {
                b = true;
                a = 50;
            } else
                b = false;
        }

        return b;
    }


    int temp = 0;

    public int count(int c) {

        temp += c;

        return temp;
    }


    int[] code = Code.Generate();

    public int[] codeGenerator() {

        //int[] code = Code.Generate();

        return code;
    }

    public void drawPin(int[] pins) {

        int[] pinsNeeded = pins;

        int[] pinList = {11, 12, 13, 14, 21, 22, 23, 24, 31, 32, 33, 34, 41, 42, 43, 44, 51, 52, 53, 54, 61, 62, 63, 64, 71, 72, 73, 74, 81, 82, 83, 84, 91, 92, 93, 94, 101, 102, 103, 104};


        int black = pinsNeeded[0];
        int white = pinsNeeded[1];
        int colour = white + black;

        ImageView testImg1, testImg2, testImg3, testImg4;

        int testID;
        String image2;
        boolean release = Peg.isPegReleased();
        int c = 0;
        // int temp;
        if (release == true) {
            c = Check.getCountCode().size();
            c = c - 4;
        }

        for (int a = c; a < 40; a = a + 49) {
            // for(int a=0;a<1;a++){
            // while (black > 0) {

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

        String tag = testImg.getTag().toString();

        testImg.setTag("empty");
        testImg.setImageResource(android.R.color.transparent);

        String str= image2;

        String token = "com.example.sshan.mastermind4:id/pegimage";
        String IdAsString1 = IdAsString.replace(token, "");

       // Toast pieceToast1;
       // pieceToast1 = Toast.makeText(getApplicationContext(), IdAsString1, Toast.LENGTH_SHORT);
       // pieceToast1.show();

       /* String numberOnly = str.substring(8,9);

        String digits = str.replaceAll("[^0-9.]","");

        Toast pieceToast;
        pieceToast = Toast.makeText(getApplicationContext(), numberOnly, Toast.LENGTH_SHORT);
        pieceToast.show();*/

        int x;

        if(IdAsString1.matches("101") || IdAsString1.matches("102") || IdAsString1.matches("103") || IdAsString1.matches("104")){
            x = Integer.parseInt(IdAsString1.substring(2));
        }
        else {
            x = Integer.parseInt(IdAsString1.substring(1));
        }

        Check.removePegCode(x);

    }


    public void toastPins(int[] p){

        Toast pieceToast;
        pieceToast = Toast.makeText(getApplicationContext(), p[0] + " " + p[1], Toast.LENGTH_SHORT);
        pieceToast.show();

    }

    public void Close(){

        Check.clearPegCode();
        finish();

    }


}