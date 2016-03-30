package com.example.sshan.mastermind4;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;


public class Preferences extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();
    }

    public static class MyPreferenceFragment extends PreferenceFragment
    {

        static boolean boo;
        static String pegs;
        static String colour;

        @Override
        public void onCreate(final Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.preference);

            SharedPreferences SP = PreferenceManager.getDefaultSharedPreferences(getActivity());   // SHARED PREFERENCES
            boo = SP.getBoolean("duplicates", false);
            pegs = SP.getString("pegs", "1");
            colour = SP.getString("colours", "4");

            boolean b;
            if((colour.matches("6")) || (colour.matches("7")) || (colour.matches("8")))
                b = true;
            else
                b = false;

            if ((!boo) && (pegs.matches("2")) && (!b)){ //(!colour.matches("6"))) {
                showMessage();
            }
        }

        public void showMessage(){

            String message = getString(R.string.Colour_Error);
            final AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
            alertDialog.setTitle("Error");
            alertDialog.setMessage(message);
            alertDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    alertDialog.show();
                }
            });
            alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            boolean b;
            if((colour.matches("6")) || (colour.matches("7")) || (colour.matches("8")))
                b = true;
            else
                b = false;

            if ((!boo) && (pegs.matches("2")) && (!b)){ //(!colour.matches("6"))) {
                alertDialog.show();
            }

        }

    }
}
