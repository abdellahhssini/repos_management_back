package com.example.gestion_repos.repository;

import com.example.gestion_repos.model.SousGroupe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SousGroupeRepository extends MongoRepository<SousGroupe, String> {
    List<SousGroupe> findBy_idGroupe(String _idGroupe);
}
