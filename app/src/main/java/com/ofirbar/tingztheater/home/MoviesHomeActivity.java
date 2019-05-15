package com.ofirbar.tingztheater.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ofirbar.tingztheater.R;
import com.ofirbar.tingztheater.persistence.DatabaseUtils;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MoviesHomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Movie> moviesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movies_home_activity);

        moviesList = DatabaseUtils.getMovieDAOInstance(this).getAllMovies();
        sortMoviesByReleaseYearDescending();

        MovieListAdapter movieListAdapter = new MovieListAdapter(moviesList, this);
        recyclerView = findViewById(R.id.item_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(movieListAdapter);

    }

    private void sortMoviesByReleaseYearDescending(){
        Collections.sort(moviesList, new Comparator<Movie>() {
            @Override
            public int compare(Movie m1, Movie m2) {
                return m2.getReleaseYear().compareTo(m1.getReleaseYear());
            }
        });
    }

}
