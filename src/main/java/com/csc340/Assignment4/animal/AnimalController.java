package com.csc340.Assignment4.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// Basically hand-held the instructions that were provided via Canvas.

/**
 * AnimalController.java.
 * Includes all REST API endpoint mappings for the Animal object.
 */
@Controller
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

    /**
     * Get a list of all Animals in the database.
     * http://localhost:8080/animals/all
     */

    @GetMapping("/all")
    public String getAllAnimals(Model model) {
        // return new ResponseEntity<>(service.getAllStudents(), HttpStatus.OK);
        model.addAttribute("animalList", service.getAllAnimals());
        //model.addAttribute("title", "All Animals");
        return "animal-list";
    }

    /**
     * Get a specific Animal by Id.
     * http://localhost:8080/animals/{animalId}
     *
     */

    @GetMapping("/{animalId}")
    public Object getOneAnimal(@PathVariable int animalId, Model model) {
        // return new ResponseEntity<>(service.getStudentById(studentId), HttpStatus.OK);
        model.addAttribute("animal", service.getAnimalById(animalId));
        model.addAttribute("title", "Animal #: " + animalId);
        return "animal-details";

    }

    /**
     * Create a new Animal entry.
     */
    @PostMapping("/new")
    public String createAnimal(@RequestParam String type, @RequestParam String name, @RequestParam String description,
                               @RequestParam String breed)

    // Since Assignment 4, I made it so that there were three databases, complicates things and I therefore have to put this in to allow updates.
    // Information from the create page is the stuff above, apply that to this post and post.
    {
        Animal animal;
        if ("cat".equalsIgnoreCase(type)) {
            animal = new Cat(name, description, breed);
        } else {
            animal = new Dog(name, description, breed);
        }

        service.addNewAnimal(animal);
        return "redirect:/animals/all";
    }

    @GetMapping("/new")
    public String showCreateAnimalForm(Model model) {
        model.addAttribute("animal", new Animal());
        return "animal-create";
    }

    /**
     * Update an existing Animal object.
     */
    @GetMapping("/update/{animalId}")
    public String showUpdateAnimalForm(@PathVariable int animalId, Model model) {
        Animal animal = service.getAnimalById(animalId);
        model.addAttribute("animal", animal);
        // Again because I made an extra table and animal is a superclass, have to pass this off.
        model.addAttribute("type", animal instanceof Cat ? "Cat" : "Dog");
        model.addAttribute("title", "Update Animal");
        return "animal-update";
    }

    @PostMapping("/update/{animalId}")
    public String updateAnimal(@PathVariable int animalId, Animal formAnimal, @RequestParam String type) {
        Animal updatedAnimal;

        // Same logic as the one above, if it is a cat, then put as one, otherwise it is a dog.  Otherwise will get type error.
        if ("Cat".equalsIgnoreCase(type)) {
            updatedAnimal = new Cat(formAnimal.getName(), formAnimal.getDescription(), formAnimal.getBreed());
        } else {
            updatedAnimal = new Dog(formAnimal.getName(), formAnimal.getDescription(), formAnimal.getBreed());
        }

        service.updateAnimal(animalId, updatedAnimal);
        return "redirect:/animals/" + animalId;
    }


    /**
     * Delete an Animal object.
     * http://localhost:8080/animals/delete/{animalId}
     *
     */
    @GetMapping("/delete/{animalId}")
    public String deleteAnimalById(@PathVariable int animalId) {
        service.deleteAnimalById(animalId);
        return "redirect:/animals/all";
    }

}
