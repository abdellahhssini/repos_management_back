package com.example.gestion_repos.controller;

import com.example.gestion_repos.model.Fonction;
import com.example.gestion_repos.services.FonctionService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/fonction")
public class FonctionController {
    private FonctionService fonctionService;

    public FonctionController(FonctionService fonctionService) {
        this.fonctionService = fonctionService;
    }

    @GetMapping("/all")
    public List<Fonction> getAll(){
        return fonctionService.getAllFonction();
    }

    @PostMapping("/add")
    public Map<String, String> save(@RequestBody Fonction newFonction){
        Map<String, String> response = new HashMap<>();
        response.put("_id", fonctionService.save(newFonction));
        return response;
    }

    @DeleteMapping("/delete/{_id}")
    public void delete(@PathVariable String _id){
        fonctionService.delete(_id);
    }
}
