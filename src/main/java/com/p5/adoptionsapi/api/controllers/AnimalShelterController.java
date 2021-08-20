package com.p5.adoptionsapi.api.controllers;

import com.p5.adoptionsapi.repository.animal.Animal;
import com.p5.adoptionsapi.repository.animal.AnimalRepository;
import com.p5.adoptionsapi.repository.cats.Cat;
import com.p5.adoptionsapi.repository.dogs.Dog;
import com.p5.adoptionsapi.repository.shelters.AnimalShelter;
import com.p5.adoptionsapi.service.AnimalShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/shelter")
public class AnimalShelterController {


    private AnimalShelterService animalShelterService;

    public AnimalShelterController(AnimalShelterService animalShelterService) {
        this.animalShelterService = animalShelterService;
    }

    @GetMapping()
    public ResponseEntity<List<AnimalShelter>> getShelters() {
        return ResponseEntity.ok(animalShelterService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimalShelter> getShelter(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(animalShelterService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<AnimalShelter> createShelter(@RequestBody AnimalShelter animalShelter) {
        return ResponseEntity.ok(animalShelterService.createShelter(animalShelter));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimalShelter> updateShelter(@PathVariable("id") Integer id, @RequestBody AnimalShelter animalShelter) {
        return ResponseEntity.ok(animalShelterService.updateShelter(id, animalShelter));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Objects> deleteShelter(@PathVariable("id") Integer id) {
        animalShelterService.deleteById(id);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }

//Cat

    @GetMapping("/{shelterId}/cat")
    public ResponseEntity<List<Cat>> getCatsForShelter(@PathVariable("shelterId") Integer id) {
        return ResponseEntity.ok(animalShelterService.findAllCatsByShelter(id));
    }

    @GetMapping("/{shelterId}/cat/{id}")
    public ResponseEntity<List<Cat>> getCatsById(@PathVariable("shelterId") Integer shelterId, @PathVariable("id") Integer id) {
        return ResponseEntity.ok(animalShelterService.findCatById(shelterId, id));
    }

    @PutMapping("/{shelterId}/cat")
    public ResponseEntity<List<Cat>> createCatForShelter(@PathVariable("shelterId") Integer id, @RequestBody Cat cat) {
        return ResponseEntity.ok(animalShelterService.addNewCat(id, cat));
    }

    @PatchMapping("/{shelterId}/cat/{catId}")
    public ResponseEntity<Cat> updateCatInShelter(@PathVariable("shelterId") Integer shelterId, @PathVariable("catId") Integer catId, @RequestBody Cat cat) {
        return ResponseEntity.ok(animalShelterService.updateCatInShelter(shelterId, catId, cat));
    }

    @DeleteMapping("/{shelterId}/cat/{catId}")
    public ResponseEntity<Cat> deleteCatForShelterById(@PathVariable("shelterId") Integer shelterId, @PathVariable("catId") Integer catId, @RequestBody Cat cat) {
        animalShelterService.deleteCatById(shelterId, catId);
        return ResponseEntity.status(HttpStatus.GONE).build();

    }


// Dog

    @GetMapping("/{shelterId}/dog")
    public ResponseEntity<List<Dog>> getDogsForShelter(@PathVariable("shelterId") Integer id) {
        return ResponseEntity.ok(animalShelterService.findAllDogByShelter(id));
    }

    @GetMapping("/{shelterId}/dog/{id}")
    public ResponseEntity<List<Dog>> getDogById(@PathVariable("shelterId") Integer shelterId, @PathVariable("id") Integer id) {
        return ResponseEntity.ok(animalShelterService.findDogById(shelterId, id));
    }

    @PutMapping("/{shelterId}/dog")
    public ResponseEntity<List<Dog>> createDogForShelter(@PathVariable("shelterId") Integer id, @RequestBody Dog dog) {
        return ResponseEntity.ok(animalShelterService.addNewDog(id, dog));
    }

    @PatchMapping("/{shelterId}/dog/{dogId}")
    public ResponseEntity<Dog> updateDogInShelter(@PathVariable("shelterId") Integer shelterId, @PathVariable("dogId") Integer dogId, @RequestBody Dog dog) {
        return ResponseEntity.ok(animalShelterService.updateDogInShelter(shelterId, dogId, dog));
    }

    @DeleteMapping("/{shelterId}/dog/{dogId}")
    public ResponseEntity<Dog> deleteDogForShelterById(@PathVariable("shelterId") Integer shelterId, @PathVariable("dogId") Integer dogId, @RequestBody Dog dog) {
        animalShelterService.deleteDogById(shelterId, dogId);
        return ResponseEntity.status(HttpStatus.GONE).build();

    }
}

