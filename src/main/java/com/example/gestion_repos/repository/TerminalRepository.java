package com.example.gestion_repos.repository;

import com.example.gestion_repos.model.Terminal;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TerminalRepository extends MongoRepository<Terminal, String> {
    List<Terminal> findTerminalByNom(String nom);
}
