package com.p5.adoptionsapi.repository.shelters;

import com.p5.adoptionsapi.model.Cat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AnimalShelter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true)
    private String name;

    // unidirectional OneToMany
/*    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "shelter_id")
    private List<Cat> cats = new ArrayList<>();*/

/*
    //    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    //    @JoinColumn(name = "cat_id")
    //    private Cat cat;

    //    Bidirectional
    //    @OneToMany(cascade = CascadeType.ALL, mappedBy = "shelter")
    //    private List<Cat> cats = new ArrayList<>();

    //    @ManyToMany
    //    @JoinTable(name = "shelters_cats",
    //               joinColumns = @JoinColumn(name = "shelter_id", referencedColumnName = "id"),
    //               inverseJoinColumns = @JoinColumn(name = "cat_id", referencedColumnName = "id"))
    //    private List<Cat> catss = new ArrayList<>();
*/
    public Integer getId() {
        return id;
    }

    public AnimalShelter setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public AnimalShelter setName(String name) {
        this.name = name;
        return this;
    }
}
