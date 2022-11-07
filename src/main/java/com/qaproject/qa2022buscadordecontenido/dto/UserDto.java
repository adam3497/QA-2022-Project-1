package com.qaproject.qa2022buscadordecontenido.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
/**
 * User Dto
 */
public class UserDto
{
    /**
     * User id
     */
    private Long id;
    @NotEmpty
    /**
     * User name
     */
    private String firstName;
    @NotEmpty
    private String lastName;
    /**
     * User email
     */
    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;
    /**
     * User password
     */
    @NotEmpty(message = "Password should not be empty")
    private String password;
}
