package com.example.gestion_repos.controller;

import com.example.gestion_repos.model.Terminal;
import com.example.gestion_repos.services.TerminalService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/terminal")
public class TerminalController {
    private TerminalService terminalService;

    public TerminalController(TerminalService terminalService) {
        this.terminalService = terminalService;
    }

    @GetMapping("/all")
    public List<Terminal> getAll(){
        return terminalService.getAllTerminal();
    }

    @PostMapping("/add")
    public Map<String, String> save(@RequestBody Terminal newTerminal){
        Map<String, String> response = new HashMap<>();
        response.put("_id", terminalService.save(newTerminal));
        return response;
    }

    @DeleteMapping("/delete/{_id}")
    public void delete(@PathVariable String _id){
        terminalService.delete(_id);
    }
}
