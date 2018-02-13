/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.saver;

import java.util.HashSet;

/**
 *
 * @author AZARIA
 * @param <T>
 */
public abstract class  ModelSaver <T> {
    
    private HashSet<T> data=new HashSet<>();

    public HashSet<T> getData() {
        return data;
    }

    public void setData(HashSet<T> data) {
        this.data = data;
    }
    
    public abstract void rechercher();
    /*
    *methode pour verifier si une donner existe par son id
    */
    public abstract boolean isThere(int id);
    /*
    *recupere des données par un attribut quelconque
    *en specifiant l'attribut de recherche et sa valeur
    */
    public abstract HashSet<T> fetchBy(String attribut,Object valeur);
    /*
    *recupere une donnée en fonction de son id
    */
    public abstract T fetchById(int id);
    
}
