package com.qaproject.qa2022buscadordecontenido.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "page",
        "total_pages",
        "total_results",
        "results"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class TvShowResults extends ResultsModel {

    @JsonProperty("results")
    private ArrayList<TvShowModel> results;

    public TvShowResults() {
        super();
    }

    public TvShowResults(@JsonProperty("page") int page, @JsonProperty("total_pages") int total_pages,
                         @JsonProperty("total_results") int total_results,
                         @JsonProperty("results") ArrayList<TvShowModel> results) {
        super(page, total_pages, total_results);
        this.results = results;
    }

    @JsonProperty("results")
    public ArrayList<TvShowModel> getResults() {
        return results;
    }

    @JsonProperty("results")
    public void setResults(ArrayList<TvShowModel> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") +
                ", results=" + results.toString() +
                "}";
    }
}
