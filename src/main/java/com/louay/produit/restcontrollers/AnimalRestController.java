package com.louay.produit.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.louay.produit.Services.AnimalService;
import com.louay.produit.entities.Animal;

@RestController
@RequestMapping("/api/animaux")
@CrossOrigin(origins = "http://localhost:4200")
public class AnimalRestController {

    @Autowired
    private AnimalService animalService;

    @GetMapping
    public List<Animal> getAllAnimals() {
        return animalService.getAllAnimal();
    }

    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable("id") Long id) {
        return animalService.getAnimal(id);
    }

    @PostMapping
    public Animal createAnimal(@RequestBody Animal animal) {
        return animalService.saveAnimal(animal);
    }

    @PutMapping
    public Animal updateAnimal(@RequestBody Animal animal) {
        return animalService.updateAnimal(animal);
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable("id") Long id) {
        animalService.deleteAnimalById(id);
    }

    @GetMapping("/groupes/{groupId}")
    public List<Animal> getAnimalsByGroupId(@PathVariable("groupId") Long groupId) {
        return animalService.findByGroupesIdGrou(groupId);
    }
}
