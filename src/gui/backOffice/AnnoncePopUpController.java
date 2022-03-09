/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.backOffice;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Ed
 */
public class AnnoncePopUpController implements Initializable {

    @FXML
    private TextField dogName;
    @FXML
    private TextField ownerName;
    @FXML
    private TextField postedOn;
    @FXML
    private TextField location;
    @FXML
    private TextArea descriptionText;
    @FXML
    private Button CancelButton;
    @FXML
    private Button SubmitButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
