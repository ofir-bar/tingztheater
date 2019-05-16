package com.ofirbar.tingztheater.detailed;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ofirbar.tingztheater.R;

public class MovieDetailedActivity extends AppCompatActivity {

    public static final String MOVIE_TITLE = "movieTitle";
    public static final String MOVIE_RATING = "movieRating";
    public static final String MOVIE_RELEASE_YEAR = "movieReleaseYear";
    public static final String MOVIE_IMAGE_URL = "movieImageURL";

    TextView movieTitle;
    RatingBar movieRating;
    TextView movieReleaseYear;
    ImageView movieImage;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detailed_activity);

        movieImage = findViewById(R.id.detailed_movie_image);
        Glide.with(this).load(getIntent().getStringExtra(MOVIE_IMAGE_URL)).into(movieImage);

        movieTitle = findViewById(R.id.detailed_movie_title);
        movieTitle.setText(getIntent().getStringExtra(MOVIE_TITLE));

        movieRating = findViewById(R.id.detailed_movie_rating);
        movieRating.setIsIndicator(true);
        movieRating.setRating((float)(getIntent().getDoubleExtra(MOVIE_RATING, 3) / 2)); // Divide the rating by 2. So we can fit a score of 8.2 into 5 stars (which will show a 4.1 Star)

        movieReleaseYear = findViewById(R.id.detailed_movie_release_year);
        movieReleaseYear.setText(String.format("%s %s",getString(R.string.detailed_movie_release_year_default),String.valueOf(getIntent().getIntExtra(MOVIE_RELEASE_YEAR, 0))));

    }



}
