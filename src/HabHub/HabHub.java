/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package habhub;

import entities.Categorie;
import entities.Magasin;
import entities.Produit;
import entities.panier;

import java.sql.SQLException;
import services.CategorieService;
import services.MagasinService;
import services.PanierService;
import services.ProduitService;



public class HabHub {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        
       // panier pa1 = new panier (1,2,34);
        
        PanierService pas1 = new PanierService();
        
        
        try {        
          
            System.out.println(pas1.afficheParId(1));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        // *****************************************************************
        
          //Produit p1 = new Produit (11,11,"makrouna","spaghetti num 3","Warda",1000);
        
        ProduitService sp1 = new ProduitService();
        
        //******************************************************************
        
          Categorie c = new Categorie ("jouets","divertissement");
        
        CategorieService sp = new CategorieService();
        
        //************************************************************
        
      //  Magasin ma = new Magasin(10,2097,"09635579",3333333,"Koulni","Fathi ep soumaya","Boumhal bessatine","Ben arous","Mourad hedhli","123","123/2");
        
        MagasinService mg = new MagasinService();
        
         /**
        try {
            mg.ajouterMa(ma);
            System.out.println("ajout avec succes du magasin");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } **/
          /**
         try {
            System.out.println(mg.afficherMagasin());
            mg.deleteMagasin(6);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  **/
         
        /** try {
            mg.deleteMagasin(ma.getIdMagasin());
            System.out.println("supression du magasin avec succes");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }**/
        
        /**
         try {
            sp1.ajouterp(p1);
            System.out.println("ajout avec succes");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }**/
        
         /** try {
            System.out.println(sp1.afficherproduit());
            //sp1.deleteProduit(3);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  **/
       
         // mg.updateMagasin(2,10,3097,"09582239",0000,"klebna klebek","hamidou","rades mrah","ben arous","iheb memmi","23tunis2345","identifiant behy");
          

        
        /**
         try {
            sp.ajouterc(c);
            System.out.println("ajout avec succes");
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        **/
       /** try {
            System.out.println(sp.affichercategorie());
             sp.deleteCategorie(11);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
        try {
            sp.deleteCategorie(c.getIdCategorie());
            System.out.println("supression avec succes");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        **/
        
       /**try {
            sp1.deleteProduit(p1.getIdProduit());
            System.out.println("supression avec succes");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        **/
        
      
          
           
        
          // sp.updateCategorie(1,"aziz","chniti");
          // sp1.updateProduit(1,5,2,"kosksi","kheyeb","kaskasni",3500);
           
           
          /** try {
            pas1.ajouterPa(pa1);
            System.out.println("ajout avec succes");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }**/
            /**
         try {
            System.out.println(pas1.afficherPanier());
            pas1.deletePanier(3);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }  
         
           try {
            pas1.deletePanier(pa1.getIdPanier());
          //  System.out.println("supression avec succes");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
           
          
         **/
    }
        
    

}