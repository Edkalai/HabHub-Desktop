/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package habhub;

import entite.Individu;
import entite.Utilisateur;
import java.sql.SQLException;
import services.UserIndividuServices;
//import services.UtilisateurService;



public class HabHub {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        
       
              UserIndividuServices uis = new UserIndividuServices();
              Utilisateur t = new Utilisateur();
        Individu i = new Individu(2,t,"nada", "nouisser","123","bhgy","fff","fff","fff","fff");
       
      /* try{
        uis.ajouter(i, t);
         } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }*/
        
        //us.AjouterUser(u);
        
          //us.modifierUser(u);
          //us.SupprimerUser(1);
          
          
          
         /*
        try {
            System.out.println(uis.afficherIndividu());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
  */
 
        
    }
}
    

