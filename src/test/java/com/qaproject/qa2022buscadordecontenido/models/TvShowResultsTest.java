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

@Epic("TvShowResults object to handle the TMDB JSON response")
@ExtendWith(MockitoExtension.class)
class TvShowResultsTest {

    @InjectMocks
    private TvShowResults tvShowResultsTest;

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
        ArrayList<TvShowModel> tvShowResults = new ArrayList<>();
        TvShowModel showModel = new TvShowModel();
        tvShowResults.add(showModel);
        tvShowResultsTest.setResults(tvShowResults);
        //when
        ArrayList<TvShowModel> result = tvShowResultsTest.getResults();
        //then
        assertThat(result).isEqualTo(tvShowResults);
    }

    @Description("This method test the right functionality of the override toString() method within the model")
    @Severity(SeverityLevel.TRIVIAL)
    @Test
    void testToString() {
        ArrayList<TvShowModel> tvShowResults = new ArrayList<>();
        TvShowModel showModel = new TvShowModel();
        tvShowResults.add(showModel);
        tvShowResultsTest.setResults(tvShowResults);
        assertAll("toString() method tests",
                () -> assertEquals(String.class, tvShowResultsTest.toString().getClass()),
                () -> assertFalse(tvShowResultsTest.toString().isEmpty()),
                () -> assertTrue(tvShowResultsTest.toString().contains(", results=")),
                () -> assertTrue(tvShowResultsTest.toString().contains("}")));
    }
}