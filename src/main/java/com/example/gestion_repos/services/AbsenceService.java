package com.example.gestion_repos.services;

import com.example.gestion_repos.model.Absence;
import com.example.gestion_repos.repository.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbsenceService {
    @Autowired
    private AbsenceRepository absenceRepository;

    public AbsenceService(AbsenceRepository absenceRepository) {
        this.absenceRepository = absenceRepository;
    }

    public List<Absence> gelAllAbsence(){
        return this.absenceRepository.findAll();
    }

    public String save(Absence newAbsence){
        Absence absence = new Absence();

        absence.set_id(newAbsence.get_id());
        absence.setDateDebut(newAbsence.getDateDebut());
        absence.setDateFin(newAbsence.getDateFin());
        absence.setMotif(newAbsence.getMotif());

        return absenceRepository.save(absence).get_id();
    }

    public void update(String _id, Absence newAbsence){
        Optional<Absence> absence = findById(_id);
        if(absence.isPresent()){
            Absence forUpdate = absence.get();

            forUpdate.setDateDebut(newAbsence.getDateDebut());
            forUpdate.setDateFin(newAbsence.getDateFin());
            forUpdate.setMotif(newAbsence.getMotif());

            absenceRepository.save(forUpdate);
        }
    }

    public void delete(String _id){
        Optional<Absence> absence = findById(_id);
        if(absence.isPresent()){
            absenceRepository.delete(absence.get());
        }
    }

    public Optional<Absence> findById(String _id){
        return absenceRepository.findById(_id);
    }
}
