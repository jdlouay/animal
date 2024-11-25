package com.louay.produit.Services;

import java.util.List;
import com.louay.produit.entities.Groupe;

public interface GroupeService {
    Groupe saveGroupe(Groupe groupe);
    Groupe updateGroupe(Groupe groupe);
    void deleteGroupe(Groupe groupe);
    void deleteGroupeById(Long id);
    Groupe getGroupe(Long id);
    List<Groupe> getAllGroupes();
}
