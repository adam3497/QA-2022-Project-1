package com.qaproject.qa2022buscadordecontenido.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieModel extends MediaObject{

    private String title;
    private String original_title;
    private String release_date;
    private boolean video;

    public MovieModel(boolean adult, String backdrop_path, int id, String original_language,
                      String overview, String poster_path, String media_type, ArrayList<Integer> genre_ids,
                      int popularity, int vote_average, int vote_count, String title, String original_title,
                      String release_date, boolean video) {
        super(adult, backdrop_path, id, original_language, overview, poster_path, media_type, genre_ids,
                popularity, vote_average, vote_count);
        this.title = title;
        this.original_title = original_title;
        this.release_date = release_date;
        this.video = video;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") +
                ", title='" + title + '\'' +
                ", originalTitle='" + original_title + '\'' +
                ", releaseDate='" + release_date + '\'' +
                ", video=" + video +
                "} ";
    }
}
