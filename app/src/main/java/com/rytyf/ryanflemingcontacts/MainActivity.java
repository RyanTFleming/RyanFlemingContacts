package com.rytyf.ryanflemingcontacts;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

    /**
     * Retrieves the user input from the form and prints it back out in the
     * saved information section of the GUI.
     *
     * @param v - the view control that sent the action.
     */
    public void saveButtonOnClick(View v) {
        boolean isError = false;
        TextView errorMessage = (TextView) findViewById(R.id.errorMessage);
        EditText nameTextEdit = (EditText) findViewById(R.id.nameTextField);
        Editable nameText = nameTextEdit.getText();
        EditText emailTextEdit = (EditText) findViewById(R.id.emailTextField);
        Editable emailText = emailTextEdit.getText();
        EditText phoneTextEdit = (EditText) findViewById(R.id.phoneTextField);
        Editable phoneText = phoneTextEdit.getText();
        TextView phoneTextView = (TextView) findViewById(R.id.phoneTextView);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        int radioButtonID = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedButton = (RadioButton) findViewById(radioButtonID);

        if (selectedButton == null) {

            errorMessage.setVisibility(View.VISIBLE);
            isError = true;
        } else {
            errorMessage.setVisibility(View.INVISIBLE);
        }

        if (nameText.length() == 0) {
            nameTextEdit.setError("Required");
            isError = true;
        }

        if (emailText.length() == 0) {
            emailTextEdit.setError("Required");
            isError = true;
        }
        if (phoneText.length() == 0) {
            phoneTextEdit.setError("Required");
            isError = true;
        }

        if (isError) {
            return;
        }

        TextView nameTextView = (TextView) findViewById(R.id.nameTextView);
        nameTextView.setText(nameText);

        TextView emailTextView = (TextView) findViewById(R.id.emailTextView);
        emailTextView.setText(emailText);
        String phoneType = (String) selectedButton.getText();
        phoneTextView.setText(phoneText + "(" + phoneType + ")");
    }
}
