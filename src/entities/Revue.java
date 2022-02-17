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
 int idUtilisateur;
 int nbEtoiles;
 String commentaire;

    public Revue(int idRevue, int idUtilisateur, int nbEtoiles, String commentaire) {
        this.idRevue = idRevue;
        this.idUtilisateur = idUtilisateur;
        this.nbEtoiles = nbEtoiles;
        this.commentaire = commentaire;
    }

    public int getIdRevue() {
        return idRevue;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
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

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public void setNbEtoiles(int nbEtoiles) {
        this.nbEtoiles = nbEtoiles;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public String toString() {
        return "Revue{" + "idRevue=" + idRevue + ", idUtilisateur=" + idUtilisateur +  ", nbEtoiles=" + nbEtoiles + ", commentaire=" + commentaire + '}';
    }
    
}
