/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

public class Chien {

    int idChien;
    ProprietaireChien proprietaireChien;
    String nom;
    String sexe;
    String age;
    Boolean vaccination;
    String description;
    String image;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
    String color;
    String race;
    String group;

    public Chien() {
    }

    public Chien(int idChien, String nom, String sexe, String age, Boolean vaccination, String description, String image, String color, String race, String group) {
        this.idChien = idChien;
        this.nom = nom;
        this.sexe = sexe;
        this.age = age;
        this.vaccination = vaccination;
        this.description = description;
        this.image = image;
        this.color = color;
        this.race = race;
        this.group = group;
    }

    public Chien(int idChien) {
        this.idChien = idChien;
    }

    public Chien(String nom, String sexe, String age, Boolean vaccination, String description, String image, String color, String race, String group) {
        this.nom = nom;
        this.sexe = sexe;
        this.age = age;
        this.vaccination = vaccination;
        this.description = description;
        this.image = image;
        this.color = color;
        this.race = race;
        this.group = group;
    }

    public Chien(int idChien, ProprietaireChien proprietaireChien, String nom, String sexe, String age, Boolean vaccination, String description, String image, String color, String race, String group) {
        this.idChien = idChien;
        this.proprietaireChien = proprietaireChien;
        this.nom = nom;
        this.sexe = sexe;
        this.age = age;
        this.vaccination = vaccination;
        this.description = description;
        this.image = image;
        this.color = color;
        this.race = race;
        this.group = group;
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
        return "Chien{" + "idChien=" + idChien + ", proprietaireChien=" + proprietaireChien + ", nom=" + nom + ", sexe=" + sexe + ", age=" + age + ", vaccination=" + vaccination + ", description=" + description + ", image=" + image + ", color=" + color + ", race=" + race + ", group=" + group + '}';
    }

  

}
