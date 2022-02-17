package services;

import entities.ProprietaireChien;
import utils.MyDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProprietaireChienService {
     private Connection connect;
    private Statement ste;

    public ProprietaireChienService() {
        connect = MyDB.getInstance().getConnexion();

    }

   
    
     public void ajouterProprietaireChien(ProprietaireChien p) throws SQLException {
        PreparedStatement pre = connect.prepareStatement("INSERT INTO proprietaire_chien (idUtilisateur, bio)VALUES (?,?);");
        pre.setInt(1,p.getIdUtilisateur());
        pre.setString(2,p.getBio());
        pre.executeUpdate();
    }
   

     
     
    public boolean updateProprietaireChien(int idProprietaireChien,String bio) {
            try {
            PreparedStatement pre = connect.prepareStatement("UPDATE proprietaire_chien SET bio= ? where idProprietaireChien=?;");
            pre.setString(1, bio);
            pre.setInt(2, idProprietaireChien);
            

            if (pre.executeUpdate() != 0) {
                System.out.println(" Proprietaire Chien updated");
                 } else {
                System.out.println(" Proprietaire Chien not updated");
            }
                return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
   
    
    public boolean delete(int idProprietaireChien) throws SQLException {

        PreparedStatement pre = connect.prepareStatement("Delete from proprietaire_chien where idProprietaireChien=? ;");
        pre.setInt(1, idProprietaireChien);
        if (pre.executeUpdate() != 0) {
            System.out.println(" Proprietaire Chien Deleted");
            return true;
        }
        System.out.println(" Proprietaire Chien not found");
        return false;

    }
    
     public List<ProprietaireChien> afficherProprietaireChien() throws SQLException {
        List<ProprietaireChien> proprietairesChien = new ArrayList<>();
        String req = "select * from proprietaire_chien;";
        ste = connect.createStatement();
        ResultSet rst = ste.executeQuery(req);

        while (rst.next()) {
            ProprietaireChien p = new ProprietaireChien(rst.getInt("idProprietaireChien"),
            rst.getInt("idUtilisateur"),
            rst.getString("bio"));
            proprietairesChien.add(p);
        }
        return proprietairesChien;
    }
        
     
}
