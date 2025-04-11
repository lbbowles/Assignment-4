package com.csc340.Assignment4.animal;

import jakarta.persistence.Entity;

//Create new classes that inherit from Animal

@Entity
public class Cat extends Animal {

    public Cat() {
        super();
    }

    public Cat(String name, String description, String breed) {
        super(name, description, breed);
        this.setBreed(breed);
    }

}
