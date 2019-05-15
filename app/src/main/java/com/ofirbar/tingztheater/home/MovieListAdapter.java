package com.ofirbar.tingztheater.home;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ofirbar.tingztheater.R;

import java.util.List;


public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.ViewHolder> {

    private List<Movie> movieList;

    private Context context;


    public MovieListAdapter(List<Movie> listItems, Context context) {
        this.movieList = listItems;
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                //inflate the layout where we have the item model
                .inflate(R.layout.cardview_model, parent, false);

        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Movie singleMovie = movieList.get(position);
        //Here we set the actual content of our items
        holder.movieTitle.setText(singleMovie.getTitle());
        holder.movieReleaseYear.setText(String.valueOf(singleMovie.getReleaseYear()));
        holder.movieRating.setText(String.valueOf(singleMovie.getRating()));
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        //
        TextView movieTitle, movieReleaseYear, movieRating;

        LinearLayout linearLayoutCard;

        ViewHolder(View itemView) {
            super(itemView);

            //connect our local objects with the actual widgets ID
            movieTitle = itemView.findViewById(R.id.card_view_movie_title);
            movieReleaseYear = itemView.findViewById(R.id.card_view_movie_release_year);
            movieRating = itemView.findViewById(R.id.card_view_movie_rating);
            linearLayoutCard = itemView.findViewById(R.id.movies_card_listview);
        }
    }


}
