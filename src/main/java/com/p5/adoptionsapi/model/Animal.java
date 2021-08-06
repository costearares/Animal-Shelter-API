package com.p5.adoptionsapi.model;

public class Animal extends AbstractAnimal implements AnimalInterface {

    private String name;
    private String photo;


     public  Animal(){
     }

    public Animal(String name, String photo) {
        this.name = name;
        this.photo = photo;
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
    public String whatDoesItEats() {
        return "Unknown";
    }

    @Override
    public String makeSounds() {
        return "Nothing";
    }

    @Override
    public String howManyLegs() {
        return "4 legs";
    }
}
