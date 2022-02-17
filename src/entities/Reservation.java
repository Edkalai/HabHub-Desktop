/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class Reservation {
    int idReservation;
    int idProprietaireChien ;
    int idBusinessServices;
    String dateHeureDebut;
    String dateHeureFin;

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public void setIdProprietaireChien(int idProprietaireChien) {
        this.idProprietaireChien = idProprietaireChien;
    }

    public void setIdBusinessServices(int idBusinessServices) {
        this.idBusinessServices = idBusinessServices;
    }

    public void setDateHeureDebut(String dateHeureDebut) {
        this.dateHeureDebut = dateHeureDebut;
    }

    public void setDateHeureFin(String dateHeureFin) {
        this.dateHeureFin = dateHeureFin;
    }

    public Reservation(int idReservation, int idProprietaireChien, int idBusinessServices, String dateHeureDebut,String dateHeureFin) {
        this.idReservation = idReservation;
        this.idProprietaireChien = idProprietaireChien;
        this.idBusinessServices = idBusinessServices;
        this.dateHeureDebut = dateHeureDebut;
        this.dateHeureFin = dateHeureFin;

    }

    public int getIdReservation() {
        return idReservation;
    }

    public int getIdProprietaireChien() {
        return idProprietaireChien;
    }

    public int getIdBusinessServices() {
        return idBusinessServices;
    }

    public String getDateHeureDebut() {
        return dateHeureDebut;
    }

    public String getDateHeureFin() {
        return dateHeureFin;
    }
    
    
      @Override
    public String toString() {
        return "Reservation{" + "idReservation=" + idReservation + ", idProprietaireChien=" + idProprietaireChien + ", idBusinessServices=" + idBusinessServices + ", dateHeureDebut=" + dateHeureDebut + ", dateHeureFin=" + dateHeureFin + '}';
    }
}
