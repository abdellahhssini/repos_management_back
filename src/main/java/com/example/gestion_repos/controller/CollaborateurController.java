package com.example.gestion_repos.controller;

import com.example.gestion_repos.model.Collaborateur;
import com.example.gestion_repos.services.CollaborateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/collaborateur")
public class CollaborateurController {
    private CollaborateurService collaborateurService;

    public CollaborateurController(CollaborateurService collaborateurService) {
        this.collaborateurService = collaborateurService;
    }

    @GetMapping("/findByTerminal/{_idTerminal}")
    public List<Collaborateur> getCollaborateursByTerminal(@PathVariable String _idTerminal){
        return collaborateurService.findCollaborateursByTerminal(_idTerminal);
    }

    @GetMapping("/findByFonction/{_idFonction}")
    public List<Collaborateur> getCollaborateursByFonction(@PathVariable String _idFonction){
        return collaborateurService.findCollaborateursByFonction(_idFonction);
    }

    @GetMapping("/findByGroupe/{_idGroupe}")
    public List<Collaborateur> getCollaborateursByGroupe(@PathVariable String _idGroupe){
        return collaborateurService.findCollaborateursByGroupe(_idGroupe);
    }

    @GetMapping("/findByAbsence/{_idAbsence}")
    public Collaborateur getCollaborateursByAbsence(@PathVariable String _idAbsence){
        return collaborateurService.findCollaborateursByAbsence(_idAbsence);
    }

    @GetMapping("/findBySousGroupe/{_idSousGroupe}")
    public List<Collaborateur> getCollaborateursBySousGroupe(@PathVariable String _idSousGroupe){
        return collaborateurService.findCollaborateursBySousGroupe(_idSousGroupe);
    }

    @GetMapping("/search")
    public List<Collaborateur> getCollaborateursByMatricule(@RequestParam(required = false) String matricule){
        if(StringUtils.isEmpty(matricule)){
            return collaborateurService.getAllCollaborateur();
        }

        return collaborateurService.findCollaborateurByMatricule(matricule);
    }

    @GetMapping("/all")
    public List<Collaborateur> getAll(){
        return collaborateurService.getAllCollaborateur();
    }

    @PostMapping("/add")
    public Map<String, String> save(@RequestBody Collaborateur newCollaborateur){
        Map<String, String> response = new HashMap<>();
        response.put("_id", collaborateurService.save(newCollaborateur));
        return response;
    }

    @PutMapping("/edit/{_id}")
    public void update(@PathVariable String _id, @RequestBody Collaborateur newCollaborateur){
        Optional<Collaborateur> collaborateur = collaborateurService.findById(_id);
        if(collaborateur.isPresent()){
            collaborateurService.update(_id, newCollaborateur);
        } else {
            collaborateurService.save(newCollaborateur);
        }
    }

    @GetMapping("/get/{_id}")
    public ResponseEntity<Collaborateur> postResponseEntity(@PathVariable String _id){
        Optional<Collaborateur> collaborateur = collaborateurService.findById(_id);
        return collaborateur.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{_id}")
    public void delete(@PathVariable String _id){
        collaborateurService.delete(_id);
    }
}
