package com.louay.produit.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.louay.produit.entities.Groupe;

public interface GroupeRepository extends JpaRepository<Groupe, Long> {

    // Find by exact name
    List<Groupe> findByNomGroupe(String nomGroupe);

    // Find by name containing a substring
    List<Groupe> findByNomGroupeContains(String partNom);

    // Find by name containing a substring (case insensitive)
    List<Groupe> findByNomGroupeContainingIgnoreCase(String partNom);

    @Query("SELECT g FROM Groupe g WHERE g.nomGroupe = :nomGroupe")
    List<Groupe> findGroupesByExactName(@Param("nomGroupe") String nomGroupe);

    @Query("SELECT g FROM Groupe g ORDER BY g.nomGroupe ASC")
    List<Groupe> findAllOrderedByNom();

    @Query("SELECT g FROM Groupe g WHERE g.nomGroupe LIKE %:partNom% ORDER BY g.idGroupe ASC")
    List<Groupe> findGroupesByPartialName(@Param("partNom") String partNom);


    // Custom query to count groups
    @Query("SELECT COUNT(g) FROM Groupe g")
    Long countAllGroupes();
}
