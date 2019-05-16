package com.ofirbar.tingztheater.detailed;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ofirbar.tingztheater.R;

public class MovieDetailedActivity extends AppCompatActivity {

    public static final String MOVIE_TITLE = "movieTitle";
    public static final String MOVIE_RATING = "movieRating";
    public static final String MOVIE_RELEASE_YEAR = "movieReleaseYear";
    public static final String MOVIE_IMAGE_URL = "movieImageURL";

    TextView movieTitle;
    TextView movieRating;
    TextView movieReleaseYear;
    ImageView movieImage;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detailed_activity);

        movieTitle = findViewById(R.id.detailed_movie_title);
        movieRating = findViewById(R.id.detailed_movie_rating);
        movieReleaseYear = findViewById(R.id.detailed_movie_release_year);
        movieImage = findViewById(R.id.detailed_movie_image);


        // set the String values to the views
        movieTitle.setText(getIntent().getStringExtra(MOVIE_TITLE));
        movieRating.setText(String.format("%s %s",getString(R.string.detailed_movie_rating_default),String.valueOf(getIntent().getDoubleExtra(MOVIE_RATING, -1))));
        movieReleaseYear.setText(String.format("%s %s",getString(R.string.detailed_movie_release_year_default),String.valueOf(getIntent().getIntExtra(MOVIE_RELEASE_YEAR, 0))));
        Glide.with(this).load(getIntent().getStringExtra(MOVIE_IMAGE_URL)).into(movieImage);
    }



}
