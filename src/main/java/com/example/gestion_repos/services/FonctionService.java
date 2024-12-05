package com.example.gestion_repos.services;

import com.example.gestion_repos.model.Fonction;
import com.example.gestion_repos.repository.FonctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FonctionService {
    @Autowired
    private FonctionRepository fonctionRepository;

    public FonctionService(FonctionRepository fonctionRepository) {
        this.fonctionRepository = fonctionRepository;
    }

    public List<Fonction> getAllFonction(){
        return this.fonctionRepository.findAll();
    }

    public List<Fonction> findFonctionByName(String nom){
        return fonctionRepository.findFonctionByNom(nom);
    }

    public String save(Fonction newFonction){
        Fonction fonction = new Fonction();

        fonction.set_id(newFonction.get_id());
        fonction.setNom(newFonction.getNom());

        return fonctionRepository.save(fonction).get_id();
    }

    public void delete(String _id){
        Optional<Fonction> fonction = findById(_id);
        if(fonction.isPresent()){
            fonctionRepository.delete(fonction.get());
        }
    }

    public Optional<Fonction> findById(String _id){
        return fonctionRepository.findById(_id);
    }
}
