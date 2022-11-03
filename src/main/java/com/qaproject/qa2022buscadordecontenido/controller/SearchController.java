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

@RestController
public class SearchController {
    private static final Logger log = LoggerFactory.getLogger(SearchController.class);

    @GetMapping("/search")
    public ModelAndView mediaSearch(@Param("Search") String keyword, Model model, RestTemplate restTemplate) {
        ModelAndView mv = new ModelAndView();

        String uriEncodedKeyword = URLEncoder.encode(keyword, StandardCharsets.UTF_8);
        uriEncodedKeyword = uriEncodedKeyword.replace("+", "&");

        String searchTvUrl = SEARCH_TV_URL + API_KEY_URL + QUERY + uriEncodedKeyword;
        String searchMovieUrl = SEARCH_MOVIES_URL + API_KEY_URL + QUERY + uriEncodedKeyword;

        if (!isSearchValid(keyword)) {
            model.addAttribute("keyword", "Busqueda invalida");
            model.addAttribute("titulo de pagina", "Busqueda invalida");
            return mv;

        } else {

            try {
                log.info(searchTvUrl);
                TvShowResults tvShowResults = restTemplate.getForObject(searchTvUrl, TvShowResults.class);
                assert tvShowResults != null;
                mv.addObject("shows", tvShowResults.getResults());

                log.info(searchMovieUrl);
                MovieResults movieResults = restTemplate.getForObject(searchMovieUrl, MovieResults.class);
                assert movieResults != null;
                mv.addObject("movies", movieResults.getResults());

                model.addAttribute("keyword", "Resultados de busqueda para: " + keyword);
                model.addAttribute("titulo de pagina", "Resultados de busqueda para: " + keyword);
                model.addAttribute("Movies", "Peliculas");
                model.addAttribute("Shows", "Series");
                return mv;

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }

        }
    }

    public boolean isSearchValid(String string){
        if (string.startsWith(" ")) {return false;}
        else return !string.isEmpty();
    }

}

