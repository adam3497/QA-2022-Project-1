package com.qaproject.qa2022buscadordecontenido.service.impl;

import com.qaproject.qa2022buscadordecontenido.dto.UserDto;
import com.qaproject.qa2022buscadordecontenido.entity.User;
import com.qaproject.qa2022buscadordecontenido.repository.RoleRepository;
import com.qaproject.qa2022buscadordecontenido.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private RoleRepository roleRepository;
    @Mock
    private PasswordEncoder passwordEncoder;
    @InjectMocks
    private UserServiceImpl underTest;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void saveUser() {

        //given
        UserDto userDto = new UserDto();
        userDto.setFirstName("firstName");
        userDto.setLastName("lastName");
        userDto.setEmail("email");
        userDto.setPassword("password");
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        //when
        underTest.saveUser(userDto);
        //then
        assertThat(user.getName()).isEqualTo(userDto.getFirstName() + " " + userDto.getLastName());
    }

    @Test
    void findByEmailNonExistingUser() {
        // given
        String username = "somenewuser";
        String password = "123queso";


        // when
        Optional<User> result = Optional.ofNullable(underTest.findByEmail(username));

        // then
        assertThat(result).isEmpty();
    }


    @Test
    void findAllUsers() {

        List<UserDto> result = underTest.findAllUsers();

        assertThat(result).isNotNull();

    }

    @Nested
    class WhenSavingUser {
        @Mock
        private UserDto userDto;
        @Mock
        private User user;
        @Mock
        private User savedUser;


        @BeforeEach
        void setup() {
            when(userDto.getFirstName()).thenReturn("firstName");
            when(userDto.getLastName()).thenReturn("lastName");
            when(userDto.getEmail()).thenReturn("email");
            when(userDto.getPassword()).thenReturn("password");
            when(userRepository.save(user)).thenReturn(savedUser);
        }
    }

    @Nested
    class WhenFindingByEmail {


        @BeforeEach
        void setup() {


        }
    }

    @Nested
    class WhenFindingAllUsers {
        @BeforeEach
        void setup() {
            Mockito.when(userRepository.findAll()).thenReturn(List.of());

        }
    }
}