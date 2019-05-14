package com.ofirbar.tingztheater.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ofirbar.tingztheater.R;

import java.util.ArrayList;

public class MoviesHomeActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movies_home_activity);

        // Initializing list view with the custom adapter
        ArrayList<Movie> movieList = new ArrayList<Movie>();

        MovieArrayAdapter movieArrayAdapter = new MovieArrayAdapter(R.layout.list_item, movieList);
        recyclerView = findViewById(R.id.item_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(movieArrayAdapter);

        // Populating list items
        for(int i=0; i<40; i++) {
            Movie someMovie = new Movie();
            someMovie.setTitle("StarWars" + (i));
            movieList.add(someMovie);
        }

    }
}
