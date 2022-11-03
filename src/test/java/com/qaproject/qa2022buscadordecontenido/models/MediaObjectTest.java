package com.qaproject.qa2022buscadordecontenido.models;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static com.qaproject.qa2022buscadordecontenido.utils.Constants.BASE_IMG_URL;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

@Epic("Media JSON object from TMDB API")
@ExtendWith(MockitoExtension.class)
class MediaObjectTest {

    @InjectMocks
    private MediaObject mediaObjectTest;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Story("The application has to handle the JSON response, create internal objects and return its corresponding values")
    @Description("This method test the right functionality of isAdult() method")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void isAdult() {
        //given
        mediaObjectTest.setAdult(true);
        //when
        boolean result = mediaObjectTest.isAdult();
        //then
        assertThat(result).isEqualTo(true);
    }

    @Story("The application has to handle the JSON response, create internal objects and return its corresponding values")
    @Description("This method test the right functionality of getBackdrop_path() method")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void getBackdrop_path() {
        //given
        mediaObjectTest.setBackdrop_path("somerandompngpath.png");
        //when
        String result = mediaObjectTest.getBackdrop_path();
        //then
        assertThat(result).isEqualTo(BASE_IMG_URL + "somerandompngpath.png");
    }

    @Story("The application has to handle the JSON response, create internal objects and return its corresponding values")
    @Description("This method test the right functionality of getId() method")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    void getId() {
        //given
        mediaObjectTest.setId(123);
        //when
        int result = mediaObjectTest.getId();
        //then
        assertThat(result).isEqualTo(123);
    }

    @Story("The application has to handle the JSON response, create internal objects and return its corresponding values")
    @Description("This method test the right functionality of getOriginal_language() method")
    @Severity(SeverityLevel.MINOR)
    @Test
    void getOriginal_language() {
        //given
        mediaObjectTest.setOriginal_language("EN-US");
        //when
        String result = mediaObjectTest.getOriginal_language();
        //then
        assertThat(result).isEqualTo("EN-US");
    }

    @Story("The application has to handle the JSON response, create internal objects and return its corresponding values")
    @Description("This method test the right functionality of getOverview() method")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void getOverview() {
        //given
        mediaObjectTest.setOverview("some overview");
        //when
        String result = mediaObjectTest.getOverview();
        //then
        assertThat(result).isEqualTo("some overview");
    }

    @Story("The application has to handle the JSON response, create internal objects and return its corresponding values")
    @Description("This method test the right functionality of getPoster_path() method")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void getPoster_path() {
        //given
        mediaObjectTest.setPoster_path("posterpath.png");
        //when
        String result = mediaObjectTest.getPoster_path();
        //then
        assertThat(result).isEqualTo(BASE_IMG_URL + "posterpath.png");
    }

    @Story("The application has to handle the JSON response, create internal objects and return its corresponding values")
    @Description("This method test the right functionality of getMedia_type() method")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void getMedia_type() {
        //given
        mediaObjectTest.setMedia_type("movie");
        //when
        String result = mediaObjectTest.getMedia_type();
        //then
        assertThat(result).isEqualTo("movie");
    }

    @Story("The application has to handle the JSON response, create internal objects and return its corresponding values")
    @Description("This method test the right functionality of getGenre_ids() method")
    @Severity(SeverityLevel.MINOR)
    @Test
    void getGenre_ids() {
        //given
        ArrayList<Integer> genreIds = new ArrayList<>();
        genreIds.add(1);
        mediaObjectTest.setGenre_ids(genreIds);
        //when
        ArrayList<Integer> result = mediaObjectTest.getGenre_ids();
        //then
        assertThat(result).isEqualTo(genreIds);
    }

    @Story("The application has to handle the JSON response, create internal objects and return its corresponding values")
    @Description("This method test the right functionality of getPopularity() method")
    @Severity(SeverityLevel.MINOR)
    @Test
    void getPopularity() {
        //given
        mediaObjectTest.setPopularity(123);
        //when
        float result = mediaObjectTest.getPopularity();
        //then
        assertThat(result).isEqualTo(123f);
    }

    @Story("The application has to handle the JSON response, create internal objects and return its corresponding values")
    @Description("This method test the right functionality of getVote_average() method")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void getVote_average() {
        //given
        mediaObjectTest.setVote_average(123);
        //when
        float result = mediaObjectTest.getVote_average();
        //then
        assertThat(result).isEqualTo(123f);
    }

    @Story("The application has to handle the JSON response, create internal objects and return its corresponding values")
    @Description("This method test the right functionality of getVote_count() method")
    @Severity(SeverityLevel.MINOR)
    @Test
    void getVote_count() {
        //given
        mediaObjectTest.setVote_count(123);
        //when
        int result = mediaObjectTest.getVote_count();
        //then
        assertThat(result).isEqualTo(123);
    }

    @Description("This method test the override toString() method within the model")
    @Severity(SeverityLevel.TRIVIAL)
    @Test
    void toStringTest() {
        assertAll("toString() method tests",
                () -> assertEquals(String.class, mediaObjectTest.toString().getClass()),
                () -> assertFalse(mediaObjectTest.toString().isEmpty()),
                () -> assertTrue(mediaObjectTest.toString().contains("MediaObject{")),
                () -> assertTrue(mediaObjectTest.toString().contains("}")));
    }
}