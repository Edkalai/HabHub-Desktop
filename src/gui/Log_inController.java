/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import services.UtilisateurService;
import services.UserIndividuServices;

/**
 * FXML Controller class
 *
 * @author NADA_USER
 */
public class Log_inController implements Initializable {

    
        /* @FXML
         private TextField email;
        @FXML
         private TextField pswd;*/
    
      @FXML
    private TextField email;

    @FXML
    private TextField password;

    @FXML
    private Button forgotpasswd;

    @FXML
    private Button signup;

    @FXML
    private Text wrongaccess;
    
    
 
      
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         }    
    

    
    
}
