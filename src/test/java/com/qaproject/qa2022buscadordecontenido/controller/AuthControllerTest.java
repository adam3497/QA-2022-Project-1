package com.qaproject.qa2022buscadordecontenido.controller;

import com.qaproject.qa2022buscadordecontenido.dto.UserDto;
import com.qaproject.qa2022buscadordecontenido.service.UserService;
import jakarta.validation.Valid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.net.MalformedURLException;
import java.net.URL;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class AuthControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    @Mock
    private UserService userService;
    @InjectMocks
    private AuthController underTest;

    @Test
    public void home() throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/").toString(), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void loginForm() throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/login").toString(), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void showRegistrationForm() throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/register").toString(), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void registration() throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/register").toString(), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    void listRegisteredUsers() throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/users").toString(), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Nested
    class WhenHoming {
        @BeforeEach
        void setup() {
        }
    }

    @Nested
    class WhenLoginingForm {
        @BeforeEach
        void setup() {
        }
    }

    @Nested
    class WhenShowingRegistrationForm {
        @Mock
        private Model model;

        @BeforeEach
        void setup() {
        }
    }

    @Nested
    class WhenRegistrationing {
        @Mock
        private @Valid UserDto user;
        @Mock
        private BindingResult result;
        @Mock
        private Model model;

        @BeforeEach
        void setup() {
        }
    }

    @Nested
    class WhenListingRegisteredUsers {
        @Mock
        private Model model;

        @BeforeEach
        void setup() {
        }
    }
}