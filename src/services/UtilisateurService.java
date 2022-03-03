/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entite.Individu;
import entite.Utilisateur;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyDB;

/**
 *
 * @author NADA_USER
 */
public class UtilisateurService implements  IUtilisateur <Utilisateur >{
    


    Connection connect;
    Statement stm;

    public UtilisateurService() {
        connect = MyDB.getInstance().getConnexion();
    }
    

        @Override
    public boolean login(String email, String password) throws SQLException {
             List<Utilisateur> utilisateurs=new ArrayList<>();
      String req="SELECT * FROM UTILISATEUR where (emil='"+email+"' AND password='"+password+"')";
      
             //exec
             Statement st=connect.createStatement();
             ResultSet rs= st.executeQuery(req);
             while(rs.next())
                {
               //  int idUtilisateur ; String email ;  String password; int numTel;  String type 
                 utilisateurs.add(new Utilisateur(rs.getInt("idUtilisateur"),rs.getString("email"), rs.getString("password"), rs.getInt("numtel"), rs.getString("type")));
                 
                }
              if(utilisateurs.isEmpty()){
                  return false;
                } 
              else{
                  return true;
                }
         
         
                 
    }

    


        @Override

    public List<Utilisateur> TrierUtilisateur() throws SQLException{
            List<Utilisateur> utilisateurs=new ArrayList<>();
      String req="SELECT * FROM UTILISATEUR ORDER BY nom ";
      
             //exec
             Statement st=connect.createStatement();
             ResultSet rs= st.executeQuery(req);
             while(rs.next())
             {
                 //String nom, String prenom, String sexe, String date,String email, String login, String mdp, String role
                 utilisateurs.add(new Utilisateur(rs.getInt("idUtilisateur"),rs.getString("email"), rs.getString("password"), rs.getInt("numtel"), rs.getString("type")));
             
         } 
return utilisateurs;
    }

    @Override
    public List<Utilisateur> chercherUtilisateur(String input) throws SQLException {
 List<Utilisateur> utilisateurs=new ArrayList<>();
      String req="SELECT * FROM UTILISATEUR where email="+input;
      try {
             //exec
             Statement st=connect.createStatement();
             ResultSet rs= st.executeQuery(req);
             while(rs.next())
             {
                 //String nom, String prenom, String sexe, String date,String email, String login, String mdp, String role
                 utilisateurs.add(new Utilisateur(rs.getInt("idUtilisateur"),rs.getString("email"), rs.getString("password"), rs.getInt("numtel"), rs.getString("type")));
             }
         } catch (SQLException ex) {
            ex.printStackTrace();
         }
return utilisateurs;    }

   
    }
    

    


   
  
    
  
  



  

