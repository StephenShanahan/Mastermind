package com.example.sshan.mastermind4;


import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        Button button_Play = (Button) findViewById(R.id.button_Play);
        button_Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //boolean b = Options.getDuplicates();
                Intent intent = new Intent(v.getContext(), MainActivity.class);
                startActivityForResult(intent, 0);
                Check.clearPegCode();
                Check.clearCountcode();
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

                //Options.setDuplicates();
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
}
