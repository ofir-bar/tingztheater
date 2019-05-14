package com.ofirbar.tingztheater.networking;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AndroidHiveMoviesApi {

    @GET("movies/")
    Call<MoviesListResponseSchema> fetchAllMovies();

}
