package com.qaproject.qa2022buscadordecontenido.security;

import com.qaproject.qa2022buscadordecontenido.entity.Role;
import com.qaproject.qa2022buscadordecontenido.entity.User;
import com.qaproject.qa2022buscadordecontenido.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Custom user details service
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {



    private UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        /**
         * Constructor
         * @param userRepository
         */
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        /**
         * Load user by email
         * @param email
         * @return UserDetails object
         * @throws UsernameNotFoundException
         */
        User user = userRepository.findByEmail(email);

        if (user != null) {
            return new org.springframework.security.core.userdetails.User(user.getEmail(),
                    user.getPassword(),
                    mapRolesToAuthorities(user.getRoles()));
        }else{
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }

    private Collection < ? extends GrantedAuthority> mapRolesToAuthorities(Collection <Role> roles) {
/**
         * Map roles to authorities
         * @param roles
         * @return Collection of authorities
         */
        Collection < ? extends GrantedAuthority> mapRoles = roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        return mapRoles;
    }
}
