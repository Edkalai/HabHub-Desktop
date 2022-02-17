/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Revue;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author User
 */
public interface Interface_Revue {
        public void ajouter(Revue R)throws SQLException ;
        public boolean Update(int idRevue,int idUtilisateur,int nbEtoiles,String commentaire) ;
        public boolean delete(Integer idRevue) throws SQLException;
        public List<Revue> afficherRevue() throws SQLException;


}
