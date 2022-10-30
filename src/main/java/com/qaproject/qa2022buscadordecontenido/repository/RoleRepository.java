package com.qaproject.qa2022buscadordecontenido.repository;

import com.qaproject.qa2022buscadordecontenido.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
