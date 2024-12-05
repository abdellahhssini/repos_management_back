package com.example.gestion_repos.services;

import com.example.gestion_repos.model.SousGroupe;
import com.example.gestion_repos.repository.SousGroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SousGroupeService {
    @Autowired
    private SousGroupeRepository sousGroupeRepository;

    public SousGroupeService(SousGroupeRepository sousGroupeRepository) {
        this.sousGroupeRepository = sousGroupeRepository;
    }

    public List<SousGroupe> getAllSousGroupes(){
        return this.sousGroupeRepository.findAll();
    }

    public List<SousGroupe> findSousGroupesByGroupe(String _idGroupe){
        return sousGroupeRepository.findBy_idGroupe(_idGroupe);
    }

    public String save(SousGroupe newSousGroupe){
        SousGroupe sousGroupe = new SousGroupe();

        sousGroupe.set_id(newSousGroupe.get_id());
        sousGroupe.setName(newSousGroupe.getName());
        sousGroupe.set_idGroupe(newSousGroupe.get_idGroupe());

        return sousGroupeRepository.save(sousGroupe).get_id();
    }

    public void delete(String _id){
        Optional<SousGroupe> sousGroupe = findById(_id);
        if (sousGroupe.isPresent()){
            sousGroupeRepository.delete(sousGroupe.get());
        }
    }

    public Optional<SousGroupe> findById(String _id){
        return sousGroupeRepository.findById(_id);
    }
}
