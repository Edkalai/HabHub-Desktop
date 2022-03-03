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
import services.ProduitService;
import entities.Produit;

import java.sql.SQLException;
import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;



/**
 * FXML Controller class
 *
 * @author Ed
 */
public class ProduitFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
      @FXML
    private ImageView ProdImage;

    @FXML
    private Label nameLabel;
    @FXML
    private Label Price;
    
   
    
    @FXML
    private Button EvalProduit;

    @FXML
    private Button AjPanier;
    
     private Produit produit;
     
      @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(produit);
    }
    
 private MyListener myListener;
         
         
    public void setData(Produit produit,MyListener myListener) {
        this.produit = produit;
        this.myListener=myListener;
        nameLabel.setText(produit.getNom());
        String s = Float.toString(produit.getPrix())+"DNT";
        Price.setText(s);
       
        Image Image = new Image(getClass().getResourceAsStream("../assets/img/sq.jpg"));
        ProdImage.setImage(Image);
        
        
       
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
