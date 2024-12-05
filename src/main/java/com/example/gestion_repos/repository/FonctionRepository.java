package com.example.gestion_repos.repository;

import com.example.gestion_repos.model.Fonction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FonctionRepository extends MongoRepository<Fonction, String> {
    List<Fonction> findFonctionByNom(String nom);
}
