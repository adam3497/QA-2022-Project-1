package com.qaproject.qa2022buscadordecontenido.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;

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
@JsonIgnoreProperties(ignoreUnknown = true)
public class TvShowModel extends MediaObject {

    @JsonProperty("name")
    private String name;
    @JsonProperty("original_name")
    private String original_name;
    @JsonProperty("first_air_date")
    private String first_air_date;

    public TvShowModel() {
        super();
    }
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

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("original_name")
    public String getOriginal_name() {
        return original_name;
    }

    @JsonProperty("original_name")
    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    @JsonProperty("first_air_date")
    public String getFirst_air_date() {
        return first_air_date;
    }

    @JsonProperty("first_air_date")
    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") +
                ", name='" + name + '\'' +
                ", originalName='" + original_name + '\'' +
                ", firstAirDate='" + first_air_date + '\'' +
                "}";
    }
}
