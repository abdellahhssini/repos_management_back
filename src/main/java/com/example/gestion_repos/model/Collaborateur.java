package com.example.gestion_repos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "collaborateurs")
public class Collaborateur {
    @Id
    private String _id;
    private String matricule;
    private String nom;
    private String prenom;
    private String terminal;
    private String fonction;
    private String statut;
    private String _idTerminal;
    private String _idFonction;
    private String _idGroupe;
    private String _idAbsence;
    private String _idSousGroupe;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
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

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
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

    public String get_idGroupe() {
        return _idGroupe;
    }

    public void set_idGroupe(String _idGroupe) {
        this._idGroupe = _idGroupe;
    }

    public String get_idAbsence() {
        return _idAbsence;
    }

    public void set_idAbsence(String _idAbsence) {
        this._idAbsence = _idAbsence;
    }

    public String get_idSousGroupe() {
        return _idSousGroupe;
    }

    public void set_idSousGroupe(String _idSousGroupe) {
        this._idSousGroupe = _idSousGroupe;
    }
}
