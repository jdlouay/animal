package com.louay.produit.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("idAnimal") // For JSON serialization
    private Long idAnimal;

    @JsonProperty("nomAnimal")
    private String nom;

    @JsonProperty("especeAnimal")
    private String especeAnimal;

    @JsonProperty("dateNaissance")
    private Date dateNaissance;

    private String email;

    @ManyToOne
    private Groupe groupe;

    public Animal() {}

    public Animal(String nom, String especeAnimal, Date dateNaissance, String email) {
        this.nom = nom;
        this.especeAnimal = especeAnimal;
        this.dateNaissance = dateNaissance;
        this.email = email;
    }

    public Long getIdAnimal() {
        return idAnimal;
    }

    public void setIdAnimal(Long idAnimal) {
        this.idAnimal = idAnimal;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEspeceAnimal() {
        return especeAnimal;
    }

    public void setEspeceAnimal(String especeAnimal) {
        this.especeAnimal = especeAnimal;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    @Override
    public String toString() {
        return "Animal [idAnimal=" + idAnimal + ", nom=" + nom + ", especeAnimal=" + especeAnimal
                + ", dateNaissance=" + dateNaissance + ", email=" + email + "]";
    }
}
