package com.example.precticelabforfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText editTextUserName,editTextPassword;
    CheckBox checkBoxStudent,checkBoxTeacher;
    Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextUserName = findViewById(R.id.editTextUserName);
        editTextPassword = findViewById(R.id.editTextPassword);
        checkBoxStudent = findViewById(R.id.checkBoxStudent);
        checkBoxTeacher = findViewById(R.id.checkBoxTeacher);
        buttonRegister = findViewById(R.id.buttonRegister);



        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String type = "null";
                if (checkBoxStudent.isChecked()) {
                    type = "Student";
                } else if (checkBoxTeacher.isChecked()){
                    type = "Teacher";
                }

                UserMaster userMaster = new UserMaster(editTextUserName.getText().toString(),editTextPassword.getText().toString(),type);

                DBHelper dbHelper = new DBHelper(RegisterActivity.this);
                dbHelper.addDataToUser(userMaster);
            }
        });
    }
}