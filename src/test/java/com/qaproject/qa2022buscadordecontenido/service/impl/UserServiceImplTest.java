package com.qaproject.qa2022buscadordecontenido.service.impl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
class UserServiceImplTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void saveUser() {

    }

    @Test
    void findByEmail() {

    }

    @Test
    void findAllUsers() {

    }
}