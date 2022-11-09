package com.qaproject.qa2022buscadordecontenido.controller;

import com.qaproject.qa2022buscadordecontenido.models.MovieResults;
import com.qaproject.qa2022buscadordecontenido.models.TvShowResults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static com.qaproject.qa2022buscadordecontenido.utils.Constants.*;

/**
 * Controller class for the whole search module
 */
@RestController
public class SearchController {
    private static final Logger log = LoggerFactory.getLogger(SearchController.class);


    @GetMapping("/search")
    public ModelAndView mediaSearch(@Param("Search") String keyword, Model model, RestTemplate restTemplate) {
        /**
         * This method is called when the search button it makes a search request to the TMDB API
         * The request takes the string stored in the search botton placeholder as keyword for the search
         * to get the movies and shows associated with the keyword, and it returns them as an attribute of a ModelAndView object
         * @param restTemplate object of the current application
         * @param keyword string to send the query with
         * @return ModelAndView object with "movies" and "shows" that match with the query search
         */
        // We initialized our ModelAndView objet
        ModelAndView mv = new ModelAndView();

        // We parse the keyword to match request format
        String uriEncodedKeyword = URLEncoder.encode(keyword, StandardCharsets.UTF_8);
        uriEncodedKeyword = uriEncodedKeyword.replace("+", "&");

        // We create a new URL that will be used to get the matching shows and movies
        String searchTvUrl = SEARCH_TV_URL + API_KEY_URL + QUERY + uriEncodedKeyword;
        String searchMovieUrl = SEARCH_MOVIES_URL + API_KEY_URL + QUERY + uriEncodedKeyword;

        // Checks if the query is valid
        if (!isSearchValid(keyword)) {
            model.addAttribute("keyword", "Busqueda invalida");
            model.addAttribute("titulo de pagina", "Busqueda invalida");
            return mv;

        } else {

            try {
                // We use the RestTemplate class to make a GET request and get the response in JSON format
                // Spring Boot automatically parse the JSON response into an object of type MovieResults using Jackson library
                log.info(searchTvUrl);
                TvShowResults tvShowResults = restTemplate.getForObject(searchTvUrl, TvShowResults.class);
                // An assertion to make sure the results are non-null to avoid errors
                assert tvShowResults != null;
                mv.addObject("shows", tvShowResults.getResults());

                log.info(searchMovieUrl);
                MovieResults movieResults = restTemplate.getForObject(searchMovieUrl, MovieResults.class);
                // An assertion to make sure the results are non-null to avoid errors
                assert movieResults != null;
                mv.addObject("movies", movieResults.getResults());

                model.addAttribute("keyword", "Resultados de busqueda para: " + keyword);
                model.addAttribute("titulo de pagina", "Resultados de busqueda para: " + keyword);
                model.addAttribute("Movies", "Peliculas");
                model.addAttribute("Shows", "Series");
                // Finally, we return a ModelAndView object with our list of movies and list of shows matching the keyword
                return mv;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }
    }

    // Checks if the query is valid
    public boolean isSearchValid(String string){
        if (string.startsWith(" ")) {return false;}
        else return !string.isEmpty();
    }

}

