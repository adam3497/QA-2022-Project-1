package com.qaproject.qa2022buscadordecontenido.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
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

    private String name;
    private String original_name;
    private String first_air_date;

    public TvShowModel() {
        super();
    }
    public TvShowModel(boolean adult, String backdrop_path, int id, String original_language,
                       String overview, String poster_path, String media_type, ArrayList<Integer> genre_ids,
                       int popularity, int vote_average, int vote_count, String name, String original_name,
                       String first_air_date) {
        super(adult, backdrop_path, id, original_language, overview, poster_path, media_type, genre_ids,
                popularity, vote_average, vote_count);
        this.name = name;
        this.original_name = original_name;
        this.first_air_date = first_air_date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginal_name() {
        return original_name;
    }

    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

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
