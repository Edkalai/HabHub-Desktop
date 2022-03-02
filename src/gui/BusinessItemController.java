/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import entities.Business;
import java.sql.SQLException;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.image.Image;



/**
 * FXML Controller class
 *
 * @author 
 */
public class BusinessItemController implements Initializable {

    /**
     * Initializes the controller class.
     */
   
     @FXML
    private ImageView businessImage;

    @FXML
    private Label businessTitle;

    @FXML
    private Label villeLabel;

    @FXML
    private Label nbEtoilesLabel;

    @FXML
    private Label horaireLabel;

    @FXML
    private Button bookingButton;

     private Business business;
    

    public void setData(Business business) {
        this.business = business;
        businessTitle.setText(business.getTitre());
        villeLabel.setText(business.getVille());
        horaireLabel.setText(business.getHoraire());
        nbEtoilesLabel.setText("5");
        Image bImage = new Image(getClass().getResourceAsStream("../assets/img/business/BusinessItem/vetImage.png"));
        
        businessImage.setImage(bImage);
        /*Image genderImg = new Image(getClass().getResourceAsStream("../assets/img/female.png"));
        if ("M".equals(annonceProprietaireChien.getChien().getSexe())){
            genderImg = new Image(getClass().getResourceAsStream("../assets/img/male.png"));
        }
        genderIcon.setImage(genderImg);*/
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
