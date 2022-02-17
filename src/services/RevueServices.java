/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Revue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import utils.MyDB;

/**
 *
 * @author User
 */
public class RevueServices implements Interface_Revue {
      Connection connect;
      Statement stm;

    public RevueServices() {
      connect=MyDB.getInstance().getConnexion();

    }
       public void ajouter(Revue R)throws SQLException {
        PreparedStatement pre = connect.prepareStatement("INSERT INTO revue (idRevue,idUtilisateur,nbEtoiles,commentaire)VALUES (?,?,?,?);");
        pre.setInt(1, R.getIdRevue());
        pre.setInt(2, R.getIdUtilisateur());
        pre.setInt(3, R.getNbEtoiles());
        pre.setString(4,R.getCommentaire());

        pre.executeUpdate();
   }
     
    
    public boolean Update(int idRevue,int idUtilisateur,int nbEtoiles,String commentaire) {
            try {

            PreparedStatement pre = connect.prepareStatement("UPDATE revue SET idUtilisateur = ? , nbEtoiles= ? , commentaire= ?  where idRevue= ? ;");
            pre.setInt(1, idUtilisateur);
            pre.setInt(2, nbEtoiles);
            pre.setString(3, commentaire);   
            pre.setInt(5,idRevue);

            if (pre.executeUpdate() != 0) {
                System.out.println(" Revue Updated");
                 } else {
                System.out.println("not Updated");
            }
                return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
 public boolean delete(Integer idRevue) throws SQLException {

        PreparedStatement pre = connect.prepareStatement("Delete from revue where idRevue=? ;");
        pre.setInt(1, idRevue);
        if (pre.executeUpdate() != 0) {
            System.out.println("Review Deleted");
            return true;
        }
        System.out.println("id of Review not found");
        return false;

    }
    public List<Revue> afficherRevue() throws SQLException{
        List<Revue> revues = new ArrayList<>();
        String req = "select * from reservation;";
        stm = connect.createStatement();
        ResultSet rst = stm.executeQuery(req);
            while (rst.next()) {
            Revue R = new Revue (rst.getInt("idRevue"),
            rst.getInt("idUtilisateur"),
            rst.getInt("nbEtoiles"),
            rst.getString("commentaire"));

            revues.add(R);
        }
        return revues;
        }
        }
 
