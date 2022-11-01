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

@RestController
public class IndexController {

    private static final Logger log = LoggerFactory.getLogger(IndexController.class);

    @GetMapping("/home")
    public ModelAndView index(RestTemplate restTemplate) {
        String trendingShowsURL = TRENDING_TV_URL + TRENDING_DAY + API_KEY_URL;
        String trendingMoviesURL = TRENDING_MOVIE_URL + TRENDING_DAY + API_KEY_URL;
        log.info(trendingShowsURL);
        log.info(trendingMoviesURL);
        try {
            TvShowResults showResults = restTemplate.getForObject(trendingShowsURL, TvShowResults.class);
            MovieResults movieResults = restTemplate.getForObject(trendingMoviesURL, MovieResults.class);
            ModelAndView mv = new ModelAndView();
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
