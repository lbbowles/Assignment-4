package com.csc340.Assignment4.animal;

import jakarta.persistence.*;

@Entity

//Look over this
@Inheritance(strategy = InheritanceType.JOINED)

@Table(name = "animals")

public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int animalId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String breed;

    public Animal(int animalId, String name, String description, String breed) {
        this.animalId = animalId;
        this.name = name;
        this.description = description;
        this.breed = breed;
    }

    public Animal(String name, String description) {
        this.name = name;
        this.description = description;
        this.breed = breed;
    }

    //Always include a no-argument constructor.
    public Animal() {
    }

    public int getAnimalId() { return animalId; }

    public void setAnimalId(int animalId) { this.animalId = animalId; }

    public String getBreed() { return breed; }

    public void setBreed(String breed) { this.breed = breed; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

}