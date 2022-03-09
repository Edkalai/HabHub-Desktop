/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import entite.Individu;
import entite.Utilisateur;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.FXCollections;



public class MyDB {
    
    final String url ="jdbc:mysql://localhost:3306/habhub";
    final String login ="root";
    final String pwd="";
    private static MyDB instance;
    Connection connexion;
    
    
    private MyDB(){
        
        try {
            connexion =  DriverManager.getConnection(url, login, pwd);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    public static MyDB getInstance(){
    if (instance == null)
        instance = new MyDB();
    return instance;
    }

    public Connection getConnexion() {
        return connexion;
    }
    
    
    private List<Individu> afficherIndividu(){
        Connection connexion =  MyDB.getInstance().getConnexion();
        List<Individu> list = FXCollections.observableArrayList();
        return null ;
    }
   
}