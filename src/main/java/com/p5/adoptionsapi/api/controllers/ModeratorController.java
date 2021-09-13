package com.p5.adoptionsapi.api.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/moderators")
@PreAuthorize("isAuthenticated() && hasRole('MOD')")

public class ModeratorController {

    @GetMapping("/hello")
    public String hello() {
        return "hello Moderator";
    }

}
