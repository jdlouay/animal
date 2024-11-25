package com.louay.produit.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.louay.produit.entities.Groupe;
import com.louay.produit.repos.GroupeRepository;

@Service
public class GroupeServiceImpl implements GroupeService {

    @Autowired
    private GroupeRepository groupeRepository;

    @Override
    public Groupe saveGroupe(Groupe groupe) {
        return groupeRepository.save(groupe);
    }

    @Override
    public Groupe updateGroupe(Groupe groupe) {
        return groupeRepository.save(groupe);
    }

    @Override
    public void deleteGroupe(Groupe groupe) {
        groupeRepository.delete(groupe);
    }

    @Override
    public void deleteGroupeById(Long id) {
        groupeRepository.deleteById(id);
    }

    @Override
    public Groupe getGroupe(Long id) {
        return groupeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Groupe> getAllGroupes() {
        return groupeRepository.findAll();
    }
}
