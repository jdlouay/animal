package com.louay.produit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.louay.produit.entities.Animal;
import com.louay.produit.entities.Groupe;

@SpringBootApplication
public class AnimalApplication implements CommandLineRunner {

    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(AnimalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Expose entity IDs in REST responses for specified entities
    	repositoryRestConfiguration.exposeIdsFor(Animal.class, Groupe.class);

        // Optional: Log a message when the application starts
        System.out.println("Application started successfully. Entity IDs are now exposed in REST responses.");
    }
}
