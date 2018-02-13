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
public class Comptes {
    
    private static int id=0;
    private long numCompte=0;
    private double solde=0;
    private Clients titulaire=new Clients();
    private Gestionnaires gestionnaire=new Gestionnaires();
    private TypeComptes type=new TypeComptes();

    public Comptes() {
        Comptes.id=Comptes.id+1;
    }
    
    
    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Comptes.id = id;
    }

    public long getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(long numCompte) {
        this.numCompte = numCompte;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Clients getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(Clients titulaire) {
        this.titulaire = titulaire;
    }

    public Gestionnaires getGestionnaire() {
        return gestionnaire;
    }

    public void setGestionnaire(Gestionnaires gestionnaire) {
        this.gestionnaire = gestionnaire;
    }

    public TypeComptes getType() {
        return type;
    }

    public void setType(TypeComptes type) {
        this.type = type;
    }
    
    
    
}
