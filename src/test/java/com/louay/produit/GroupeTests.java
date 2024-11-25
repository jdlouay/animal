package com.louay.produit;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.louay.produit.entities.Groupe;
import com.louay.produit.repos.GroupeRepository;

@SpringBootTest
public class GroupeTests {

    @Autowired
    private GroupeRepository groupeRepository;

    @Test
    public void testCreateGroupe() {
        Groupe groupe = new Groupe();
        groupe.setNomGroupe("Mammifères");
        Groupe savedGroupe = groupeRepository.save(groupe);

        assertNotNull(savedGroupe.getIdGroupe());
        assertEquals("Mammifères", savedGroupe.getNomGroupe());
    }

    @Test
    public void testFindGroupeById() {
        Groupe groupe = groupeRepository.findById(1L).orElse(null);
        assertNotNull(groupe);
        assertEquals(1L, groupe.getIdGroupe());
    }

    @Test
    public void testUpdateGroupe() {
        Groupe groupe = groupeRepository.findById(1L).orElse(null);
        assertNotNull(groupe);
        groupe.setNomGroupe("Oiseaux Volants");
        Groupe updatedGroupe = groupeRepository.save(groupe);

        assertEquals("Oiseaux Volants", updatedGroupe.getNomGroupe());
    }

    @Test
    public void testDeleteGroupe() {
        groupeRepository.deleteById(1L);
        System.out.println("Deleted group with ID 1.");
    }

    @Test
    public void testListAllGroupes() {
        List<Groupe> groupes = groupeRepository.findAll();
        System.out.println("All groups:");
        groupes.forEach(System.out::println);
    }
}
