package com.ofirbar.tingztheater.persistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MovieDAO {
    @Insert
    void insert(Movie... movies);

    @Update
    void update(Movie... movies);

    @Delete
    void delete(Movie movies);

    @Query("SELECT * FROM movies")
    List<Movie> getAllMovies();

    @Query("SELECT * FROM movies WHERE title = :movieTitle")
    Movie getMovieWithTitle(String movieTitle);

}
