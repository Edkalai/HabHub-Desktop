/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;



/**
 *
 * @author asus
 */
public class Produit {
    private int idProduit,idCategorie,nbetoiles;
 private String nom,description,marque;
    private float prix;
    
    public Produit( int idCategorie ,int nbetoiles, String nom, String description, String marque, float prix) {
        this.nbetoiles = nbetoiles;
     
        this.idCategorie = idCategorie;
        this.nom = nom;
        this.description = description;
        this.marque = marque;
        this.prix = prix;
    }
   

    public Produit(int idProduit, int idCategorie, int nbetoiles, String nom, String description, String marque, float prix) {
        this.idProduit = idProduit;
        this.nbetoiles = nbetoiles;
     
        this.idCategorie = idCategorie;
        this.nom = nom;
        this.description = description;
        this.marque = marque;
        this.prix = prix;
    }
   

 

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public Produit(int nbetoiles, String nom, String description, String marque, float prix) {
        this.nbetoiles = nbetoiles;
 
        this.nom = nom;
        this.description = description;
        this.marque = marque;
        this.prix = prix;
    }
    
    
    

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getNbetoiles() {
        return nbetoiles;
    }

    public void setNbetoiles(int nbetoiles) {
        this.nbetoiles = nbetoiles;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }



    @Override
    public String toString() {
        return "Produit{" + "idProduit=" + idProduit + ", nbetoiles=" + nbetoiles +  ", idCategorie=" + idCategorie + ", nom=" + nom + ", description=" + description + ", marque=" + marque + ", prix=" + prix + '}';
    }

  


   
    
    
    
    
            
    
}
