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

    }

    public void onClick(View v) {

        Toast pieceToast=null;
        ImageButton imgBus;
        String buttonID;
        int resID;
        int x = 1;
        int y = 1;

      //  for(int x = 1;x<11;x++) {
        //    for (int y = 1; y < 5; y++) {
                switch (v.getId()) {

                    case R.id.redPeg:
                        //pieceToast= Toast.makeText(getApplicationContext(), "Image Button One Clicked", Toast.LENGTH_SHORT);
                        //pieceToast.show();
                        buttonID = "pegimage" + String.valueOf(x) + String.valueOf(y);
                        resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                        imgBus = ((ImageButton) findViewById(resID));
                        imgBus.setImageResource(R.drawable.red_peg_nobg);
                        y++;
                        break;

                    case R.id.greenPeg:
                        // pieceToast= Toast.makeText(getApplicationContext(), "Image Button Two Clicked", Toast.LENGTH_SHORT);
                        //pieceToast.show();
                        //adds source image to blank imageview on click
                        //imgBus = (ImageView) findViewById(R.id.testimg3);
                        imgBus = (ImageButton) findViewById(R.id.pegimage23);
                        imgBus.setImageResource(R.drawable.green_peg2_nobg);
                        y++;
                        break;

         /*   case R.id.imageButton3:
                pieceToast= Toast.makeText(getApplicationContext(), "Image Button Three Clicked", Toast.LENGTH_SHORT);
                pieceToast.show();
                break;

            case R.id.imageButton4:
                pieceToast= Toast.makeText(getApplicationContext(), "Image Button Four Clicked", Toast.LENGTH_SHORT);
                pieceToast.show();
                break;*/

                    default:
                        break;
               }
            //}
        //}

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

    public void selectBlue(View v)
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

    public int guessRow()
    {
        int x = 1;

        while(x<11)
        {
           switch(x){
               case 1:

                   break;
               case 2:
           }


            x++;
        }

        return x;
    }

    public int guessPosition()
    {
        int x = 1;
        int y=0;

        while(x<5)
        {
          y = x;

        }

        x++;
        return y;
    }
}
