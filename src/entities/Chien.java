/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

public class Chien {
    int idChien;
    int idProprietaireChien;
    String nom;
    String sexe;
    String age;

    
    Boolean vaccination;
    String description;

    public Chien(int idChien, int idProprietaireChien, String nom, String sexe, String age, Boolean vaccination, String description) {
        this.idChien = idChien;
        this.idProprietaireChien = idProprietaireChien;
        this.nom = nom;
        this.sexe = sexe;
        this.age = age;
        this.vaccination = vaccination;
        this.description = description;
    }

    public int getIdChien() {
        return idChien;
    }

    public void setIdChien(int idChien) {
        this.idChien = idChien;
    }

    public int getIdProprietaireChien() {
        return idProprietaireChien;
    }

    public void setIdProprietaireChien(int idProprietaireChien) {
        this.idProprietaireChien = idProprietaireChien;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Boolean getVaccination() {
        return vaccination;
    }

    public void setVaccination(Boolean vaccination) {
        this.vaccination = vaccination;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "Chien{" + "idChien=" + idChien + ", idProprietaireChien=" + idProprietaireChien + ", nom=" + nom + ", sexe=" + sexe + ", age=" + age + ", vaccination=" + vaccination + ", description=" + description + '}';
    }
    
}