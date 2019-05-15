package com.ofirbar.tingztheater.persistence;

import android.arch.persistence.room.Room;
import android.content.Context;

import java.io.File;

import static com.ofirbar.tingztheater.Constants.LOCAL_DATABASE_NAME;

public class DatabaseUtils {

    private static AppDatabase moviesDatabase;
    private static MovieDAO movieDAO;

    public static AppDatabase getMoviesLocalDatabase(Context context) {
        if (moviesDatabase == null) {
            moviesDatabase = Room.databaseBuilder(context, AppDatabase.class, LOCAL_DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return moviesDatabase;
    }

    public static MovieDAO getMovieDAOInstance(Context context){
        movieDAO = getMoviesLocalDatabase(context).getMovieDAO();
        return movieDAO;
    }


    // Room is SQLite behind the scenes. SQLite is a file, so we can check if the file exists
    // It will allow us to know if the DB exist.
    public static boolean doesDatabaseExist(Context context) {
        File dbFile = context.getDatabasePath(LOCAL_DATABASE_NAME);
        return dbFile.exists();
    }

}
