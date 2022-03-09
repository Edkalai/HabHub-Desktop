/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entite.Individu;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class UsersBackOfficeController implements Initializable {

    
    @FXML
    private TextField searchBox1;

    @FXML
    private TextField searchBox;

    @FXML
    private TableView<?> tableusers;

    @FXML
    private TableColumn<?, ?> idindiv;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> iduser;

    @FXML
    private TableColumn<?, ?> email;

    @FXML
    private TableColumn<?, ?> pwd;

    @FXML
    private TableColumn<?, ?> numtel;

    @FXML
    private TableColumn<?, ?> type;

    @FXML
    private TableColumn<?, ?> nom;

    @FXML
    private TableColumn<?, ?> prenom;

    @FXML
    private TableColumn<?, ?> adresse;

    @FXML
    private TableColumn<?, ?> facebook;

    @FXML
    private TableColumn<?, ?> whatsapp;

    @FXML
    private TableColumn<?, ?> instagram;

    @FXML
    private TableColumn<?, ?> datnaiss;

    @FXML
    private TextField searchBox2;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        adresse.setCellValueFactory(new List<Individu>("idIndividu") {});
                
                
       
    }    
    
}
