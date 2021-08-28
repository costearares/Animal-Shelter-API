package com.p5.adoptionsapi.service.DTO;


import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

public class ShelterDTO {
@Null
@NotBlank
    private Integer id;

    private String name;
    private List<CatDTO> cats = new ArrayList<>();
    private List<DogDTO> dogs = new ArrayList<>();

    public ShelterDTO() {
    }

    public ShelterDTO(Integer id, String name, List<CatDTO> cats, List<DogDTO> dogs) {
        this.id = id;
        this.name = name;
        this.cats = cats;
        this.dogs = dogs;
    }

    public Integer getId() {
        return id;
    }

    public ShelterDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ShelterDTO setName(String name) {
        this.name = name;
        return this;
    }

    public List<CatDTO> getCats() {
        return cats;
    }

    public ShelterDTO setCats(List<CatDTO> cats) {
        this.cats = cats;
        return this;
    }

    public List<DogDTO> getDogs() {
        return dogs;
    }

    public ShelterDTO setDogs(List<DogDTO> dogs) {
        this.dogs = dogs;
        return this;
    }
}
