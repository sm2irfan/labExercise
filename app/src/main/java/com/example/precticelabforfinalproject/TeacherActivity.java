package com.example.precticelabforfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TeacherActivity extends AppCompatActivity {

    EditText editTextSubject, editTextMessage;
    Button buttonSend;

    String teacherName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);
        Intent intentmy = getIntent();
        teacherName = intentmy.getStringExtra("TEACHER_NAME");


        editTextSubject = findViewById(R.id.editTextSubject);
        editTextMessage = findViewById(R.id.editTextMessage);
        buttonSend = findViewById(R.id.buttonSend);

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MessageMaster messageMaster = new MessageMaster(teacherName,editTextSubject.getText().toString(),editTextMessage.getText().toString());
                DBHelper dbHelper = new DBHelper(TeacherActivity.this);
                dbHelper.addDataToMessage(messageMaster);

                Toast.makeText(TeacherActivity.this,"success",Toast.LENGTH_LONG).show();

            }
        });

    }
}