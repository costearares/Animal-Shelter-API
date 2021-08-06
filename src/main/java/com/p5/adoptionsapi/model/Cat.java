package com.p5.adoptionsapi.model;

public class Cat extends Animal implements AnimalInterface{

    public static String staticField ="This is a static field";
    public Integer purrIntensity;

    public Cat(String name, String photo) {
        super(name, photo);
        this.purrIntensity=5;
    }
    //Super is mandatory if we have a constructor with parameters in base class
    //MUST BE ON THE FIRST LINE OF THE CHILD'S CONSTRUCTOR
    public Cat(String name, String photo, Integer purrIntensity) {
        super(name, photo);
        this.purrIntensity = purrIntensity;
    }

    @Override
    public String whatDoesItEats() {
        return "Milk";
    }

    @Override
    public String makeSounds() {
        return "Miau";
    }

    @Override
    public String howManyLegs() {
        return "Four";
    }
}
