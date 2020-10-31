package com.example.precticelabforfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin,btnRegister;
    EditText editTextUserName,editTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.buttonLogin);
        btnRegister = findViewById(R.id.buttonRegister);
        editTextUserName = findViewById(R.id.editTextUserName);
        editTextPassword = findViewById(R.id.editTextPassword);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editTextUserName.getText().toString();
                DBHelper dbHelper = new DBHelper(LoginActivity.this);
                String see = dbHelper.checkUser(editTextUserName.getText().toString());
                if("Teacher".equals(see)){
                    Intent intent = new Intent(LoginActivity.this,TeacherActivity.class);
                    intent.putExtra("TEACHER_NAME",name);
                    startActivity(intent);
                    Toast.makeText(LoginActivity.this,"success Teacher",Toast.LENGTH_SHORT).show();
                }else if ("Student".equals(see)){
                    Intent intent = new Intent(LoginActivity.this,StudentActivity.class);
                    startActivity(intent);
                    Toast.makeText(LoginActivity.this,"success Student",Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(LoginActivity.this,"Name is not correct",Toast.LENGTH_SHORT).show();
                }



            }
        });

    }
}