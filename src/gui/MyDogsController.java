/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import HabHub.CommunityListener;
import entities.Chien;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import services.ChienService;
import utils.Statics;

/**
 * FXML Controller class
 *
 * @author Ed
 */
public class MyDogsController implements Initializable {

    /**
     * Initializes the controller class.
     */
       @FXML
    private GridPane grid;

    @FXML
    private ImageView dogImage;

    @FXML
    private Label dogNameLabel;

    @FXML
    private Label ownerLocationLabel;

    @FXML
    private ImageView genderImage;

    @FXML
    private Label ageLabel;

    @FXML
    private Label dogColorLabel;

    @FXML
    private Label genderLabel;

    @FXML
    private Label dogRaceLabel;

    @FXML
    private Label dogGroupLabel;

    @FXML
    private Text dogStory;

    @FXML
    private Label ownerNameLabel;

    @FXML
    private Label ownerLocationLabel2;
     private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    public void switchSceneDogsMatchup (ActionEvent event) throws IOException
    {
       root = FXMLLoader.load(getClass().getResource("DogsMatchup.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    }
     @FXML
    public void switchSceneDogsNextDoor (ActionEvent event) throws IOException
    {
       root = FXMLLoader.load(getClass().getResource("DogsNextDoor.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    }
     @FXML
    public void switchSceneMissingDogs (ActionEvent event) throws IOException
    {
    root = FXMLLoader.load(getClass().getResource("MissingDogs.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    }
     @FXML
    public void switchSceneAddDog (ActionEvent event) throws IOException
    {
    root = FXMLLoader.load(getClass().getResource("AddDog.fxml"));
    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    }
   public ObservableList<Chien> data = FXCollections.observableArrayList();
    ChienService cs = new ChienService();

    

    private ObservableList<Chien> getChienByIndividu() {
        List<Chien> chiens = new ArrayList<>();

        try {
            //chiens = cs.findChienByIndividu(Statics.currentIndividu.getIdIndividu());
            chiens = cs.findChienByIndividu(1);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        data.clear();
        data.addAll(chiens);
        return data;

    }

   /* private void setChosenChien(Chien a) {

        dogNameLabel.setText(a.getChien().getNom());
        Image genderImg = new Image(getClass().getResourceAsStream("../assets/img/female.png"));
        genderLabel.setText("Female");
        if ("M".equals(a.getChien().getSexe())) {
            genderImg = new Image(getClass().getResourceAsStream("../assets/img/male.png"));
            genderLabel.setText("Male");
        }
        genderImage.setImage(genderImg);

        ageLabel.setText(a.getChien().getAge());
        dogStory.setText(a.getChien().getDescription());
        ownerLocationLabel.setText(a.getLocalisation());
        ownerLocationLabel2.setText(a.getLocalisation());
        dogRaceLabel.setText(a.getChien().getRace());
        dogGroupLabel.setText(a.getChien().getGroupe());
        dogColorLabel.setText(a.getChien().getColor());

        dogLastSeenOnLabel.setText(a.getDatePerte().toString());
        dogLastSeenInLabel.setText(a.getLocalisation());
        ownerNameLabel.setText(a.getChien().getIndividu().getPrenom());

       Image dogImg = new Image(getClass().getResourceAsStream("../assets/img/chien/"+a.getChien().getImage()+".png"));
       dogImage.setImage(dogImg);

    }
*/

    private void displayChiens(ObservableList<Chien> chiens) {
        grid.getChildren().clear();
        int column = 0;
        int row = 1;

       try {
            for (int i = 0; i < chiens.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("DogListItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                DogListItemController dogListItemController = fxmlLoader.getController();
                dogListItemController.setData(chiens.get(i));

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
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        displayChiens(getChienByIndividu());

     
        }
   
    
}
