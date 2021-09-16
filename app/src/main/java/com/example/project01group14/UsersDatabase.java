package com.example.project01group14;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {UsersEntity.class}, version = 1)

public abstract class UsersDatabase extends RoomDatabase {
    private static String dbName = "users_database";
    private static UsersDatabase instance;
    public abstract UsersDao usersDao();
    public static synchronized UsersDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    UsersDatabase.class, "users_table")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

//    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
//        @Override
//        public void onCreate(@NonNull SupportSQLiteDatabase db) {
//            super.onCreate(db);
//            new PopulateDbAsyncTask(instance).execute();
//        }
//    };

//    public static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
//        private UsersDao usersDao;
//        private PopulateDbAsyncTask(UsersDatabase db){
//            usersDao = db.usersDao();
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            usersDao.insert(new UsersEntity("Username1", "Firstname1", "Lastname1", "Password1"));
//            usersDao.insert(new UsersEntity("Username2", "Firstname2", "Lastname2", "Password2"));
//            usersDao.insert(new UsersEntity("Username3", "Firstname3", "Lastname3", "Password3"));
//            return null;
//        }
//    }
}
