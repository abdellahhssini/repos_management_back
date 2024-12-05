package com.example.gestion_repos.controller;

import com.example.gestion_repos.model.SousGroupe;
import com.example.gestion_repos.services.SousGroupeService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/sousgroupe")
public class SousGroupeController {
    private SousGroupeService sousGroupeService;

    public SousGroupeController(SousGroupeService sousGroupeService) {
        this.sousGroupeService = sousGroupeService;
    }

    @GetMapping("/all")
    public List<SousGroupe> getAll(){
        return sousGroupeService.getAllSousGroupes();
    }

    @GetMapping("/findByGroupe/{_idGroupe}")
    public List<SousGroupe> getSousGroupesByGroupe(@PathVariable String _idGroupe){
        return sousGroupeService.findSousGroupesByGroupe(_idGroupe);
    }

    @PostMapping("/add")
    public Map<String, String> save(@RequestBody SousGroupe newSousGroupe){
        Map<String, String> response = new HashMap<>();
        response.put("_id", sousGroupeService.save(newSousGroupe));
        return response;
    }

    @DeleteMapping("/delete/{_id}")
    public void delete(@PathVariable String _id){
        sousGroupeService.delete(_id);
    }
}
