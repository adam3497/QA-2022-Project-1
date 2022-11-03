package com.qaproject.qa2022buscadordecontenido.models;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Epic("ResultsModel parent class to handle the TMDB JSON response")
@ExtendWith(MockitoExtension.class)
class ResultsModelTest {

    @InjectMocks
    private ResultsModel resultsModelTest;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Story("The application has to handle the JSON response, create internal objects and return its corresponding values")
    @Description("This method test the right functionality of getPage() method")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void getPage() {
        //given
        resultsModelTest.setPage(1);
        //when
        int result = resultsModelTest.getPage();
        //then
        assertThat(result).isEqualTo(1);
    }

    @Story("The application has to handle the JSON response, create internal objects and return its corresponding values")
    @Description("This method test the right functionality of getTotal_pages() method")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void getTotal_pages() {
        //given
        resultsModelTest.setTotal_pages(123);
        //when
        int result = resultsModelTest.getTotal_pages();
        //then
        assertThat(result).isEqualTo(123);
    }

    @Story("The application has to handle the JSON response, create internal objects and return its corresponding values")
    @Description("This method test the right functionality of getTotal_results() method")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void getTotal_results() {
        //given
        resultsModelTest.setTotal_results(123);
        //when
        int result = resultsModelTest.getTotal_results();
        //then
        assertThat(result).isEqualTo(123);
    }

    @Description("This method test the right functionality of the override toString() method within the model")
    @Severity(SeverityLevel.TRIVIAL)
    @Test
    void testToString() {
        assertAll("toString() method tests",
                () -> assertEquals(String.class, resultsModelTest.toString().getClass()),
                () -> assertFalse(resultsModelTest.toString().isEmpty()),
                () -> assertTrue(resultsModelTest.toString().contains("ResultsModel{")),
                () -> assertTrue(resultsModelTest.toString().contains("}")));
    }
}