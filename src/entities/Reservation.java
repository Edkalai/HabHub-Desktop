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
    ProprietaireChien PropChien ;
    ServiceBusiness serviceBusiness;
    Timestamp dateHeureDebut;
    Timestamp dateHeureFin;

    

    public Reservation( ProprietaireChien PropChien,ServiceBusiness serviceBusiness,Timestamp dateHeureDebut,Timestamp dateHeureFin) {
        this. PropChien = PropChien;
        this.serviceBusiness = serviceBusiness;
        this.dateHeureDebut = dateHeureDebut;
        this.dateHeureFin = dateHeureFin;

    }
    public Reservation(int idReservation,ProprietaireChien PropChien,ServiceBusiness serviceBusiness, Timestamp dateHeureDebut,java.sql.Timestamp dateHeureFin) {
        this.idReservation = idReservation;
        this.PropChien = PropChien;
        this.serviceBusiness = serviceBusiness;
        this.dateHeureDebut = dateHeureDebut;
        this.dateHeureFin = dateHeureFin;

    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public void setPropChien( ProprietaireChien PropChien) {
        this.PropChien = PropChien;
    }

    public void setIdBusinessServices(ServiceBusiness serviceBusiness) {
        this.serviceBusiness = serviceBusiness;
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

    public ProprietaireChien getPropChien() {
        return PropChien;
    }

    public ServiceBusiness getBusinessServices() {
        return serviceBusiness;
    }

    public Timestamp getDateHeureDebut() {
        return dateHeureDebut;
    }

    public Timestamp getDateHeureFin() {
        return dateHeureFin;
    }
    
    
      @Override
    public String toString() {
        return "Reservation{" + "idReservation=" + idReservation + ", idProprietaireChien=" + PropChien.idProprietaireChien + ", idBusinessServices=" + serviceBusiness.idBusinessServices + ", dateHeureDebut=" + dateHeureDebut + ", dateHeureFin=" + dateHeureFin + '}';
    }
}
