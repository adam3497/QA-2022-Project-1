package com.qaproject.qa2022buscadordecontenido.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "page",
        "total_pages",
        "total_results"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultsModel {

    @JsonProperty("page")
    protected int page;
    @JsonProperty("total_pages")
    protected int total_pages;
    @JsonProperty("total_results")
    protected int total_results;

    public ResultsModel(@JsonProperty("page") int page, @JsonProperty("total_pages") int total_pages,
                        @JsonProperty("total_results") int total_results) {
        this.page = page;
        this.total_pages = total_pages;
        this.total_results = total_results;
    }

    public ResultsModel() {

    }

    @JsonProperty("page")
    public int getPage() {
        return page;
    }

    @JsonProperty("page")
    public void setPage(int page) {
        this.page = page;
    }

    @JsonProperty("total_pages")
    public int getTotal_pages() {
        return total_pages;
    }

    @JsonProperty("total_pages")
    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    @JsonProperty("total_results")
    public int getTotal_results() {
        return total_results;
    }

    @JsonProperty("total_results")
    public void setTotal_results(int total_results) {
        this.total_results = total_results;
    }

    @Override
    public String toString() {
        return "ResultsModel{" +
                "page=" + page +
                ", totalPages=" + total_pages +
                ", totalResults=" + total_results +
                '}';
    }
}
