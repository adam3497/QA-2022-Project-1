package com.qaproject.qa2022buscadordecontenido.controller;

import com.qaproject.qa2022buscadordecontenido.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

import java.net.MalformedURLException;
import java.net.URL;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class AuthControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

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

    }

    @Test
    void listRegisteredUsers() throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/users").toString(), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}