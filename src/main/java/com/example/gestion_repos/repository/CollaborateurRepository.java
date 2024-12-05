package com.example.gestion_repos.repository;

import com.example.gestion_repos.model.Collaborateur;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollaborateurRepository extends MongoRepository<Collaborateur, String> {
    List<Collaborateur> findCollaborateurByMatricule(String matricule);
    List<Collaborateur> findBy_idTerminal(String _idTerminal);
    List<Collaborateur> findBy_idFonction(String _idFonction);
    List<Collaborateur> findBy_idGroupe(String _idGroupe);
    Collaborateur findBy_idAbsence(String _idAbsence);
    List<Collaborateur> findBy_idSousGroupe(String _idSousGroupe);
}
