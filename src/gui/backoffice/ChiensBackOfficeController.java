/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.backOffice;

import static com.sun.xml.internal.ws.api.model.wsdl.WSDLBoundOperation.ANONYMOUS.optional;
import entities.AnnonceAdoption;
import entities.Chien;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import services.AnnonceAdoptionService;
import services.ChienService;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ChiensBackOfficeController implements Initializable {

    /**
     * Initializes the controller class.
     */
   

    @FXML
    private Button refreshButton;

    @FXML
    private Button addButton;

    @FXML
    private Button editButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TableView<Chien> dogTableView;

    @FXML
    private TableColumn<Chien, Integer> idCol;

    @FXML
    private TableColumn<Chien, String> dogNameCol;

    @FXML
    private TableColumn<Chien, String> dogOwnerCol;

    @FXML
    private TableColumn<Chien, String> dogColorCol;

    @FXML
    private TableColumn<Chien, String> dogAgeCol;

    @FXML
    private TableColumn<Chien, String> dogDescCol;

    @FXML
    private TableColumn<Chien, String> dogGenderCol;

    @FXML
    private TableColumn<Chien, String> dogGroupCol;

    @FXML
    private TableColumn<Chien, String> dogBreedCol;

    @FXML
    private TextField searchBox;

    @FXML
    private TextField searchBox2;

    @FXML
    private TextField searchBox3;

    private Chien chien;

    ChienService cs = new ChienService();

    @FXML
    void refreshDogTable()throws SQLException {
        data.clear();
        data.addAll(cs.afficherChiens());
        System.out.println("test");
        dogTableView.setItems(data);
    }

    @FXML
    void deleteDog(MouseEvent event) throws SQLException  {

        chien = dogTableView.getSelectionModel().getSelectedItem();
        cs.delete(chien.getIdChien());
        refreshDogTable();

    }

    public ObservableList<Chien> data = FXCollections.observableArrayList();

    private void loadDogData() {
        try {
            refreshDogTable();
        } catch (SQLException ex) {
            Logger.getLogger(ChiensBackOfficeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        idCol.setCellValueFactory(new PropertyValueFactory<>("idChien"));

        dogNameCol.setCellValueFactory(new PropertyValueFactory<>("nom"));
        dogDescCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        dogOwnerCol.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getIndividu().getPrenom())));
        dogAgeCol.setCellValueFactory(new PropertyValueFactory<>("age"));
        dogGenderCol.setCellValueFactory(new PropertyValueFactory<>("sexe"));
        dogGroupCol.setCellValueFactory(new PropertyValueFactory<>("groupe"));
        dogBreedCol.setCellValueFactory(new PropertyValueFactory<>("race"));
        dogColorCol.setCellValueFactory(new PropertyValueFactory<>("color"));

       /*
                        editButton.setOnMouseClicked((MouseEvent event) -> {
                            
                            chien = dogTableView.getSelectionModel().getSelectedItem();
                            FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("/chienPopUp.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                Logger.getLogger(TableViewController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            ChienPopUpController chienPopUpController = loader.getController();
                            chienPopUpController.setUpdate(true);
                            chienPopUpController.setTextField(student.getId(), student.getName(), 
                                    student.getBirth().toLocalDate(),student.getAdress(), student.getEmail());
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();
                            

                           

                        });

                        HBox managebtn = new HBox(editIcon, deleteIcon);
                        managebtn.setStyle("-fx-alignment:center");
                        HBox.setMargin(deleteIcon, new Insets(2, 2, 0, 3));
                        HBox.setMargin(editIcon, new Insets(2, 3, 0, 2));

                        setGraphic(managebtn);

                        setText(null);

                    }
                }

            };

            return cell;
        };
         editCol.setCellFactory(cellFoctory);
         studentsTable.setItems(StudentList);
         */
    }
 
    @FXML
    private TableView<AnnonceAdoption> adoptionTableView;

    @FXML
    private TableColumn<AnnonceAdoption, String> adoptionNomChien;

    @FXML
    private TableColumn<AnnonceAdoption, String> adoptionNomIndividu;

    @FXML
    private TableColumn<AnnonceAdoption, String> adoptionDescription;

    @FXML
    private TableColumn<AnnonceAdoption, String> adoptionDate;

    @FXML
    private TableColumn<AnnonceAdoption, String> adoptionLocalisation;
    @FXML
    private TextField searchBox11;

    @FXML
    private Button refreshButton1;

    @FXML
    private Button addButton1;

    @FXML
    private Button editButton1;

    @FXML
    private Button deleteButton1;
    
    AnnonceAdoptionService sa = new AnnonceAdoptionService();
    AnnonceAdoption a = new AnnonceAdoption();
    
    public ObservableList<AnnonceAdoption> adoptionData = FXCollections.observableArrayList();
    
    @FXML
    void deleteAnnonceAdoption(MouseEvent event) throws SQLException  {
        a = adoptionTableView.getSelectionModel().getSelectedItem();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Do you want to proceed ?");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure baby ?");
            Optional <ButtonType> action = alert.showAndWait();
            if(action.get()== ButtonType.OK){
                try {
                        sa.deleteAnnonceAdoption(a.getIdAnnonceAdoption());
                } 
                catch (SQLException ex) {
                Logger.getLogger(ChiensBackOfficeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
        
                
                }
        
        
        refreshAdoptionTable();
        

    }
    @FXML
    private void getAnnonceAddView(MouseEvent event) {
        try {
            Parent parent = FXMLLoader.load(getClass().getResource("AnnoncePopUp.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.initStyle(StageStyle.UTILITY);
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(ChiensBackOfficeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
    void getAnnonceEditView(MouseEvent event) {
        if (adoptionTableView.getSelectionModel().getSelectedItem()!=null)
        {
        a = adoptionTableView.getSelectionModel().getSelectedItem();
                            FXMLLoader loader = new FXMLLoader ();
                            loader.setLocation(getClass().getResource("AnnoncePopUp.fxml"));
                            try {
                                loader.load();
                            } catch (IOException ex) {
                                Logger.getLogger(ChiensBackOfficeController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                            AnnoncePopUpController annoncePopUpController = loader.getController();
                            annoncePopUpController.setUpdate(true);
                            annoncePopUpController.setIdUpdate(a.getIdAnnonceAdoption());
                            
                            annoncePopUpController.setTextField(a.getIdChien().getNom(), a.getIdChien().getAge(),a.getIdChien().getDescription(),
                             a.getIdChien().getColor(),a.getIdChien().getRace()
                            ,a.getIdChien().getGroupe());
                            Parent parent = loader.getRoot();
                            Stage stage = new Stage();
                            stage.setScene(new Scene(parent));
                            stage.initStyle(StageStyle.UTILITY);
                            stage.show();

    }
    }
    @FXML
    void refreshAdoptionTable()throws SQLException {
        adoptionData.clear();
        adoptionData.addAll(sa.displayAnnonceAdoption());
        System.out.println(adoptionData);
        adoptionTableView.setItems(adoptionData);
    }
    
     private void loadAdoptionData() {
        try {
            refreshAdoptionTable();
        } catch (SQLException ex) {
            Logger.getLogger(ChiensBackOfficeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        adoptionNomChien.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getIdChien().getNom())));
        adoptionDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        adoptionNomIndividu.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getIdIndividu().getPrenom())));
        adoptionLocalisation.setCellValueFactory(new PropertyValueFactory<>("localisation"));
        adoptionDate.setCellValueFactory(new PropertyValueFactory<>("datePublication"));
    
    
    
    
    
     }
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadDogData();
        loadAdoptionData();
        //loadMatingData();
        //loadLostData();
        //loadAdoptionData();
    }

}
