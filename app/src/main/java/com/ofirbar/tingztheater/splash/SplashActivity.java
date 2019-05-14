package com.ofirbar.tingztheater.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.ofirbar.tingztheater.home.Movie;
import com.ofirbar.tingztheater.home.MoviesHomeActivity;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.ofirbar.tingztheater.networking.NetworkUtils.getMoviesApi;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fetchMoviesData();
    }

    private void fetchMoviesData(){
        Call<List<Movie>> call = getMoviesApi().getAllMovies();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                saveDataToLocalDb(response.body());
                navigateToHomeScreen();
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {

            }
        });
    }

    private void saveDataToLocalDb(List<Movie> moviesList){

    }
    private void navigateToHomeScreen(){
        startActivity(new Intent(this, MoviesHomeActivity.class));
        finish();
    }




}
