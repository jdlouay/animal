package com.louay.produit;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.louay.produit.entities.Animal;
import com.louay.produit.entities.Groupe;
import com.louay.produit.repos.AnimalRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class AnimalTests {

    @Autowired
    private AnimalRepository animalRepository;

    @Test
    public void testCreateAnimal() {
        Animal animal = new Animal("Tigre", "Félin", new Date(), "tigre@example.com");
        Animal savedAnimal = animalRepository.save(animal);
        assertNotNull(savedAnimal.getIdAnimal(), "Animal ID should not be null after saving");
        assertEquals("Tigre", savedAnimal.getNom(), "Animal name should match");
        System.out.println("Animal created: " + savedAnimal);
    }

    @Test
    public void testFindAnimalById() {
        Long testId = 6L; // Replace with an actual ID from your database
        Animal animal = animalRepository.findById(testId).orElse(null);
        assertNotNull(animal, "Animal should be found with ID " + testId);
        System.out.println("Found animal: " + animal);
    }

    @Test
    public void testUpdateAnimal() {
        Long testId = 5L; // Replace with an actual ID from your database
        Animal animal = animalRepository.findById(testId).orElse(null);
        assertNotNull(animal, "Animal should be found with ID " + testId);

        animal.setEspeceAnimal("Baboucha");
        Animal updatedAnimal = animalRepository.save(animal);

        assertNotNull(updatedAnimal, "Updated animal should not be null");
        assertEquals("Baboucha", updatedAnimal.getEspeceAnimal(), "Species should be updated to 'Baboucha'");
        System.out.println("Updated animal: " + updatedAnimal);
    }

    @Test
    public void testDeleteAnimal() {
        Long testId = 5L; // Replace with an actual ID from your database
        if (animalRepository.existsById(testId)) {
            animalRepository.deleteById(testId);
            assertFalse(animalRepository.existsById(testId), "Animal with ID " + testId + " should be deleted");
        } else {
            System.out.println("Animal with ID " + testId + " not found.");
        }
    }

    @Test
    public void testListAllAnimals() {
        List<Animal> animals = animalRepository.findAll();
        assertNotNull(animals, "Animal list should not be null");
        assertTrue(animals.size() > 0, "Animal list should not be empty");
        System.out.println("Listing all animals:");
        animals.forEach(System.out::println);
    }

    @Test
    public void testFindAnimalByName() {
        String name = "Tigre";
        List<Animal> animals = animalRepository.findByNom(name);
        assertNotNull(animals, "Animal list should not be null");
        assertTrue(animals.size() > 0, "Animals with name '" + name + "' should exist");
        System.out.println("Animals with name '" + name + "':");
        animals.forEach(System.out::println);
    }

    @Test
    public void testFindAnimalByNameContains() {
        String partialName = "t";
        List<Animal> animals = animalRepository.findByNomContains(partialName);
        assertNotNull(animals, "Animal list should not be null");
        assertTrue(animals.size() > 0, "Animals containing '" + partialName + "' in their name should exist");
        System.out.println("Animals containing '" + partialName + "' in their name:");
        animals.forEach(System.out::println);
    }

    @Test
    public void testFindByNomAndEspece() {
        String name = "Lion";
        String species = "Félin";
        List<Animal> animals = animalRepository.findByNomAndEspece(name, species);
        assertNotNull(animals, "Animal list should not be null");
        assertTrue(animals.size() > 0, "Animals with name '" + name + "' and species '" + species + "' should exist");
        System.out.println("Animals with name '" + name + "' and species '" + species + "':");
        animals.forEach(System.out::println);
    }

    @Test
    public void testFindByGroup() {
        Long groupId = 5L; // Replace with an actual group ID from your database
        Groupe groupe = new Groupe();
        groupe.setIdGroupe(groupId);

        List<Animal> animals = animalRepository.findByGroupes(groupe);
        assertNotNull(animals, "Animal list should not be null");
        System.out.println("Animals in group ID " + groupId + ":");
        animals.forEach(System.out::println);
    }

    @Test
    public void testFindByGroupId() {
        Long groupId = 5L; // Replace with an actual group ID from your database
        List<Animal> animals = animalRepository.findByGroupesidGroupe(groupId);
        assertNotNull(animals, "Animal list should not be null");
        System.out.println("Animals in group ID " + groupId + ":");
        animals.forEach(System.out::println);
    }

    @Test
    public void testFindByOrderByNameAsc() {
        List<Animal> animals = animalRepository.findByOrderByNomAsc();
        assertNotNull(animals, "Animal list should not be null");
        System.out.println("Animals ordered by name (ascending):");
        animals.forEach(System.out::println);
    }

    @Test
    public void testSortAnimalsByNameAndDate() {
        List<Animal> animals = animalRepository.trierAnimauxParNomEtDate();
        assertNotNull(animals, "Animal list should not be null");
        System.out.println("Animals sorted by name (ASC) and birth date (DESC):");
        animals.forEach(System.out::println);
    }
}
