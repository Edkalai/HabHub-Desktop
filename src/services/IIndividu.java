/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entite.Utilisateur;
import entite.Individu;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author NADA_USER
 */
public interface IIndividu {
             public void ajouter(Individu I,Utilisateur U)throws SQLException;
        public boolean Update(int idIndividu,Utilisateur utilisateur,String nom,String prenom,String dateNaissance,String sexe,String adresse, String facebook,String instagram, String whatsapp) ;
        public boolean delete(int idIndividu) throws SQLException;
        public List<Individu> afficherIndividu() throws SQLException;
}

