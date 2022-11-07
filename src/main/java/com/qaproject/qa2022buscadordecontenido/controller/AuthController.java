package com.qaproject.qa2022buscadordecontenido.controller;

import com.qaproject.qa2022buscadordecontenido.dto.UserDto;
import com.qaproject.qa2022buscadordecontenido.entity.User;
import com.qaproject.qa2022buscadordecontenido.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class AuthController {
    /**
     * The User service
     */

    private UserService userService;

    public AuthController(UserService userService) {
        /**
         * Constructor
         * @param userService
         */
        this.userService = userService;
    }

    @GetMapping("index")
    public String home(){
        /**
         * Home page
         * @return
         */
        return "index";
    }

    @GetMapping("/login")
    public String loginForm() {
        /**
         * Login form
         * @return
         */
        return "login";
    }

    // handler method to handle user registration request
    @GetMapping("register")
    public String showRegistrationForm(Model model){
        /**
         * Register form
         * @param model
         * @return
         */
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle register user form submit request
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto user,
                               BindingResult result,
                               Model model){
        /**
         * Register user
         * @param user
         * @param result
         * @param model
         * @return
         */
        User existing = userService.findByEmail(user.getEmail());
        if (existing != null) {
            result.rejectValue("email", null, "There is already an account registered with that email");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }
        userService.saveUser(user);
        return "redirect:/register?success";
    }

    @GetMapping("/users")
    public String listRegisteredUsers(Model model){
        /**
         * List users
         * @param model
         * @return
         */
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }
}
