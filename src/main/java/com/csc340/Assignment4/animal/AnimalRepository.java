package com.csc340.Assignment4.animal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Provides the actual database transactions.
 */
@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

    List<Animal> findByName(String name);

    List<Animal> findByBreed(String breed);

}

