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
public class Business {
    int idBusiness;
    String titre;
    String description;
    float prix;
    String horaire;
    String ville;
    String localisation;

    public Business( String titre, String description, float prix, String horaire, String ville, String localisation) {
        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.horaire = horaire;
        this.ville = ville;
        this.localisation = localisation;
    }
    public Business(int idBusiness, String titre, String description, float prix, String horaire, String ville, String localisation) {
        this.idBusiness = idBusiness;
        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.horaire = horaire;
        this.ville = ville;
        this.localisation = localisation;
    }

    public int getIdBusiness() {
        return idBusiness;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public float getPrix() {
        return prix;
    }

    public String getHoraire() {
        return horaire;
    }

    public String getVille() {
        return ville;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setIdBusiness(int idBusiness) {
        this.idBusiness = idBusiness;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    @Override
    public String toString() {
        return "Business{" + "idBusiness=" + idBusiness + ", titre=" + titre + ", description=" + description + ", prix=" + prix + ", horaire=" + horaire + ", ville=" + ville + ", localisation=" + localisation + '}';
    }
    
}
