package com.p5.adoptionsapi.service.adapters;

import com.p5.adoptionsapi.repository.cats.Cat;
import com.p5.adoptionsapi.repository.dogs.Dog;
import com.p5.adoptionsapi.service.DTO.CatDTO;
import com.p5.adoptionsapi.service.DTO.DogDTO;

import java.util.List;
import java.util.stream.Collectors;

public class DogAdapter {

    public static DogDTO toDTO(Dog dog) {
        return new DogDTO().setId(dog.getId())
                .setName(dog.getName())
                .setPhoto(dog.getPhoto());
    }

    public static Dog fromDTO(DogDTO dogDTO) {
        Dog dog = new Dog();
        dog.setId(dogDTO.getId());
        dog.setName(dogDTO.getName());
        dog.setPhoto(dogDTO.getPhoto());
        return dog;
    }

    public static List<Dog> fromDTOList(List<DogDTO> dogDTOList) {
        return dogDTOList.stream().map(DogAdapter::fromDTO).collect(Collectors.toList());
    }

    public static List<DogDTO> toDTOList(List<Dog> dogList) {
        return dogList.stream().map(DogAdapter::toDTO).collect(Collectors.toList());
    }
}
