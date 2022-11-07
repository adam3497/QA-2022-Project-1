package com.qaproject.qa2022buscadordecontenido.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.ArrayList;

/**
 * A MovieResults object to handle the responses from the API related to movie queries
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
public class MovieResults extends ResultsModel {

    // Specific attribute for the MovieResults object
    @JsonProperty("results")
    private ArrayList<MovieModel> results;

    // Default constructor used for parsing the JSON object into a MovieResults object
    public MovieResults() {
        super();
    }

    /**
     * A parametrized construct used to create a new MovieResults object from a JSON object
     * @param page an int that specifies the current page of the consult
     * @param total_pages an int that specifies the amount of pages available to consult
     * @param total_results an int that specifies the total number of results from the query
     * @param results a MovieModel array with all the results from the query
     */
    public MovieResults(@JsonProperty("page") int page, @JsonProperty("total_pages") int total_pages,
                        @JsonProperty("total_results") int total_results,
                        @JsonProperty("results") ArrayList<MovieModel> results) {
        super(page, total_pages, total_results);
        this.results = results;
    }

    // Getter and setter methods within the class

    /**
     * A getter method for the results attr
     * @return a MovieModel array with all the results from the query
     */
    @JsonProperty("results")
    public ArrayList<MovieModel> getResults() {
        return results;
    }

    /**
     * An override getter method for the results attr
     * @param amount an int that specifies the amount of results to be returned within the array
     * @return a representative MovieModel array with the amount of results specified by the parameter
     */
    @JsonProperty("results")
    public ArrayList<MovieModel> getResults(int amount) {
        // We check if the amount param is less than the size of the array
        if (amount < results.size()) {
            // if so, then we proceed to truncate the array with the amount of corresponding results
            ArrayList<MovieModel> truncatedMoviesResults = new ArrayList<>();
            for (int i=0; i<amount; i++) {
                truncatedMoviesResults.add(results.get(i));
            }
            // Finally, we return the new truncated array
            return truncatedMoviesResults;
        }
        // In case the amount is greater of equals than the size, we return the array without truncation
        return results;
    }

    /**
     * A setter method for the results attr
     * @param results a MovieModel array with all the results from the current page
     */
    @JsonProperty("results")
    public void setResults(ArrayList<MovieModel> results) {
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
                "} ";
    }
}
