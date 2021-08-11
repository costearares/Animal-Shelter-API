package com.p5.adoptionsapi.service;

import com.p5.adoptionsapi.repository.animal.Animal;
import com.p5.adoptionsapi.repository.animal.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class AnimalService {
    /*private final AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public List<Animal> findAnimals(){
        return animalRepository.findAll();
    }*/
    private static Long animalsCount = 3L;
    private static List<Animal> animals = new ArrayList<>();

    static {
        animals.add(new Animal(1L, "dog", "Mark"));
        animals.add(new Animal(2L, "cat", "Kitty"));
        animals.add(new Animal(3L, "pig", "Fat"));
    }

    public List<Animal> findAll() {
        return animals;
    }

    public Animal saveAnimal(Animal animal) {
        if (animal.getId() == null) {
            animal.setId(++animalsCount);
        }
        animals.add(animal);
        return animal;
    }

    public Animal findOne(Long id){
        for(Animal animal:animals){
            if(animal.getId()==id)
                return animal;
        }
        return null;
    }

    public Animal deleteById(Long id) {
        Iterator<Animal>iterator= animals.iterator();
        while (iterator.hasNext()){
            Animal animal=iterator.next();
            if (animal.getId()==id){
                iterator.remove();
                return animal;
            }
        }
        return null;
    }
}
