package com.example.gestion_repos.controller;

import com.example.gestion_repos.model.Groupe;
import com.example.gestion_repos.services.GroupeService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/groupe")
public class GroupeController {
    private GroupeService groupeService;

    public GroupeController(GroupeService groupeService) {
        this.groupeService = groupeService;
    }

    @GetMapping("/all")
    public List<Groupe> getAll(){
        return groupeService.getAllGroupe();
    }

    @GetMapping("/findByTerminal/{_idTerminal}")
    public List<Groupe> getGroupeByTerminal(@PathVariable String _idTerminal){
        return groupeService.findGroupeByTerminal(_idTerminal);
    }

    @GetMapping("/findByFonction/{_idFonction}")
    public List<Groupe> getGroupeByFonction(@PathVariable String _idFonction){
        return groupeService.findGroupeByFonction(_idFonction);
    }

    @PostMapping("/add")
    public Map<String, String> save(@RequestBody Groupe newGroupe){
        Map<String, String> response = new HashMap<>();
        response.put("_id", groupeService.save(newGroupe));
        return response;
    }

    @DeleteMapping("/delete/{_id}")
    public void delete(@PathVariable String _id){
        groupeService.delete(_id);
    }
}
