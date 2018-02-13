/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.saver;

import com.model.entities.Comptes;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.ir.BreakNode;

/**
 *
 * @author AZARIA
 */
public class ComptesSaver  extends ModelSaver<Comptes>{

    @Override
    public void rechercher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
     public boolean isThere(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       boolean v=false;
        for (Comptes cmp : this.getData()) {
            if(Comptes.getId()==id){
                v=true;
                break;
            }
        }
        return v;
    }

    @Override
    public HashSet<Comptes> fetchBy(String attribut, Object valeur) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         HashSet<Comptes> cls=new HashSet<>();
        this.getData().forEach((Comptes cl) -> {
            try{
                System.out.println("travaille en cours...");
                Object c=cl.getClass().getMethod(attribut).invoke(cl);
                if(c.equals(valeur))
                    cls.add(cl);
            }
            catch(NoSuchMethodException | SecurityException ex){
                
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                 Logger.getLogger(ComptesSaver.class.getName()).log(Level.SEVERE, null, ex);
             }
        });
        return cls;
    }

    @Override
    public Comptes fetchById(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Comptes clt=null;
       for(Comptes cl:this.getData()){
           if(Comptes.getId()==id)
               clt= cl;
       }
       return clt;
    }
    
    public List<Comptes> fetchByCompte(List numero){
        
        List<Comptes> cmptes=new LinkedList();
        numero.forEach((num) -> {
            this.getData().forEach((cmp1)->{
                if(cmp1.getNumCompte()==Long.parseLong((String) num))
                    cmptes.add(cmp1);
            });
        });
       
        return cmptes;
    }
    public void update(Comptes cmp){
        this.getData().forEach((Comptes cmp1)->{
            if(cmp1.getNumCompte()==cmp.getNumCompte()){
                cmp1=cmp;
            }
        });
    }
    public void voir(String str){
        try{
            this.getClass().getMethod(str).invoke(this,null);
            
            
        }
        catch(Exception v){
            v.printStackTrace();
        }
        
    }
    public void display(){
        System.out.println("je suis une fonnction!!!");
    }
    
}
