package com.qaproject.qa2022buscadordecontenido.utils;

/**
 * A class with constants that are used all over the application
 */
public class Constants {
    // TMDB URL constants
    public static final String API_KEY = "74b8d0310806e6ab9d6542fc5047df15";
    public static final String QUERY = "&query=";
    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    // Trending URLs
    public static final String TRENDING_URL = BASE_URL + "trending/";
    public static final String TRENDING_MOVIE_URL = TRENDING_URL + "movie/";
    public static final String TRENDING_TV_URL = TRENDING_URL + "tv/";

    public static final String SEARCH_MOVIES_URL = BASE_URL + "search/movie";
    public static final String SEARCH_TV_URL = BASE_URL + "search/tv";
    public static final String TRENDING_DAY = "day";
    public static final String TRENDING_WEEK = "week";
    public static final String API_KEY_URL = "?api_key=" + API_KEY;
    public static final String BASE_IMG_URL = "https://image.tmdb.org/t/p/original/";
}
