package com.qaproject.qa2022buscadordecontenido.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static com.qaproject.qa2022buscadordecontenido.utils.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IndexControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void indexStatusCode() throws Exception {
        ResponseEntity<String> response = testRestTemplate.getForEntity(new URL("http://localhost:" + port + "/home").toString(), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void apiTrendingShowResponseStatus() throws Exception{
        ResponseEntity<String> response = testRestTemplate.getForEntity(new URL(TRENDING_TV_URL + TRENDING_DAY + API_KEY_URL).toString(), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void apiTrendingMovieResponseStatus() throws Exception{
        ResponseEntity<String> response = testRestTemplate.getForEntity(new URL(TRENDING_MOVIE_URL + TRENDING_DAY + API_KEY_URL).toString(), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void apiTrendingShowContentTypeVerification() throws Exception {
        ResponseEntity<String> response = testRestTemplate.getForEntity(new URL(TRENDING_TV_URL + TRENDING_DAY + API_KEY_URL).toString(), String.class);
        MediaType contentType = response.getHeaders().getContentType();
        assert contentType != null;
        assertEquals("application/json;charset=utf-8", contentType.toString());
    }

    @Test
    void apiTrendingMovieContentTypeVerification() throws Exception {
        ResponseEntity<String> response = testRestTemplate.getForEntity(new URL(TRENDING_MOVIE_URL + TRENDING_DAY + API_KEY_URL).toString(), String.class);
        MediaType contentType = response.getHeaders().getContentType();
        assert contentType != null;
        assertEquals("application/json;charset=utf-8", contentType.toString());
    }

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
}