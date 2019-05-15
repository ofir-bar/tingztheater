package com.ofirbar.tingztheater.home;

import java.util.Comparator;

public class SortByReleaseYearDescending implements Comparator<Movie> {

    @Override
    public int compare(Movie a, Movie b) {
        return b.getReleaseYear() - a.getReleaseYear();
    }
}
