/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package habhub;

import entities.Business;
import java.sql.SQLException;
import services.BusinessServices;



public class HabHub {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*Business B1 = new Business("salma","Nouisser",10,"15h-19h","Ariana","yrltsggdfg");*/
        Business B2 = new Business(-1,"ines","selmi",10,"15h-19h","Ariana","yrltsggdfg");

       
        BusinessServices BS1 = new BusinessServices();
        
        try {
            BS1.ajouter(B2);
            System.out.println("ajout avec succes");
            BS1.Update(14,"petstore","BENSLIMEN",600,"15h-19h","Ariana","yrltsggdfg");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        
        try {
            System.out.println(BS1.afficherBusiness());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
  
       
        
    }
    
}
