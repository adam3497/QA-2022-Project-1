package com.qaproject.qa2022buscadordecontenido.controller;

import com.qaproject.qa2022buscadordecontenido.models.MovieModel;
import com.qaproject.qa2022buscadordecontenido.models.TvShowModel;
import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.ModelAndView;

import java.net.URL;
import java.util.ArrayList;

import static com.qaproject.qa2022buscadordecontenido.utils.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

@Epic("MovieController Tests")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MoviesControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    MoviesController moviesControllerTest;

    @Story("User types http://localhost:8080/movies in the search bar on the browser and gets the movies page of the application")
    @Description("This method tests the functionality of the app to access the movies page and get an OK status code")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void moviesStatusCode() throws Exception {
        ResponseEntity<String> response = testRestTemplate.getForEntity(new URL("http://localhost:" + port + "/movies").toString(), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Story("The application should be able to connect to an external API and get responses according to the requests")
    @Description("This method tests the status of the TMDB API according to the trending movies request")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void apiTrendingMoviesResponseStatus() throws Exception {
        ResponseEntity<String> response = testRestTemplate.getForEntity(new URL(TRENDING_MOVIE_URL + TRENDING_DAY + API_KEY_URL).toString(), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Story("The application should be able to connect to an external API and get responses according to the requests")
    @Description("This method tests that the trending movies response from the TMDB API has an application/json type header")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void apiTrendingMovieContentTypeVerification() throws Exception {
        ResponseEntity<String> response = testRestTemplate.getForEntity(new URL(TRENDING_MOVIE_URL + TRENDING_DAY + API_KEY_URL).toString(), String.class);
        MediaType contentType = response.getHeaders().getContentType();
        assert contentType != null;
        assertEquals("application/json;charset=utf-8", contentType.toString());
    }

    @Story("The application should be able to connect to an external API and get responses according to the requests")
    @Description("This method tests that the trending movies response has the right body content")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void apiTrendingMovieBodyContent() throws Exception {
        ResponseEntity<String> response = testRestTemplate.getForEntity(new URL(TRENDING_MOVIE_URL + TRENDING_DAY + API_KEY_URL).toString(), String.class);
        String bodyContent = response.getBody();
        assert bodyContent != null;
        assertAll("Json body response",
                () -> assertTrue(bodyContent.contains("adult")),
                () -> assertTrue(bodyContent.contains("backdrop_path")),
                () -> assertTrue(bodyContent.contains("id")),
                () -> assertTrue(bodyContent.contains("original_language")),
                () -> assertTrue(bodyContent.contains("overview")),
                () -> assertTrue(bodyContent.contains("poster_path")),
                () -> assertTrue(bodyContent.contains("media_type")),
                () -> assertTrue(bodyContent.contains("genre_ids")),
                () -> assertTrue(bodyContent.contains("popularity")),
                () -> assertTrue(bodyContent.contains("vote_average")),
                () -> assertTrue(bodyContent.contains("vote_count")),
                () -> assertTrue(bodyContent.contains("title")),
                () -> assertTrue(bodyContent.contains("original_title")),
                () -> assertTrue(bodyContent.contains("release_date")),
                () -> assertTrue(bodyContent.contains("video")));
    }

    @Story("The application should be able to handle the responses and pass them to the HTML")
    @Description("This method tests that the result provided by the movies() method from the MovieController is a ModelAndView object" +
            " and has the right content in it")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void moviesMethodModelAndViewResultVerification() throws Exception {
        assertAll("ModelAndView object verifications",
                () -> assertEquals(ModelAndView.class, moviesControllerTest.movies(testRestTemplate.getRestTemplate()).getClass()),
                () -> assertEquals(1, moviesControllerTest.movies(testRestTemplate.getRestTemplate()).getModel().size()),
                () -> assertTrue(moviesControllerTest.movies(testRestTemplate.getRestTemplate()).getModel().containsKey("trendingMovies")),
                () -> assertEquals(ArrayList.class, moviesControllerTest.movies(testRestTemplate.getRestTemplate()).getModel().get("trendingMovies").getClass()),
                () -> assertEquals(ModelAndView.class, moviesControllerTest.movies(testRestTemplate.getRestTemplate()).getClass()),
                () -> assertTrue( ( (ArrayList<MovieModel>) moviesControllerTest.movies(testRestTemplate.getRestTemplate()).getModel().get("trendingMovies")).size() > 1 ) );
    }

    @Story("The application should be able to handle the responses and pass them to the HTML")
    @Description("This method tests that the movie array that has to be in the ModelAndView object returned by the movies() method " +
            "should has some data")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void checkIfMovieResultsObjectsHasNonNullNorEmptyEntries() {
        assertAll("MovieModel array from ModelAndView movies()",
                () -> assertFalse(((ArrayList<MovieModel>)
                        moviesControllerTest.movies(testRestTemplate.getRestTemplate()).getModel().get("trendingMovies")).get(0).getTitle().isEmpty()),
                () -> assertFalse(((ArrayList<MovieModel>)
                        moviesControllerTest.movies(testRestTemplate.getRestTemplate()).getModel().get("trendingMovies")).get(0).getBackdrop_path().isEmpty()),
                () -> assertFalse(((ArrayList<MovieModel>)
                        moviesControllerTest.movies(testRestTemplate.getRestTemplate()).getModel().get("trendingMovies")).get(0).getMedia_type().isEmpty()),
                () -> assertTrue(((ArrayList<MovieModel>)
                        moviesControllerTest.movies(testRestTemplate.getRestTemplate()).getModel().get("trendingMovies")).get(0).getId() != 0),
                () -> assertFalse(((ArrayList<MovieModel>)
                        moviesControllerTest.movies(testRestTemplate.getRestTemplate()).getModel().get("trendingMovies")).get(0).getOverview().isEmpty()),
                () -> assertTrue(((ArrayList<MovieModel>)
                        moviesControllerTest.movies(testRestTemplate.getRestTemplate()).getModel().get("trendingMovies")).get(0).getVote_average() != 0.0f),
                () -> assertFalse(((ArrayList<MovieModel>)
                        moviesControllerTest.movies(testRestTemplate.getRestTemplate()).getModel().get("trendingMovies")).get(0).getRelease_date().isEmpty()));
    }
}