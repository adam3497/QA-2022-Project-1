package com.qaproject.qa2022buscadordecontenido.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * A parent class model to manage the API responses and its content
 * This class is inherited by MovieModel and TvShowModel classes
 * @author adam3497
 */
// Annotations to include the non-null objects found and to give a properties order
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "page",
        "total_pages",
        "total_results"
})
// This annotation helps to ignore those unknown elements that might be found during the parsing
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultsModel {

    // Attributes shared between MovieResults and TvShowResults, we also include an annotation to define the attribute as the corresponding json property
    @JsonProperty("page")
    protected int page;
    @JsonProperty("total_pages")
    protected int total_pages;
    @JsonProperty("total_results")
    protected int total_results;

    /**
     * Parametrized construct method used by the JSON library to convert the json object into a ResultsModel Object
     * @param page an int that specifies the current page of the consult
     * @param total_pages an int that specifies the amount of pages available to consult
     * @param total_results an int that specifies the total number of results from the query
     */
    public ResultsModel(@JsonProperty("page") int page, @JsonProperty("total_pages") int total_pages,
                        @JsonProperty("total_results") int total_results) {
        this.page = page;
        this.total_pages = total_pages;
        this.total_results = total_results;
    }

    // Default constructor used for parsing the JSON object into a ResultsModel object
    public ResultsModel() {

    }

    // Methods to set and get all the attributes within the class

    /**
     * A getter method for the page attr
     * @return an int that specifies the current page
     */
    @JsonProperty("page")
    public int getPage() {
        return page;
    }

    /**
     * A setter method for the page attr
     * @param page an int that specifies the current page
     */
    @JsonProperty("page")
    public void setPage(int page) {
        this.page = page;
    }

    /**
     * A getter method for the total_pages attr
     * @return an int that represents the total number of pages within the consults that are available
     */
    @JsonProperty("total_pages")
    public int getTotal_pages() {
        return total_pages;
    }

    /**
     * A setter method for the total_pages attr
     * @param total_pages an int that specifies the total number of pages within the query
     */
    @JsonProperty("total_pages")
    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    /**
     * A getter method for the total_results attr
     * @return an int that specifies the total number of results within the query consult
     */
    @JsonProperty("total_results")
    public int getTotal_results() {
        return total_results;
    }

    /**
     * A setter method for the total_results attr
     * @param total_results an int that represents the total number of results gotten by the query
     */
    @JsonProperty("total_results")
    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    /**
     * A simple toString method for the current object
     * @return a string as a json type of object
     */
    @Override
    public String toString() {
        return "ResultsModel{" +
                "page=" + page +
                ", totalPages=" + total_pages +
                ", totalResults=" + total_results +
                '}';
    }
}
