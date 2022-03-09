/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;
import entite.Utilisateur;
import java.util.Date;
/**
 *
 * @author Ed
 */
public class Individu {
    int idIndividu;
    Utilisateur utilisateur;
    String nom;
    String prenom;
    String dateNaissance;
    String sexe;
    String adresse;
    String facebook;
    String instagram;
    String whatsapp;
public Individu(int idIndividu, Utilisateur utilisateur, String nom, String prenom,String sexe,String adresse, String facebook, String instagram, String whatsapp) {
        this.idIndividu = idIndividu;
        this.utilisateur = utilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe=sexe;
        this.adresse=adresse;
        this.facebook = facebook;
        this.instagram = instagram;
        this.whatsapp = whatsapp;
    }
    public Individu(){}
    public Individu(int idIndividu, Utilisateur utilisateur, String nom, String prenom, String dateNaissance,String sexe, String adresse, String facebook, String instagram, String whatsapp) {
        this.idIndividu = idIndividu;
        this.utilisateur = utilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.sexe=sexe;
        this.adresse = adresse;
        this.facebook = facebook;
        this.instagram = instagram;
        this.whatsapp = whatsapp;
    }

    public Individu(Utilisateur utilisateur, String nom, String prenom, String dateNaissance,String sexe, String adresse, String facebook, String instagram, String whatsapp) {
        this.utilisateur = utilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.sexe= sexe;
        this.adresse = adresse;
        this.facebook = facebook;
        this.instagram = instagram;
        this.whatsapp = whatsapp;
    }

    public Individu(int idIndividu) {
        this.idIndividu = idIndividu;
    }

    public Individu(String text, String text0, String text1, String text2, String text3, String text4, String text5, String text6) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdIndividu() {
        return idIndividu;
    }

    public void setIdIndividu(int idIndividu) {
        this.idIndividu = idIndividu;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    @Override
    public String toString() {
        return "Individu{" + "idIndividu=" + idIndividu + ", utilisateur=" + utilisateur + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", sexe=" + sexe + ", adresse=" + adresse + ", facebook=" + facebook + ", instagram=" + instagram + ", whatsapp=" + whatsapp + '}';
    }

 
  
    
}
