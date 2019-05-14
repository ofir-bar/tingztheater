package com.ofirbar.tingztheater.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ofirbar.tingztheater.home.Movie;
import com.ofirbar.tingztheater.home.MoviesHomeActivity;
import com.ofirbar.tingztheater.networking.AndroidHiveMoviesApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SplashActivity extends AppCompatActivity {

    private List<Movie> moviesList =null;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fetchMoviesData();
    }


    private void fetchMoviesData(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.androidhive.info/json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        AndroidHiveMoviesApi service = retrofit.create(AndroidHiveMoviesApi.class);
        Call<List<Movie>> call = service.getAllMovies();

        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                moviesList = response.body();

                for(Movie movie:moviesList){
                    Log.e("onResponse", movie.getTitle());
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {

            }
        });
    }

    private void saveDataToLocalDb(){}
    private void navigateToHomeScreen(){
        startActivity(new Intent(this, MoviesHomeActivity.class));
        finish();
    }

}
