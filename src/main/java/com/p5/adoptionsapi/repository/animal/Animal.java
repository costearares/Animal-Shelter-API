package com.p5.adoptionsapi.repository.animal;

import javax.persistence.*;

//Option 1
//@MappedSuperclass

//Option 2
//@Entity
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
////Only if we use SINGLE_TABLE
//@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String photo;

    public Animal(Long id, String name, String photo) {
        this.id = id;
        this.name = name;
        this.photo = photo;
    }

    public Animal() {
    }

    public Long getId() {
        return id;
    }

    public Animal setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Animal setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhoto() {
        return photo;
    }

    public Animal setPhoto(String photo) {
        this.photo = photo;
        return this;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
