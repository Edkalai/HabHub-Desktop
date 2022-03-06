/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package habhub;

import entities.AnnonceAdoption;
import java.util.Date;
import entities.Chien;
import entities.Individu;
import entities.Utilisateur;
import java.sql.SQLException;
import services.AnnonceAdoptionService;
import services.ChienService;



public class HabHub {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Chien c = new Chien("newdog","f","7mois",true,"ffff","","vert","atlas","garde");
        //Chien b = new Chien(8,"calicooooo","f","2mois",true,"iiii");
        //Chien f = new Chien("rades","f","2mois",true,"iiii");
        Utilisateur u = new Utilisateur(2);
        Individu i = new Individu(2);
        //Chien d = new Chien(13,"boubi","m","2annes",true,"kkkk");
         AnnonceAdoption a= new AnnonceAdoption(i,c,"kkkkkk","rades");
         
         
        
        ChienService cs = new ChienService();
        AnnonceAdoptionService as = new AnnonceAdoptionService();
        
        //cs.updateChien(c.getIdChien(), c.getNom(), c.getSexe(), c.getAge(), c.getVaccination(), c.getDescription(), c.getImage(), c.getColor(), c.getRace(), c.getGroupe()); 
        try {
        cs.ajouterChienSansProprietaire(c);
        System.out.println("ajout avec succes");
        System.out.println(c);
        } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        } 
        /*try {
        cs.delete(b.getIdChien());
        System.out.println("supression avec succes");
        } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        }*/ //cs.updateChien(b.getIdChien(),b.getNom(),b.getSexe(),b.getAge(),b.getVaccination(),b.getDescription());
        /*try {
        System.out.println(cs.afficherChiens());
        } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        }*/
        /*try {
        System.out.println(cs.findChienById(b.getIdChien()));
        } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        }*/
        /*try {
        as.deleteAnnonceAdoption(a.getIdAnnonceAdoption());
        System.out.println("supression avec succes");
        } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        }*/
        /*try {
        as.addAnnonceAdoption(a);
        System.out.println("ajout avec succes");
        } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        }*/
        /*try {
        System.out.println(as.displayAnnonceAdoption());
        } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        }*/
        /*try {
        as.updateAnnonceAdoption(a);
        System.out.println("modification avec succes");
        } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        }*/
        /*try {
        System.out.println(as.rechercheAnnonceAdoption(a.getLocalisation()));
        } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        }*/
        /*try {
        String filtre="localisation";
        System.out.println(as.FilterAnnonceAdoption(filtre, a.getLocalisation()));
        } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        }
        System.out.println("ajout avec succes");*/
        
        
        
  
        
    }
    
}
