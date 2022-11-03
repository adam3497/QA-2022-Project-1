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

@Epic("TvShowModel object to handle the TMDB JSON response")
@ExtendWith(MockitoExtension.class)
class TvShowModelTest {

    @InjectMocks
    private TvShowModel tvShowModelTest;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Story("The application has to handle the JSON response, create internal objects and return its corresponding values")
    @Description("This method test the right functionality of getName() method")
    @Severity(SeverityLevel.NORMAL)
    @Test
    void getName() {
        //given
        tvShowModelTest.setName("name");
        //when
        String result = tvShowModelTest.getName();
        //then
        assertThat(result).isEqualTo("name");
    }

    @Story("The application has to handle the JSON response, create internal objects and return its corresponding values")
    @Description("This method test the right functionality of getOriginal_name() method")
    @Severity(SeverityLevel.MINOR)
    @Test
    void getOriginal_name() {
        //given
        tvShowModelTest.setOriginal_name("original name");
        //when
        String result = tvShowModelTest.getOriginal_name();
        //then
        assertThat(result).isEqualTo("original name");
    }

    @Story("The application has to handle the JSON response, create internal objects and return its corresponding values")
    @Description("This method test the right functionality of getFirst_air_date() method")
    @Severity(SeverityLevel.MINOR)
    @Test
    void getFirst_air_date() {
        //given
        tvShowModelTest.setFirst_air_date("00/00/0000");
        //when
        String result = tvShowModelTest.getFirst_air_date();
        //then
        assertThat(result).isEqualTo("00/00/0000");
    }

    @Description("This method test the right functionality of the override toString() method within the model")
    @Severity(SeverityLevel.TRIVIAL)
    @Test
    void testToString() {
        assertAll("toString() method tests",
                () -> assertEquals(String.class, tvShowModelTest.toString().getClass()),
                () -> assertFalse(tvShowModelTest.toString().isEmpty()),
                () -> assertTrue(tvShowModelTest.toString().contains(", name=")),
                () -> assertTrue(tvShowModelTest.toString().contains("}")));
    }
}