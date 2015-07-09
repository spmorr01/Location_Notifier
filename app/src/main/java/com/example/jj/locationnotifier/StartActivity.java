package com.example.jj.locationnotifier;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class StartActivity extends ActionBarActivity {

    private TextView dialogTextView;
    final Context context = this;
    private int increment = 0;
    private String contactInputValue;
    public ArrayList<String> contactNumbers = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);}


        public void onDialogButtonClick(View view) {
                dialogTextView = (TextView) findViewById(R.id.dialogTextResults);
                LayoutInflater layoutInflater = LayoutInflater.from(context);
                View promptView = layoutInflater.inflate(R.layout.numberprompt, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
                alertDialogBuilder.setView(promptView);

                final EditText input = (EditText) promptView.findViewById(R.id.dialogInput);

                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialogTextView.setText(input.getText());
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertD = alertDialogBuilder.create();
                alertD.show();
            }

        public void onContactButtonClick(View view){
            dialogTextView = (TextView) findViewById(R.id.dialogTextResults);
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            View promptView = layoutInflater.inflate(R.layout.numberprompt, null);
            final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setView(promptView);

            final EditText contactInput = (EditText) promptView.findViewById(R.id.dialogInput);

            alertDialogBuilder
                    .setCancelable(false)
                    .setPositiveButton("Next", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //dialogTextView.setText(input.getText());
                            contactNumbers.add(contactInput.getText().toString());
                            dialogTextView.setText(contactNumbers.get(increment));
                            increment += 1;
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });

            AlertDialog alertD = alertDialogBuilder.create();
                            alertD.show();


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
                    }
