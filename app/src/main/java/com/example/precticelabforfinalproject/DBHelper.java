package com.example.precticelabforfinalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(@Nullable Context context) {
        super(context, "tutorial.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String userTable = "CREATE TABLE " + UserMaster.User.TABLE_NAME + " (" + UserMaster.User.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + UserMaster.User.COLUMN_NAME + " TEXT, " + UserMaster.User.COLUMN_PASSWORD + " TEXT, " + UserMaster.User.COLUMN_TYPE + " TEXT)";
        String massageTable = "CREATE TABLE " + MessageMaster.Message.TABLE_NAME + " (" + MessageMaster.Message.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + MessageMaster.Message.COLUMN_USER + " TEXT, " + MessageMaster.Message.COLUMN_SUBJECT + " TEXT, " + MessageMaster.Message.COLUMN_MESSAGE + " TEXT)";
        sqLiteDatabase.execSQL(userTable);
        sqLiteDatabase.execSQL(massageTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }




    public boolean addDataToUser (UserMaster userMaster){

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(UserMaster.User.COLUMN_NAME, userMaster.getName());
        values.put(UserMaster.User.COLUMN_PASSWORD, userMaster.getPassword());
        values.put(UserMaster.User.COLUMN_TYPE, userMaster.getType());

// Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(UserMaster.User.TABLE_NAME, null, values);

        if (newRowId==-1){
            return false;
        }else {
            return true;
        }

    }




    public boolean addDataToMessage(MessageMaster messageMaster){

        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(MessageMaster.Message.COLUMN_USER, messageMaster.getUser());
        values.put(MessageMaster.Message.COLUMN_SUBJECT, messageMaster.getSubject());
        values.put(MessageMaster.Message.COLUMN_MESSAGE, messageMaster.getMessage());


// Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(MessageMaster.Message.TABLE_NAME, null, values);

        if (newRowId==-1){
            return false;
        }else {
            return true;
        }
    }




    public List<MessageMaster> getEveryOne (){

        SQLiteDatabase db = this.getReadableDatabase();

// Define a projection that specifies which columns from the database
// you will actually use after this query.

        String queryString = "SELECT * FROM " + MessageMaster.Message.TABLE_NAME;
        Cursor cursor = db.rawQuery(queryString,null);

        List<MessageMaster> itemIds = new ArrayList<>();
        while(cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String subject = cursor.getString(2);
            String message = cursor.getString(3);
            MessageMaster messageMaster = new MessageMaster(id,name,subject,message);
            itemIds.add(messageMaster);


        }
        cursor.close();
        return itemIds;
    }










    public String checkUser(String name) {
        String type = "null";
        // array of columns to fetch
        String[] columns = {
                UserMaster.User.COLUMN_TYPE,
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = UserMaster.User.COLUMN_NAME + " = ?";
        // selection arguments
        String[] selectionArgs = {name};
        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(UserMaster.User.TABLE_NAME, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        cursor.moveToFirst();
        while(cursor.isAfterLast() == false) {
            type = cursor.getString(0);
            cursor.moveToNext();
        }
        return type;


    }


}
