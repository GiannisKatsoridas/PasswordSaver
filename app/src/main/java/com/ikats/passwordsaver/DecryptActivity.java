package com.ikats.passwordsaver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ikats.passwordsaver.listviewhelpers.Password;

public class DecryptActivity extends AppCompatActivity {

    private ClipboardManager myClipboard;
    private ClipData myClip;

    private Password password;

    EditText key;
    TextView name, stored_password, decrypted_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypt);

        password = (Password) getIntent().getSerializableExtra("password");

        key = findViewById(R.id.decrypt_key);

        name = findViewById(R.id.decrypt_name);
        stored_password = findViewById(R.id.decrypt_password);
        decrypted_password = findViewById(R.id.result);

        name.setText(password.Description);
        stored_password.setText(password.Password);
        decrypted_password.setText(password.Password);

    }

    public void goBack(View view) {

        finish();

    }

    public void copyToClipboard(View view) {

        myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        String text;
        text = decrypted_password.getText().toString();

        myClip = ClipData.newPlainText("text", text);
        myClipboard.setPrimaryClip(myClip);

        Toast.makeText(getApplicationContext(), "Password Copied!",Toast.LENGTH_SHORT).show();

    }

    public void decryptPassword(View view) {

        String decrypted = Encryption.Decrypt(key.getText().toString(), password.Password);

        decrypted_password.setText(decrypted);

    }
}