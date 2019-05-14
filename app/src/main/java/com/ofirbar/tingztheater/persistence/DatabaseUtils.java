package com.ofirbar.tingztheater.persistence;

import android.arch.persistence.room.Room;
import android.content.Context;

public class DatabaseUtils {

    private static AppDatabase moviesDatabase;
    private static MovieDAO movieDAO;

    public static AppDatabase getMoviesLocalDatabase(Context context) {
        if (moviesDatabase == null) {
            moviesDatabase = Room.databaseBuilder(context, AppDatabase.class, "db-movies")
                    .allowMainThreadQueries()
                    .build();
        }
        return moviesDatabase;
    }

    public static MovieDAO getMovieDAOInstance(Context context){
        movieDAO = getMoviesLocalDatabase(context).getMovieDAO();
        return movieDAO;
    }

}
