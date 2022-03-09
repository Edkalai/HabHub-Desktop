/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import HabHub.MyListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import services.AnnonceAdoptionService;
import entities.AnnonceAdoption;
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
public class ChienFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private ImageView dogImage;

    @FXML
    private Label nameLabel;
    @FXML
    private Label ageLabel;

    @FXML
    private ImageView genderIcon;

    @FXML
    private Label locationLabel;
    
    @FXML
    private void onClick(MouseEvent mouseEvent) {
        myListener.onClickListener(annonceAdoption);
    }

    
    private AnnonceAdoption annonceAdoption;
     
    private MyListener myListener;
    

    public void setData(AnnonceAdoption annonceAdoption, MyListener myListener ) {
        this.annonceAdoption = annonceAdoption;
        this.myListener=myListener;
        nameLabel.setText(annonceAdoption.getIdChien().getNom()+",");
        ageLabel.setText(annonceAdoption.getIdChien().getAge());
        locationLabel.setText(annonceAdoption.getLocalisation());
        Image dogImg = new Image(getClass().getResourceAsStream("../assets/img/adoption/"+annonceAdoption.getIdChien().getImage()+".png"));
        dogImage.setImage(dogImg);
        //Image genderImg = new Image(getClass().getResourceAsStream("../assets/img/female.png"));
        Image genderImg = null;
        if (annonceAdoption.getIdChien().getSexe().toLowerCase().equals("m")) {
             genderImg = new Image(getClass().getResourceAsStream("../assets/img/male.png"));
        }
        else{
             genderImg = new Image(getClass().getResourceAsStream("../assets/img/female.png"));
            
        }
        genderIcon.setImage(genderImg);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
