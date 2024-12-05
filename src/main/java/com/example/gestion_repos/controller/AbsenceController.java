package com.example.gestion_repos.controller;

import com.example.gestion_repos.model.Absence;
import com.example.gestion_repos.services.AbsenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/absence")
public class AbsenceController {
    private AbsenceService absenceService;

    public AbsenceController(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }

    @GetMapping("/all")
    public List<Absence> getAll(){
        return absenceService.gelAllAbsence();
    }

    @PostMapping("/add")
    public Map<String, String> save(@RequestBody Absence newAbsence){
        Map<String, String> response = new HashMap<>();
        response.put("_id", absenceService.save(newAbsence));
        return response;
    }

    @PutMapping("/edit/{_id}")
    public void update(@PathVariable String _id, @RequestBody Absence newAbsence){
        Optional<Absence> absence = absenceService.findById(_id);
        if(absence.isPresent()){
            absenceService.update(_id, newAbsence);
        } else {
            absenceService.save(newAbsence);
        }
    }

    @GetMapping("/get/{_id}")
    public ResponseEntity<Absence> postResponseEntity(@PathVariable String _id){
        Optional<Absence> absence = absenceService.findById(_id);
        return absence.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{_id}")
    public void delete(@PathVariable String _id){
        absenceService.delete(_id);
    }
}
