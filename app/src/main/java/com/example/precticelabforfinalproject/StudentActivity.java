package com.example.precticelabforfinalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        listView = findViewById(R.id.listViewStudent);



        DBHelper dbHelper = new DBHelper(StudentActivity.this);

        //for checking
//        ArrayAdapter arrayAdapter = new ArrayAdapter<MessageMaster>(StudentActivity.this,android.R.layout.simple_list_item_1,dbHelper.getEveryOne());
//        MessageMaster master = (MessageMaster) arrayAdapter.getItem(1);
//
//        Log.d("kkk","massage = "+ master.getMessage());

        //convert ArrayList to StringArray
        MessageMaster[] array = new MessageMaster[dbHelper.getEveryOne().size()];
        dbHelper.getEveryOne().toArray(array);

        List<String> subject = new ArrayList<>();
        for (int i=0; i<dbHelper.getEveryOne().size(); i++){
            subject.add(array[i].getSubject());
        }
 //       Log.d("kkk1","massage1 = "+ array[0].getSubject());


        ArrayAdapter arrayAdapterSubject = new ArrayAdapter(StudentActivity.this,android.R.layout.simple_list_item_1, subject);
        listView.setAdapter(arrayAdapterSubject);




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                DBHelper dbHelper = new DBHelper(StudentActivity.this);
                ArrayAdapter arrayAdapter = new ArrayAdapter<MessageMaster>(StudentActivity.this,android.R.layout.simple_list_item_1,dbHelper.getEveryOne());
                MessageMaster master = (MessageMaster) arrayAdapter.getItem(i);

                Intent intent = new Intent(StudentActivity.this,MessageActivity.class);
                intent.putExtra("subject",master.getSubject());
                intent.putExtra("message",master.getMessage());
                startActivity(intent);
            }
        });
    }
}