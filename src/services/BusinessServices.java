/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.Statement;
import utils.MyDB;
import entities.Business;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class BusinessServices implements Interface_Business {
      Connection connect;
      Statement stm;

    public BusinessServices() {
        connect=MyDB.getInstance().getConnexion();
    }
    
    public void ajouter(Business B)throws SQLException {
        PreparedStatement pre = connect.prepareStatement("INSERT INTO business (titre,description,prix,horaire,ville,localisation)VALUES (?,?,?,?,?,?);");
        /*pre.setInt(1, B.getIdBusiness());
        pre.setString(2, B.getTitre());
        pre.setString(3, B.getDescription());
        pre.setFloat(4, B.getPrix());
        pre.setString(5, B.getHoraire());
        pre.setString(6, B.getVille());
        pre.setString(7, B.getLocalisation());*/
        pre.setString(1, B.getTitre());
        pre.setString(2, B.getDescription());
        pre.setFloat(3, B.getPrix());
        pre.setString(4, B.getHoraire());
        pre.setString(5, B.getVille());
        pre.setString(6, B.getLocalisation());
                                    
        pre.executeUpdate();

    }
    

        
     public boolean Update(int idBusiness,String titre,String description,float prix,String horaire,String ville,String localisation) {
            try {

            PreparedStatement pre = connect.prepareStatement("UPDATE business SET titre = ? , description= ? , prix= ? , horaire= ? , ville= ? , localisation= ? where idBusiness= ? ;");
            pre.setString(1, titre);
            pre.setString(2, description);   
            pre.setFloat(3,prix);
            pre.setString(4,horaire);
            pre.setString(5, ville);
            pre.setString(6, localisation);
            pre.setInt(7, idBusiness);

            if (pre.executeUpdate() != 0) {
                System.out.println(" Business Updated");
                 } else {
                System.out.println("not Updated");
            }
                return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
      
 public boolean delete(Integer idBusiness) throws SQLException {

        PreparedStatement pre = connect.prepareStatement("Delete from business where idBusiness=? ;");
        pre.setInt(1, idBusiness);
        if (pre.executeUpdate() != 0) {
            System.out.println("business Deleted");
            return true;
        }
        System.out.println("id of business not found");
        return false;

    }
 
        public List<Business> afficherBusiness() throws SQLException{
        List<Business> businesses = new ArrayList<>();
        String req = "select * from business;";
        stm = connect.createStatement();
        ResultSet rst = stm.executeQuery(req);
            while (rst.next()) {
            Business a = new Business(rst.getInt("idBusiness"),
            rst.getString("titre"),
            rst.getString("description"),
            rst.getFloat("prix"),
            rst.getString("horaire"),
            rst.getString("ville"),
            rst.getString("localisation"));


            businesses.add(a);
        }
        return businesses;
        }
        }