package com.example.gestion_repos.services;

import com.example.gestion_repos.model.Groupe;
import com.example.gestion_repos.repository.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupeService {
    @Autowired
    private GroupeRepository groupeRepository;

    public GroupeService(GroupeRepository groupeRepository) {
        this.groupeRepository = groupeRepository;
    }

    public List<Groupe> getAllGroupe(){
        return this.groupeRepository.findAll();
    }

    public List<Groupe> findGroupeByTerminal(String _idTerminal){
        return groupeRepository.findBy_idTerminal(_idTerminal);
    }

    public List<Groupe> findGroupeByFonction(String _idFonction){
        return groupeRepository.findBy_idFonction(_idFonction);
    }

    public String save(Groupe newGroupe){
        Groupe groupe = new Groupe();

        groupe.set_id(newGroupe.get_id());
        groupe.setName(newGroupe.getName());
        groupe.setTerminal(newGroupe.getTerminal());
        groupe.setFonction(newGroupe.getFonction());
        groupe.set_idTerminal(newGroupe.get_idTerminal());
        groupe.set_idFonction(newGroupe.get_idFonction());

        return groupeRepository.save(groupe).get_id();
    }

    public void delete(String _id){
        Optional<Groupe> groupe = findById(_id);
        if(groupe.isPresent()){
            groupeRepository.delete(groupe.get());
        }
    }

    public Optional<Groupe> findById(String _id){
        return groupeRepository.findById(_id);
    }
}
