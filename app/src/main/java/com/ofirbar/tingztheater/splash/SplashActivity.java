package com.ofirbar.tingztheater.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ofirbar.tingztheater.R;
import com.ofirbar.tingztheater.home.Movie;
import com.ofirbar.tingztheater.home.MoviesHomeActivity;
import com.ofirbar.tingztheater.persistence.DatabaseUtils;
import com.ofirbar.tingztheater.persistence.MovieDAO;

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
                Toast.makeText(SplashActivity.this, R.string.splash_get_movies_network_error, Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void saveDataToLocalDb(List<Movie> moviesList){
        MovieDAO movieDAO = DatabaseUtils.getMoviesLocalDatabase(this).getMovieDAO();

        // Push all the movies retrieved from the network request to the local database
        for(Movie movie:moviesList){
            movieDAO.insert(new Movie
                    (movie.getTitle(),
                     movie.getImage(),
                     movie.getRating(),
                     movie.getReleaseYear()));
        }

    }
    private void navigateToHomeScreen(){
        startActivity(new Intent(this, MoviesHomeActivity.class));
        finish();
    }




}
