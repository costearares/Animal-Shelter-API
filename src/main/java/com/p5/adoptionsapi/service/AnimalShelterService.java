package com.p5.adoptionsapi.service;

import com.p5.adoptionsapi.repository.cats.Cat;
import com.p5.adoptionsapi.repository.shelters.AnimalShelter;
import com.p5.adoptionsapi.repository.shelters.AnimalShelterRepository;
import org.springframework.stereotype.Service;


import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnimalShelterService {


    AnimalShelterRepository animalShelterRepository;

    public AnimalShelterService(AnimalShelterRepository animalShelterRepository) {
        this.animalShelterRepository = animalShelterRepository;
    }

    public List<AnimalShelter> findAll() {
        return animalShelterRepository.findAll();
    }


    public AnimalShelter createShelter(AnimalShelter animalShelter) {
        return animalShelterRepository.save(animalShelter);
    }


    public AnimalShelter updateShelter(Integer id, AnimalShelter animalShelter) {
        AnimalShelter shelter = getShelterById(id);
        if (!shelter.getId().equals(animalShelter.getId())) {
            throw new RuntimeException("Id of entity not the same with path id");
        }
        return animalShelterRepository.save(animalShelter);
    }


    public AnimalShelter findById(Integer id) {
        return getShelterById(id);
    }


    public void deleteById(Integer id) {
        animalShelterRepository.deleteById(id);
    }


    private AnimalShelter getShelterById(Integer id) {
        Optional<AnimalShelter> optional = animalShelterRepository.findById(id);
        return optional.orElseThrow(() -> new EntityNotFoundException("Shelter with id " + id + "not found"));
    }

//CRUD for Cat

    public List<Cat> findAllCatsByShelter(Integer id) {
        AnimalShelter shelter = getShelterById(id);
        return shelter.getCats();
    }


    public List<Cat> findCatById(Integer shelterId, Integer catId) {
        AnimalShelter shelter = getShelterById(shelterId);
        List<Cat> newCats = shelter.getCats().stream().filter(c ->
                c.getId().equals(catId)).collect(Collectors.toList());
        return newCats;
    }

    public List<Cat> addNewCat(Integer shelterId, Cat cat) {
        AnimalShelter shelter = getShelterById(shelterId);
        shelter.getCats().add(cat);
        animalShelterRepository.save(shelter);
        return shelter.getCats();
    }


    public void deleteCatById(Integer shelterId, Integer catId) {
        AnimalShelter shelter = getShelterById(shelterId);
        List<Cat> newCats = shelter.getCats().stream().filter(c -> !c.getId().equals(catId)).collect(Collectors.toList());
        shelter.setCats(newCats);
        animalShelterRepository.save(shelter);
    }

    public Cat updateCatInShelter(Integer shelterId, Integer catId, Cat cat) {
        AnimalShelter shelter = getShelterById(shelterId);
        List<Cat> newCats = shelter.getCats().stream().map(c -> {
            if (c.getId().equals(catId)) {
                cat.setId(catId);
                return cat;
            }
            return c;
        }).collect(Collectors.toList());
        shelter.setCats(newCats);
        animalShelterRepository.save(shelter);
        return cat;
    }


    //CRUD  for Dog
}