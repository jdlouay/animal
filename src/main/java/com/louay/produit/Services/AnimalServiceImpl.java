package com.louay.produit.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.louay.produit.entities.Animal;
import com.louay.produit.entities.Groupe;
import com.louay.produit.repos.AnimalRepository;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public Animal saveAnimal(Animal p) {
        return animalRepository.save(p);
    }

    @Override
    public Animal updateAnimal(Animal p) {
        return animalRepository.save(p);
    }

    @Override
    public void deleteAnimal(Animal p) {
        animalRepository.delete(p);
    }

    @Override
    public void deleteAnimalById(Long id) {
        animalRepository.deleteById(id);
    }

    @Override
    public Animal getAnimal(Long id) {
        return animalRepository.findById(id).orElse(null);
    }

    @Override
    public List<Animal> getAllAnimal() {
        return animalRepository.findAll();
    }

    @Override
    public List<Animal> findByNom(String nom) {
        return animalRepository.findByNom(nom);
    }

    @Override
    public List<Animal> findByNomContains(String nom) {
        return animalRepository.findByNomContains(nom);
    }

    @Override
    public List<Animal> findByNomAndEspece(String nom, String espece_animal) {
        return animalRepository.findByNomAndEspece(nom, espece_animal);
    }

    @Override
    public List<Animal> findByGroupes(Groupe groupe) {
        return animalRepository.findByGroupes(groupe);
    }

    @Override
    public List<Animal> findByGroupesIdGrou(Long id) {
        return animalRepository.findByGroupesidGroupe(id);
    }

    @Override
    public List<Animal> findByOrderByNomAsc() {
        return animalRepository.findByOrderByNomAsc();
    }

    @Override
    public List<Animal> trierAnimauxParNomEtDate() {
        return animalRepository.trierAnimauxParNomEtDate();
    }
}
