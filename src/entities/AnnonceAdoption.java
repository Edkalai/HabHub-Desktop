/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author Tun21
 */
public class AnnonceAdoption {
    private int idAnnonceAdoption;
    private Individu idIndividu ;
    private Chien idChien;
    private Date datePublication;
    private String description;
    private String localisation;

    public AnnonceAdoption() {
    }

    public AnnonceAdoption(int idAnnonceAdoption, Individu idIndividu , Chien idChien, Date datePublication, String description, String localisation) {
        
        this.idAnnonceAdoption= idAnnonceAdoption;
        this.idIndividu  = idIndividu ;
        this.idChien = idChien;
        this.datePublication = datePublication;
        this.description = description;
        this.localisation = localisation;
    }

    public AnnonceAdoption(Individu idIndividu , Chien idChien, Date datePublication, String description, String localisation) {
        this.idIndividu  = idIndividu;
        this.idChien = idChien;
        this.datePublication = datePublication;
        this.description = description;
        this.localisation = localisation;
    }

    public int getIdAnnonceAdoption() {
        return idAnnonceAdoption;
    }

    public void setIdAnnonceAdoption(int idAnnonceAdoption) {
        this.idAnnonceAdoption = idAnnonceAdoption;
    }

    public Individu getIdIndividu() {
        return idIndividu;
    }

    public void setIdIndividu(Individu idIndividu) {
        this.idIndividu = idIndividu;
    }

    

    public Chien getIdChien() {
        return idChien;
    }

    public void setIdChien(Chien idChien) {
        this.idChien = idChien;
    }


    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    @Override
    public String toString() {
        return "AnnonceAdoption{" + "idAnnonceAdoption=" + idAnnonceAdoption + ", idIndividu=" + idIndividu + ", idChien=" + idChien + ", datePublication=" + datePublication + ", description=" + description + ", localisation=" + localisation + '}';
    }

    

    

    
   
    
   

    

    

   
    
    
    
    
    
    
}
