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
        "title",
        "original_title",
        "release_date",
        "video"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieModel extends MediaObject{

    @JsonProperty("title")
    private String title;
    @JsonProperty("original_title")
    private String original_title;
    @JsonProperty("release_date")
    private String release_date;
    @JsonProperty("video")
    private boolean video;

    public MovieModel() {
        super();

    }
    public MovieModel(@JsonProperty("adult") boolean adult, @JsonProperty("backdrop_path") String backdrop_path,
                      @JsonProperty("id") int id, @JsonProperty("original_language") String original_language,
                      @JsonProperty("overview") String overview, @JsonProperty("poster_path") String poster_path,
                      @JsonProperty("media_type") String media_type, @JsonProperty("genre_ids") ArrayList<Integer> genre_ids,
                      @JsonProperty("popularity") int popularity, @JsonProperty("vote_average") int vote_average,
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

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("original_title")
    public String getOriginal_title() {
        return original_title;
    }

    @JsonProperty("original_title")
    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    @JsonProperty("release_date")
    public String getRelease_date() {
        return release_date;
    }

    @JsonProperty("release_date")
    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    @JsonProperty("video")
    public boolean isVideo() {
        return video;
    }

    @JsonProperty("video")
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
