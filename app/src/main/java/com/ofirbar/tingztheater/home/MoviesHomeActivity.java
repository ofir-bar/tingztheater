package com.ofirbar.tingztheater.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ofirbar.tingztheater.R;
import com.ofirbar.tingztheater.persistence.DatabaseUtils;

import java.util.List;

public class MoviesHomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movies_home_activity);

        List<Movie> moviesList = DatabaseUtils.getMovieDAOInstance(this).getAllMovies();

        MovieListAdapter movieListAdapter = new MovieListAdapter(R.layout.list_item, moviesList);
        recyclerView = findViewById(R.id.item_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(movieListAdapter);


    }
}
