package com.qaproject.qa2022buscadordecontenido.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


/**
 * Role entity
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="roles")
public class Role
{
    /**
     * Role id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Role name
     */
    @Column(nullable=false, unique=true)
    private String name;
    /**
     * Role description
     */
    @ManyToMany(mappedBy="roles")
    private List<User> users;
}
