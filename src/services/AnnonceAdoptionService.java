/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.AnnonceAdoption;
import entities.Chien;
import entities.Individu;
import entities.Utilisateur;
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
 * @author Tun21
 */
public class AnnonceAdoptionService implements IAnnonceAdoption<AnnonceAdoption> {
    
    Connection connexion;
    Statement stm;

    public AnnonceAdoptionService() {
        connexion = MyDB.getInstance().getConnexion();
    }
    
    

    @Override
    public void addAnnonceAdoption(AnnonceAdoption a) throws SQLException {
        String req = "insert into annonce_adoption (idIndividu,idChien,datePublication,description,localisation) values (?,?,SYSDATE(),?,?)";
        PreparedStatement ps = connexion.prepareStatement(req);
            ps.setInt(1, a.getIdIndividu().getIdIndividu());
            ps.setInt(2, a.getIdChien().getIdChien());
            ps.setString(3, a.getDescription());
            ps.setString(4, a.getLocalisation());
            ps.executeUpdate();
            
    }

    @Override
    public void updateAnnonceAdoption(AnnonceAdoption a) throws SQLException {
        String req = "update annonce_adoption set idChien=?, datePublication=?, description=?, localisation=? where idAnnonceAdoption =?";
        PreparedStatement ps = connexion.prepareStatement(req);
            ps.setInt(1, a.getIdChien().getIdChien());
            java.sql.Date sqlDatePublication = new java.sql.Date( a.getDatePublication().getTime() );
            ps.setDate(2,sqlDatePublication);
            //ps.setDate(3, a.getDatePublication());
            ps.setString(3, a.getDescription());
            ps.setString(4, a.getLocalisation());
            ps.setInt(5, a.getIdAnnonceAdoption());
            ps.executeUpdate();
            
        
    }

    @Override
    public void deleteAnnonceAdoption(int id) throws SQLException {
        String req = "delete from annonce_adoption where idAnnonceAdoption =?";
        PreparedStatement ps = connexion.prepareStatement(req);
            ps.setInt(1, id);
            ps.executeUpdate();
            
    }

    @Override
    public List displayAnnonceAdoption() throws SQLException {
        List<AnnonceAdoption> listeannonces = new ArrayList<AnnonceAdoption>();

        String req = "select * from annonce_adoption a join chien c on a.idChien=c.idChien join individu i on a.idIndividu=i.idIndividu order by datePublication desc";
        stm = connexion.createStatement();
            //ensemble de resultat
        ResultSet rst = stm.executeQuery(req);
        //IChien cs = ChienService.getInstance();
        //ChienService cs = new ChienService();
        while (rst.next()) {
            /*AnnonceAdoption a = new AnnonceAdoption(rst.getInt("idAnnonceAdoption"),rst.getInt("idIndividu"),rst.getInt("idChien"),rst.getDate("datePublication"),
            rst.getString("description"),rst.getString("localisation"));*/
            Utilisateur nu= new Utilisateur(rst.getInt("idUtilisateur"));
            Individu  ni= new Individu(rst.getInt("idIndividu"),nu,rst.getString("i.nom"),rst.getString("prenom"),rst.getDate("dateNaissance"),rst.getString("adresse"),
            rst.getString("facebook"),rst.getString("instagram"),rst.getString("whatsapp"));
            Chien nc = new Chien(rst.getString("c.nom"),rst.getString("c.sexe"),rst.getString("age"),rst.getBoolean("vaccination"),rst.getString("description"),rst.getString("image")
            ,rst.getString("color"),rst.getString("race"),rst.getString("groupe"));
            AnnonceAdoption a = new AnnonceAdoption(
            ni,
            nc,
            rst.getDate("datePublication"),
            rst.getString("description"),
            rst.getString("localisation"));
            
            listeannonces.add(a);
        }
        return listeannonces;
    }
       //select * from chien join annonce_adoption from a annonce_adoption, c chien on c.idChien=a.idChien where idChien=?

    @Override
    public List<AnnonceAdoption> rechercheAnnonceAdoption(String nom) throws SQLException {
        List<AnnonceAdoption> annonce = new ArrayList<>();
        //List<Chien> chiens = new ArrayList<>();
        String req = "select * from chien c join annonce_adoption a on c.idChien=a.idChien join individu i on a.idIndividu=i.idIndividu where c.nom like ? or i.nom like ? or a.localisation like ?";
        PreparedStatement ps = connexion.prepareStatement(req);
            ps.setString(1, "%" + nom+ "%");
            ps.setString(2, "%" + nom+ "%");
            ps.setString(3, "%" + nom+ "%");
            ResultSet rst = ps.executeQuery();
            while (rst.next()) {
            Utilisateur nu= new Utilisateur(rst.getInt("idUtilisateur"));
            Individu  ni= new Individu(rst.getInt("idIndividu"),nu,rst.getString("i.nom"),rst.getString("prenom"),rst.getDate("dateNaissance"),rst.getString("adresse"),
                                       rst.getString("facebook"),rst.getString("instagram"),rst.getString("whatsapp"));
            Chien nc = new Chien(rst.getString("c.nom"),rst.getString("c.sexe"),rst.getString("age"),rst.getBoolean("vaccination"),rst.getString("description"),rst.getString("image"),
                                 rst.getString("color"),rst.getString("race"),rst.getString("groupe"));
            AnnonceAdoption a = new AnnonceAdoption(
            rst.getInt("idAnnonceAdoption"),
            ni,
            nc,
            rst.getDate("datePublication"),
            rst.getString("description"),
            rst.getString("localisation"));
                
                annonce.add(a);
            }
            return annonce;
    }
    public List<AnnonceAdoption> FilterAnnonceAdoption(String filtre,String valeur) throws SQLException {
        List<AnnonceAdoption> listeannonces= new ArrayList<>();
        PreparedStatement ps = connexion.prepareStatement("select * from annonce_adoption a join chien c ON a.idChien=c.idChien join individu i on a.idIndividu=i.idIndividu where  "+filtre+" = ?;");
        ps.setString(1,valeur);
        ResultSet rst = ps.executeQuery();
        while (rst.next()) {
            /*AnnonceAdoption a = new AnnonceAdoption(rst.getInt("idAnnonceAdoption"),rst.getInt("idIndividu"),rst.getInt("idChien"),rst.getDate("datePublication"),
            rst.getString("description"),rst.getString("localisation"));*/
            Utilisateur nu= new Utilisateur(rst.getInt("idUtilisateur"));
            Individu  ni= new Individu(rst.getInt("idIndividu"),nu,rst.getString("i.nom"),rst.getString("prenom"),rst.getDate("dateNaissance"),rst.getString("adresse"),
            rst.getString("facebook"),rst.getString("instagram"),rst.getString("whatsapp"));
            Chien nc = new Chien(rst.getString("c.nom"),rst.getString("c.sexe"),rst.getString("age"),rst.getBoolean("vaccination"),rst.getString("description"),rst.getString("image"),
                                 rst.getString("color"),rst.getString("race"),rst.getString("groupe"));
            AnnonceAdoption a = new AnnonceAdoption(
            rst.getInt("idAnnonceAdoption"),
            ni,
            nc,
            rst.getDate("datePublication"),
            rst.getString("description"),
            rst.getString("localisation"));
            
            listeannonces.add(a);
        }
        return listeannonces;
    }
    
    
    /*@Override
    public List<AnnonceAdoption> afficherAnnonceLocation(String L) throws SQLException {
        List<AnnonceAdoption> annonce = new ArrayList<>();
        String req = "select * from annonce_adoption where localisation=?";
        PreparedStatement ps = connexion.prepareStatement(req);
            ps.setString(1, L);
            ResultSet rst = ps.executeQuery();

        while (rst.next()) {
            AnnonceAdoption a = new AnnonceAdoption(rst.getInt("idAnnonceAdoption"),rst.getInt("idIndividu"),rst.getInt("idChien"),rst.getDate("datePublication"),
            rst.getString("description"),rst.getString("localisation"));
            annonce.add(a);
        }
        return annonce;
    }*/

    /*@Override
    public List<AnnonceAdoption> afficherAnnonceParIndividu(String nom) throws SQLException {
        List<AnnonceAdoption> annonce = new ArrayList<>();
       AnnonceAdoption a = new AnnonceAdoption();
        String req = "select * from chien where idIndividu=? ";
        PreparedStatement ps = connexion.prepareStatement(req);
            ps.setString(1, nom);
            ResultSet rst = ps.executeQuery();
            while (rst.next()) {
                a.setIdAnnonceAdoption(rst.getInt(1));
                a.setIdIndividu(rst.getInt(2));
                a.setIdChien(rst.getInt(3));
                a.setDatePublication(rst.getDate(4));
                a.setDescription(rst.getString(5));
                a.setLocalisation(rst.getString(6));
                
                annonce.add(a);
            }
            return annonce;
    }*/
}
