package com.example.sshan.mastermind4;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Menu extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);


        Button button_Play = (Button) findViewById(R.id.button_Play);
        button_Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                boolean boo = duplicatePegs();
                String pegs = pegNumber();
                String colour = pegColour();
                boolean b;
                if((colour.matches("6")) || (colour.matches("7")) || (colour.matches("8")))
                    b = true;
                else
                    b = false;

                if ((!boo) && (pegs.matches("2")) &&(!b)){ // (!colour.matches("6"))){
                    Toast pieceToast;
                    pieceToast = Toast.makeText(getApplicationContext(), "Error! Please check Options.", Toast.LENGTH_SHORT);
                    pieceToast.show();
                } else {
                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    startActivityForResult(intent, 0);
                    Check.clearPegCode();
                    Check.clearCountcode();
                }
            }
        });

        Button button_HowTo = (Button) findViewById(R.id.button_How);
        button_HowTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), HowTo.class);
                startActivityForResult(intent, 0);
            }
        });

        Button button_Options = (Button) findViewById(R.id.button_Options);
        button_Options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), Preferences.class);
                startActivityForResult(intent, 0);
            }
        });

        Button button_Exit = (Button) findViewById(R.id.button_Exit);
        button_Exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

        Button button_Credits = (Button) findViewById(R.id.button_test);
        button_Credits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), Credits.class);
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
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

    public String pegNumber(){
        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        return SP.getString("pegs", "1");
    }

    public String pegColour(){
        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        return SP.getString("colours", "4");
    }

    public boolean duplicatePegs(){
        SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        return SP.getBoolean("duplicates", false);
    }
}
