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
import services.UtilisateurService;
import utils.Statics;
//import services.UtilisateurService;



public class HabHub {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        
       
     UserIndividuServices uis = new UserIndividuServices();
              Utilisateur t = new Utilisateur("ahmedkalai@gmail.com","mdp",23070294,"I");
        Individu i = new Individu(t,"nada", "nouisser","123","bhgy","fff","fff","fff","fff");
          UtilisateurService u = new UtilisateurService();
       
        u.UpdateUser(7, "e", "k", 0, "r");
        
        
        System.out.println("choof edited wallee!!");
        
            System.out.println(Statics.currentIndividu);
                
        
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
    

