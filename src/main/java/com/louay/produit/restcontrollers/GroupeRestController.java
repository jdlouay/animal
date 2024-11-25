package com.louay.produit.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.louay.produit.Services.GroupeService;
import com.louay.produit.entities.Groupe;

@RestController
@RequestMapping("/api/groupes")
@CrossOrigin(origins = "http://localhost:4200")
public class GroupeRestController {

    @Autowired
    private GroupeService groupeService;

    @GetMapping
    public List<Groupe> getAllGroupes() {
        return groupeService.getAllGroupes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Groupe> getGroupeById(@PathVariable("id") Long id) {
        Groupe groupe = groupeService.getGroupe(id);
        if (groupe == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(groupe);
    }

    @PostMapping
    public ResponseEntity<Groupe> createGroupe(@RequestBody Groupe groupe) {
        try {
            Groupe savedGroupe = groupeService.saveGroupe(groupe);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedGroupe);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<Groupe> updateGroupe(@RequestBody Groupe groupe) {
        try {
            Groupe updatedGroupe = groupeService.updateGroupe(groupe);
            return ResponseEntity.ok(updatedGroupe);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGroupeById(@PathVariable Long id) {
        try {
            groupeService.deleteGroupeById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
