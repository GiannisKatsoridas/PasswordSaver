package com.ikats.passwordsaver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File file = new File(getFilesDir(), "data");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                Toast.makeText(this, "There has been an error creating the internal file. Please check your permissions.", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void storePassword(View view) {

        Intent intent = new Intent(MainActivity.this, StoreActivity.class);
        startActivity(intent);

    }

    public void retrievePassword(View view) {

        Intent intent = new Intent(MainActivity.this, RetrieveActivity.class);
        startActivity(intent);

    }

    public void removePassword(View view) {

        Intent intent = new Intent(MainActivity.this, RemoveActivity.class);
        startActivity(intent);

    }
}