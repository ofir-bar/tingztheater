package com.ofirbar.tingztheater.splash;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ofirbar.tingztheater.R;
import com.ofirbar.tingztheater.home.MoviesHomeActivity;
import com.ofirbar.tingztheater.networking.MoviesListResponseSchema;
import com.ofirbar.tingztheater.networking.NetworkUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fetchMoviesData(this);
    }


    private void fetchMoviesData(final Context context){
        Call<MoviesListResponseSchema> callToGetMovies = NetworkUtils.getMoviesApi().fetchAllMovies();
        callToGetMovies.enqueue(new Callback<MoviesListResponseSchema>() {
            @Override
            public void onResponse(Call<MoviesListResponseSchema> call, Response<MoviesListResponseSchema> response) {
                //TODO: Store the movies to a local DB
                navigateToHomeScreen();
            }

            @Override
            public void onFailure(Call<MoviesListResponseSchema> call, Throwable t) {
                Toast.makeText(context, R.string.splash_get_movies_network_error, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void navigateToHomeScreen(){
        startActivity(new Intent(this, MoviesHomeActivity.class));
        finish();
    }

}
