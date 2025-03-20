package com.csc340.Assignment4.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;


    /**
     * Fetch all Animals.
     *
     * @return the list of all Animals.
     */
    public List<Animal> getAllAnimals() {

        return animalRepository.findAll();
    }

    /**
     * Fetch a unique animal.
     *
     * @param animalId the unique Animal id.
     * @return a unique Animal object.
     */
    public Animal getAnimalById(int animalId) {

        return animalRepository.findById(animalId).orElse(null);
    }

    /**
     * Fetch all animals whose breed matches the search term.
     *
     * @param breed the search key.
     * @return the list of matching Animals.
     */
    public List<Animal> getAnimalsByBreed(String breed) {
        return animalRepository.findByBreed(breed);
    }

    /**
     *  Fetch all animals whose name contains the searched string
     */

    public List<Animal> getAnimalsByName(String name) {
        return animalRepository.findByName(name);
    }

    /**
     * Add a new Animal to the database.
     *
     * @param animal the Animal object to be added.
     */
    public Animal addNewAnimal(Animal animal) {
        Animal savedAnimal;

        // If entered breed = "dog", save as Dog
        if (animal.getBreed().equalsIgnoreCase("dog")) {
            savedAnimal = new Dog(animal.getName(), animal.getDescription(), animal.getBreed());
        }
        // If entered breed = "cat", save as Cat
        else if(animal.getBreed().equalsIgnoreCase("cat")) {
            savedAnimal = new Cat(animal.getName(), animal.getDescription(), animal.getBreed());
        }
        // Otherwise if they input something not relevant to the website, return Null.
        else {
            return null;
        }

        return animalRepository.save(savedAnimal);
    }

    /**
     * Update an existing Animal.
     *
     * @param animalId the ID of the Animal to update.
     * @param updatedAnimal the updated Animal object.
     */
    public void updateAnimal(int animalId, Animal updatedAnimal) {

        Optional<Animal> existingAnimal = animalRepository.findById(animalId);

        if (existingAnimal.isPresent()) {

            Animal animal = existingAnimal.get();
            animal.setName(updatedAnimal.getName());
            animal.setDescription(updatedAnimal.getDescription());
            animalRepository.save(animal);

        }
    }

    /**
     * Delete an Animal by ID.
     *
     * @param animalId the ID of the Animal to delete.
     */
    public void deleteAnimalById(int animalId) {
        animalRepository.deleteById(animalId);
    }

}
