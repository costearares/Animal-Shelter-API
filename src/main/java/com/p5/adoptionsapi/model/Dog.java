package com.p5.adoptionsapi.model;

public class Dog extends Animal implements AnimalInterface{

    public Dog(String name, String photo) {
        super(name, photo);
    }

    @Override
    public String whatDoesItEats() {
        return "Bones";
    }

    @Override
    public String makeSounds() {
        return "ham";
    }

    @Override
    public String howManyLegs() {
        return "Four";
    }
}
