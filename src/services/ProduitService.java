/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;


import static com.mysql.jdbc.Messages.getString;
import entities.Produit;
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
 * @author asus
 */
public class ProduitService implements IProduit<Produit>{
    
    Connection connexion;
    Statement stm;
    
    public ProduitService(){
        connexion = MyDB.getInstance().getConnexion();
    }
    

    
    @Override
       public void ajouterp(Produit p) throws SQLException {
        String req = "INSERT INTO `produit`(idCategorie,prix, nbEtoiles ,nom,  description, marque )  "
                + "VALUES (?, ?, ? ,?, ? , ?) ";
        PreparedStatement ps = connexion.prepareStatement(req);
        ps.setInt(1, p.getIdCategorie());
        ps.setFloat(2, p.getPrix());
        ps.setInt(3, p.getNbetoiles());
        ps.setString(4, p.getNom());
        ps.setString(5, p.getDescription());
        ps.setString(6, p.getMarque());
       
        ps.executeUpdate();
    }

    @Override
    public List<Produit> afficherproduit() throws SQLException {
        List<Produit> produits = new ArrayList<>();
        String req = "select * from produit";
        stm = connexion.createStatement();
        //ensemble de resultat
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Produit p = new Produit(
                    rst.getInt("IdProduit"),
                    rst.getInt("nbetoiles"),
                   
                    rst.getInt("idCategorie"),//or rst.getInt(1)
                  
                    rst.getString("nom"),
                    rst.getString("description"),
                    rst.getString("marque"),
                    rst.getFloat("prix"))
                    ;
                    
            produits.add(p);
        }
        return produits;
    }

    @Override
    public void deleteProduit(int idProduit) throws SQLException {
         String req = "delete from produit where idProduit =?";
        PreparedStatement ps = connexion.prepareStatement(req);
            ps.setInt(1, idProduit);
            ps.executeUpdate();
    }

    @Override
    public boolean updateProduit(int idProduit, int idCategorie, int nbetoiles, String nom, String description, String marque, float prix) {
        try {

            PreparedStatement pre = connexion.prepareStatement("UPDATE produit SET idProduit = ? , nbetoiles= ? ,nom = ? , description= ?,marque = ? , prix= ?  where idProduit= ? ;");
           pre.setInt(1, idCategorie);
            pre.setInt(2, nbetoiles);  
            pre.setString(3, nom);
            pre.setString(4, description);  
            pre.setString(5, marque);
            pre.setFloat(6, prix);   
            pre.setInt(7, idProduit);
            if (pre.executeUpdate() != 0) {
                System.out.println(" Produit Updated");
                 } else {
                System.out.println("not Updated");
            }
                return true;
            
            } catch (SQLException ex) {
            System.out.println(ex.getMessage());
                                        }
        return false;
    }

    @Override
    public List<Produit> afficherProduitTriP() throws SQLException {
 List<Produit> produits = new ArrayList<>();
        String req = "select * from produit order by prix";
        stm = connexion.createStatement();
        //ensemble de resultat
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Produit p = new Produit(
                    rst.getInt("IdProduit"),
                    rst.getInt("nbetoiles"),
                   
                    rst.getInt("idCategorie"),//or rst.getInt(1)
                  
                    rst.getString("nom"),
                    rst.getString("description"),
                    rst.getString("marque"),
                    rst.getFloat("prix"))
                    ;
                    
            produits.add(p);
        }
        return produits;    }

    @Override
    public List<Produit> afficherProduitParCategorie(String categorie) throws SQLException {
List<Produit> produits = new ArrayList<>();
        String req = "select * from produit p join categorie c on p.idCategorie=c.idCategorie where c.nom='" + categorie + "'";
        stm = connexion.createStatement();
        //ensemble de resultat
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Produit p = new Produit(
                    rst.getInt("IdProduit"),
                    rst.getInt("nbetoiles"),
                   
                    rst.getInt("idCategorie"),//or rst.getInt(1)
                  
                    rst.getString("nom"),
                    rst.getString("description"),
                    rst.getString("marque"),
                    rst.getFloat("prix"))
                    ;
                    
            produits.add(p);
        }
        return produits;     }

    @Override
    public List<Produit> RechercheProduit(String nom) throws SQLException {
        List<Produit> produits = new ArrayList<>();
        PreparedStatement pre = connexion.prepareStatement("select * from produit p join categorie c on p.idCategorie=c.idCategorie where c.nom like ? or p.nom like ?");
          
             pre.setString(1, "%" + nom+ "%");
             pre.setString(2, "%" + nom+ "%");
       
        //ensemble de resultat
        ResultSet rst = pre.executeQuery();
        

        while (rst.next()) {
            Produit p = new Produit(
                    rst.getInt("IdProduit"),
                    rst.getInt("nbetoiles"),
                   
                    rst.getInt("idCategorie"),//or rst.getInt(1)
                  
                    rst.getString("nom"),
                    rst.getString("description"),
                    rst.getString("marque"),
                    rst.getFloat("prix"))
                    ;
                    
            produits.add(p);
        }
        return produits;    }

    @Override
    public List<Produit> addichierProduitParNote() throws SQLException {
List<Produit> produits = new ArrayList<>();
        String req = "select * from produit order by nbEtoiles desc";
        stm = connexion.createStatement();
        //ensemble de resultat
        ResultSet rst = stm.executeQuery(req);

        while (rst.next()) {
            Produit p = new Produit(
                    rst.getInt("IdProduit"),
                    rst.getInt("nbetoiles"),
                   
                    rst.getInt("idCategorie"),//or rst.getInt(1)
                  
                    rst.getString("nom"),
                    rst.getString("description"),
                    rst.getString("marque"),
                    rst.getFloat("prix"))
                    ;
                    
            produits.add(p);
        }
        return produits;    }

 
    
    
}
