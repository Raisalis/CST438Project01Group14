package com.example.project01group14;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import androidx.lifecycle.LiveData;

public class UsersRepository {
    private UsersDao usersDao;
    private LiveData<List<UsersEntity>> allUsers;

    public UsersRepository(Application application) {
        UsersDatabase database = UsersDatabase.getInstance(application);
        usersDao = database.usersDao();
        allUsers = usersDao.getAllUsers();
    }

    public void insert(UsersEntity usersEntity){
        new InsertUsersAsyncTask(usersDao).execute(usersEntity);
    }

    public void update(UsersEntity usersEntity){
        new UpdateAsyncTask(usersDao).execute(usersEntity);
    }

    public void delete(UsersEntity usersEntity){
        new DeleteUsersAsyncTask(usersDao).execute(usersEntity);
    }

    public void deleteAllUsers(){
        new DeleteAllUsersAsyncTask(usersDao).execute();
    }

    public LiveData<List<UsersEntity>> getAllUsers(){
        return allUsers;
    }

    private static class InsertUsersAsyncTask extends AsyncTask<UsersEntity, Void, Void>{
        private UsersDao usersDao;
        private InsertUsersAsyncTask(UsersDao usersDao){
            this.usersDao = usersDao;
        }
        @Override
        protected Void doInBackground(UsersEntity... usersEntities) {
            usersDao.insert(usersEntities[0]);
            return null;
        }
    }

    private static class UpdateAsyncTask extends AsyncTask<UsersEntity, Void, Void>{
        private UsersDao usersDao;
        private UpdateAsyncTask(UsersDao usersDao){
            this.usersDao = usersDao;
        }
        @Override
        protected Void doInBackground(UsersEntity... usersEntities) {
            usersDao.update(usersEntities[0]);
            return null;
        }
    }

    private static class DeleteUsersAsyncTask extends AsyncTask<UsersEntity, Void, Void>{
        private UsersDao usersDao;
        private DeleteUsersAsyncTask(UsersDao usersDao){
            this.usersDao = usersDao;
        }
        @Override
        protected Void doInBackground(UsersEntity... usersEntities) {
            usersDao.delete(usersEntities[0]);
            return null;
        }
    }

    private static class DeleteAllUsersAsyncTask extends AsyncTask<Void, Void, Void>{
        private UsersDao usersDao;
        private DeleteAllUsersAsyncTask(UsersDao usersDao){
            this.usersDao = usersDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            usersDao.deleteAllUsers();
            return null;
        }
    }
}

