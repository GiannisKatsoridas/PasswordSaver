package com.ikats.passwordsaver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void storePassword(View view) {

        Intent intent = new Intent(MainActivity.this, StoreActivity.class);
        startActivity(intent);

    }

    public void retrievePassword(View view) {

        Intent intent = new Intent(MainActivity.this, RetrieveActivity.class);
        startActivity(intent);

    }
}