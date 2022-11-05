package com.qaproject.qa2022buscadordecontenido.controller;

import com.qaproject.qa2022buscadordecontenido.models.MovieResults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import static com.qaproject.qa2022buscadordecontenido.utils.Constants.*;

/**
 * This class controls the whole interaction of /movies page and gives the data it needs
 * @author adam3497
 */
@RestController
public class MoviesController {

    private static final Logger log = LoggerFactory.getLogger(MoviesController.class);

    /**
     * This method is called when access http://localhost:8080/movies, it makes the request to the TMDB API
     * To get the trending movies of the day, and it returns them as an attribute of a ModelAndView object
     * @param restTemplate object of the current application
     * @return ModelAndView object with one attribute called "trendingMovies"
     */
    @GetMapping("/movies")
    public ModelAndView movies(RestTemplate restTemplate) {
        // We create a new URL that will be used to get the trending movies
        String trendingMoviesURL = TRENDING_MOVIE_URL + TRENDING_DAY + API_KEY_URL;
        log.info("Requesting data to: " + trendingMoviesURL);
        try {
            // We use the RestTemplate class to make a GET request and get the response in JSON format
            // Spring Boot automatically parse the JSON response into an object of type MovieResults using Jackson library
            MovieResults movieResults = restTemplate.getForObject(trendingMoviesURL, MovieResults.class);
            // Finally, we return a ModelAndView object with our list of movies as an attribute called "trendingMovies"
            ModelAndView mv = new ModelAndView();
            assert movieResults != null;
            // In this case we are using just 5 movies instead of the whole result
            mv.addObject("trendingMovies", movieResults.getResults(5));
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
