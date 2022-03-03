/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import HabHub.MyListener;
import entities.Produit;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import services.ProduitService;


/**
 * FXML Controller class
 *
 * @author Ed
 */
public class BoutiqueFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private GridPane grid;
     
  public ObservableList<Produit> produits = FXCollections.observableArrayList();
    ProduitService sa=new ProduitService();
    
    private ObservableList<Produit> getProduits() {
        List<Produit> Produit = new ArrayList<>();

        try {
            Produit = sa.afficherproduit();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        produits.clear();
        produits.addAll(Produit);
        return produits;

    }
     private ObservableList<Produit> getRechercheProduits(String input) {
        List<Produit> ProduitRecherche = new ArrayList<>();

        try {
            ProduitRecherche = sa.RechercheProduit(input);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        produits.clear();
        produits.addAll(ProduitRecherche);
        return produits;

    }
    
    
     private void setChosenProduit(Produit p) {
          Image Image = new Image(getClass().getResourceAsStream("../assets/img/sq.jpg"));
        ProdImage.setImage(Image);
        nameLabel.setText(p.getNom());
        String s = Float.toString(p.getPrix())+"DNT";
        Price.setText(s);
        Desc.setText(p.getDescription());
      
        
        
        
        /*chosenFruitCard.setStyle("-fx-background-color: #" + fruit.getColor() + ";\n" +
                "    -fx-background-radius: 30;");*/
    }
     private void displayProduits(ObservableList<Produit> produits) {
        grid.getChildren().clear();
        int column = 0;
        int row = 1;

        try {
            myListener = new MyListener() {
                @Override
                public void onClickListener(Produit produit) {
                    setChosenProduit(produit);
                }

            };
            for (int i = 0; i < produits.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ProduitFXML.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ProduitFXMLController produitController = fxmlLoader.getController();
                produitController.setData(produits.get(i), myListener);

                if (column == 6) {
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
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
  

    @FXML
    private ImageView ProdImage;

    @FXML
    private Label nameLabel;

    @FXML
    private Label Price;

    @FXML
    private ImageView genderImage;

    @FXML
    private Label Desc;
    
    @FXML
    private TextField searchBox;


  
    
      @FXML
    private Label totprice;
    
    
        @FXML
    void RechercheProduit(ActionEvent event) {
   

    }
    
    
        private MyListener myListener;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        displayProduits(getProduits());
            if (produits.size() > 0) {
            setChosenProduit(produits.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Produit produit) {
                    setChosenProduit(produit);
                }

            };
        }
        
       
        
         
        searchBox.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
            displayProduits(getRechercheProduits(newValue));

        });
    }

}
