package com.qaproject.qa2022buscadordecontenido.repository;

import com.qaproject.qa2022buscadordecontenido.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Role repository
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
    /**
     * Find role by name
     * @param name
     * @return Role object or null
     */
    Role findByName(String name);
}
