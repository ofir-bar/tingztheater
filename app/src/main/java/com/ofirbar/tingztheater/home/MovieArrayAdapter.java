package com.ofirbar.tingztheater.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ofirbar.tingztheater.R;
import java.util.ArrayList;


public class MovieArrayAdapter extends RecyclerView.Adapter<MovieArrayAdapter.ViewHolder> {

    private int listItemLayout;
    private ArrayList<Movie> movieList;
    // Constructor of the class
    public MovieArrayAdapter(int layoutId, ArrayList<Movie> movieList) {
        listItemLayout = layoutId;
        this.movieList = movieList;
    }

    // get the size of the list
    @Override
    public int getItemCount() {
        return movieList == null ? 0 : movieList.size();
    }


    // specify the row layout file and click for each row
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);
        ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    // load data in each row element
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int listPosition) {
        TextView item = holder.item;
        item.setText(movieList.get(listPosition).getTitle());
    }

    // Static inner class to initialize the views of rows
    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView item;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            item = itemView.findViewById(R.id.row_item);
        }
        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "onClick " + getLayoutPosition() + " " + item.getText(), Toast.LENGTH_SHORT).show();
        }
    }
}