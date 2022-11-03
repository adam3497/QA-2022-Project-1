package com.qaproject.qa2022buscadordecontenido.models;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@Epic("MovieResults object to handle the TMDB JSON response")
@ExtendWith(MockitoExtension.class)
class MovieResultsTest {

    @InjectMocks
    private MovieResults movieResultsTest;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Story("The application has to handle the JSON response, create internal objects and return its corresponding values")
    @Description("This method test the right functionality of getResults() method")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void getResults() {
        //given
        ArrayList<MovieModel> movieResults = new ArrayList<>();
        MovieModel movieModel = new MovieModel();
        movieResults.add(movieModel);
        movieResultsTest.setResults(movieResults);
        //when
        ArrayList<MovieModel> result = movieResultsTest.getResults();
        //then
        assertThat(result).isEqualTo(movieResults);
    }

    @Story("The application has to handle the JSON response, create internal objects and return its corresponding values")
    @Description("This method test the right functionality of getResults(int index) method")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void testGetResults() {
        //given
        ArrayList<MovieModel> movieResults = new ArrayList<>();
        MovieModel movieModel1 = new MovieModel();
        MovieModel movieModel2 = new MovieModel();
        movieResults.add(movieModel1);
        movieResults.add(movieModel2);
        movieResultsTest.setResults(movieResults);
        //when
        ArrayList<MovieModel> result = movieResultsTest.getResults(2);
        //then
        assertThat(result).isEqualTo(movieResults);
    }

    @Description("This method test the right functionality of the override toString() method within the model")
    @Severity(SeverityLevel.TRIVIAL)
    @Test
    void testToString() {
        ArrayList<MovieModel> movieResults = new ArrayList<>();
        MovieModel movieModel1 = new MovieModel();
        movieResultsTest.setResults(movieResults);
        assertAll("toString() method tests",
                () -> assertEquals(String.class, movieResultsTest.toString().getClass()),
                () -> assertFalse(movieResultsTest.toString().isEmpty()),
                () -> assertTrue(movieResultsTest.toString().contains(", results=")),
                () -> assertTrue(movieResultsTest.toString().contains("}")));
    }
}