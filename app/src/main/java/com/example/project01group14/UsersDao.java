package com.example.project01group14;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UsersDao {

    @Insert
    void insert(UsersEntity usersEntity);

    @Update
    void update(UsersEntity usersEntity);

    @Delete
    void delete(UsersEntity usersEntity);

    @Query("DELETE FROM users_table")
    void deleteAllUsers();

    @Query("SELECT * FROM users_table ORDER BY user_first_name DESC")
    LiveData<List<UsersEntity>> getAllUsers();
}
