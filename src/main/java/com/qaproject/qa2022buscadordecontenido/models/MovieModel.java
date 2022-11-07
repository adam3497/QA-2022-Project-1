package com.qaproject.qa2022buscadordecontenido.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;

/**
 * MovieModel is a class used to define a movie JSON object from the TMDB API
 * It inherits attributes and methods from MediaObject class
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
        "vote_count",
        "title",
        "original_title",
        "release_date",
        "video"
})
// This annotation helps to ignore those unknown elements that might be found during the parsing
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieModel extends MediaObject{

    // Attributes that are specific for the movie object, we also include an annotation to define the attribute as the corresponding json property
    @JsonProperty("title")
    private String title;
    @JsonProperty("original_title")
    private String original_title;
    @JsonProperty("release_date")
    private String release_date;
    @JsonProperty("video")
    private boolean video;

    // Default constructor used for parsing the JSON object into a MovieModel object
    public MovieModel() {
        // Call to the father class
        super();

    }

    /**
     * Parametrized constructor for parsing the JSON Object into a MovieModel object, we also pass the data to the parent class
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
     * @param title a string that represents the title of the movie
     * @param original_title a string that represents the full original title of the movie
     * @param release_date a string that represents the date when the movie was released
     * @param video a boolean that specifies whether the movie is for adults only or not
     */
    public MovieModel(@JsonProperty("adult") boolean adult, @JsonProperty("backdrop_path") String backdrop_path,
                      @JsonProperty("id") int id, @JsonProperty("original_language") String original_language,
                      @JsonProperty("overview") String overview, @JsonProperty("poster_path") String poster_path,
                      @JsonProperty("media_type") String media_type, @JsonProperty("genre_ids") ArrayList<Integer> genre_ids,
                      @JsonProperty("popularity") float popularity, @JsonProperty("vote_average") float vote_average,
                      @JsonProperty("vote_count") int vote_count, @JsonProperty("title") String title,
                      @JsonProperty("original_title") String original_title, @JsonProperty("release_date") String release_date,
                      @JsonProperty("video") boolean video) {
        super(adult, backdrop_path, id, original_language, overview, poster_path, media_type, genre_ids,
                popularity, vote_average, vote_count);
        this.title = title;
        this.original_title = original_title;
        this.release_date = release_date;
        this.video = video;
    }

    // Methods to set and get all the attributes within the class

    /**
     * A getter method for the title attr
     * @return a string that represents the title of the movie
     */
    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    /**
     * A setter method for the title attr
     * @param title a string that represents the title of the movie
     */
    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * A getter method for the original_title attr
     * @return a string that represents the full original title of the movie
     */
    @JsonProperty("original_title")
    public String getOriginal_title() {
        return original_title;
    }

    /**
     * A setter method for the original_title attr
     * @param original_title a string that specifies full original title of the movie
     */
    @JsonProperty("original_title")
    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    /**
     * A getter method for the release_date attr
     * @return a string that represents the day when the movie got released
     */
    @JsonProperty("release_date")
    public String getRelease_date() {
        return release_date;
    }

    /**
     * A setter method for the release_date attr
     * @param release_date a string that represents the day when the movie got released
     */
    @JsonProperty("release_date")
    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    /**
     * A getter method for the video attr
     * @return a boolean that specifies whether the movie is for adults only or not
     */
    @JsonProperty("video")
    public boolean isVideo() {
        return video;
    }

    /**
     * A setter method for the video attr
     * @param video a boolean that specifies whether the movie is for adults only or not
     */
    @JsonProperty("video")
    public void setVideo(boolean video) {
        this.video = video;
    }

    /**
     * A simple toString method for the current object
     * @return a string as a json type of object
     */
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
