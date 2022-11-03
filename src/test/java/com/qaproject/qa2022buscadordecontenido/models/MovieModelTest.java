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

@Epic("MovieModel objecto to handle the TMDB JSON response")
@ExtendWith(MockitoExtension.class)
class MovieModelTest {

    @InjectMocks
    private MovieModel movieModelTest;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Story("The application has to handle the JSON response, create internal objects and return its corresponding values")
    @Description("This method test the right functionality of getTitle() method")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void getTitle() {
        //given
        movieModelTest.setTitle("some title");
        //when
        String result = movieModelTest.getTitle();
        //then
        assertThat(result).isEqualTo("some title");
    }

    @Story("The application has to handle the JSON response, create internal objects and return its corresponding values")
    @Description("This method test the right functionality of getOriginal_title() method")
    @Severity(SeverityLevel.MINOR)
    @Test
    void getOriginal_title() {
        //given
        movieModelTest.setOriginal_title("original title");
        //when
        String result = movieModelTest.getOriginal_title();
        //then
        assertThat(result).isEqualTo("original title");
    }

    @Story("The application has to handle the JSON response, create internal objects and return its corresponding values")
    @Description("This method test the right functionality of getRelease_date() method")
    @Severity(SeverityLevel.MINOR)
    @Test
    void getRelease_date() {
        //given
        movieModelTest.setRelease_date("00/00/0000");
        //when
        String result = movieModelTest.getRelease_date();
        //then
        assertThat(result).isEqualTo("00/00/0000");
    }

    @Story("The application has to handle the JSON response, create internal objects and return its corresponding values")
    @Description("This method test the right functionality of isVideo() method")
    @Severity(SeverityLevel.MINOR)
    @Test
    void isVideo() {
        //given
        movieModelTest.setVideo(true);
        //when
        boolean result = movieModelTest.isVideo();
        //then
        assertThat(result).isEqualTo(true);
    }

    @Description("This method test the right functionality of the override toString() method within the model")
    @Severity(SeverityLevel.TRIVIAL)
    @Test
    void testToString() {
        assertAll("toString() method tests",
                () -> assertEquals(String.class, movieModelTest.toString().getClass()),
                () -> assertFalse(movieModelTest.toString().isEmpty()),
                () -> assertTrue(movieModelTest.toString().contains(", title=")),
                () -> assertTrue(movieModelTest.toString().contains("}")));
    }
}