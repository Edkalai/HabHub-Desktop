/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Ed
 */
public class ProprietaireChien {
    int idProprietaireChien;
    int idUtilisateur;
    String bio;

   

    public ProprietaireChien(int idProprietaireChien, int idUtilisateur, String bio) {
        this.idProprietaireChien = idProprietaireChien;
        this.idUtilisateur = idUtilisateur;
        this.bio = bio;
    }

    public int getIdProprietaireChien() {
        return idProprietaireChien;
    }

    public void setIdProprietaireChien(int idProprietaireChien) {
        this.idProprietaireChien = idProprietaireChien;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
    
     @Override
    public String toString() {
        return "ProprietaireChien{" + "idProprietaireChien=" + idProprietaireChien + ", idUtilisateur=" + idUtilisateur + ", bio=" + bio + '}';
    }
    
}
