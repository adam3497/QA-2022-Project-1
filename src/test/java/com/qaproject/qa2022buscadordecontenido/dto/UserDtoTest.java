package com.qaproject.qa2022buscadordecontenido.dto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserDtoTest {

    private static final String FIRST_NAME = "FIRST_NAME";
    private static final String LAST_NAME = "LAST_NAME";
    private static final String EMAIL = "EMAIL";
    private static final String PASSWORD = "PASSWORD";
    @InjectMocks
    private UserDto underTest;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getId() {
        //given
        underTest.setId(1L);
        //when
        Long result = underTest.getId();
        //then
        assertThat(result).isEqualTo(1L);
    }

    @Test
    void getFirstName() {
        //given
        underTest.setFirstName(FIRST_NAME);
        //when
        String result = underTest.getFirstName();
        //then
        assertThat(result).isEqualTo(FIRST_NAME);
    }

    @Test
    void getLastName() {
        //given
        underTest.setLastName(LAST_NAME);
        //when
        String result = underTest.getLastName();
        //then
        assertThat(result).isEqualTo(LAST_NAME);
    }

    @Test
    void getEmail() {
        //given
        underTest.setEmail(EMAIL);
        //when
        String result = underTest.getEmail();
        //then
        assertThat(result).isEqualTo(EMAIL);
    }

    @Test
    void getPassword() {
        //given
        underTest.setPassword(PASSWORD);
        //when
        String result = underTest.getPassword();
        //then
        assertThat(result).isEqualTo(PASSWORD);
    }

    @Test
    void setId() {
        //given
        underTest.setId(1L);
        //when
        Long result = underTest.getId();
        //then
        assertThat(result).isEqualTo(1L);
    }

    @Test
    void setFirstName() {
        //given
        underTest.setFirstName(FIRST_NAME);
        //when
        String result = underTest.getFirstName();
        //then
        assertThat(result).isEqualTo(FIRST_NAME);
    }

    @Test
    void setLastName() {
        //given
        underTest.setLastName(LAST_NAME);
        //when
        String result = underTest.getLastName();
        //then
        assertThat(result).isEqualTo(LAST_NAME);
    }

    @Test
    void setEmail() {
        //given
        underTest.setEmail(EMAIL);
        //when
        String result = underTest.getEmail();
        //then
        assertThat(result).isEqualTo(EMAIL);
    }

    @Test
    void setPassword() {
        //given
        underTest.setPassword(PASSWORD);
        //when
        String result = underTest.getPassword();
        //then
        assertThat(result).isEqualTo(PASSWORD);
    }
}