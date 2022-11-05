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
 * @author adam3497
 */
// Annotations to include the non-null objects found and to give a properties order
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
// This annotation helps to ignore those unknown elements that might be found during the parsing
@JsonIgnoreProperties(ignoreUnknown = true)
public class MediaObject {
    // Attributes shared between Movies and Tv Shows, we also include an annotation to define the attribute as the corresponding json property
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

    // Default constructor used for parsing the JSON object into a MediaObject object
    public MediaObject() {

    }

    /**
     * Parametrized constructor for parsing the JSON Object into a MediaObject, it also helps as the way to pass the attributes
     * from the classes that inherit from this one
     * @param adult a boolean that defines if the content is for adults or not
     * @param backdrop_path a string that defines the backdrop image of the content
     * @param id an int that defines the number used to find the content in the API
     * @param original_language a string that defines the original language code for the content
     * @param overview a string that contains the summary of the content
     * @param poster_path a string that defines the poster image of the content
     * @param media_type a string that defines whether the content is a movie or a tv show
     * @param genre_ids an arrays with all the genre ids for the content
     * @param popularity a float that defines how popular the content is
     * @param vote_average a float that represents the score of the content 1 <= vote_average <= 10
     * @param vote_count an int that represents how many votes the content has
     */
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

    // Methods to set and get all the attributes within the class

    /**
     * Getter method for the adult attr
     * @return the adult attr
     */
    public boolean isAdult() {
        return adult;
    }

    /**
     * A setter method for the adult attr
     * @param adult a boolean that represents whether the content is for adults only or not
     */
    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    /**
     * A getter method for the backdrop_path attr
     * @return a string that represents the whole image URL for the backdrop
     */
    public String getBackdrop_path() {
        // since the backdrop only represents the name of the image, we have to add the base image url in order to access it
        return BASE_IMG_URL + backdrop_path;
    }

    /**
     * A setter method for the backdrop_path attr
     * @param backdrop_path a string that contains the name of the backdrop + its extension (jpg, png, etc)
     */
    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    /**
     * A getter method for the id attr
     * @return an int that represents the id of the content in the TMDB API
     */
    public int getId() {
        return id;
    }

    /**
     * A setter method for the id attr
     * @param id an int representing the id of the content in the TMDB API
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * A getter for the original_language attr
     * @return a string that represents the language code of the content
     */
    public String getOriginal_language() {
        return original_language;
    }

    /**
     * A setter for the original_language attr
     * @param original_language a string that represents the language code of the content
     */
    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    /**
     * A getter method for the overview attr
     * @return a string with the overview
     */
    public String getOverview() {
        return overview;
    }

    /**
     * A setter method for the overview attr
     * @param overview a string that represents the overview of the content
     */
    public void setOverview(String overview) {
        this.overview = overview;
    }

    /**
     * A getter method for the poster_path attr
     * @return a string that contains the whole image url
     */
    public String getPoster_path() {
        // since the poster only represents the name of the image, we have to add the base image url in order to access it
        return BASE_IMG_URL + poster_path;
    }

    /**
     * A setter method for the poster_path attr
     * @param poster_path a string that contains the name of the poster + its extension (png, jpg, etc)
     */
    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    /**
     * A getter method for the media_type attr
     * @return a string that represents the media type of the content (tv or movie)
     */
    public String getMedia_type() {
        return media_type;
    }

    /**
     * A setter method for the media_type attr
     * @param media_type a string "tv" or "movie"
     */
    public void setMedia_type(String media_type) {
        this.media_type = media_type;
    }

    /**
     * A getter method for the genre_ids attr
     * @return an integer array with all the genre ids
     */
    public ArrayList<Integer> getGenre_ids() {
        return genre_ids;
    }

    /**
     * A setter method for the genre_ids attr
     * @param genre_ids an integer array with all the genre ids for the content
     */
    public void setGenre_ids(ArrayList<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }

    /**
     * A getter method for the popularity attr
     * @return a float that represents the popularity
     */
    public float getPopularity() {
        return popularity;
    }

    /**
     * A setter method for the popularity attr
     * @param popularity a float that represents the popularity
     */
    public void setPopularity(float popularity) {
        this.popularity = popularity;
    }

    /**
     * A getter method for the vote_average attr
     * @return a float with the vote average of the content
     */
    public float getVote_average() {
        return vote_average;
    }

    /**
     * A setter method for the vote_average attr
     * @param vote_average a float that represents the vote_average
     */
    public void setVote_average(float vote_average) {
        this.vote_average = vote_average;
    }

    /**
     * A getter method for the vote_count attr
     * @return a int that represents the vote count of the content
     */
    public int getVote_count() {
        return vote_count;
    }

    /**
     * A setter method for the vote_count attr
     * @param vote_count an int that represents the vote count of the content
     */
    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    /**
     * A simple toString method for the current object
     * @return a string as a json type of object
     */
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
