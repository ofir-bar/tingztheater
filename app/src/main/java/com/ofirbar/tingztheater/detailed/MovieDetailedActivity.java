package com.ofirbar.tingztheater.detailed;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.ofirbar.tingztheater.R;

public class MovieDetailedActivity extends AppCompatActivity {

    TextView movieTitle;
    ImageView movieImage;
    TextView movieRating;
    TextView movieReleaseYear;
    TextView movieGenre;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detailed_activity);

        movieTitle = findViewById(R.id.detailed_movie_title);
        movieImage = findViewById(R.id.detailed_movie_image);
        movieRating = findViewById(R.id.detailed_movie_rating);
        movieReleaseYear = findViewById(R.id.detailed_movie_release_year);
        movieGenre = findViewById(R.id.detailed_movie_genre);

    }



}
