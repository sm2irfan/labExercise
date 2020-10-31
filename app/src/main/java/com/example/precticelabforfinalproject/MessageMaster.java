package com.example.precticelabforfinalproject;

import android.provider.BaseColumns;

public class MessageMaster {
    private int id;
    private String user;
    private String subject;
    private String message;

    public MessageMaster(int id, String user, String subject, String message) {
        this.id = id;
        this.user = user;
        this.subject = subject;
        this.message = message;
    }

    public MessageMaster(String user, String subject, String message) {
        this.user = user;
        this.subject = subject;
        this.message = message;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageMaster() {
    }

    public static class Message implements BaseColumns{

        public static final String TABLE_NAME = "message";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_USER = "user";
        public static final String COLUMN_SUBJECT = "subject";
        public static final String COLUMN_MESSAGE = "message";
    }
}
