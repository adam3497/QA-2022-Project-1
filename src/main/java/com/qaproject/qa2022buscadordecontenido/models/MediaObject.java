package com.qaproject.qa2022buscadordecontenido.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;

import static com.qaproject.qa2022buscadordecontenido.utils.Constants.BASE_IMG_URL;

/**
 * MediaObject class is a parent model intended to serve as the starting point for the media type objects that are
 * gotten from the TMDB API responses
 * Classes like MovieModel and TvShowModel inherit from this class
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "adult",
        "backdrop_path",
        "id",
        "original_language",
        "overview",
        "poster_path",
        "media_type",
        "genre_ids",
        "popularity",
        "vote_average",
        "vote_count"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class MediaObject {
    // Attributes and Methods shared between Movies and Tv Shows
    @JsonProperty("adult")
    protected boolean adult;
    @JsonProperty("backdrop_path")
    protected String backdrop_path;
    @JsonProperty("id")
    protected int id;
    @JsonProperty("original_language")
    protected String original_language;
    @JsonProperty("overview")
    protected String overview;
    @JsonProperty("poster_path")
    protected String poster_path;
    @JsonProperty("media_type")
    protected String media_type;
    @JsonProperty("genre_ids")
    protected ArrayList<Integer> genre_ids;
    @JsonProperty("popularity")
    protected float popularity;
    @JsonProperty("vote_average")
    protected float vote_average;
    @JsonProperty("vote_count")
    protected int vote_count;

    public MediaObject() {

    }

    public MediaObject(@JsonProperty("adult") boolean adult, @JsonProperty("backdrop_path") String backdrop_path,
                       @JsonProperty("id") int id, @JsonProperty("original_language") String original_language,
                       @JsonProperty("overview") String overview, @JsonProperty("poster_path") String poster_path,
                       @JsonProperty("media_type") String media_type, @JsonProperty("genre_ids") ArrayList<Integer> genre_ids,
                       @JsonProperty("popularity") float popularity, @JsonProperty("vote_average") float vote_average,
                       @JsonProperty("vote_count") int vote_count) {
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
        return BASE_IMG_URL + backdrop_path;
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
        return BASE_IMG_URL + poster_path;
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

    public float getPopularity() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public float getVote_average() {
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
