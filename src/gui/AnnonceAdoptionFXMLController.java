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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.text.Text;
import javafx.stage.Stage;
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
    private TextField keyboardTexField;
    @FXML
    private ImageView chienImg;

    @FXML
    private Label chienNameLable;

    @FXML
    private Label adoptionLocation;

    @FXML
    private ImageView genderImage;

    @FXML
    private Label chienAge;

    @FXML
    private Label genderColor;

    @FXML
    private Label chienSexe;

    @FXML
    private Text chienDescription;

    @FXML
    private Label adoptionFosterName;

    @FXML
    private Label adoptionFosterAdress;

    @FXML
    private Text ownerDescription;
   @FXML
    private TextField searchBox;

    @FXML
    private GridPane grid;
    @FXML
    private Button btnAdd;
    private MyListener myListener;
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    public ObservableList<AnnonceAdoption> data = FXCollections.observableArrayList();
    AnnonceAdoptionService sa = new AnnonceAdoptionService();
    
    private ObservableList<AnnonceAdoption> getAnnonceAdoption() {
        List<AnnonceAdoption> annonces = new ArrayList<>();

        try {
            annonces = sa.displayAnnonceAdoption();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        data.clear();
        data.addAll(annonces);
        return data;

    }
    private ObservableList<AnnonceAdoption> getRechercheAnnonceAdoption(String input) {
        List<AnnonceAdoption> annoncesRecherche = new ArrayList<>();

        try {
            annoncesRecherche = sa.rechercheAnnonceAdoption(input);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        data.clear();
        data.addAll(annoncesRecherche);
        return data;

    }
    private void setChosenChien(AnnonceAdoption a) {
        chienNameLable.setText(a.getIdChien().getNom());
        Image genderImg;
        if (a.getIdChien().getSexe().toLowerCase().equals("m")) {
             genderImg = new Image(getClass().getResourceAsStream("../assets/img/male.png"));
            chienSexe.setText("Masculin");
        }
        else{
             genderImg = new Image(getClass().getResourceAsStream("../assets/img/female.png"));
        chienSexe.setText("Feminin");
            
        }
        genderImage.setImage(genderImg);
        chienAge.setText(a.getIdChien().getAge());
        chienDescription.setText(a.getIdChien().getDescription());
        adoptionLocation.setText(a.getLocalisation());
        adoptionFosterName.setText(a.getIdIndividu().getPrenom());
        adoptionFosterAdress.setText(a.getIdIndividu().getAdresse());
        Image dogImg = new Image(getClass().getResourceAsStream("../assets/img/dog.png"));
        chienImg.setImage(dogImg);
        
        /*chosenFruitCard.setStyle("-fx-background-color: #" + fruit.getColor() + ";\n" +
                "    -fx-background-radius: 30;");*/
    }
    private void displayAnnonces(ObservableList<AnnonceAdoption> annonces) {
        grid.getChildren().clear();
        int column = 0;
        int row = 1;

        try {
            myListener = new MyListener() {
                @Override
                public void onClickListener(AnnonceAdoption annonceAdoption) {
                    setChosenChien(annonceAdoption);
                }

            };
            for (int i = 0; i < annonces.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ChienFXML.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ChienFXMLController chienController = fxmlLoader.getController();
                chienController.setData(annonces.get(i), myListener);

                if (column == 5) {
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
    
    /**
     *
     * @param event
     * @throws IOException
     */
    @FXML
    public void switchSceneAnnonceChien(ActionEvent event) throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("AddAnnonceAdoptionFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        displayAnnonces(getAnnonceAdoption());
        if (data.size() > 0) {
            setChosenChien(data.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(AnnonceAdoption annonceAdoption) {
                    setChosenChien(annonceAdoption);
                }

            };
        }
        searchBox.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
            displayAnnonces(getRechercheAnnonceAdoption(newValue));

        });
        /*annoncesAdoption.addAll(getAnnonceAdoption());
        if (annoncesAdoption.size() > 0) {
            setChosenChien(annoncesAdoption.get(0));
            myListener = new MyListener(){
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
    }*/
    

}
}