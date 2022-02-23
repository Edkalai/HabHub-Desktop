/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import java.util.*;
import entities.Business;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import utils.MyDB;
import entities.Reservation;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class ReservationServices implements Interface_Reservation {
      Connection connect;
      Statement stm;

    public ReservationServices() {
      connect=MyDB.getInstance().getConnexion();
  
    }
   public void ajouter(Reservation R)throws SQLException {
        PreparedStatement pre = connect.prepareStatement("INSERT INTO reservation (idProprietaireChien,idBusinessServices,dateHeureDebut,dateHeureFin)VALUES (?,?,?,?);");
        pre.setInt(1, R.getIdProprietaireChien());
        pre.setInt(2, R.getIdBusinessServices());
        Timestamp heureDebut = new Timestamp(R.getDateHeureDebut().getTime());
        pre.setTimestamp(3,heureDebut);
        Timestamp heureFin = new Timestamp(R.getDateHeureFin().getTime());
        pre.setTimestamp(4,heureFin);
        

        pre.executeUpdate();
   }
   
     
    public boolean Update(int idReservation,int idProprietaireChien,int idBusinessServices,Timestamp dateHeureDebut,Timestamp dateHeureFin) {
            try {

            PreparedStatement pre = connect.prepareStatement("UPDATE reservation SET idProprietaireChien = ? , idBusinessServices= ? , dateHeureDebut= ? , dateHeureFin= ? where idReservation= ? ;");
            pre.setInt(1, idProprietaireChien);
            pre.setInt(2, idBusinessServices);
            Timestamp heureDebut = new java.sql.Timestamp(dateHeureDebut.getTime());
            pre.setTimestamp(3, heureDebut);  
            java.sql.Timestamp heureFin = new java.sql.Timestamp(dateHeureFin.getTime());
            pre.setTimestamp(4,heureFin);
            pre.setInt(5,idReservation);

            if (pre.executeUpdate() != 0) {
                System.out.println(" Reservation Updated");
                 } else {
                System.out.println("not Updated");
            }
                return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
         public boolean delete(Integer idReservation) throws SQLException {

        PreparedStatement pre = connect.prepareStatement("Delete from reservation where idReservation=? ;");
        pre.setInt(1, idReservation);
        if (pre.executeUpdate() != 0) {
            System.out.println("Review Deleted");
            return true;
        }
        System.out.println("id of Review not found");
        return false;

         }
         
        public List<Reservation> afficherReservation() throws SQLException{
        List<Reservation> reservations = new ArrayList<>();
        String req = "select * from reservation;";
        stm = connect.createStatement();
        ResultSet rst = stm.executeQuery(req);
            while (rst.next()) {
            Reservation R = new Reservation (rst.getInt("idReservation"),
            rst.getInt("idProprietaireChien"),
            rst.getInt("idBusinessServices"),
            rst.getTimestamp("dateHeureDebut",Calendar.getInstance()),
            rst.getTimestamp("dateHeureFin",Calendar.getInstance()));

            //rst.getString("dateHeureFin"));


            reservations.add(R);
        }
        return reservations;
        }
        }
 




