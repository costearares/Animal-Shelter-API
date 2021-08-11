package com.p5.adoptionsapi.api.controllers;

import com.p5.adoptionsapi.repository.cats.Cat;
import com.p5.adoptionsapi.repository.cats.CatRepository;
import com.p5.adoptionsapi.repository.shelters.AnimalShelter;
import com.p5.adoptionsapi.service.AnimalService;
import com.p5.adoptionsapi.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
