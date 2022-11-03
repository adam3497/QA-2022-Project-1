package com.qaproject.qa2022buscadordecontenido.controller;

import com.qaproject.qa2022buscadordecontenido.models.MovieModel;
import com.qaproject.qa2022buscadordecontenido.models.TvShowModel;
import io.qameta.allure.*;
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

@Epic("IndexController Tests")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IndexControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    IndexController indexController;

    @Story("User types http://localhost:8080/home in the search bar on the browser and gets the home page of the application")
    @Description("This method tests the functionality of the app to access the home page and get a OK status code")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void indexStatusCode() throws Exception {
        ResponseEntity<String> response = testRestTemplate.getForEntity(new URL("http://localhost:" + port + "/home").toString(), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Story("The application should be able to connect to an external API and get responses according to the requests")
    @Description("This method tests the status of the TMDB API according to the trending tv shows request")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void apiTrendingShowResponseStatus() throws Exception{
        ResponseEntity<String> response = testRestTemplate.getForEntity(new URL(TRENDING_TV_URL + TRENDING_DAY + API_KEY_URL).toString(), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Story("The application should be able to connect to an external API and get responses according to the requests")
    @Description("This method tests the status of the TMDB API according to the trending movies request")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void apiTrendingMovieResponseStatus() throws Exception{
        ResponseEntity<String> response = testRestTemplate.getForEntity(new URL(TRENDING_MOVIE_URL + TRENDING_DAY + API_KEY_URL).toString(), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Story("The application should be able to connect to an external API and get responses according to the requests")
    @Description("This method tests that the trending tv shows response from the TMDB API has an application/json type header")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void apiTrendingShowContentTypeVerification() throws Exception {
        ResponseEntity<String> response = testRestTemplate.getForEntity(new URL(TRENDING_TV_URL + TRENDING_DAY + API_KEY_URL).toString(), String.class);
        MediaType contentType = response.getHeaders().getContentType();
        assert contentType != null;
        assertEquals("application/json;charset=utf-8", contentType.toString());
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
    @Description("This method tests that the trending tv shows response has the right body content")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void apiTrendingShowBodyContent() throws Exception {
        ResponseEntity<String> response = testRestTemplate.getForEntity(new URL(TRENDING_TV_URL + TRENDING_DAY + API_KEY_URL).toString(), String.class);
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
                () -> assertTrue(bodyContent.contains("name")),
                () -> assertTrue(bodyContent.contains("original_name")),
                () -> assertTrue(bodyContent.contains("first_air_date")));
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
    @Description("This method tests that the result provided by the index method from the indexController is a ModelAndView object" +
            " and has the right content in it")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void indexMethodModelAndViewResultVerification() {
        assertAll("Index results",
                () -> assertEquals(ModelAndView.class, indexController.index(testRestTemplate.getRestTemplate()).getClass()),
                () -> assertEquals(2, indexController.index(testRestTemplate.getRestTemplate()).getModel().size()),
                () -> assertTrue(indexController.index(testRestTemplate.getRestTemplate()).getModel().containsKey("movies")),
                () -> assertTrue(indexController.index(testRestTemplate.getRestTemplate()).getModel().containsKey("shows")),
                () -> assertEquals(ArrayList.class, indexController.index(testRestTemplate.getRestTemplate()).getModel().get("movies").getClass()),
                () -> assertEquals(ArrayList.class, indexController.index(testRestTemplate.getRestTemplate()).getModel().get("shows").getClass()),
                () -> assertTrue(((ArrayList<MovieModel>)
                        indexController.index(testRestTemplate.getRestTemplate()).getModel().get("movies")).size() > 1),
                () -> assertTrue(((ArrayList<TvShowModel>)
                        indexController.index(testRestTemplate.getRestTemplate()).getModel().get("shows")).size() > 1));
    }

    @Story("The application should be able to handle the responses and pass them to the HTML")
    @Description("This method tests that the movie array that has to be in the ModelAndView object returned by the index() method " +
            "should has some data")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void checkIfMovieResultsObjectsHasNonNullNorEmptyEntries() {
        assertAll("MovieModel array from ModelAndView index()",
                () -> assertFalse(((ArrayList<MovieModel>)
                        indexController.index(testRestTemplate.getRestTemplate()).getModel().get("movies")).get(0).getTitle().isEmpty()),
                () -> assertFalse(((ArrayList<MovieModel>)
                        indexController.index(testRestTemplate.getRestTemplate()).getModel().get("movies")).get(0).getBackdrop_path().isEmpty()),
                () -> assertFalse(((ArrayList<MovieModel>)
                        indexController.index(testRestTemplate.getRestTemplate()).getModel().get("movies")).get(0).getMedia_type().isEmpty()),
                () -> assertTrue(((ArrayList<MovieModel>)
                        indexController.index(testRestTemplate.getRestTemplate()).getModel().get("movies")).get(0).getId() != 0),
                () -> assertFalse(((ArrayList<MovieModel>)
                        indexController.index(testRestTemplate.getRestTemplate()).getModel().get("movies")).get(0).getOverview().isEmpty()),
                () -> assertTrue(((ArrayList<MovieModel>)
                        indexController.index(testRestTemplate.getRestTemplate()).getModel().get("movies")).get(0).getVote_average() != 0.0f),
                () -> assertFalse(((ArrayList<MovieModel>)
                        indexController.index(testRestTemplate.getRestTemplate()).getModel().get("movies")).get(0).getRelease_date().isEmpty()));
    }

    @Story("The application should be able to handle the responses and pass them to the HTML")
    @Description("This method tests that the tv show array that has to be in the ModelAndView object returned by the index() method " +
            "should has some data")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void checkIfShowResultsObjectsHasNonNullNorEmptyEntries() {
            assertAll("TvShowModel array from ModelAndView index()",
                () -> assertFalse(((ArrayList<TvShowModel>)
                        indexController.index(testRestTemplate.getRestTemplate()).getModel().get("shows")).get(0).getName().isEmpty()),
                () -> assertFalse(((ArrayList<TvShowModel>)
                        indexController.index(testRestTemplate.getRestTemplate()).getModel().get("shows")).get(0).getBackdrop_path().isEmpty()),
                () -> assertFalse(((ArrayList<TvShowModel>)
                        indexController.index(testRestTemplate.getRestTemplate()).getModel().get("shows")).get(0).getMedia_type().isEmpty()),
                () -> assertTrue(((ArrayList<TvShowModel>)
                        indexController.index(testRestTemplate.getRestTemplate()).getModel().get("shows")).get(0).getId() != 0),
                () -> assertFalse(((ArrayList<TvShowModel>)
                        indexController.index(testRestTemplate.getRestTemplate()).getModel().get("shows")).get(0).getOverview().isEmpty()),
                () -> assertTrue(((ArrayList<TvShowModel>)
                        indexController.index(testRestTemplate.getRestTemplate()).getModel().get("shows")).get(0).getVote_average() != 0.0f),
                () -> assertFalse(((ArrayList<TvShowModel>)
                        indexController.index(testRestTemplate.getRestTemplate()).getModel().get("shows")).get(0).getFirst_air_date().isEmpty()));
    }
}