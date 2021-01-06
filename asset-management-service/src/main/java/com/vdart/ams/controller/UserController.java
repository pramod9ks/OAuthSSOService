package com.vdart.ams.controller;

import com.vdart.ams.exception.ResourceNotFoundException;
import com.vdart.ams.model.User;
import com.vdart.ams.repository.UserRepository;
import com.vdart.ams.security.CurrentUser;
import com.vdart.ams.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return "AssetManagement Service";
    }
    
    @GetMapping("/home")
    public String testHome() {
        return "AssetManagement Home";
    }
}
