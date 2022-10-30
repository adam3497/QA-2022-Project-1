package com.qaproject.qa2022buscadordecontenido.repository;

import com.qaproject.qa2022buscadordecontenido.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
