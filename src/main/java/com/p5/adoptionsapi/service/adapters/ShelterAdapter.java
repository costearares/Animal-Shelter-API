package com.p5.adoptionsapi.service.adapters;

import com.p5.adoptionsapi.repository.shelters.AnimalShelter;
import com.p5.adoptionsapi.service.DTO.ShelterDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ShelterAdapter {

    public static ShelterDTO toDTO(AnimalShelter shelter) {
        return new ShelterDTO()
                .setId(shelter.getId())
                .setName(shelter.getName())
                .setCats(CatAdapter.toDTOList(shelter.getCats()))
                .setDogs(DogAdapter.toDTOList(shelter.getDogs()));
    }

    public static AnimalShelter fromDTO(ShelterDTO shelterDTO) {
        AnimalShelter shelter = new AnimalShelter();
        shelter.setId(shelterDTO.getId());
        shelter.setName(shelterDTO.getName());
        shelter.setCats(CatAdapter.fromDTOList(shelterDTO.getCats()));
        shelter.setDogs(DogAdapter.fromDTOList(shelterDTO.getDogs()));
        return shelter;
    }

    public static List<ShelterDTO> toDTOList(List<AnimalShelter> animalShelters) {
        return animalShelters
                .stream()
                .map(ShelterAdapter::toDTO)
                .collect(Collectors.toList());
    }

    public static List<AnimalShelter> fromDTOList(List<ShelterDTO> shelterDTOS) {
        return shelterDTOS
                .stream()
                .map(ShelterAdapter::fromDTO)
                .collect(Collectors.toList());
    }
}
