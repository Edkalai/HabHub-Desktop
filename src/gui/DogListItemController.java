/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import HabHub.CommunityListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import services.AnnonceProprietaireChienService;
import entities.AnnonceProprietaireChien;
import entities.Chien;
import java.sql.SQLException;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;




/**
 * FXML Controller class
 *
 * @author Ed
 */
public class DogListItemController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
      @FXML
    private ImageView dogImage;

    @FXML
    private Label dogName;

    @FXML
    private ImageView dogGenderIcon;

    @FXML
    private Label dogGenderLabel;

    @FXML
    private Label ageLabel;

    @FXML
    private Label dogBreedLabel;

    @FXML
    private Label dogGroupLabel;

     //private CommunityListener communityListener;
     private Chien chien;
     
     
     
      
  
  
   
   

    public void setData(Chien chien) {
        this.chien = chien;
        dogName.setText(chien.getNom()+",");
        ageLabel.setText(chien.getAge());
        Image dogImg = new Image(getClass().getResourceAsStream("../assets/img/chien/"+chien.getImage()+".png"));
        dogImage.setImage(dogImg);
        Image genderImg = new Image(getClass().getResourceAsStream("../assets/img/female.png"));
        dogGenderLabel.setText("Female");
        if ("M".equals(chien.getSexe())) {
            genderImg = new Image(getClass().getResourceAsStream("../assets/img/male.png"));
            dogGenderLabel.setText("Male");
        }
        dogGenderIcon.setImage(genderImg);
        dogGroupLabel.setText(chien.getGroupe());
        dogBreedLabel.setText(chien.getRace());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
