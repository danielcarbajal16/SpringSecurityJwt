package com.example.SpringSecurityJwt.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRolesController {
    @GetMapping("/accessAdmin")
    @PreAuthorize("hasRole('ADMIN')")
    public String accessAdmin() {
        return "Hello, you are an admin";
    }

    @GetMapping("/accessUser")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public String accessUser() {
        return "Hello, you are an user";
    }

    @GetMapping("/accessInvited")
    @PreAuthorize("hasRole('INVITED')")
    public String accessInvited() {
        return "Hello, you are an invited";
    }
}
