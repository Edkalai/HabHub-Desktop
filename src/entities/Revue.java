/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author User
 */
public class Revue {
 int idRevue ;
 Individu indiv;
 int idProduit;
 Business business;
 int nbEtoiles;
 String commentaire;

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }
 

    public Revue(Individu indiv,Business business,int nbEtoiles, String commentaire) {
        this.indiv = indiv;
        this.business = business;
        this.nbEtoiles = nbEtoiles;
        this.commentaire = commentaire;
    }
    
    public Revue(int idRevue,Individu indiv,Business business,int nbEtoiles, String commentaire) {
        this.idRevue = idRevue;
        this.indiv =indiv;
        this.business = business;
        this.nbEtoiles = nbEtoiles;
        this.commentaire = commentaire;
    }
   /* public Revue(int idRevue,Individu indiv,int idProduit,int idBusiness,int nbEtoiles, String commentaire) {
        this.idRevue = idRevue;
        this.indiv =indiv;
        this.idProduit = idProduit;
        this.business = business;
        this.nbEtoiles = nbEtoiles;
        this.commentaire = commentaire;
    }
    */

   

    public Business getBusiness() {
        return business;
    }
  

    public int getIdRevue() {
        return idRevue;
    }

    public Individu getIndividu() {
        return indiv;
    }

    
    public int getNbEtoiles() {
        return nbEtoiles;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setIdRevue(int idRevue) {
        this.idRevue = idRevue;
    }

    public void setIndividu(Individu indiv) {
        this.indiv = indiv;
    }
 

    public void setIdBusiness(Business business) {
        this.business = business;
    }
    public void setNbEtoiles(int nbEtoiles) {
        this.nbEtoiles = nbEtoiles;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public String toString() {
        return "Revue{" + "idRevue=" + idRevue + ", idIndividu=" + indiv.idIndividu+ ", prenom=" + indiv.prenom + ", nom=" + indiv.nom + ", titre business=" + business.titre +",idProduit="+idProduit+ ",idBusiness="+business.idBusiness+  ", nbEtoiles=" + nbEtoiles + ", commentaire=" + commentaire + "} \r\n";
    }
    
    
}
