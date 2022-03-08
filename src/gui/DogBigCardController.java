/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import HabHub.DogItemListener;
import entities.Chien;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Ed
 */
public class DogBigCardController implements Initializable {

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
    private Label likeNumberLabel;

    private DogItemListener dogItemListener;
    private Chien chien;

    @FXML
    private void click(MouseEvent mouseEvent) {
        dogItemListener.onClickListener(chien);
    }

    public void setData(Chien chien, DogItemListener dogItemListener) {
        this.chien = chien;
        this.dogItemListener = dogItemListener;
        nameLabel.setText(chien.getNom() + ",");
        ageLabel.setText(chien.getAge());
        Image dogImg = new Image(getClass().getResourceAsStream("../assets/img/chien/" + chien.getImage() + ".png"));
        dogImage.setImage(dogImg);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
