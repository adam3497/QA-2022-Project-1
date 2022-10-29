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
        String trendingURL = TRENDING_TV_URL + TRENDING_DAY + API_KEY_URL;
        log.info(trendingURL);
        try {
            TvShowResults results = restTemplate.getForObject(trendingURL, TvShowResults.class);
            ModelAndView mv = new ModelAndView();
            assert results != null;
            mv.addObject("shows", results.getResults());
            return mv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
