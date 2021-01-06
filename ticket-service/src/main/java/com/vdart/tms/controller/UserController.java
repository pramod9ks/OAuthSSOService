package com.vdart.tms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vdart.tms.exception.ResourceNotFoundException;
import com.vdart.tms.model.User;
import com.vdart.tms.repository.UserRepository;
import com.vdart.tms.security.CurrentUser;
import com.vdart.tms.security.UserPrincipal;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
    
    @GetMapping("/")
    public String home() {
        return "Ticket Management";
    }
    
    @GetMapping("/home")
    public String testHome() {
        return "Ticket Management Home";
    }
}
