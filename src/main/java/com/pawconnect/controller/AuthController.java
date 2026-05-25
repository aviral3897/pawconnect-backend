package com.pawconnect.controller;

import com.pawconnect.model.User;
import com.pawconnect.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController


@RequestMapping("/auth")
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {

        User existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser != null) {
            return "Email already exists!";
        }

        user.setRole("USER");

        userRepository.save(user);

        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser == null) {
            return "User not found!";
        }

        if (!existingUser.getPassword().equals(user.getPassword())) {
            return "Invalid password!";
        }

        return "Login successful!";
    }
}