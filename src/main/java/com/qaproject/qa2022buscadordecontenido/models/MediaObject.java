package com.qaproject.qa2022buscadordecontenido.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

/**
 * MediaObject class is a parent model intended to serve as the starting point for the media type objects that are
 * gotten from the TMDB API responses
 * Classes like MovieModel and TvShowModel inherit from this class
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MediaObject {
    // Attributes and Methods shared between Movies and Tv Shows
    protected boolean adult;
    protected String backdrop_path;
    protected int id;
    protected String original_language;
    protected String overview;
    protected String poster_path;
    protected String media_type;
    protected ArrayList<Integer> genre_ids;
    protected int popularity;
    protected int vote_average;
    protected int vote_count;

    public MediaObject(boolean adult, String backdrop_path, int id, String original_language,
                       String overview, String poster_path, String media_type, ArrayList<Integer> genre_ids,
                       int popularity, int vote_average, int vote_count) {
        this.adult = adult;
        this.backdrop_path = backdrop_path;
        this.id = id;
        this.original_language = original_language;
        this.overview = overview;
        this.poster_path = poster_path;
        this.media_type = media_type;
        this.genre_ids = genre_ids;
        this.popularity = popularity;
        this.vote_average = vote_average;
        this.vote_count = vote_count;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getMedia_type() {
        return media_type;
    }

    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    public ArrayList<Integer> getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(ArrayList<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    public int getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public int getVote_average() {
        return vote_average;
    }

    public void setVote_average(int vote_average) {
        this.vote_average = vote_average;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    @Override
    public String toString() {
        return "MediaObject{" +
                "adult=" + adult +
                ", backdropPath='" + backdrop_path + '\'' +
                ", id=" + id +
                ", originalLanguage='" + original_language + '\'' +
                ", overview='" + overview + '\'' +
                ", posterPath='" + poster_path + '\'' +
                ", mediaType='" + media_type + '\'' +
                ", genreIds=" + genre_ids +
                ", popularity=" + popularity +
                ", voteAverage=" + vote_average +
                ", voteCount=" + vote_count +
                '}';
    }
}
