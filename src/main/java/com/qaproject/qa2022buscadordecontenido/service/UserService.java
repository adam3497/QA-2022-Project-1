package com.qaproject.qa2022buscadordecontenido.service;

import com.qaproject.qa2022buscadordecontenido.dto.UserDto;
import com.qaproject.qa2022buscadordecontenido.entity.User;

import java.util.List;

/**
 * User service
 */
public interface UserService {
    /**
     * Save user
     * @param userDto
     */
    void saveUser(UserDto userDto);

    /**
     * Find user by email
     * @param email
     * @return User object or null
     */
    User findByEmail(String email);
    /**
     * Find all users
     * @return List of users
     */
    List<UserDto> findAllUsers();

}
