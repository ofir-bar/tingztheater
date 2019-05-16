package com.ofirbar.tingztheater.networking;

import com.ofirbar.tingztheater.persistence.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AndroidHiveMoviesApi {

    @GET("movies.json")
    Call<List<Movie>> getAllMovies();

}
