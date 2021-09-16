package com.example.project01group14;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users_table")
public class UsersEntity {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String user_name;
    private String user_first_name;
    private String user_last_name;
    private String user_password;

//    public UsersEntity(String user_name, String user_first_name, String user_last_name, String user_password) {
//        this.user_name = user_name;
//        this.user_first_name = user_first_name;
//        this.user_last_name = user_last_name;
//        this.user_password = user_password;
//    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_first_name(String user_first_name) {
        this.user_first_name = user_first_name;
    }

    public void setUser_last_name(String user_last_name) {
        this.user_last_name = user_last_name;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public int getId() {
        return id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getUser_first_name() {
        return user_first_name;
    }

    public String getUser_last_name() {
        return user_last_name;
    }

    public String getUser_password() {
        return user_password;
    }
}
