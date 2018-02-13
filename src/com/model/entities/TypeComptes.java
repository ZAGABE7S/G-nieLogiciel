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
public class TypeComptes {
    
    private static int id=0;
    private String libele="";
    private double taux=0.00;

    public TypeComptes() {
        TypeComptes.id=TypeComptes.id+1;
    }
    

    public int getId() {
        return TypeComptes.id;
    }

    public void setId(int id) {
        TypeComptes.id = id;
    }

    public String getLibele() {
        return libele;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
    
}
