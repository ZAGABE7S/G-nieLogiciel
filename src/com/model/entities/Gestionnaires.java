/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.entities;

/**
 *
 * @author AZARIA
 */
public class Gestionnaires {
    
    private static int cid=0;
    private int id=0;
    private String nom="";
    private String postnom="";
    private String prenom="";
    private String sexe="M";
    private String numMat;

    public Gestionnaires() {
        Gestionnaires.cid=Gestionnaires.cid+1;
        this.id=Gestionnaires.cid;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPostnom() {
        return postnom;
    }

    public void setPostnom(String postnom) {
        this.postnom = postnom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getNumMat() {
        return numMat;
    }

    public void setNumMat(String numMat) {
        this.numMat = numMat;
    }
    
}
