package com.qaproject.qa2022buscadordecontenido.models;

import java.util.ArrayList;

public class TvShowResults extends ResultsModel {

    private ArrayList<TvShowModel> results;

    public TvShowResults(int page, int total_pages, int total_results, ArrayList<TvShowModel> results) {
        super(page, total_pages, total_results);
        this.results = results;
    }

    public ArrayList<TvShowModel> getResults() {
        return results;
    }

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
