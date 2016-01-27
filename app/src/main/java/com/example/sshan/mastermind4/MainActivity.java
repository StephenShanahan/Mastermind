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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void select(View v)
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

    }

    public void selectBlue(View v)
    {

        //adds source image to blank imageview on click
        ImageView imgBus;
        //imgBus = (ImageView) findViewById(R.id.testimg2);
        imgBus = (ImageView) findViewById(R.id.pegimage22);
        imgBus.setImageResource(R.drawable.blue_peg2_nobg);

      /*  ImageView image = new ImageView(this);
        image.setImageResource(R.drawable.blue_peg2);
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.gameRow1);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.BELOW, R.id.gameRow1);
        //lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        lp.addRule(RelativeLayout.RIGHT_OF, image.getId());
        rl.addView(iv, lp);*/

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
                 buttonID = "pegimage21";
            }
            else{
                buttonID = "testimg1";
            }
            int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
            imgBus = ((ImageButton) findViewById(resID));
            imgBus.setImageResource(R.drawable.red_peg_nobg);
        }
      /*  ImageView image = new ImageView(this);
        image.setImageResource(R.drawable.blue_peg2);
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.gameRow1);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.BELOW, R.id.gameRow1);
        //lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        lp.addRule(RelativeLayout.RIGHT_OF, image.getId());
        rl.addView(iv, lp);*/

    }

    public void selectGreen(View v)
    {

        //adds source image to blank imageview on click
        ImageView imgBus;
        //imgBus = (ImageView) findViewById(R.id.testimg3);
        imgBus = (ImageView) findViewById(R.id.pegimage23);
        imgBus.setImageResource(R.drawable.green_peg2_nobg);

      /*  ImageView image = new ImageView(this);
        image.setImageResource(R.drawable.blue_peg2);
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.gameRow1);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.BELOW, R.id.gameRow1);
        //lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        lp.addRule(RelativeLayout.RIGHT_OF, image.getId());
        rl.addView(iv, lp);*/

    }

    public void selectYellow(View v)
    {

        //adds source image to blank imageview on click
        ImageView imgBus;
        //imgBus = (ImageView) findViewById(R.id.testimg4);
        imgBus = (ImageView) findViewById(R.id.pegimage24);
        imgBus.setImageResource(R.drawable.yellow_peg2_nobg);

      /*  ImageView image = new ImageView(this);
        image.setImageResource(R.drawable.blue_peg2);
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.gameRow1);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.BELOW, R.id.gameRow1);
        //lp.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        lp.addRule(RelativeLayout.RIGHT_OF, image.getId());
        rl.addView(iv, lp);*/

    }
}
