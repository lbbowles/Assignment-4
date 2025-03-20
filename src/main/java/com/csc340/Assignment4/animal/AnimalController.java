package com.csc340.Assignment4.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * AnimalController.java.
 * Includes all REST API endpoint mappings for the Animal object.
 */
@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

    /**
     * Get a list of all Animals in the database.
     * http://localhost:8080/animals/all
     *
     * @return a list of Animal objects.
     */
    @GetMapping("/all")
    public ResponseEntity<List<Animal>> getAllAnimals() {
        return new ResponseEntity<>(service.getAllAnimals(), HttpStatus.OK);
    }

    /**
     * Get a specific Animal by Id.
     * http://localhost:8080/animals/{animalId}
     *
     * @param animalId the unique Id for an Animal.
     * @return One Animal object.
     */
    @GetMapping("/{animalId}")
    public ResponseEntity<Animal> getOneAnimal(@PathVariable int animalId) {
        return new ResponseEntity<>(service.getAnimalById(animalId), HttpStatus.OK);
    }

    /**
     * Get a list of animals with a name that contains the given string.
     * http://localhost:8080/animals/name?search=reyna
     *
     * @param search the search key
     * @return list of Animal objects matching the search key.
     */
    @GetMapping("/name")
    public ResponseEntity<List<Animal>> getAnimalsByName(@RequestParam(name = "search", defaultValue = "") String search) {
        return new ResponseEntity<>(service.getAnimalsByName(search), HttpStatus.OK);
    }

    /**
     * Get a list of Animals based on their breed.
     * http://localhost:8080/animals/breed/{breed}
     *
     * @param breed the search key.
     * @return A list of Animal objects matching the search key.
     */
    @GetMapping("/breed/{breed}")
    public ResponseEntity<List<Animal>> getAnimalsByBreed(@PathVariable String breed) {
        return new ResponseEntity<>(service.getAnimalsByBreed(breed), HttpStatus.OK);
    }

    /**
     * Create a new Animal entry.
     * http://localhost:8080/animals/new --data '{  "name": "sample new animal", "breed": "dog" }'
     *
     * @param animal the new Animal object.
     * @return the updated list of Animals.
     */
    @PostMapping("/new")
    public ResponseEntity<List<Animal>> addNewAnimal(@RequestBody Animal animal) {
        service.addNewAnimal(animal);
        return new ResponseEntity<>(service.getAllAnimals(), HttpStatus.CREATED);
    }

    /**
     * Update an existing Animal object.
     * http://localhost:8080/animals/update/{animalId} --data '{ "name": "sampleUpdated", "breed": "dog" }'
     *
     * @param animalId the unique Animal Id.
     * @param animal   the updated Animal details.
     * @return the updated Animal object.
     */
    @PutMapping("/update/{animalId}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable int animalId, @RequestBody Animal animal) {
        service.updateAnimal(animalId, animal);
        return new ResponseEntity<>(service.getAnimalById(animalId), HttpStatus.OK);
    }

    /**
     * Delete an Animal object.
     * http://localhost:8080/animals/delete/{animalId}
     *
     * @param animalId the unique Animal Id.
     * @return the updated list of Animals.
     */
    @DeleteMapping("/delete/{animalId}")
    public ResponseEntity<List<Animal>> deleteAnimalById(@PathVariable int animalId) {
        service.deleteAnimalById(animalId);
        return new ResponseEntity<>(service.getAllAnimals(), HttpStatus.OK);
    }
}
