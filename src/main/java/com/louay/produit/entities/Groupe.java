package com.louay.produit.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Groupe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("idGroupe") // For JSON serialization/deserialization
    private Long idGroupe;

    @Column(name = "nom_groupe") // Maps to the actual database column
    @JsonProperty("nomGroupe") // For JSON serialization/deserialization
    private String nomGroupe;

    @JsonIgnore
    @OneToMany(mappedBy = "groupe")
    private List<Animal> animals; // Plural for clarity
}
