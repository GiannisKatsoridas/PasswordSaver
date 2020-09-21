package com.ikats.passwordsaver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ikats.passwordsaver.listviewhelpers.Password;
import com.ikats.passwordsaver.listviewhelpers.PasswordAdapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RetrieveActivity extends AppCompatActivity {

    ListView listview;

    ArrayList<Password> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        listview = findViewById(R.id.retrieve_listview);

        items = new ArrayList<>();

        File file = new File(getFilesDir(), "data");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String s = br.readLine();
            while(s != null){

                String ss = br.readLine();

                items.add(new Password(s, ss));

                s = br.readLine();
            }

        } catch (IOException e) {
            Toast.makeText(this, "Something went wrong.", Toast.LENGTH_LONG).show();
        }

        PasswordAdapter passwordAdapter = new PasswordAdapter(this, R.layout.password_row, items);

        listview.setAdapter(passwordAdapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(RetrieveActivity.this, DecryptActivity.class);
                intent.putExtra("password", items.get(position));
                startActivity(intent);

            }
        });
    }

    public void goBack(View view) {

        finish();

    }
}