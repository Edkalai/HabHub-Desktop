/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entities.AnnonceProprietaireChien;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import services.AnnonceProprietaireChienService;


/**
 * FXML Controller class
 *
 * @author Ed
 */
public class CommunityFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private GridPane grid;
     
    public ObservableList<AnnonceProprietaireChien> annoncesProprietaireChien = FXCollections.observableArrayList();
    AnnonceProprietaireChienService sa=new AnnonceProprietaireChienService();
    
    private List<AnnonceProprietaireChien> getAnnoncesProprietaireChien(){
        List<AnnonceProprietaireChien> annonces=new ArrayList<>();
  
    try {
          annonces=sa.afficherAnnonceProprietaireChien("A");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    return annonces;
    
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        annoncesProprietaireChien.addAll(getAnnoncesProprietaireChien());
          int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < annoncesProprietaireChien.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ChienFXML.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ChienFXMLController chienController = fxmlLoader.getController();
                chienController.setData(annoncesProprietaireChien.get(i));

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
