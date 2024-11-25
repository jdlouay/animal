package com.louay.produit.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.louay.produit.entities.Animal;
import com.louay.produit.entities.Groupe;

@RepositoryRestResource(path = "rest")
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    List<Animal> findByNom(String nom);

    List<Animal> findByNomContains(String nom);

    @Query("select a from Animal a where a.nom like %:nom% and a.especeAnimal = :especeAnimal")
    List<Animal> findByNomAndEspece(@Param("nom") String nom, @Param("especeAnimal") String especeAnimal);

    @Query("select a from Animal a where a.groupe = ?1")
    List<Animal> findByGroupes(Groupe groupe);

    @Query("select a from Animal a where a.groupe.idGroupe = ?1")
    List<Animal> findByGroupesidGroupe(Long id);

    List<Animal> findByOrderByNomAsc();

    @Query("select a from Animal a order by a.nom ASC, a.dateNaissance DESC")
    List<Animal> trierAnimauxParNomEtDate();
}

