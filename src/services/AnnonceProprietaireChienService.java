package services;

import entities.AnnonceProprietaireChien;
import utils.MyDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AnnonceProprietaireChienService {
     private Connection connect;
    private Statement ste;

    public AnnonceProprietaireChienService() {
        connect = MyDB.getInstance().getConnexion();

    }

   
    
     public void ajouterAnnonceAccouplement(AnnonceProprietaireChien a) throws SQLException {
        PreparedStatement pre = connect.prepareStatement("INSERT INTO annonce_proprietaire_chien (idChien, datePublication,description,type,Localisation)VALUES (?,?,?,?,?);");
        pre.setInt(1, a.getIdChien());
        pre.setString(2, a.getDatePublication());
        pre.setString(3, a.getDescription());
        pre.setString(4, a.getType());
        pre.setString(5, a.getLocalisation());
        pre.executeUpdate();
    }
     
     public void ajouterAnnonceChienPerdu(AnnonceProprietaireChien a) throws SQLException {
        PreparedStatement pre = connect.prepareStatement("INSERT INTO annonce_proprietaire_chien (idChien, datePublication,description,type,datePerte,Localisation,messageVocal) VALUES (?,?,?,?,?,?,?);");
        pre.setInt(1, a.getIdChien());
        pre.setString(2, a.getDatePublication());
        pre.setString(3, a.getDescription());
        pre.setString(4, a.getType());
        pre.setString(5, a.getDatePerte());
        pre.setString(6, a.getLocalisation());
        pre.setString(7, a.getMessageVocal());
        pre.executeUpdate();
    }

     
     
    public boolean updateAnnonceAccouplement(int idAnnonceProprietaireChien,String description,String localisation) {
            try {
            PreparedStatement pre = connect.prepareStatement("UPDATE annonce_proprietaire_chien SET description= ? , localisation= ? where idAnnonceProprietaireChien=?;");
            pre.setString(1, description);
            pre.setString(2, localisation);
            pre.setInt(3, idAnnonceProprietaireChien);

            

            if (pre.executeUpdate() != 0) {
                System.out.println(" Annonce Accouplement updated");
                 } else {
                System.out.println("Annonce Accouplement not updated");
            }
                return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
    public boolean updateAnnonceChienPerdu(int idAnnonceProprietaireChien,String description,String datePerte ,String localisation,String messageVocal) {
            try {
            PreparedStatement pre = connect.prepareStatement("UPDATE annonce_proprietaire_chien SET description= ? , datePerte= ? , localisation= ? ,messageVocal=? where idAnnonceProprietaireChien=?;");
            pre.setString(1, description);
            pre.setString(2, datePerte);
            pre.setString(3, localisation);
            pre.setString(4, messageVocal);
            pre.setInt(5, idAnnonceProprietaireChien);
            
            

            if (pre.executeUpdate() != 0) {
                System.out.println(" Annonce Chien Perdu updated");
                 } else {
                System.out.println("Annonce Chien Perdu not updated");
            }
                return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    
    public boolean delete(int idAnnonceProprietaireChien) throws SQLException {

        PreparedStatement pre = connect.prepareStatement("Delete from annonce_proprietaire_chien where IdAnnonceProprietaireChien=? ;");
        pre.setInt(1, idAnnonceProprietaireChien);
        if (pre.executeUpdate() != 0) {
            System.out.println("Annonce Deleted");
            return true;
        }
        System.out.println("Annonce not found");
        return false;

    }
    
       public List<AnnonceProprietaireChien> afficherAnnonceAccouplement() throws SQLException {
        List<AnnonceProprietaireChien> annoncesAccouplement = new ArrayList<>();
        String req = "select * from annonce_proprietaire_chien where type='A';";
        ste = connect.createStatement();
        ResultSet rst = ste.executeQuery(req);

        while (rst.next()) {
            AnnonceProprietaireChien a = new AnnonceProprietaireChien(rst.getInt("idAnnonceProprietaireChien"),
            rst.getInt("idChien"),
            rst.getString("datePublication"),
            rst.getString("description"),
            rst.getString("type"),
            rst.getString("localisation"));
         
            
            annoncesAccouplement.add(a);
        }
        return annoncesAccouplement;
    }
        public List<AnnonceProprietaireChien> afficherAnnonceChienPerdu() throws SQLException {
        List<AnnonceProprietaireChien> annoncesAccouplement = new ArrayList<>();
        String req = "select * from annonce_proprietaire_chien where type='P';";
        ste = connect.createStatement();
        ResultSet rst = ste.executeQuery(req);

        while (rst.next()) {
            AnnonceProprietaireChien a = new AnnonceProprietaireChien(rst.getInt("idAnnonceProprietaireChien"),
            rst.getInt("idChien"),
            rst.getString("datePublication"),
            rst.getString("description"),
            rst.getString("type"),
            rst.getString("datePerte"),
            rst.getString("localisation"),
            rst.getString("messageVocal"));
         
            
            annoncesAccouplement.add(a);
        }
        return annoncesAccouplement;
    }
     
}
