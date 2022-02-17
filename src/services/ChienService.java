package services;

import entities.Chien;
import utils.MyDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ChienService {
     private Connection connect;
    private Statement ste;

    public ChienService() {
        connect = MyDB.getInstance().getConnexion();

    }

   
    
     public void ajouterChien(Chien c) throws SQLException {
        PreparedStatement pre = connect.prepareStatement("INSERT INTO chien (idProprietaireChien, nom,sexe,age,vaccination,description)VALUES (?,?,?,?,?,?);");
        pre.setInt(1,c.getIdProprietaireChien());
        pre.setString(2,c.getNom());
        pre.setString(3,c.getSexe());
        pre.setString(4,c.getAge());
        pre.setBoolean(5,c.getVaccination());
        pre.setString(6,c.getDescription());
        pre.executeUpdate();
    }
   

     
     
    public boolean updateChien(int idChien,String nom,String sexe,String age,boolean vaccination,String description) {
            try {
            PreparedStatement pre = connect.prepareStatement("UPDATE chien SET nom= ? , sexe= ?, age= ?, vaccination= ?, description= ? where idChien=?;");
            pre.setString(1, nom);
            pre.setString(2, sexe);
            pre.setString(3, age);
            pre.setBoolean(4, vaccination);
            pre.setString(5, description);
            pre.setInt(6, idChien);
            

            if (pre.executeUpdate() != 0) {
                System.out.println(" Chien updated");
                 } else {
                System.out.println("Chien not updated");
            }
                return true;
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
    
   
    
    public boolean delete(int idChien) throws SQLException {

        PreparedStatement pre = connect.prepareStatement("Delete from chien where IdChien=? ;");
        pre.setInt(1, idChien);
        if (pre.executeUpdate() != 0) {
            System.out.println("Chien Deleted");
            return true;
        }
        System.out.println("Chien not found");
        return false;

    }
    
       public List<Chien> afficherChien() throws SQLException {
        List<Chien> chiens = new ArrayList<>();
        String req = "select * from chien;";
        ste = connect.createStatement();
        ResultSet rst = ste.executeQuery(req);

        while (rst.next()) {
            Chien a = new Chien(rst.getInt("idChien"),
            rst.getInt("idProprietaireChien"),
            rst.getString("nom"),
            rst.getString("sexe"),
            rst.getString("age"),
            rst.getBoolean("vaccination"),
            rst.getString("description"));
         
            
            chiens.add(a);
        }
        return chiens;
    }
        
     
}
