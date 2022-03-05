/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import HabHub.Main;
import entite.Utilisateur;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import services.UtilisateurService;
import services.UserIndividuServices;
import utils.Statics;
import services.UtilisateurService;
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
     Connection connect;

   
     
     
    @FXML
   private Button  changer1;
     
    
@FXML

 private Stage stage;
 private Scene scene;
 private Parent parent;
 
 public void switchToScene1(ActionEvent event) throws IOException {
  Parent root = FXMLLoader.load(getClass().getResource("../gui/log_in.fxml"));
  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
  scene = new Scene(root);
  stage.setScene(scene);
  stage.show();
 }
 @FXML
    private void seConnecter(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
          
            UtilisateurService us = new UtilisateurService();
            if (us.verifLogin(email.getText(), password.getText()))
            {
            alert.setContentText("auth succes");
            Statics.currentUser = us.chercherUtilisateur(email.getText());
            switchToScene1(event);
            }
            else
            {
            alert.setContentText("auth failed");
            }
            alert.show();
    }
 
 
 
 
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
     


    }
       
           /*  @FXML
    private Button signup;        
    private void seConnecter(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            LoginDAO ls = new LoginDAO();
            UtilisateurDAO us = new UtilisateurDAO();
            if (ls.verifLogin(emailInput.getText(), mdpInput.getText()))
            {
            alert.setContentText("auth succes");
            Statics.currentUser = us.findUtilisateurtByMail(emailInput.getText());
            switchSceneProfil(event);
            }
            else
            {
            alert.setContentText("auth failed");
            }
            alert.show();
    }*/
           
    /**
     *
     */
   
 
 
        
    
   
    

          
     