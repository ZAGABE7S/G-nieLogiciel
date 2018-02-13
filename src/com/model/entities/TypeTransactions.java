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
public class TypeTransactions {
    
    private static int id=0;
    private String libele="";

    public TypeTransactions() {
        TypeTransactions.id=TypeTransactions.id+1;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        TypeTransactions.id = id;
    }

    public String getLibele() {
        return libele;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }
    
    
    
}
