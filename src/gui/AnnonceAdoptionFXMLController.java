/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import HabHub.MyListener;
import entities.AnnonceAdoption;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import services.AnnonceAdoptionService;


/**
 * FXML Controller class
 *
 * @author Ed
 */
public class AnnonceAdoptionFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */

    @FXML
    private Label chienNameLable;
    @FXML
    private Label chienAge;
    @FXML
    private Label chienDescription;

    @FXML
    private Label chienSexe;
    @FXML
    private ImageView chienImg;

    @FXML
    private Label adoptionLocation;
    @FXML
    private Label adoptionFosterName; 
    @FXML
    private Label adoptionFosterAdress; 
    @FXML
    private GridPane grid;
    private MyListener myListener;
     
    public ObservableList<AnnonceAdoption> annoncesAdoption = FXCollections.observableArrayList();
    AnnonceAdoptionService sa=new AnnonceAdoptionService();
    
    private List<AnnonceAdoption> getAnnonceAdoption(){
        List<AnnonceAdoption> annonces=new ArrayList<>();
  
    try {
          annonces=sa.displayAnnonceAdoption();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    return annonces;
    
}
    private void setChosenChien(AnnonceAdoption a) {
        /*chienNameLable.setText(a.getIdChien().getNom());
        chienSexe.setText(a.getIdChien().getSexe());
        chienAge.setText(a.getIdChien().getAge());
        chienDescription.setText(a.getIdChien().getDescription());
        adoptionLocation.setText(a.getLocalisation());
        adoptionFosterName.setText(a.getIdIndividu().getPrenom());
        adoptionFosterAdress.setText(a.getIdIndividu().getAdresse());*/
        Image dogImg = new Image(getClass().getResourceAsStream("../assets/img/dog.png"));
        chienImg.setImage(dogImg);
        
        /*chosenFruitCard.setStyle("-fx-background-color: #" + fruit.getColor() + ";\n" +
                "    -fx-background-radius: 30;");*/
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        annoncesAdoption.addAll(getAnnonceAdoption());
        if (annoncesAdoption.size() > 0) {
            setChosenChien(annoncesAdoption.get(0));
            MyListener myListener = new MyListener(){
            @Override
            public void onClickListener(AnnonceAdoption annonceAdoption) {
                setChosenChien(annonceAdoption);
            }
            
        };
        }
        int column = 0;
        int row = 1;
        
        try {
            for (int i = 0; i < annoncesAdoption.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ChienFXML.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ChienFXMLController chienController = fxmlLoader.getController();
                chienController.setData(annoncesAdoption.get(i),myListener);

                if (column == 6) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_PREF_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_PREF_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
