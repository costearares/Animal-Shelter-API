package com.p5.adoptionsapi.api.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class MainController {


    @GetMapping("/hello")
    public ResponseEntity<String> greet(@RequestParam(name = "name", required = false) String name) {
        String owner = name == null ? " world " : name;
        return ResponseEntity.ok("Hello " + name + " from animal shelter");
    }

    @GetMapping("/owner")
    public ResponseEntity<String> greetOwner() {
        return ResponseEntity.ok("Hello owner!");
    }


}
