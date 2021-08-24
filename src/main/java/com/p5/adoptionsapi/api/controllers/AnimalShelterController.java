package com.p5.adoptionsapi.api.controllers;

import com.p5.adoptionsapi.repository.animal.Animal;
import com.p5.adoptionsapi.repository.animal.AnimalRepository;
import com.p5.adoptionsapi.repository.cats.Cat;
import com.p5.adoptionsapi.repository.dogs.Dog;
import com.p5.adoptionsapi.repository.shelters.AnimalShelter;
import com.p5.adoptionsapi.service.AnimalShelterService;
import com.p5.adoptionsapi.service.DTO.CatDTO;
import com.p5.adoptionsapi.service.DTO.DogDTO;
import com.p5.adoptionsapi.service.DTO.ListDTO;
import com.p5.adoptionsapi.service.DTO.ShelterDTO;
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
    public ResponseEntity<ListDTO<ShelterDTO>> getShelters() {
        return ResponseEntity.ok(animalShelterService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShelterDTO> getShelter(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(animalShelterService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<ShelterDTO> createShelter(@RequestBody ShelterDTO shelterDTO) {
        return ResponseEntity.ok(animalShelterService.createShelter(shelterDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShelterDTO> updateShelter(@PathVariable("id") Integer id, @RequestBody ShelterDTO shelterDTO) {
        return ResponseEntity.ok(animalShelterService.updateShelter(id, shelterDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Objects> deleteShelter(@PathVariable("id") Integer id) {
        animalShelterService.deleteById(id);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }

//Cat

    @GetMapping("/{shelterId}/cat")
    public ResponseEntity<List<CatDTO>> getCatsForShelter(@PathVariable("shelterId") Integer id) {
        return ResponseEntity.ok(animalShelterService.findAllCatsByShelter(id));
    }

    @GetMapping("/{shelterId}/cat/{id}")
    public ResponseEntity<List<CatDTO>> getCatsById(@PathVariable("shelterId") Integer shelterId, @PathVariable("id") Integer id) {
        return ResponseEntity.ok(animalShelterService.findCatById(shelterId, id));
    }

    @PutMapping("/{shelterId}/cat")
    public ResponseEntity<List<CatDTO>> createCatForShelter(@PathVariable("shelterId") Integer id, @RequestBody CatDTO catDTO) {
        return ResponseEntity.ok(animalShelterService.addNewCat(id, catDTO));
    }

    @PatchMapping("/{shelterId}/cat/{catId}")
    public ResponseEntity<CatDTO> updateCatInShelter(@PathVariable("shelterId") Integer shelterId, @PathVariable("catId") Integer catId, @RequestBody CatDTO catDTO) {
        return ResponseEntity.ok(animalShelterService.updateCatInShelter(shelterId, catId, catDTO));
    }

    @DeleteMapping("/{shelterId}/cat/{catId}")
    public ResponseEntity<CatDTO> deleteCatForShelterById(@PathVariable("shelterId") Integer shelterId, @PathVariable("catId") Integer catId, @RequestBody CatDTO catDTO) {
        animalShelterService.deleteCatById(shelterId, catId);
        return ResponseEntity.status(HttpStatus.GONE).build();

    }


// Dog

    @GetMapping("/{shelterId}/dog")
    public ResponseEntity<List<DogDTO>> getDogsForShelter(@PathVariable("shelterId") Integer id) {
        return ResponseEntity.ok(animalShelterService.findAllDogByShelter(id));
    }

    @GetMapping("/{shelterId}/dog/{id}")
    public ResponseEntity<List<DogDTO>> getDogById(@PathVariable("shelterId") Integer shelterId, @PathVariable("id") Integer id) {
        return ResponseEntity.ok(animalShelterService.findDogById(shelterId, id));
    }

    @PutMapping("/{shelterId}/dog")
    public ResponseEntity<List<DogDTO>> createDogForShelter(@PathVariable("shelterId") Integer id, @RequestBody DogDTO dogDTO) {
        return ResponseEntity.ok(animalShelterService.addNewDog(id, dogDTO));
    }

    @PatchMapping("/{shelterId}/dog/{dogId}")
    public ResponseEntity<DogDTO> updateDogInShelter(@PathVariable("shelterId") Integer shelterId, @PathVariable("dogId") Integer dogId, @RequestBody DogDTO dogDTO) {
        return ResponseEntity.ok(animalShelterService.updateDogInShelter(shelterId, dogId, dogDTO));
    }

    @DeleteMapping("/{shelterId}/dog/{dogId}")
    public ResponseEntity<DogDTO> deleteDogForShelterById(@PathVariable("shelterId") Integer shelterId, @PathVariable("dogId") Integer dogId, @RequestBody DogDTO dogDTO) {
        animalShelterService.deleteDogById(shelterId, dogId);
        return ResponseEntity.status(HttpStatus.GONE).build();

    }
}

