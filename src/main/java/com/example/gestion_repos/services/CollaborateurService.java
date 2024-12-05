package com.example.gestion_repos.services;

import com.example.gestion_repos.model.Collaborateur;
import com.example.gestion_repos.repository.CollaborateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CollaborateurService {
    @Autowired
    private CollaborateurRepository collaborateurRepository;

    public CollaborateurService(CollaborateurRepository collaborateurRepository) {
        this.collaborateurRepository = collaborateurRepository;
    }

    public List<Collaborateur> getAllCollaborateur(){
        return this.collaborateurRepository.findAll();
    }

    public List<Collaborateur> findCollaborateursByTerminal(String _idTerminal){
        return collaborateurRepository.findBy_idTerminal(_idTerminal);
    }

    public List<Collaborateur> findCollaborateursByFonction(String _idFonction){
        return collaborateurRepository.findBy_idFonction(_idFonction);
    }

    public List<Collaborateur> findCollaborateursByGroupe(String _idGroupe){
        return collaborateurRepository.findBy_idGroupe(_idGroupe);
    }

    public Collaborateur findCollaborateursByAbsence(String _idAbsence){
        return collaborateurRepository.findBy_idAbsence(_idAbsence);
    }

    public List<Collaborateur> findCollaborateursBySousGroupe(String _idSousGroupe){
        return collaborateurRepository.findBy_idSousGroupe(_idSousGroupe);
    }

    public List<Collaborateur> findCollaborateurByMatricule(String matricule){
        return collaborateurRepository.findCollaborateurByMatricule(matricule);
    }

    public String save(Collaborateur newCollaborateur){
        Collaborateur collaborateur = new Collaborateur();

        collaborateur.set_id(newCollaborateur.get_id());
        collaborateur.setMatricule(newCollaborateur.getMatricule());
        collaborateur.setNom(newCollaborateur.getNom());
        collaborateur.setPrenom(newCollaborateur.getPrenom());
        collaborateur.setTerminal(newCollaborateur.getTerminal());
        collaborateur.setFonction(newCollaborateur.getFonction());
        collaborateur.setStatut(newCollaborateur.getStatut());
        collaborateur.set_idTerminal(newCollaborateur.get_idTerminal());
        collaborateur.set_idFonction(newCollaborateur.get_idFonction());
        collaborateur.set_idGroupe(newCollaborateur.get_idGroupe());
        collaborateur.set_idAbsence(newCollaborateur.get_idAbsence());
        collaborateur.set_idSousGroupe(newCollaborateur.get_idSousGroupe());

        return collaborateurRepository.save(collaborateur).get_id();
    }

    public void update(String _id, Collaborateur newCollaborateur){
        Optional<Collaborateur> collaborateur = findById(_id);
        if(collaborateur.isPresent()){
            Collaborateur forUpdate = collaborateur.get();

            forUpdate.setMatricule(newCollaborateur.getMatricule());
            forUpdate.setNom(newCollaborateur.getNom());
            forUpdate.setPrenom(newCollaborateur.getPrenom());
            forUpdate.setTerminal(newCollaborateur.getTerminal());
            forUpdate.setFonction(newCollaborateur.getFonction());
            forUpdate.setStatut(newCollaborateur.getStatut());
            forUpdate.set_idTerminal(newCollaborateur.get_idTerminal());
            forUpdate.set_idFonction(newCollaborateur.get_idFonction());
            forUpdate.set_idGroupe(newCollaborateur.get_idGroupe());
            forUpdate.set_idAbsence(newCollaborateur.get_idAbsence());
            forUpdate.set_idSousGroupe(newCollaborateur.get_idSousGroupe());

            collaborateurRepository.save(forUpdate);
        }
    }

    public void delete(String _id){
        Optional<Collaborateur> collaborateur = findById(_id);
        if(collaborateur.isPresent()){
            collaborateurRepository.delete(collaborateur.get());
        }
    }

    public Optional<Collaborateur> findById(String _id){
        return collaborateurRepository.findById(_id);
    }
}
