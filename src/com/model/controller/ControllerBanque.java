/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.controller;

import com.model.entities.Clients;
import com.model.entities.Comptes;
import com.model.entities.Gestionnaires;
import com.model.entities.Transactions;
import com.model.entities.TypeComptes;
import com.model.saver.ClientsSaver;
import com.model.saver.ComptesSaver;
import com.model.saver.TransactionsSaver;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author AZARIA
 */
public class ControllerBanque {
    private final Gestionnaires gestionnaire=new Gestionnaires();
    private final List<TypeComptes> typecomptes=new LinkedList();
    private final ComptesSaver cmpSaver=new ComptesSaver();
    private final ClientsSaver clSaver=new ClientsSaver();
    private final TransactionsSaver trsvr;
    private int cnt=100;
    private int y=0;

    public ControllerBanque() {
        this.trsvr = new TransactionsSaver();
    }
    
    public void process(Scanner in){
        /*
        *on recupère la reponse de l'utilisateur 
        *et on commence le traitement*
        *******************************
        */
        this.init();
        String rep=(String)this.input("string","VEUILLEZ CHOISIR UNE OPTION DE MENU", in);
        System.out.println(rep);
        switch(rep){
            case "1":
                this.creation(in);
                break;
            case "2":
                this.consultation(in);
                break;
            case "3":
                //System.out.println("vous avez choisit l");
                this.crediter(in);
                break;
            case "4":
                this.debiter(in);
                break;
            case "5":
                this.calculInteret();
                this.process(in);
                break;
            case "6":
                this.rechercher(in);
                break;
            case "7":
                this.rapport(in);
                break;
            default:
                System.out.println("AUTRE/QUITTER");
            
                break;
        }
        
        
    }
    public Object input(String type,String str,Scanner getin){
        System.out.print(str+":");
        Object ob=null;
        if(type.equals("int")){
            ob=getin.nextInt();
        }
        if(type.equals("double")){
            ob=getin.nextDouble();
        }
        if(type.equals("string")){
            ob=getin.next();
        }
            
        return ob;
    }
    public void creation(Scanner in){
        String ch=(String)this.input("string","Entrez le numero du client", in);
                //ClientsSaver cs=new ClientsSaver();
                HashSet<Clients> listeClients=this.clSaver.fetchBy("getNumPhone", ch);
                Comptes cmp=new Comptes();
                if(!listeClients.isEmpty()){
                    String choix="EPARGNE";
                    System.out.println("quel type de compte voulez-vous ?");
                    System.out.println("1.EPARGNE--5%");
                    System.out.println("2.COURANT--10%");
                    ch=(String)this.input("string","Entrez votre choix", in);
                    if(ch.equals("2"))
                       cmp.setType(this.typecomptes.get(1));
                    else
                        cmp.setType(this.typecomptes.get(0));
                    ch=(String)this.input("string","Entrez un montant initial par ex 20.00", in);
                    double mnt=Double.parseDouble(ch);
                    cmp.setSolde(mnt);
                    cmp.setGestionnaire(this.gestionnaire);
                    Object[] c=listeClients.toArray();
                    cmp.setTitulaire((Clients)c[0]);
                    cmp.setNumCompte(cnt);
                    this.cnt=this.cnt+1;
                    //ComptesSaver cmpsaver=new ComptesSaver();
                    this.cmpSaver.getData().add(cmp);
                    System.out.println("l'Enregistrement s'est très bien deroulé");
                    System.out.println("-----------------------------fin de la creation de compte du client "+cmp.getTitulaire().getNom()+" "+cmp.getTitulaire().getPrenom()+"----------------------------------");
                    
                }
                else{
                    System.out.println("le client n'existe pas , il faut le créer");
                    ch=(String)this.input("string","Entrez le nom post prenon sexe numphone(séparé par des -)", in);
                    try{
                        String[]data=ch.split("-");
                        Clients cl=new Clients();
                        cl.setNom(data[0]);cl.setPostnom(data[1]);cl.setPrenom(data[2]);cl.setSexe(data[3]);
                        cl.setNumPhone(data[data.length-1]);
                        System.out.println(cl.getId()+"-"+cl.getNom());
                        
                        this.clSaver.getData().add(cl);
                        
                        /*-------------------------------------------------------------------------------------------------------------*/
                        String choix="EPARGNE";
                    System.out.println("quel type de compte voulez-vous ?");
                    System.out.println("1.EPARGNE--5%");
                    System.out.println("2.COURANT--10%");
                    ch=(String)this.input("string","Entrez votre choix", in);
                    if(ch.equals("2"))
                       cmp.setType(this.typecomptes.get(1));
                    else
                        cmp.setType(this.typecomptes.get(0));
                    ch=(String)this.input("string","Entrez un montant initial par ex 20.00", in);
                    double mnt=/*Double.parseDouble(ch)*/Double.parseDouble(ch);
                    System.out.println("Enregistrement en cours...");
                    cmp.setSolde(mnt);
                    cmp.setGestionnaire(this.gestionnaire);
                    cmp.setTitulaire(cl);
                    cmp.setNumCompte(cnt);
                    this.cnt=this.cnt+1;
                    //ComptesSaver cmpsaver=new ComptesSaver();
                    this.cmpSaver.getData().add(cmp);
                    System.out.println("l'Enregistrement s'est très bien deroulé");
                    System.out.println("-----------------------------fin de la creation de compte du client "+cmp.getTitulaire().getNom()+" "+cmp.getTitulaire().getPrenom()+"----------------------------------");
                    this.process(in);
                    }
                    catch(Exception ex){
                         System.out.println("vous n'avez pas respecté la consigne,veillez recommencer");
                        this.process(in);
                        //ex.printStackTrace();
                    }
                    
                }
    }
    public void consultation(Scanner in){
        String ch=(String)this.input("string","entrez le numero de compte à consulter", in);
        //ComptesSaver cmpS=new ComptesSaver();
        HashSet<Comptes> list=this.cmpSaver.fetchBy("getNumCompte", Long.parseLong(ch));
        System.out.println("preparation des données...");
        if(!list.isEmpty()){
            System.out.println("...");
            Comptes cmp=(Comptes) list.toArray()[0];
            Transactions tr=new Transactions();
            tr.setType("consultation");
            tr.setMontant(0);
            tr.setCompte(cmp);
            tr.setTitulaire(cmp.getTitulaire());
            tr.setAgent(cmp.getGestionnaire());
            this.trsvr.getData().add(tr);
            
            System.out.println("le compte:"+cmp.getNumCompte()+"\n A comme propriétaire:"+cmp.getTitulaire().getNom()+"-"+cmp.getTitulaire().getPrenom());
            System.out.println("Le solde du compte est:"+cmp.getSolde());
            System.out.println("Le type du compte est "+cmp.getType().getLibele()+" avec un taux d'interet de :"+cmp.getType().getTaux());
            System.out.println("************************************fin de consultation de compte************************************");
            this.process(in);
        }
        else{
            System.out.println("Le numero de compte entré n'existe pas,recommencz svp ");
        }
        this.process(in);
    }
    public void crediter(Scanner in){
        String ch=(String)this.input("string","entrez le numero de compte à crediter", in);
        //ComptesSaver cmpS=new ComptesSaver();
        HashSet<Comptes> list=this.cmpSaver.fetchBy("getNumCompte", Long.parseLong(ch));
        ch=(String)this.input("string","entrez le montant à deposer dans le compte ex:200.00", in);
        double mnt=Double.parseDouble(ch);
        if(!list.isEmpty()){
            Comptes cmp=(Comptes) list.toArray()[0];
            cmp.setSolde(cmp.getSolde()+mnt);
            Transactions tr=new Transactions();
            tr.setType("Depot");
            tr.setMontant(mnt);
            tr.setCompte(cmp);
            tr.setTitulaire(cmp.getTitulaire());
            tr.setAgent(cmp.getGestionnaire());
            this.cmpSaver.update(cmp);
            this.trsvr.getData().add(tr);
            
            System.out.println("lec ompte:"+cmp.getNumCompte()+"\n A comme propriétaire:"+cmp.getTitulaire().getNom()+"-"+cmp.getTitulaire().getPrenom());
            System.out.println("A été crédité avec un montant de "+mnt+"\nLe solde du compte est maintenant à :"+cmp.getSolde());
            System.out.println("Le type du compte est "+cmp.getType().getLibele()+" avec un taux d'interet de :"+cmp.getType().getTaux());
            System.out.println("************************************fin de modifcation(depot) de compte************************************");
            this.process(in);
        }
        else{
            System.out.println("le numero de compte entré n'existe pas, recommencer");
            this.process(in);
        }
        
    }
    public void debiter(Scanner in){
        String ch=(String)this.input("string","entrez le numero de compte à Débiter", in);
        //ComptesSaver cmpS=new ComptesSaver();
        HashSet<Comptes> list=this.cmpSaver.fetchBy("getNumCompte", Long.parseLong(ch));
        ch=(String)this.input("string","entrez le montant à retirer dans le compte ex:200.00", in);
        double mnt=Double.parseDouble(ch);
        if(!list.isEmpty()){
            Comptes cmp=(Comptes) list.toArray()[0];
            if(cmp.getSolde()>mnt)
                cmp.setSolde(cmp.getSolde()-mnt);
            Transactions tr=new Transactions();
            tr.setType("Retrait");
            tr.setMontant(mnt);
            tr.setCompte(cmp);
            tr.setTitulaire(cmp.getTitulaire());
            tr.setAgent(cmp.getGestionnaire());
            this.cmpSaver.update(cmp);
            this.trsvr.getData().add(tr);
            
            System.out.println("lec ompte:"+cmp.getNumCompte()+"\n A comme propriétaire:"+cmp.getTitulaire().getNom()+"-"+cmp.getTitulaire().getPrenom());
            System.out.println("A été débité avec un montant de "+mnt+"\nLe solde du compte est maintenant à :"+cmp.getSolde());
            System.out.println("Le type du compte est "+cmp.getType().getLibele()+" avec un taux d'interet de :"+cmp.getType().getTaux());
            System.out.println("************************************fin de modifcation(retrait) de compte************************************");
            this.process(in);
        }
    }
    public void calculInteret(){
        //ComptesSaver cmpS=new ComptesSaver();
        System.out.println("calcul de l'interet de tous les comptes geré par la Banque ecours...");
        this.cmpSaver.getData().forEach((cmp)->{
            System.out.println("pour le compte "+cmp.getNumCompte()+" avec un Solde de "+cmp.getSolde());
            System.out.println("Dont le type de compte est "+cmp.getType().getLibele()+" avec un taux d'interet de "+cmp.getType().getTaux());
            double mnt=cmp.getSolde()*cmp.getType().getTaux();
            System.out.println("àprès calcul de l'interet le solde est devenu:"+(mnt+cmp.getSolde()));
            
        });
        System.out.println("*****************************************fin du calcul d'interet********************************************");
    }
    public void rapport(Scanner in){
        String ch=(String)this.input("string","Entrez une liste des comptes(séparé par des -)", in);
        List list=new LinkedList();
        List<Comptes> ll=new LinkedList();
        try{
                String[]data=ch.split("-");
                list.addAll(Arrays.asList(data));
                List transactions=this.trsvr.fetchByTransactionsByComptes(list);
                System.out.println("lecture des données entrées...");
                transactions.forEach((tr)->{
                    Transactions tra=(Transactions)tr;
                    System.out.println("transactions effectuée sur le compte:"+tra.getCompte().getNumCompte());
                    System.out.println("Montant:"+tra.getMontant()+" le "+tra.getDateT()+" type:"+tra.getType());
                });
               
            System.out.println("**************************************************fin de la liste des transactions****************************************");  
            this.process(in);
        }
        catch(Exception ex){
                System.out.println("vous n'avez pas respecté la consigne,veillez recommencer");
                this.process(in);
                        //ex.printStackTrace();
        }
    }
    public void rechercher(Scanner in){
        String ch=(String)this.input("string","Entrez l'identifiant du client à rechercher", in);
        int id=(int)Integer.parseInt(ch);
        System.out.println("recherche en cours...");
        //ComptesSaver saver=new ComptesSaver();
        this.cmpSaver.getData().forEach((cmp)->{
            if(cmp.getTitulaire().getId()==id){
                this.y++;
                System.out.println("Mr ou Mm "+cmp.getTitulaire().getNom()+" "+cmp.getTitulaire().getPrenom()+" a le compte "+cmp.getNumCompte());
            }
        });
        System.out.println("Nombre total de comptes trouvés est "+this.y);
        this.process(in);
    }
    public void init(){
        this.gestionnaire.setNom("SAIDI");
        this.gestionnaire.setNumMat("093655");
        this.gestionnaire.setPrenom("AZARIA");
        this.gestionnaire.setSexe("M");
        this.gestionnaire.setPostnom("ALLY");
        TypeComptes t1=new TypeComptes(),t2=new TypeComptes();
        t1.setLibele("EPARGNE");t1.setTaux(0.5);t2.setLibele("COURANT");
        t2.setTaux(1.00);this.typecomptes.add(t2);this.typecomptes.add(t1);
        
        
        System.out.println("***************************************************");
        System.out.println("*********PROGRAMME DE GESTION BANCAIRE*************");
        System.out.println("***************************************************");
        System.out.println("1.CREER UN COMPTE D'UN CLIENT");
        System.out.println("2.CONSULTER UN COMPTE");
        System.out.println("3.CREDITER UN COMPTE");
        System.out.println("4.DEBITER UN COMPTE");
        System.out.println("5.CALCULER TAUX D'INTERET SUR UN COMPTE");
        System.out.println("6.RECHERCHER UN COMPTE");
        System.out.println("7.RAPPORT SUR DES COMPTES");
        System.out.println("8.AUTRE OPERATION OU QUITTER");
           
    }
}
