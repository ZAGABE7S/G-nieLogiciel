/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.saver;

import com.model.entities.Transactions;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author AZARIA
 */
public class TransactionsSaver extends ModelSaver<Transactions> {

    @Override
    public void rechercher() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isThere(int id) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        boolean v=false;
        for (Transactions cmp : this.getData()) {
            if(Transactions.getId()==id){
                v=true;
                break;
            }
        }
        return v;
    }

    @Override
    public HashSet<Transactions> fetchBy(String attribut, Object valeur) {
        HashSet<Transactions> cls=new HashSet<>();
        this.getData().forEach((Transactions cl) -> {
            try{
                if(cl.getClass().getMethod(attribut).equals(valeur))
                    cls.add(cl);
            }
            catch(NoSuchMethodException | SecurityException ex){
                
            }
        });
        return cls;
    }

    @Override
    public Transactions fetchById(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          Transactions clt=null;
       for(Transactions cl:this.getData()){
           if(Transactions.getId()==id)
               clt= cl;
       }
       return clt;
    }
    public List<Transactions> fetchByTransactionsByComptes(List numero){
        
        List<Transactions> transactions=new LinkedList();
        numero.forEach((num) -> {
            this.getData().forEach((cmp1)->{
                if(cmp1.getCompte().getNumCompte()==Long.parseLong((String) num))
                   transactions.add(cmp1);
            });
        });
       
        return transactions;
    }
}
