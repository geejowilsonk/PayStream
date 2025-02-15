package com.paystream.userservice.controller;

import com.paystream.userservice.model.User;
import com.paystream.userservice.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserRepository repository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    // Register New User
    @PostMapping("/register")
    public User register(@RequestParam String username, @RequestParam String password, @RequestParam String role) {
        User user = new User(username, passwordEncoder.encode(password), role); // Removed 'null'
        return repository.save(user);
    }

    // Get All Users
    @GetMapping
    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
