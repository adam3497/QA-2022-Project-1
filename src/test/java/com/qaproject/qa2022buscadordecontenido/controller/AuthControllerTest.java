package com.qaproject.qa2022buscadordecontenido.controller;



import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
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

@Epic("User Controller")
@Feature("Login Features")
@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class AuthControllerTest {
    /**
     * The User service Test
     */

    @LocalServerPort
    private int port;


    @Autowired
    private TestRestTemplate restTemplate;
    @Mock
    private UserService userService;
    @InjectMocks
    private AuthController underTest;

    @Test
    @Story("User tries to access login page")
    @Description("User click on homepage.")
    public void home() throws Exception {
        /**
         * Home page
         * @return
         */
        ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/").toString(), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @Story("User tries to access login form")
    @Description("User click on login.")
    void loginForm() throws Exception {
        /**
         * Login form
         * @return
         */
        ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/login").toString(), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @Story("User tries to register")
    @Description("User click on register.")
    void showRegistrationForm() throws Exception {
        /**
         * Register form
         * @param model
         * @return
         */
        ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/register").toString(), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    @Story("User register")
    @Description("User click register on register form.")
    void registration() throws Exception {
        /**
         * Register
         * @param user
         * @param bindingResult
         * @param model
         * @return
         */
        ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/register").toString(), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

    @Test
    @Story("User list of users")
    @Description("admin user click on list of users.")
    void listRegisteredUsers() throws Exception {
        /**
         * List of users
         * @param model
         * @return
         */
        ResponseEntity<String> response = restTemplate.getForEntity(new URL("http://localhost:" + port + "/users").toString(), String.class);

    }

    /**
     * The User service Test Setup and Tear Down
     */

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