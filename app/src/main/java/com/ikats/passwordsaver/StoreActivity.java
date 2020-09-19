package com.ikats.passwordsaver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class StoreActivity extends AppCompatActivity {

    TextInputEditText storeName, storePassword;
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);

        storeName = findViewById(R.id.storeName);
        storePassword = findViewById(R.id.storePassword);

        file = new File(getApplicationContext().getFilesDir(), "data");
    }

    public void goBack(View view) {

        finish();

    }

    public void storePassword(View view) {

        try {

            FileOutputStream fos = new FileOutputStream(file, true);
            PrintStream printstream = new PrintStream(fos);
            printstream.println(storeName.getText().toString());
            printstream.println(storePassword.getText().toString());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}