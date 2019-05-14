package com.ofirbar.tingztheater.networking;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MovieSchema {

    @SerializedName("title")
    @Expose
    public String title;
    @SerializedName("image")
    @Expose
    public String image;
    @SerializedName("rating")
    @Expose
    public Double rating;
    @SerializedName("releaseYear")
    @Expose
    public Integer releaseYear;
    @SerializedName("genre")
    @Expose
    public List<String> genre = null;

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public Double getRating() {
        return rating;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public List<String> getGenre() {
        return genre;
    }
}