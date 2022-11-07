package com.qaproject.qa2022buscadordecontenido.repository;

import com.qaproject.qa2022buscadordecontenido.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User repository
 */
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Find user by email
     * @param email
     * @return User object or null
     */
    User findByEmail(String email);
}
