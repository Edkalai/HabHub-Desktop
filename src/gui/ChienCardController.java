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
import java.sql.SQLException;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;




/**
 * FXML Controller class
 *
 * @author Ed
 */
public class ChienCardController implements Initializable {

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
     private CommunityListener communityListener;
     private AnnonceProprietaireChien annonceProprietaireChien;
     
     
     
      
  
    
     @FXML
    private void click(MouseEvent mouseEvent) {
        communityListener.onClickListener(annonceProprietaireChien);
        
     
    }
   
   

    public void setData(AnnonceProprietaireChien annonceProprietaireChien,CommunityListener communityListener) {
        this.annonceProprietaireChien = annonceProprietaireChien;
        this.communityListener=communityListener;
        nameLabel.setText(annonceProprietaireChien.getChien().getNom()+",");
        ageLabel.setText(annonceProprietaireChien.getChien().getAge());
        locationLabel.setText(annonceProprietaireChien.getLocalisation());
        Image dogImg = new Image(getClass().getResourceAsStream("../assets/img/chien/"+annonceProprietaireChien.getChien().getImage()+".png"));
        dogImage.setImage(dogImg);
        Image genderImg = new Image(getClass().getResourceAsStream("../assets/img/female.png"));
        if ("M".equals(annonceProprietaireChien.getChien().getSexe())){
            genderImg = new Image(getClass().getResourceAsStream("../assets/img/male.png"));
        }
        genderIcon.setImage(genderImg);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
