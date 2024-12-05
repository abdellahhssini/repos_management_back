package com.example.gestion_repos.repository;

import com.example.gestion_repos.model.Absence;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbsenceRepository extends MongoRepository<Absence, String> {

}
