package com.example.project01group14;

import android.app.Application;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class UsersViewModel extends AndroidViewModel {
    private UsersRepository repository;
    private LiveData<List<UsersEntity>> allUsers;

    public UsersViewModel(@NonNull Application application) {
        super(application);
        repository = new UsersRepository(application);
        allUsers = repository.getAllUsers();
    }
    public void insert(UsersEntity usersEntity){
        repository.insert(usersEntity);
    }
    public void update(UsersEntity usersEntity){
        repository.update(usersEntity);
    }
    public void delete(UsersEntity usersEntity){
        repository.delete(usersEntity);
    }
    public void deleteAllUsers(){
        repository.deleteAllUsers();
    }
    public LiveData<List<UsersEntity>> getAllUsers(){
        return allUsers;
    }
}
