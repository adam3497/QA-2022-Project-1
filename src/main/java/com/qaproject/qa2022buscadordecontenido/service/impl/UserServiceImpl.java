package com.qaproject.qa2022buscadordecontenido.service.impl;

import com.qaproject.qa2022buscadordecontenido.dto.UserDto;
import com.qaproject.qa2022buscadordecontenido.entity.Role;
import com.qaproject.qa2022buscadordecontenido.entity.User;
import com.qaproject.qa2022buscadordecontenido.repository.RoleRepository;
import com.qaproject.qa2022buscadordecontenido.repository.UserRepository;
import com.qaproject.qa2022buscadordecontenido.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User service implementation
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * User repository
     */

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        /**
         * Constructor
         */
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto userDto) {
        /**
         * Save user
         * @param userDto
         */
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());

        //encrypt the password once we integrate spring security
        //user.setPassword(userDto.getPassword());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        Role role = roleRepository.findByName("ROLE_ADMIN");
        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        /**
         * Find user by email
         * @param email
         * @return User object or null
         */
        return userRepository.findByEmail(email);
    }

    @Override
    public List<UserDto> findAllUsers() {
        /**
         * Find all users
         * @return List of UserDto objects
         */
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> convertEntityToDto(user))
                .collect(Collectors.toList());
    }

    private UserDto convertEntityToDto(User user){
        /**
         * Convert entity to dto
         */
        UserDto userDto = new UserDto();
        String[] name = user.getName().split(" ");
        userDto.setFirstName(name[0]);
        userDto.setLastName(name[1]);
        userDto.setEmail(user.getEmail());
        return userDto;
    }

    private Role checkRoleExist() {
        /**
         * Check if role exists
         */
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
