package com.ofirbar.tingztheater.detailed;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.ofirbar.tingztheater.R;

public class MovieDetailedActivity extends AppCompatActivity {

    public static final String MOVIE_TITLE = "movieTitle";
    public static final String MOVIE_RATING = "movieRating";
    public static final String MOVIE_RELEASE_YEAR = "movieReleaseYear";


    TextView movieTitle;
    TextView movieRating;
    TextView movieReleaseYear;

    String movieTitleString;
    String movieRatingString;
    String movieReleaseYearString;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detailed_activity);

        movieTitle = findViewById(R.id.detailed_movie_title);
        movieRating = findViewById(R.id.detailed_movie_rating);
        movieReleaseYear = findViewById(R.id.detailed_movie_release_year);


        //get values from intent
        movieTitleString = getIntent().getStringExtra(MOVIE_TITLE);
        movieRatingString = String.valueOf(getIntent().getDoubleExtra(MOVIE_RATING, 0)) ;
        movieReleaseYearString = String.valueOf(getIntent().getIntExtra(MOVIE_RELEASE_YEAR, 0));

        // set the String values to the views
        movieTitle.setText(movieTitleString);
        movieRating.setText(movieRatingString);
        movieReleaseYear.setText(movieReleaseYearString);
    }



}
