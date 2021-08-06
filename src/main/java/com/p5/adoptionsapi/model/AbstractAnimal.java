package com.p5.adoptionsapi.model;

public abstract class AbstractAnimal {

    /**
     * An abstract class, cannot be instantiated anymore
     * <p>
     * Pluses over interface:
     * - we can fields private static, non-static,protected
     * - we can body to functions
     * - we can abstract methods == interface methods
     * - constructors
     *
     * Minuses:
     * - IMPORTANT!!!  Limits inheritance, because we need to extend this in child, AND WE CAN ONLY EXTENDS ON
     */
    protected String customField;

    public abstract String whatDoesItEats();

}
