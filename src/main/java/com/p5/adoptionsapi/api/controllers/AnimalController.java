package com.p5.adoptionsapi.api.controllers;

import com.p5.adoptionsapi.repository.animal.Animal;
import com.p5.adoptionsapi.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/animal")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @GetMapping("/getAnimals")
    public List<Animal> retriveAnimals(){
        return animalService.findAll();
    }

    @PostMapping("/saveAnimal")
    public ResponseEntity<Animal> addAnimal(@RequestBody Animal animal){
        Animal sevedAnimal= animalService.saveAnimal(animal);
        URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(sevedAnimal.getId()).toUri();
        return ResponseEntity.created(location).build();

        //return animalService.saveAnimal(animal);
       // return new Animal(4L,"Jonny" , "photo");
    }


    @GetMapping ("/animals/{id}")
    public Animal retriveAnimal(@PathVariable Long id) {
        return animalService.findOne(id);
    }


        @DeleteMapping("/animals/{id}")
                public void deleteAnimal(@PathVariable Long id){
            Animal animal =animalService.deleteById(id);

        }
    }

