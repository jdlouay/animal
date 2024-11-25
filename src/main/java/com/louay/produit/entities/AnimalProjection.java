package com.louay.produit.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nom_animal", types = { Animal.class })
public interface AnimalProjection {
    String getNom();
}
