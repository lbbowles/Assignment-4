package com.csc340.Assignment4.animal;

import jakarta.persistence.Entity;

//Create new classes that inherit from Animal

@Entity
public class Dog extends Animal {

    public Dog() {
        super();
    }

    public Dog(String name, String description, String breed) {
        super(name, description);
        this.setBreed(breed);
    }


}