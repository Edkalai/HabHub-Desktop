/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package habhub;
import entities.Revue;
import entities.Business;
import entities.Individu;
import entities.ServiceBusiness;
import entities.Reservation;
import entities.Utilisateur;
import java.sql.SQLException;
import services.UserBusinessServices;
import services.ServiceBusinessServices;

import services.RevueServices;
import java.util.Date;
import java.sql.Timestamp;
import services.ReservationServices;


public class HabHub {

    /**
     * @param args the command line arguments
     **/
    public static void main(String[] args) {
        // TODO code application logic here
    
        //Reservation Res1 = new Reservation(-1);
        //Business B2 = new Business(-1,"nada","nouisser",10,new Date("2022-10-26"),"Ariana","yrltsggdfg");

        //Revue R1 = new Revue(2,7,0,3,"revue produit ahmed");
        //Utilisateur U2 = new Utilisateur("mariem12345678@gmail.com","mdp",92962405,"business");
       // Business UB2 = new Business(-1,U2,"DogSalon","","","","");
        //Utilisateur U1 = new Utilisateur("aziz@gmail.com","mdp",92962405,"individu");

        Individu I1 = new Individu(1);
        //Revue R2 = new Revue(I1,UB2,5,"revue business aziz");
        RevueServices RS1 = new RevueServices();
        //RevueServices RS2 = new RevueServices();
        //RS1.afficherRevueBusiness(R2);
        
        
        
        //Utilisateur U2 = new Utilisateur("aziz@gmail.com","mdp",98745632,"business");
        //Business UB2 = new Business(-1,U2,"DogNail","we are a grooming salon","horaire","la marsa","localisation","",5);
        Business UB2 = new Business(9);
        UserBusinessServices UBS1 = new UserBusinessServices();
        
        Revue R2 = new Revue(I1,UB2,5,"revue DogNail aziz");

        
        
        
        
        
       // Timestamp HrDeb = new Timestamp(System.currentTimeMillis());
       // Timestamp HrFin = new Timestamp(System.currentTimeMillis());
        //Reservation RV1 = new Reservation (-1,8,2,HrDeb,HrFin);
        //ReservationServices RVS1= new ReservationServices();
        //ServiceBusiness SB1 = new ServiceBusiness(-1,UB2,"grooming",20);
        //ServiceBusinessServices SBS1 = new ServiceBusinessServices();
       // try {
            //RS1.ajouterRevueProduit(R1);
            //RS1.ajouterRevueBusiness(R2);
            //UBS1.ajouter(UB2,U2);
            //SBS1.ajouter(SB1);
            //RS1.ajouterRevueBusiness(R2); 
            
            //System.out.println("ajout avec succes");
            //BS1.Update(19,"iheb","mejri",10,"15h-19h","Ariana","yrltsggdfg");
            //BS1.delete(1);
            
            
            
             //   } catch (SQLException ex) {
            //System.out.println(ex.getMessage());

        }
        
        /* try {
            //System.out.println("jmeet el bizbiz");
            System.out.println(RS1.afficherRevueBusiness("helloPet"));
            //System.out.println("jmeet el produit");
            //System.out.println(RS1.afficherRevueProduit());
            //System.out.println(SBS1.filterBusinessByType("vet")); 
            //System.out.println(SBS1.filterBusinessBy2Variables("vet","ville","ariana")); 
            //System.out.println(UBS1.rechercherBusinessByType("vet","ville")); 

            //System.out.println(UBS1.afficherVet());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
          
 
    }
    */
}
