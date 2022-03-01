/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import entities.Individu;
/**
 *
 * @author Ed
 */
public class ProprietaireChien {
    int idProprietaireChien;
    Individu individu;
    String bio;

    public ProprietaireChien() {
    }

    public ProprietaireChien(int idProprietaireChien, Individu individu, String bio) {
        this.idProprietaireChien = idProprietaireChien;
        this.individu = individu;
        this.bio = bio;
    }
     public ProprietaireChien(int idProprietaireChien) {
        this.idProprietaireChien = idProprietaireChien;
     
    }

    public int getIdProprietaireChien() {
        return idProprietaireChien;
    }

    public void setIdProprietaireChien(int idProprietaireChien) {
        this.idProprietaireChien = idProprietaireChien;
    }

    public Individu getIndividu() {
        return individu;
    }

    public void setIndividu(Individu individu) {
        this.individu = individu;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
    
     @Override
    public String toString() {
        return "ProprietaireChien{" + "idProprietaireChien=" + idProprietaireChien + ", individu=" + individu + ", bio=" + bio + '}';
    }
    
}
