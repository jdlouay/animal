package com.louay.produit.Services;

import java.util.List;

import com.louay.produit.entities.Animal;
import com.louay.produit.entities.Groupe;

public interface AnimalService {
    
    Animal saveAnimal(Animal p);
    Animal updateAnimal(Animal p);
    void deleteAnimal(Animal p);
    void deleteAnimalById(Long id);
    Animal getAnimal(Long id);
    List<Animal> getAllAnimal();
    
    List<Animal> findByNom(String nom);
    List<Animal> findByNomContains(String nom);
    
    List<Animal> findByNomAndEspece(String nom, String espece_animal);
    
    List<Animal> findByGroupes(Groupe groupe);
    List<Animal> findByGroupesIdGrou(Long id);
    
    List<Animal> findByOrderByNomAsc();
    List<Animal> trierAnimauxParNomEtDate(); // Correct method name
}
