package com.qaproject.qa2022buscadordecontenido.controller;

import com.qaproject.qa2022buscadordecontenido.models.MovieResults;
import com.qaproject.qa2022buscadordecontenido.models.TvShowResults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import static com.qaproject.qa2022buscadordecontenido.utils.Constants.*;

/**
 * This class controls the whole interaction of /home page and gives the data it needs
 * @author adam3497
 */
@RestController
public class IndexController {

    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    /**
     * This method is called when access http://localhost:8080/home, it makes the request to the TMDB API
     * To get the trending movies and shows of the day, then it returns them as attributes of a ModelAndView object
     * @param restTemplate object of the current application
     * @return ModelAndView object with two attributes with names "movies" and "shows"
     */
    @GetMapping("/home")
    public ModelAndView index(RestTemplate restTemplate) {
        // We create two new URLs that will be used to get the trending movies and shows
        String trendingShowsURL = TRENDING_TV_URL + TRENDING_DAY + API_KEY_URL;
        String trendingMoviesURL = TRENDING_MOVIE_URL + TRENDING_DAY + API_KEY_URL;
        log.info(trendingShowsURL);
        log.info(trendingMoviesURL);
        try {
            // We use the RestTemplate class to make a GET request and get the response in JSON format
            // Spring Boot automatically parse the JSON response into an object of type MovieResults and TvShowResults using Jackson library
            TvShowResults showResults = restTemplate.getForObject(trendingShowsURL, TvShowResults.class);
            MovieResults movieResults = restTemplate.getForObject(trendingMoviesURL, MovieResults.class);
            // Finally, we return a ModelAndView object with our list of movies and shows as two attributes called "movies" and "shows" respectively
            ModelAndView mv = new ModelAndView();
            // An assertion to make sure the results are non-null to avoid errors
            assert showResults != null;
            assert movieResults != null;
            mv.addObject("shows", showResults.getResults());
            mv.addObject("movies", movieResults.getResults());
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
