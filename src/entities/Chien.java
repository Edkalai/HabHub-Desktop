/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import entities.ProprietaireChien;

public class Chien {
    int idChien;
    ProprietaireChien proprietaireChien;
    String nom;
    String sexe;
    String age;
    Boolean vaccination;
    String description;
    String image;

     public Chien() {
    }
    public Chien(int idChien, String nom, String sexe, String age, Boolean vaccination, String description,String image) {
        this.idChien = idChien;
        this.nom = nom;
        this.sexe = sexe;
        this.age = age;
        this.vaccination = vaccination;
        this.description = description;
        this.image = image;
    }

    public Chien(int idChien) {
        this.idChien = idChien;
    }
    public Chien(String nom, String sexe, String age, Boolean vaccination, String description,String image) {
        this.nom = nom;
        this.sexe = sexe;
        this.age = age;
        this.vaccination = vaccination;
        this.description = description;
        this.image = image;
    }

    public Chien(int idChien, ProprietaireChien proprietaireChien, String nom, String sexe, String age, Boolean vaccination, String description,String image) {
        this.idChien = idChien;
        this.proprietaireChien = proprietaireChien;
        this.nom = nom;
        this.sexe = sexe;
        this.age = age;
        this.vaccination = vaccination;
        this.description = description;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
 

    public int getIdChien() {
        return idChien;
    }

    public void setIdChien(int idChien) {
        this.idChien = idChien;
    }

    public ProprietaireChien getProprietaireChien() {
        return proprietaireChien;
    }

    public void setProprietaireChien(ProprietaireChien proprietaireChien) {
        this.proprietaireChien = proprietaireChien;
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
        return "Chien{" + "idChien=" + idChien + ", \r\n proprietaireChien=" + proprietaireChien + ", nom=" + nom + ", sexe=" + sexe + ", age=" + age + ", vaccination=" + vaccination + ", description=" + description + ", image=" + image + '}';
    }
    
}