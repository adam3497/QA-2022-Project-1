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
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import static com.qaproject.qa2022buscadordecontenido.utils.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SearchControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate testRestTemplate;

    @Autowired
    SearchController searchController;


    @Test
    void apiSearchShowResponseStatus() throws Exception{
        ResponseEntity<String> response = testRestTemplate.getForEntity(new URL(SEARCH_TV_URL + API_KEY_URL + QUERY + URLEncoder.encode("The big bang theory", StandardCharsets.UTF_8)).toString(), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void apiSearchMovieResponseStatus() throws Exception{
        ResponseEntity<String> response = testRestTemplate.getForEntity(new URL(SEARCH_MOVIES_URL + API_KEY_URL + QUERY + URLEncoder.encode("Avatar", StandardCharsets.UTF_8)).toString(), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void apiSearchShowContentTypeVerification() throws Exception {
        ResponseEntity<String> response = testRestTemplate.getForEntity(new URL(SEARCH_TV_URL + API_KEY_URL + QUERY + URLEncoder.encode("The big bang theory", StandardCharsets.UTF_8)).toString(), String.class);
        MediaType contentType = response.getHeaders().getContentType();
        assert contentType != null;
        assertEquals("application/json;charset=utf-8", contentType.toString());
    }

    @Test
    void apiSearchMovieContentTypeVerification() throws Exception {
        ResponseEntity<String> response = testRestTemplate.getForEntity(new URL(SEARCH_MOVIES_URL + API_KEY_URL + QUERY + URLEncoder.encode("Avatar", StandardCharsets.UTF_8)).toString(), String.class);
        MediaType contentType = response.getHeaders().getContentType();
        assert contentType != null;
        assertEquals("application/json;charset=utf-8", contentType.toString());
    }

    @Test
    void invalidEmptyQuery() {
        assertEquals(searchController.isSearchValid(""),false);
    }

    @Test
    void invalidSpaceStartQuery() {
        assertEquals(searchController.isSearchValid(" "),false);
    }

    @Test
    void invalidSpaceStartWithTextQuery() {
        assertEquals(searchController.isSearchValid(" abc"),false);
    }

    @Test
    void validQuery() {
        assertEquals(searchController.isSearchValid("abc"),true);
    }
    @Test
    void validWithSpacesQuery() {
        assertEquals(searchController.isSearchValid("abc   def"),true);
    }
    @Test
    void validWithNumbersQuery() {
        assertEquals(searchController.isSearchValid("abc123123def"),true);
    }

    @Test
    void validWithSymbolsQuery() {
        assertEquals(searchController.isSearchValid("abc12}{:}:}{}:?:><<3123def"),true);
    }
}