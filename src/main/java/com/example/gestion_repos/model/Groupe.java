package com.example.gestion_repos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "group")
public class Groupe {
    @Id
    private String _id;
    private String name;
    private String terminal;
    private String fonction;
    private String _idTerminal;
    private String _idFonction;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String get_idTerminal() {
        return _idTerminal;
    }

    public void set_idTerminal(String _idTerminal) {
        this._idTerminal = _idTerminal;
    }

    public String get_idFonction() {
        return _idFonction;
    }

    public void set_idFonction(String _idFonction) {
        this._idFonction = _idFonction;
    }
}
