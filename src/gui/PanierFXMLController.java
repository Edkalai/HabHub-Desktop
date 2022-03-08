/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import HabHub.MyListener;
import entities.Produit;
import entities.panier;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import services.PanierService;
import services.ProduitService;
import utils.Statics;

/**
 * FXML Controller class
 *
 * @author User
 */
public class PanierFXMLController implements Initializable {

    
    @FXML
    private GridPane grid;
    
    @FXML
    private Label sommeprod;

    @FXML
    private Label total;

    @FXML
    private Label clearCartClickLabel;

    @FXML
    private Button order;
    
    @FXML
    private Button clear;
    
    
   
    
      public ObservableList<panier> paniers = FXCollections.observableArrayList();
    PanierService pa = new PanierService();

    private ObservableList<panier> getProduits() {
        List<panier> Panier = new ArrayList<>();

        try {
            Panier = pa.afficheParId(Statics.currentIndividu.getIdIndividu());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        paniers.clear();
        paniers.addAll(Panier);
        //System.out.println(Panier[panier].);
        return paniers;
        

    }
    
  
    
    
     private void displayProduits(ObservableList<panier> paniers) {
        grid.getChildren().clear();
        int column = 0;
        int row = 1;

        try {
         
            for (int i = 0; i < paniers.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("PanierItemFXML.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                PanierItemFXMLController itemController = fxmlLoader.getController();
              
                    itemController.setData(paniers.get(i));
                    //System.out.println(paniers.get(i).getIdPanier());
                    
                    //sommeprod=Integer.toString(Integer.parseInt(itemController.TotItemPrice));
                    
                if (column == 1) { 
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_PREF_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_COMPUTED_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_PREF_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_COMPUTED_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
                
                //sommeprod.setText( (Float.parseFloat(paniers.get(i).getClass().getPrix().getText()) )  +    );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        displayProduits(getProduits());
        // TODO
    }    
    
}
