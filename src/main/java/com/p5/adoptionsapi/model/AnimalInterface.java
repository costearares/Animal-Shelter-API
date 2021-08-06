package com.p5.adoptionsapi.model;

public interface AnimalInterface {

    public static String hello = "Hello animals";

    String makeSounds();

    public String howManyLegs();

    default String defaultMethod(){
        return "This is a default method";
    }
}
