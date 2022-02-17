/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

public class AnnonceProprietaireChien {
    int idAnnonceProprietaireChien;
    int idChien;
    String datePublication;
    String description;
    String type;
    String datePerte;
    String localisation;
    String messageVocal;


  public AnnonceProprietaireChien(int idAnnonceProprietaireChien, int idChien, String datePublication,String description,String type,String localisation ) {
        this.idAnnonceProprietaireChien=idAnnonceProprietaireChien;
        this.idChien=idChien;
        this.datePublication=datePublication;
        this.description=description;
        this.type=type;
        this.localisation=localisation;
             
    }

  public AnnonceProprietaireChien(int idAnnonceProprietaireChien, int idChien, String datePublication,String description,String type,String datePerte,
          String localisation,String messageVocal ) {
        this.idAnnonceProprietaireChien=idAnnonceProprietaireChien;
        this.idChien=idChien;
        this.datePublication=datePublication;
        this.description=description;
        this.type=type;
        this.datePerte=datePerte;
        this.localisation=localisation;
        this.messageVocal=messageVocal;
             
    }

    

    public int getIdAnnonceProprietaireChien() {
        return idAnnonceProprietaireChien;
    }

    public void setIdAnnonceProprietaireChien(int idAnnonceProprietaireChien) {
        this.idAnnonceProprietaireChien = idAnnonceProprietaireChien;
    }

    public int getIdChien() {
        return idChien;
    }

    public void setIdChien(int idChien) {
        this.idChien = idChien;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDatePerte() {
        return datePerte;
    }

    public void setDatePerte(String datePerte) {
        this.datePerte = datePerte;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public String getMessageVocal() {
        return messageVocal;
    }

    public void setMessageVocal(String messageVocal) {
        this.messageVocal = messageVocal;
    }


    
  @Override
    public String toString() {
        return "AnnonceProprietaireChien{" + "idAnnonceProprietaireChien=" + idAnnonceProprietaireChien + ", idChien=" + idChien + ", datePublication=" + datePublication + ", description=" + description + ", type=" + type + ", datePerte=" + datePerte + ", localisation=" + localisation + ", messageVocal=" + messageVocal + '}';
    }


   
}
