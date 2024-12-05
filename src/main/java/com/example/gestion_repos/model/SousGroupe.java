package com.example.gestion_repos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sousgroupe")
public class SousGroupe {
    @Id
    private String _id;
    private String name;
    private String _idGroupe;

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

    public String get_idGroupe() {
        return _idGroupe;
    }

    public void set_idGroupe(String _idGroupe) {
        this._idGroupe = _idGroupe;
    }
}
