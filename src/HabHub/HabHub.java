/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package habhub;

import entities.AnnonceProprietaireChien;
import entities.ProprietaireChien;
import entities.Chien;
import services.AnnonceProprietaireChienService;
import services.ProprietaireChienService;
import services.ChienService;
import services.ProprietaireChienService;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;




public class HabHub {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProprietaireChien pc = new ProprietaireChien (-1,2,"azeazeazeazeaze");
        ProprietaireChienService pcs=new ProprietaireChienService();
        Chien c = new Chien(1,1,"aa","M","6mois",true,"aaaaa");
        ChienService cs = new ChienService();
        AnnonceProprietaireChien a = new AnnonceProprietaireChien(-1,1,"25/02/2020","hentita","A","Ezzahra");
        AnnonceProprietaireChienService sa=new AnnonceProprietaireChienService();
        
            //pcs.updateProprietaireChien(4, "aaaaaa");
            //cs.updateChien(1,"test","M","5mois",true,"Golden");
            /*try {
           pcs.delete(1);
            
            
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }*/
       
        /*
        try {
            pcs.ajouterProprietaireChien(pc);
            System.out.println("ajout avec succes");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            cs.ajouterChien(c);
            System.out.println("ajout avec succes");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        try {
            sa.ajouterAnnonceAccouplement(a);
            System.out.println("ajout avec succes");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        */
        
        try {
            System.out.println(pcs.afficherProprietaireChien());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
         try {
            System.out.println(cs.afficherChien());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         
          try {
            System.out.println(sa.afficherAnnonceAccouplement());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
         
          try {
            System.out.println(sa.afficherAnnonceChienPerdu());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }
        
        
          
    }
    

