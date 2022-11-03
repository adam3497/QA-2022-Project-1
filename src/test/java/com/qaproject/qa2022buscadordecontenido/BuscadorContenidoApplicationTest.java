package com.qaproject.qa2022buscadordecontenido;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.web.client.RestTemplateBuilder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Epic("Apllication")
@Feature("Apllication Features")
@ExtendWith(MockitoExtension.class)
class BuscadorContenidoApplicationTest {

    @InjectMocks
    private BuscadorContenidoApplication underTest;

    @Test
    void main() {


    }

    @Story("Start application")
    @Description("Start application rest template builder.")
    @Test
    void restTemplate() {
        //given
        RestTemplateBuilder builder = mock(RestTemplateBuilder.class);
        //when
        underTest.restTemplate(builder);
        //then
        verify(builder).build();

    }

    @Nested
    class WhenMaining {
        @Mock
        private String[] args;

        @BeforeEach
        void setup() {
        }
    }

    @Nested
    class WhenRestingTemplate {
        @Mock
        private RestTemplateBuilder builder;

        @BeforeEach
        void setup() {
        }
    }
}