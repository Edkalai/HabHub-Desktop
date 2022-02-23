/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.logging.Logger;
import java.sql.Timestamp;
/**
 *
 * @author User
 */
public class Reservation {
    int idReservation;
    int idProprietaireChien ;
    int idBusinessServices;
    Timestamp dateHeureDebut;
    Timestamp dateHeureFin;

    

    public Reservation(int idProprietaireChien, int idBusinessServices,Timestamp dateHeureDebut,Timestamp dateHeureFin) {
        this.idProprietaireChien = idProprietaireChien;
        this.idBusinessServices = idBusinessServices;
        this.dateHeureDebut = dateHeureDebut;
        this.dateHeureFin = dateHeureFin;

    }
    public Reservation(int idReservation,int idProprietaireChien, int idBusinessServices, Timestamp dateHeureDebut,java.sql.Timestamp dateHeureFin) {
        this.idReservation = idReservation;
        this.idProprietaireChien = idProprietaireChien;
        this.idBusinessServices = idBusinessServices;
        this.dateHeureDebut = dateHeureDebut;
        this.dateHeureFin = dateHeureFin;

    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public void setIdProprietaireChien(int idProprietaireChien) {
        this.idProprietaireChien = idProprietaireChien;
    }

    public void setIdBusinessServices(int idBusinessServices) {
        this.idBusinessServices = idBusinessServices;
    }

    public void setDateHeureDebut(Timestamp dateHeureDebut) {
        this.dateHeureDebut = dateHeureDebut;
    }

    public void setDateHeureFin(Timestamp dateHeureFin) {
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

    public Timestamp getDateHeureDebut() {
        return dateHeureDebut;
    }

    public Timestamp getDateHeureFin() {
        return dateHeureFin;
    }
    
    
      @Override
    public String toString() {
        return "Reservation{" + "idReservation=" + idReservation + ", idProprietaireChien=" + idProprietaireChien + ", idBusinessServices=" + idBusinessServices + ", dateHeureDebut=" + dateHeureDebut + ", dateHeureFin=" + dateHeureFin + '}';
    }
}
