package com.example.gestion_repos.services;

import com.example.gestion_repos.model.Terminal;
import com.example.gestion_repos.repository.TerminalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TerminalService {
    @Autowired
    private TerminalRepository terminalRepository;

    public TerminalService(TerminalRepository terminalRepository) {
        this.terminalRepository = terminalRepository;
    }

    public List<Terminal> getAllTerminal(){
        return this.terminalRepository.findAll();
    }

    public List<Terminal> findTerminalByNom(String nom){
        return terminalRepository.findTerminalByNom(nom);
    }

    public String save(Terminal newterminal){
        Terminal terminal = new Terminal();

        terminal.set_id(newterminal.get_id());
        terminal.setNom(newterminal.getNom());

        return terminalRepository.save(terminal).get_id();
    }

    public void delete(String _id){
        Optional<Terminal> terminal = findById(_id);
        if(terminal.isPresent()){
            terminalRepository.delete(terminal.get());
        }
    }

    public Optional<Terminal> findById(String _id){
        return terminalRepository.findById(_id);
    }
}
