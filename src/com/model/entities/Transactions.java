/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.entities;

import java.util.Date;

/**
 *
 * @author AZARIA
 */
public class Transactions {
    
    private static int id=0;
    private double montant=0;
    private Date dateT;
    //private TypeTransactions typeT=new TypeTransactions();
    private String type="";
    private Gestionnaires agent=new Gestionnaires();
    private Clients titulaire=new Clients();
    private Comptes compte= new Comptes();

    public Transactions(Date dateT) {
        this.dateT = new Date();
        Transactions.id=Transactions.id+1;
    }

    public Transactions() {
        Transactions.id=Transactions.id+1;
        this.dateT = new Date();
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Transactions.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDateT() {
        return dateT;
    }

    public void setDateT(Date dateT) {
        this.dateT = dateT;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

  

    public Gestionnaires getAgent() {
        return agent;
    }

    public void setAgent(Gestionnaires agent) {
        this.agent = agent;
    }

    public Clients getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(Clients titulaire) {
        this.titulaire = titulaire;
    }

    public Comptes getCompte() {
        return compte;
    }

    public void setCompte(Comptes compte) {
        this.compte = compte;
    }
    
    
    
}
