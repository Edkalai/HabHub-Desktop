package gui;

import HabHub.MyListener;
import entities.AnnonceAdoption;
import entities.Chien;
import entities.Individu;
import java.io.File;
import services.ChienService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import services.AnnonceAdoptionService;
import services.UserIndividuServices;
import utils.Statics;

public class AddAnnonceAdoptionFXMLController implements Initializable {

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
    private ToggleGroup dogVaccination;

    @FXML
    private ToggleGroup dogGender;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private ImageView dogImageView;

    @FXML
    private AnchorPane test;
    
    @FXML
    private Label genderLabel;
    
    @FXML
    private Label vaccinationLabel;

    
    UserIndividuServices uis = new UserIndividuServices();

    @FXML
    String insertImage(ActionEvent event) throws SQLException {
        FileChooser fc = new FileChooser();
        String imageFilePath = "";
        String imageName = "";
        File f = fc.showOpenDialog(null);

        if (f != null) {

            Image imageToBeSaved = new Image(f.toURI().toString(), 135, 130, false, true);

            dogImageView.setImage(imageToBeSaved);

            

        }

        return imageName;
    }
    ChienService cs = new ChienService();
    AnnonceAdoptionService as = new AnnonceAdoptionService();

    public void switchSceneAnnonceAdoption(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AnnonceAdoptionFXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void ajouterChien(ActionEvent event) throws IOException, SQLException {
        String age;
        String gender;
        boolean vaccination = false;
        String selectedAge = ageComboBox.getSelectionModel().getSelectedItem();
        String selectedRace = raceComboBox.getSelectionModel().getSelectedItem();
        String selectedGroupe = groupeComboBox.getSelectionModel().getSelectedItem();
                
            
        if (selectedAge.equals("Months")) {
            age = ageLabel.getText() + " mo";

        } else {
            age = ageLabel.getText() + " yr";
        }
        RadioButton selectedGender = (RadioButton) dogGender.getSelectedToggle();
        String selectedGenderValue;
            
        selectedGenderValue = selectedGender.getText();
        if (selectedGenderValue.equals("Male")){
            gender="M";
            }
            else{
                gender="F";
                }
            
        
        RadioButton selectedVaccination = (RadioButton) dogVaccination.getSelectedToggle();
        String selectedVaccinationValue;
            
        selectedVaccinationValue = selectedVaccination.getText();
        
        if (selectedVaccinationValue.equals("Yes")){
           vaccination=true;
        }
        else{
            vaccination=false;
        }   
        
        if(dogNameLabel.getText().isEmpty() | ageLabel.getText().isEmpty()|colorLabel.getText().isEmpty()|descriptionTextArea.getText().isEmpty()){
                
                Alert alert = new Alert(AlertType.ERROR);
                
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Fill all blank fields!");
                alert.showAndWait();
                
            }
       
             if(dogNameLabel.getText().isEmpty()){
                dogNameLabel.setStyle("-fx-border-width:2px; -fx-border-color:#FF6347");}
             
             if(ageLabel.getText().isEmpty()){
                ageLabel.setStyle("-fx-border-width:2px; -fx-border-color:#FF6347");}
             
             if(colorLabel.getText().isEmpty()){
                colorLabel.setStyle("-fx-border-width:2px; -fx-border-color:#FF6347");}
             
             if(descriptionTextArea.getText().isEmpty()){
                descriptionTextArea.setStyle("-fx-border-width:2px; -fx-border-color:#FF6347");}
             
             
             else{
                String nom = dogNameLabel.getText();
                String description = descriptionTextArea.getText();
                String color = colorLabel.getText();
                Statics.currentIndividu.getIdIndividu();
                String image=Integer.toString(Statics.currentIndividu.getIdIndividu()) + "_" + Integer.toString(uis.getDogsNumberByIdIndividu(Statics.currentIndividu.getIdIndividu())+1)+".png";
                File file = new File("C:\\Users\\Tun21\\Desktop\\HabHub\\HabHub-Desktop\\src\\assets\\img\\chien"
                    +image);
            try {
                ImageIO.write(SwingFXUtils.fromFXImage(dogImageView.getImage(), null), "png", file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        
        Chien c = new Chien(nom, gender, age, vaccination, description, image, color, selectedRace, selectedGroupe);
        cs.ajouterChienSansProprietaire(c);
        
        AnnonceAdoption a = new AnnonceAdoption(Statics.currentIndividu,c,c.getDescription(),Statics.currentIndividu.getAdresse());
        as.addAnnonceAdoption(a);
        switchSceneAnnonceAdoption(event);
             }
    }

    private Stage stage;
    private Scene scene;
    private Parent root;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> ageList = FXCollections.observableArrayList("Months", "Years");
        ObservableList<String> groupeList = FXCollections.observableArrayList("Working", "Herding", "Toy", "Hound", "Sporting", "Non-Sporting", "Terrier");
        ObservableList<String> raceList = FXCollections.observableArrayList(
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
    /**/

}
