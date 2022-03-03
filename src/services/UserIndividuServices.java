/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entite.Individu;
import entite.Utilisateur;
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
 * @author NADA_USER
 */
public class UserIndividuServices implements IIndividu {
    
         Connection connect;
      Statement stm;

    public UserIndividuServices() {
        connect=MyDB.getInstance().getConnexion();
    }

    @Override
    public void ajouter(Individu I , Utilisateur U) throws SQLException {
            PreparedStatement preUser = connect.prepareStatement("INSERT INTO utilisateur (email,password,numTel,type)VALUES (?,?,?,?);");
        preUser.setString(1, U.getEmail());
        preUser.setString(2, U.getPassword());
        preUser.setInt(3, U.getNumTel());
        preUser.setString(4, U.getType());
        preUser.executeUpdate();

        PreparedStatement stm = connect.prepareStatement("select idUtilisateur from utilisateur where email =?;");
        stm.setString(1, U.getEmail());
        ResultSet rst = stm.executeQuery();
        
        Utilisateur u = new Utilisateur ();
        while (rst.next()){
        u.setIdUtilisateur(rst.getInt("idUtilisateur"));
        }
      
        PreparedStatement pre = connect.prepareStatement("INSERT INTO indivdu (idUtilisateur,nom,prenom,dateNaissance,sexe,adresse,facebook,instagram,whatsapp)VALUES (?,?,?,?,?,?,?,?,?);");
        pre.setInt(1,u.getIdUtilisateur());      
        pre.setString(2, I.getNom());
        pre.setString(3, I.getPrenom());
        pre.setString(4, I.getDateNaissance());
        pre.setString(5, I.getAdresse());
        pre.setString(6, I.getFacebook());
        pre.setString(7, I.getInstagram());
        pre.setString(8, I.getWhatsapp());
                                    
        pre.executeUpdate();
        
    }

    @Override
    public boolean Update(int idIndividu, Utilisateur utilisateur, String nom, String prenom, String dateNaissance, String sexe,String adresse, String facebook, String instagram, String whatsapp) {
                    try {

            PreparedStatement pre = connect.prepareStatement("UPDATE individu SET nom = ? , prenom= ? ,dateNaissance= ? , sexe= ? , adresse= ? , facebook= ?,instagram= ? , whatsapp= ? , where idIndividu= ? ;");
            pre.setString(1, nom);
            pre.setString(2, prenom);   
            pre.setString(3,dateNaissance);
            pre.setString(4, sexe);
            pre.setString(5, adresse);
            pre.setString(6, facebook);
            pre.setString(7, instagram);
            pre.setString(8, whatsapp);

            if (pre.executeUpdate() != 0) {
                System.out.println("individu Updated successfully!!");
                 } else {
                System.out.println("not Updated!!!");
            }
                return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(int idIndividu) throws SQLException {
        PreparedStatement pre = connect.prepareStatement("Delete from individu where idIndividu=? ;");
        pre.setInt(1, idIndividu);
        if (pre.executeUpdate() != 0) {
            System.out.println("individu Deleted");
            return true;
        }
        System.out.println("id of individu not found");
        return false;

    }
 
   

    @Override
    public List<Individu> afficherIndividu() throws SQLException {
               
        List<Individu> Individu = new ArrayList<>();
        String req = "select * from individu;";
        stm = connect.createStatement();
        ResultSet rst = stm.executeQuery(req);
            while (rst.next()) {
            Individu k = new Individu(rst.getInt("idIndividu"),
                       new Utilisateur(rst.getInt     ("idUtilisateur"))  ,
            rst.getString("nom"),
            rst.getString("prenom"),
            rst.getString("dateNaissance"),
            rst.getString("sexe"),
            rst.getString("adresse"),
                        rst.getString("facebook"),
                        rst.getString("instagram"),
                        rst.getString("whatsapp"));



            Individu.add(k);
        }
        return Individu;
    }
    
}
