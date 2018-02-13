/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.saver;

import com.model.entities.Clients;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AZARIA
 */
public class ClientsSaver extends ModelSaver<Clients>{

    @Override
    public void rechercher() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isThere(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       boolean v=false;
        for (Clients clients : this.getData()) {
            if(clients.getId()==id){
                v=true;
                break;
            }
        }
        return v;
    }
    public boolean isy(){
        System.out.println("execution****");
        boolean t=false;
        try{
            this.getClass().getMethod("isy");
            System.out.println(this.getClass().getMethod("isy").toString());
            t=true;
        }
        catch(NoSuchMethodException no){
            System.out.println("la methode n'existe pas!!!");
            t=false;
        }
        return t;
    }

    @Override
    public HashSet<Clients> fetchBy(String attribut, Object valeur) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        HashSet<Clients> cls=new HashSet<>();
        this.getData().forEach((Clients cl) -> {
            try{
                System.out.println("travaille en cours...");
                Object c=cl.getClass().getMethod(attribut).invoke(cl);
                if(c.equals(valeur))
                    cls.add(cl);
            }
            catch(NoSuchMethodException | SecurityException ex){
                
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(ClientsSaver.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        return cls;
        
    }

    @Override
    public Clients fetchById(int id) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       /*
       *initialise un client pour retourner le resultat
       */
       Clients clt=null;
       for(Clients cl:this.getData()){
           if(cl.getId()==id)
               clt= cl;
       }
       return clt;
    }
    
}
