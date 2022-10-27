package com.qaproject.qa2022buscadordecontenido.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieModel extends MediaObject{

    private String title;
    private String originalTitle;
    private String releaseDate;
    private boolean video;

    public MovieModel(boolean adult, String backdropPath, int id, String originalLanguage,
                      String overview, String posterPath, String mediaType, ArrayList<Integer> genreIds,
                      int popularity, int voteAverage, int voteCount, String title, String originalTitle,
                      String releaseDate, boolean video) {
        super(adult, backdropPath, id, originalLanguage, overview, posterPath, mediaType, genreIds, popularity,
                voteAverage, voteCount);
        this.title = title;
        this.originalTitle = originalTitle;
        this.releaseDate = releaseDate;
        this.video = video;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
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
                ", originalTitle='" + originalTitle + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", video=" + video +
                "} ";
    }
}
