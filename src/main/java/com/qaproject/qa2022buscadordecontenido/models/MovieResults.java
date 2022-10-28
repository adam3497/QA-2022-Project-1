package com.qaproject.qa2022buscadordecontenido.models;

import java.util.ArrayList;

public class MovieResults extends ResultsModel {

    private ArrayList<MovieModel> results;

    public MovieResults(int page, int totalPages, int totalResults, ArrayList<MovieModel> results) {
        super(page, totalPages, totalResults);
        this.results = results;
    }

    public ArrayList<MovieModel> getResults() {
        return results;
    }

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
