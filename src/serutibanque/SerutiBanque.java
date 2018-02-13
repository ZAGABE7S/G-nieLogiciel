/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serutibanque;

import com.model.controller.ControllerBanque;
import com.model.entities.Clients;
import com.model.entities.Comptes;
import com.model.saver.ComptesSaver;
import java.util.Scanner;

/**
 *
 * @author AZARIA
 */
public class SerutiBanque {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       /* Clients cl=new Clients();
        Clients ct=new Clients();
        Clients c=new Clients();
        System.out.println("id1:"+cl.getId()+" et id2:"+ct.getId()+" id3:"+c.getId());*/
       /*Comptes cmp =new  Comptes();
       cmp.setNumCompte(1000);*/
        ComptesSaver sv=new ComptesSaver();
        sv.voir("display");
        Scanner in=new Scanner(System.in);
        /*
        *on instancie un controller qui va recuperer l'entrée standard 
        *et va gerer les options du systeme
        */
        ControllerBanque cnt=new ControllerBanque();
        cnt.process(in);
    }
    
}
