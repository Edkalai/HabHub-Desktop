package gui;

import HabHub.CommunityListener;
import entities.Chien;
import services.ChienService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class AddDogController implements Initializable {

    @FXML
    private Button DogsNextDoor;

    @FXML
    private Button DogsMatchup;

    @FXML
    private Button MissingDogs;

    @FXML
    private TextField dogNameLabel;

    @FXML
    private TextField ageLabel;
    
    @FXML
    private TextField colorLabel;

    @FXML
    private ComboBox<String> ageComboBox;

    @FXML
    private ComboBox<String> raceComboBox;

    @FXML
    private ComboBox<String> groupeComboBox;

    @FXML
    private RadioButton vaccinationTrue;

    @FXML
    private ToggleGroup dogVaccination;

    @FXML
    private RadioButton vaccinationFalse;

    @FXML
    private RadioButton male;

    @FXML
    private ToggleGroup dogGender;

    @FXML
    private RadioButton female;


    @FXML
    private TextArea descriptionTextArea;
    
    ChienService cs = new ChienService();

    @FXML
    void ajouterChien(ActionEvent event) {
        String age;
        String gender;
        boolean vaccination;
        String selectedAge = ageComboBox.getSelectionModel().getSelectedItem();
        String selectedRace = raceComboBox.getSelectionModel().getSelectedItem();
        String selectedGroupe = groupeComboBox.getSelectionModel().getSelectedItem();
        if (selectedAge.equals("Months")) {
            age = ageLabel.getText() + " mo";

        } else {
            age = ageLabel.getText() + " yr";
        }
        if (male.isSelected()){
           gender="M";
        
        }
        else if (female.isSelected()){
            gender="F";
        }
        vaccination=vaccinationTrue.isSelected();
        
        String nom = dogNameLabel.getText();
        String description = descriptionTextArea.getText();
        String color = colorLabel.getText();
        //Chien c = new Chien(nom,age,gender,vaccination,description,color,selectedRace,selectedGroupe);
        //cs.ajouterChienProprietaire(c);
    }

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void switchSceneDogsMatchup(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("DogsMatchup.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchSceneDogsNextDoor(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("DogsNextDoor.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void switchSceneMissingDogs(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("MissingDogs.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> ageList = FXCollections.observableArrayList("Months", "Years");
        ObservableList<String> raceList = FXCollections.observableArrayList("Working", "Herding", "Toy", "Hound", "Sporting", "Non-Sporting", "Terrier");
        ObservableList<String> groupeList = FXCollections.observableArrayList(
                "Golden Retriever",
                "Husky",
                "Labrador Retriever",
                "French Bulldog",
                "German Shepherd",
                "English Bulldog",
                "Poodle",
                "Beagle",
                "Rottweiler",
                "French Bulldog");

        ageComboBox.setItems(ageList);
        ageComboBox.getSelectionModel().selectFirst();
        raceComboBox.setItems(raceList);
        raceComboBox.getSelectionModel().selectFirst();
        groupeComboBox.setItems(groupeList);
        groupeComboBox.getSelectionModel().selectFirst();

    }

}
