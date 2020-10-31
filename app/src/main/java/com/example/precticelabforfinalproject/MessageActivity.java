package com.example.precticelabforfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MessageActivity extends AppCompatActivity {

    TextView textViewSubject, textViewMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        textViewSubject = findViewById(R.id.textViewSubject);
        textViewMessage = findViewById(R.id.textViewMessage);

        Intent intent = getIntent();
        String subject = intent.getStringExtra("subject");
        String message = intent.getStringExtra("message");

        textViewSubject.setText(subject);
        textViewMessage.setText(message);
        Log.d("see","message = " + subject);
    }
}