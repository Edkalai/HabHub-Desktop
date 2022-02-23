/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;
import entities.Utilisateur;
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
    Date dateNaissance;
    String adresse;
    String facebook;
    String instagram;
    String whatsapp;

    public Individu( Utilisateur utilisateur) {
        
        this.utilisateur = utilisateur;
        
    }
    public Individu(String prenom,String nom) {
        
        this.prenom = prenom;
        this.nom = nom;

    }
    
    public Individu(int idIndividu, Utilisateur utilisateur, String nom, String prenom, Date dateNaissance, String adresse, String facebook, String instagram, String whatsapp) {
        this.idIndividu = idIndividu;
        this.utilisateur = utilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.facebook = facebook;
        this.instagram = instagram;
        this.whatsapp = whatsapp;
    }

    public Individu(Utilisateur utilisateur, String nom, String prenom, Date dateNaissance, String adresse, String facebook, String instagram, String whatsapp) {
        this.utilisateur = utilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.adresse = adresse;
        this.facebook = facebook;
        this.instagram = instagram;
        this.whatsapp = whatsapp;
    }

    public Individu(int idIndividu) {
        this.idIndividu = idIndividu;
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

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
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

    @Override
    public String toString() {
        return "Individu{" + "idIndividu=" + idIndividu + ", utilisateur=" + utilisateur + ", nom=" + nom + ", prenom=" + prenom + ", dateNaissance=" + dateNaissance + ", adresse=" + adresse + ", facebook=" + facebook + ", instagram=" + instagram + ", whatsapp=" + whatsapp + '}';
    }
    
}
