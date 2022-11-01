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
public class MovieResults extends ResultsModel {

    @JsonProperty("results")
    private ArrayList<MovieModel> results;

    public MovieResults() {
        super();
    }

    public MovieResults(@JsonProperty("page") int page, @JsonProperty("total_pages") int total_pages,
                        @JsonProperty("total_results") int total_results,
                        @JsonProperty("results") ArrayList<MovieModel> results) {
        super(page, total_pages, total_results);
        this.results = results;
    }

    @JsonProperty("results")
    public ArrayList<MovieModel> getResults() {
        return results;
    }

    @JsonProperty("results")
    public ArrayList<MovieModel> getResults(int amount) {
        if (amount <= results.size()) {
            ArrayList<MovieModel> truncatedMoviesResults = new ArrayList<>();
            for (int i=0; i<amount; i++) {
                truncatedMoviesResults.add(results.get(i));
            }
            return truncatedMoviesResults;
        }
        return results;
    }

    @JsonProperty("results")
    public void setResults(ArrayList<MovieModel> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return super.toString().replace("}", "") +
                ", results=" + results.toString() +
                "} ";
    }
}
