package com.qaproject.qa2022buscadordecontenido.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;

/**
 * A TvShowResults object to handle the responses from the API related to movie queries
 * It inherits attributes and methods from ResultsModel parent class
 * @author adam3497
 */
// Annotations to include the non-null objects found and to give a properties order
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "page",
        "total_pages",
        "total_results",
        "results"
})
// This annotation helps to ignore those unknown elements that might be found during the parsing
@JsonIgnoreProperties(ignoreUnknown = true)
public class TvShowResults extends ResultsModel {

    // Specific attribute for the TvShowResults object
    @JsonProperty("results")
    private ArrayList<TvShowModel> results;

    // Default constructor used for parsing the JSON object into a TvShowResults object
    public TvShowResults() {
        super();
    }

    /**
     * A parametrized construct used to create a new TvShowResults object from a JSON object
     * @param page an int that specifies the current page of the consult
     * @param total_pages an int that specifies the amount of pages available to consult
     * @param total_results an int that specifies the total number of results from the query
     * @param results a TvShowResults array with all the results from the current page
     */
    public TvShowResults(@JsonProperty("page") int page, @JsonProperty("total_pages") int total_pages,
                         @JsonProperty("total_results") int total_results,
                         @JsonProperty("results") ArrayList<TvShowModel> results) {
        super(page, total_pages, total_results);
        this.results = results;
    }

    // Getter and setter methods within the class

    /**
     * A getter method for the results attr
     * @return a TvShowResults array with all the results from the query
     */
    @JsonProperty("results")
    public ArrayList<TvShowModel> getResults() {
        return results;
    }

    /**
     * A setter method for the results attr
     * @param results a TvShowResults array with all the results from the current page
     */
    @JsonProperty("results")
    public void setResults(ArrayList<TvShowModel> results) {
        this.results = results;
    }

    /**
     * A simple toString method for the current object
     * @return a string as a json type of object
     */
    @Override
    public String toString() {
        return super.toString().replace("}", "") +
                ", results=" + results.toString() +
                "}";
    }
}
