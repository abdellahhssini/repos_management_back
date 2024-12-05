package com.example.gestion_repos.repository;

import com.example.gestion_repos.model.Groupe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GroupeRepository extends MongoRepository<Groupe, String> {
    List<Groupe> findBy_idTerminal(String _idTerminal);
    List<Groupe> findBy_idFonction(String _idFonction);
}
