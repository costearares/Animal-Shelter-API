package com.p5.adoptionsapi.service;

import com.p5.adoptionsapi.repository.cats.Cat;
import com.p5.adoptionsapi.repository.dogs.Dog;
import com.p5.adoptionsapi.repository.shelters.AnimalShelter;
import com.p5.adoptionsapi.repository.shelters.AnimalShelterRepository;
import com.p5.adoptionsapi.service.DTO.CatDTO;
import com.p5.adoptionsapi.service.DTO.DogDTO;
import com.p5.adoptionsapi.service.DTO.ListDTO;
import com.p5.adoptionsapi.service.DTO.ShelterDTO;
import com.p5.adoptionsapi.service.adapters.CatAdapter;
import com.p5.adoptionsapi.service.adapters.DogAdapter;
import com.p5.adoptionsapi.service.adapters.ShelterAdapter;
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

    public ListDTO<ShelterDTO> findAll() {
        List<ShelterDTO>data=ShelterAdapter.toDTOList(animalShelterRepository.findAll());
        Long totalCount= animalShelterRepository.count();
        ListDTO<ShelterDTO> response=new ListDTO<>();
        response.setData(data);
        response.setTotalCount(totalCount);
        return response;
    }


    public ShelterDTO createShelter(ShelterDTO shelterDTO) {
        AnimalShelter shelter=ShelterAdapter.fromDTO(shelterDTO);
        AnimalShelter savedShelter= animalShelterRepository.save(shelter);
        return ShelterAdapter.toDTO(savedShelter);
    }


    public ShelterDTO updateShelter(Integer id, ShelterDTO shelterDTO) {
        AnimalShelter shelter = getShelterById(id);
        if (!shelter.getId().equals(shelterDTO.getId())) {
            throw new RuntimeException("Id of entity not the same with path id");
        }
        return ShelterAdapter.toDTO(animalShelterRepository.save(ShelterAdapter.fromDTO(shelterDTO)));
    }

//******
    public ShelterDTO findById(Integer id) {
        AnimalShelter shelter= getShelterById(id);
        return ShelterAdapter.toDTO(shelter);
    }


    public void deleteById(Integer id) {
        animalShelterRepository.deleteById(id);
    }


    private AnimalShelter getShelterById(Integer id) {
        Optional<AnimalShelter> optional = animalShelterRepository.findById(id);
        return optional.orElseThrow(() -> new EntityNotFoundException("Shelter with id " + id + "not found"));
    }


//CRUD for Cat

    public List<CatDTO> findAllCatsByShelter(Integer id) {
        AnimalShelter shelter = getShelterById(id);
        return CatAdapter.toDTOList(shelter.getCats());
    }


    public List<CatDTO> findCatById(Integer shelterId, Integer catId) {
        AnimalShelter shelter = getShelterById(shelterId);
        List<Cat> newCats = shelter.getCats().stream().filter(c ->
                c.getId().equals(catId)).collect(Collectors.toList());
        return CatAdapter.toDTOList(newCats);
    }

    public List<CatDTO> addNewCat(Integer shelterId, CatDTO catDTO) {
        AnimalShelter shelter = getShelterById(shelterId);
        shelter.getCats().add(CatAdapter.fromDTO(catDTO));
        animalShelterRepository.save(shelter);
        return CatAdapter.toDTOList(shelter.getCats());
    }


    public void deleteCatById(Integer shelterId, Integer catId) {
        AnimalShelter shelter = getShelterById(shelterId);
        List<Cat> newCats = shelter.getCats().stream().filter(c -> !c.getId().equals(catId)).collect(Collectors.toList());
        shelter.setCats(newCats);
        animalShelterRepository.save(shelter);
    }

    public CatDTO updateCatInShelter(Integer shelterId, Integer catId, CatDTO catDTO) {
        AnimalShelter shelter = getShelterById(shelterId);
        Cat cat=CatAdapter.fromDTO(catDTO);
        List<Cat> newCats = shelter.getCats().stream().map(c -> {
            if (c.getId().equals(catId)) {
                cat.setId(catId);
                return cat;
            }
            return c;
        }).collect(Collectors.toList());
        shelter.setCats(newCats);
        animalShelterRepository.save(shelter);
        return CatAdapter.toDTO(cat);
    }


//CRUD  for Dog

    public List<DogDTO> findAllDogByShelter(Integer id) {
        AnimalShelter shelter = getShelterById(id);
        return DogAdapter.toDTOList(shelter.getDogs());
    }


    public List<DogDTO> findDogById(Integer shelterId, Integer dogId) {
        AnimalShelter shelter = getShelterById(shelterId);
        List<Dog> newDog = shelter.getDogs().stream().filter(c ->
                c.getId().equals(dogId)).collect(Collectors.toList());
        return DogAdapter.toDTOList(newDog);
    }

    public List<DogDTO> addNewDog(Integer shelterId, DogDTO dogDTO) {
        AnimalShelter shelter = getShelterById(shelterId);
        shelter.getDogs().add(DogAdapter.fromDTO(dogDTO));
        animalShelterRepository.save(shelter);
        return DogAdapter.toDTOList(shelter.getDogs());
    }


    public void deleteDogById(Integer shelterId, Integer dogId) {
        AnimalShelter shelter = getShelterById(shelterId);
        List<Dog> newDogs = shelter.getDogs().stream().filter(c -> !c.getId().equals(dogId)).collect(Collectors.toList());
        shelter.setDogs(newDogs);
        animalShelterRepository.save(shelter);
    }

    public DogDTO updateDogInShelter(Integer shelterId, Integer dogId, DogDTO dogDTO) {
        AnimalShelter shelter = getShelterById(shelterId);
        Dog dog=DogAdapter.fromDTO(dogDTO);
        List<Dog> newDogs = shelter.getDogs().stream().map(c -> {
            if (c.getId().equals(dogId)) {
                dog.setId(dogId);
                return dog;
            }
            return c;
        }).collect(Collectors.toList());
        shelter.setDogs(newDogs);
        animalShelterRepository.save(shelter);
        return DogAdapter.toDTO(dog);
    }
}