package com.ikats.passwordsaver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class WelcomeActivity extends AppCompatActivity {

    EditText passcode, confirmPasscode;
    Button button;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        passcode = findViewById(R.id.insertSecretPasscode);
        confirmPasscode = findViewById(R.id.confirmSecretPasscode);
        button = findViewById(R.id.save_button);

        file = new File(getApplicationContext().getFilesDir(), "data");

        if (file.exists()) {
            startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
            finish();
        }

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        passcode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                String s1 = passcode.getText().toString();
                String s2 = confirmPasscode.getText().toString();

                if (s1.length() == 0)
                    button.setEnabled(false);
                else {

                    if (s1.equals(s2))
                        button.setEnabled(true);

                }

            }
        });

        confirmPasscode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                String s1 = passcode.getText().toString();
                String s2 = confirmPasscode.getText().toString();

                if (s1.length() == 0 || !s1.equals(s2))
                    button.setEnabled(false);
                else
                    button.setEnabled(true);


            }
        });


    }

    public void goToMain(View v){

        FileOutputStream stream = null;
        try {
            stream = new FileOutputStream(file);
            stream.write(passcode.getText().toString().getBytes());
            stream.write('\n');
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "ERROR. File not created.", Toast.LENGTH_LONG).show();
        }

        Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
        startActivity(intent);

        finish();

    }

}