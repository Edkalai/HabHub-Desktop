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
public class panier {
    private int idPanier,idProduit,idUtilisateur,quantite;

    public panier(int idPanier, int idProduit, int idUtilisateur, int quantite) {
        this.idPanier = idPanier;
        this.idProduit = idProduit;
        this.idUtilisateur = idUtilisateur;
        this.quantite = quantite;
    }

    public panier(int idProduit, int idUtilisateur, int quantite) {
        this.idProduit = idProduit;
        this.idUtilisateur = idUtilisateur;
        this.quantite = quantite;
    }

    public int getIdPanier() {
        return idPanier;
    }

    public void setIdPanier(int idPanier) {
        this.idPanier = idPanier;
    }

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "panier{" + "idPanier=" + idPanier + ", idProduit=" + idProduit + ", idUtilisateur=" + idUtilisateur + ", quantite=" + quantite + '}';
    }
    
    
    
}
