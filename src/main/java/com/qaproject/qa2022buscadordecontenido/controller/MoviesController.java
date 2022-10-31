package com.qaproject.qa2022buscadordecontenido.controller;

import com.qaproject.qa2022buscadordecontenido.models.MovieResults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import static com.qaproject.qa2022buscadordecontenido.utils.Constants.*;

@RestController
public class MoviesController {

    private static final Logger log = LoggerFactory.getLogger(MoviesController.class);

    @GetMapping("/movies")
    public ModelAndView movies(RestTemplate restTemplate) {
        String trendingMoviesURL = TRENDING_MOVIE_URL + TRENDING_DAY + API_KEY_URL;
        log.info(trendingMoviesURL);
        try {
            MovieResults movieResults = restTemplate.getForObject(trendingMoviesURL, MovieResults.class);
            ModelAndView mv = new ModelAndView();
            assert movieResults != null;
            mv.addObject("trendingMovies", movieResults.getResults(5));
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
