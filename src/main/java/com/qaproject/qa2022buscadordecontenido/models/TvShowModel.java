package com.qaproject.qa2022buscadordecontenido.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;

/**
 * TvShowModel is a class used to define a tv show JSON object from the TMDB API
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
        "name",
        "original_name",
        "first_air_date"
})
// This annotation helps to ignore those unknown elements that might be found during the parsing
@JsonIgnoreProperties(ignoreUnknown = true)
public class TvShowModel extends MediaObject {

    // Attributes that are specific for the tv show object, we also include an annotation to define the attribute as the corresponding json property
    @JsonProperty("name")
    private String name;
    @JsonProperty("original_name")
    private String original_name;
    @JsonProperty("first_air_date")
    private String first_air_date;

    // Default constructor used for parsing the JSON object into a MovieModel object
    public TvShowModel() {
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
     * @param name a string that represents the name of the show
     * @param original_name a string that represents the language code
     * @param first_air_date a string that represents the date when the show was first aired
     */
    public TvShowModel(@JsonProperty("adult") boolean adult, @JsonProperty("backdrop_path") String backdrop_path,
                       @JsonProperty("id") int id, @JsonProperty("original_language") String original_language,
                       @JsonProperty("overview") String overview, @JsonProperty("poster_path") String poster_path,
                       @JsonProperty("media_type") String media_type, @JsonProperty("genre_ids") ArrayList<Integer> genre_ids,
                       @JsonProperty("popularity") float popularity, @JsonProperty("vote_average") float vote_average,
                       @JsonProperty("vote_count") int vote_count, @JsonProperty("name") String name,
                       @JsonProperty("original_name") String original_name,
                       @JsonProperty("first_air_date") String first_air_date) {
        super(adult, backdrop_path, id, original_language, overview, poster_path, media_type, genre_ids,
                popularity, vote_average, vote_count);
        this.name = name;
        this.original_name = original_name;
        this.first_air_date = first_air_date;
    }

    // Methods to set and get all the attributes within the class

    /**
     * A getter method for the name attr
     * @return a string that represents the name of the show
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * A setter method for the name attr
     * @param name a string that represents the name of the show
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * A getter method for the original_name attr
     * @return a string that represents the full original name of the show
     */
    @JsonProperty("original_name")
    public String getOriginal_name() {
        return original_name;
    }

    /**
     * A setter method for the original_name attr
     * @param original_name a string that represents the full original name of the show
     */
    @JsonProperty("original_name")
    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    /**
     * A getter method for the first_air_date attr
     * @return a string that specifies the first day the show was broadcast
     */
    @JsonProperty("first_air_date")
    public String getFirst_air_date() {
        return first_air_date;
    }

    /**
     * A setter method for the first_air_date attr
     * @param first_air_date a string that specifies the first day the show was broadcast
     */
    @JsonProperty("first_air_date")
    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    /**
     * A simple toString method for the current object
     * @return a string as a json type of object
     */
    @Override
    public String toString() {
        return super.toString().replace("}", "") +
                ", name='" + name + '\'' +
                ", originalName='" + original_name + '\'' +
                ", firstAirDate='" + first_air_date + '\'' +
                "}";
    }
}
