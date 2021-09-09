package com.example.project01group14;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {UsersEntity.class, HistoryEntity.class}, version = 1)
public abstract class UsersDatabase extends RoomDatabase {

    private static UsersDatabase instance;
    public abstract UsersDao usersDao();
    public static synchronized UsersDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    UsersDatabase.class, "users_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    public static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private UsersDao usersDao;
        private PopulateDbAsyncTask(UsersDatabase db){
            usersDao = db.usersDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            usersDao.insert(new UsersEntity("Username 1", "Firstname 1", "Lastname 1", "Password1"));
            usersDao.insert(new UsersEntity("Username 2", "Firstname 2", "Lastname 2", "Password2"));
            usersDao.insert(new UsersEntity("Username 3", "Firstname 3", "Lastname 3", "Password3"));
            return null;
        }
    }
}
